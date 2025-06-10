package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.VentaDTO;
import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.services.IVentaService;

@RestController
@RequestMapping("/sipsoft")
public class VentaController {
    @Autowired
    private IVentaService serviceVenta;

    @GetMapping("/ventas")
    public List<VentaDTO> buscarTodos() {
        return serviceVenta.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/ventas/{idVenta}")
    public ResponseEntity<VentaDTO> buscarId(@PathVariable("idVenta") Integer idVenta) {
        return serviceVenta.buscarId(idVenta)
                .map(venta -> ResponseEntity.ok(convertToDto(venta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/ventas")
    public VentaDTO guardar(@RequestBody VentaDTO dto) {
        Venta venta = new Venta();
        mapDtoToEntity(dto, venta);
        
        venta.setFechaVenta(LocalDateTime.now());
        venta.setEstadoVenta(1); // Estado activo por defecto

        Venta savedVenta = serviceVenta.guardar(venta);
        return convertToDto(savedVenta);
    }

    @PutMapping("/ventas")
    public ResponseEntity<VentaDTO> modificar(@RequestBody VentaDTO dto) {
        if (dto.getIdVenta() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceVenta.buscarId(dto.getIdVenta())
                .map(ventaExistente -> {
                    mapDtoToEntity(dto, ventaExistente);

                    if (dto.getEstadoVenta() != null) {
                        ventaExistente.setEstadoVenta(dto.getEstadoVenta());
                    }
                     if (dto.getFechaAnulacion() != null) {
                        ventaExistente.setFechaAnulacion(dto.getFechaAnulacion());
                    }
                    
                    Venta updatedVenta = serviceVenta.modificar(ventaExistente);
                    return ResponseEntity.ok(convertToDto(updatedVenta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/ventas/{idVenta}")
    public String eliminar(@PathVariable Integer idVenta){
        serviceVenta.eliminar(idVenta);
        return "Venta eliminada";
    }

    // --- Métodos de Ayuda ---

    private VentaDTO convertToDto(Venta entity) {
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(entity.getIdVenta());
        dto.setFechaVenta(entity.getFechaVenta());
        dto.setMontoTotalVenta(entity.getMontoTotalVenta());
        dto.setFechaAnulacion(entity.getFechaAnulacion());
        dto.setDireccion(entity.getDireccion());
        dto.setReferencia(entity.getReferencia());
        dto.setEstadoVenta(entity.getEstadoVenta());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setIdCliente(entity.getIdCliente());
        dto.setIdCaja(entity.getIdCaja());
        dto.setIdUsuario(entity.getIdUsuario());
        return dto;
    }

    private void mapDtoToEntity(VentaDTO dto, Venta entity) {
        entity.setMontoTotalVenta(dto.getMontoTotalVenta());
        entity.setDireccion(dto.getDireccion());
        entity.setReferencia(dto.getReferencia());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setIdCliente(dto.getIdCliente());
        entity.setIdCaja(dto.getIdCaja());
        entity.setIdUsuario(dto.getIdUsuario());
    }
}