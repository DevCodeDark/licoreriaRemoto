package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.dto.VentaDTO;
import com.sipsoft.licoreria.dto.DetalleVentaDTO;
import com.sipsoft.licoreria.entity.DetalleVenta;
import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.entity.Cliente;
import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.entity.Transaccion;
import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.repository.LoteRepository;
import com.sipsoft.licoreria.repository.ClienteRepository;
import com.sipsoft.licoreria.repository.CajaRepository;
import com.sipsoft.licoreria.repository.TransaccionRepository;
import com.sipsoft.licoreria.repository.UsuarioRepository;
import com.sipsoft.licoreria.repository.DetalleVentaRepository;
import com.sipsoft.licoreria.services.IVentaService;

@RestController
@RequestMapping("/sipsoft")
public class VentaController {
    @Autowired
    private IVentaService serviceVenta;

    @Autowired
    private LoteRepository repoLote;
    @Autowired
    private ClienteRepository repoCliente;
    @Autowired
    private CajaRepository repoCaja;
    @Autowired
    private TransaccionRepository repoTransaccion;
    @Autowired
    private UsuarioRepository repoUsuario;
    @Autowired
    private DetalleVentaRepository repoDetalleVenta;

    @GetMapping("/ventas")
    public List<Venta> buscarTodos() {
        return serviceVenta.bucarTodos();
    }
    @PostMapping("/ventas")
    public Venta guardar(@RequestBody VentaDTO dto) {
        Venta venta = new Venta();
        venta.setFechaVenta(dto.getFechaVenta());
        venta.setMontoTotalVenta(dto.getMontoTotalVenta());
        venta.setFechaAnulacion(dto.getFechaAnulacion());
        venta.setDireccion(dto.getDireccion());
        venta.setReferencia(dto.getReferencia());
        venta.setEstadoVenta(dto.getEstadoVenta());
        venta.setTipoDocumento(dto.getTipoDocumento());

        Cliente cliente = repoCliente.findById(dto.getIdCliente()).orElse(null);
        venta.setIdCliente(cliente);
        Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);
        venta.setIdCaja(caja);
        Transaccion transaccion = repoTransaccion.findById(dto.getIdTransaccion()).orElse(null);
        venta.setIdTransaccion(transaccion);
        Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
        venta.setIdUsuario(usuario);

        serviceVenta.guardar(venta);

        // Guardar detalles y actualizar stock
        if (dto.getDetalles() != null) {
            for (DetalleVentaDTO det : dto.getDetalles()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setPrecioUnitario(det.getPrecioUnitario());
                detalle.setDescuentoVenta(det.getDescuentoVenta());
                detalle.setCantidadVenta(det.getCantidadVenta());
                detalle.setSubtotalVenta(det.getSubtotalVenta());
                detalle.setEstadoDetalleVenta(det.getEstadoDetalleVenta());
                detalle.setTipoDescuento(det.getTipoDescuento());
                detalle.setVenta(venta);
                Lote lote = repoLote.findById(det.getIdLote()).orElse(null);
                detalle.setLote(lote);
                repoDetalleVenta.save(detalle);
                // Actualizar stock del lote
                if (lote != null && det.getCantidadVenta() != null) {
                    int nuevoStock = (lote.getStockActual() != null ? lote.getStockActual() : 0) - det.getCantidadVenta();
                    lote.setStockActual(nuevoStock);
                    repoLote.save(lote);
                }
            }
        }
        return venta;
    }

    @PutMapping("/ventas")
    public Venta modificar(@RequestBody VentaDTO dto) {
        Venta venta = new Venta();
        venta.setIdVenta(dto.getIdVenta());
        venta.setFechaVenta(dto.getFechaVenta());
        venta.setMontoTotalVenta(dto.getMontoTotalVenta());
        venta.setFechaAnulacion(dto.getFechaAnulacion());
        venta.setDireccion(dto.getDireccion());
        venta.setReferencia(dto.getReferencia());
        venta.setEstadoVenta(dto.getEstadoVenta());
        venta.setTipoDocumento(dto.getTipoDocumento());

        Cliente cliente = repoCliente.findById(dto.getIdCliente()).orElse(null);
        venta.setIdCliente(cliente);
        Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);
        venta.setIdCaja(caja);
        Transaccion transaccion = repoTransaccion.findById(dto.getIdTransaccion()).orElse(null);
        venta.setIdTransaccion(transaccion);
        Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
        venta.setIdUsuario(usuario);

        serviceVenta.modificar(venta);

        // Actualizar detalles y stock si se envían detalles
        if (dto.getDetalles() != null) {
            for (DetalleVentaDTO det : dto.getDetalles()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalleVenta(det.getIdDetalleVenta());
                detalle.setPrecioUnitario(det.getPrecioUnitario());
                detalle.setDescuentoVenta(det.getDescuentoVenta());
                detalle.setCantidadVenta(det.getCantidadVenta());
                detalle.setSubtotalVenta(det.getSubtotalVenta());
                detalle.setEstadoDetalleVenta(det.getEstadoDetalleVenta());
                detalle.setTipoDescuento(det.getTipoDescuento());
                detalle.setVenta(venta);
                Lote lote = repoLote.findById(det.getIdLote()).orElse(null);
                detalle.setLote(lote);
                repoDetalleVenta.save(detalle);
                // Actualizar stock del lote
                if (lote != null && det.getCantidadVenta() != null) {
                    int nuevoStock = (lote.getStockActual() != null ? lote.getStockActual() : 0) - det.getCantidadVenta();
                    lote.setStockActual(nuevoStock);
                    repoLote.save(lote);
                }
            }
        }
        return venta;
    }

    @GetMapping("/ventas/{idVenta}")
    public Optional<Venta> buscarId(@PathVariable("idVenta") Integer idVenta) {
        return serviceVenta.buscarId(idVenta);
    }

    @DeleteMapping("/ventas/{idVenta}")
    public String eliminar(@PathVariable Integer idVenta){
        serviceVenta.eliminar(idVenta);
        return "Venta eliminada";
    }
}
