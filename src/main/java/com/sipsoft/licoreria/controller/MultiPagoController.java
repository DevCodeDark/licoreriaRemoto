package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sipsoft.licoreria.entity.MultiPago;
import com.sipsoft.licoreria.entity.MultiPagoDTO;
import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.repository.TipoPagoRepository;
import com.sipsoft.licoreria.repository.VentaRepository;
import com.sipsoft.licoreria.services.IMultiPagoService;

@RestController
@RequestMapping("/sipsoft")
public class MultiPagoController {
    
    @Autowired
    private IMultiPagoService serviceMultiPago;
    
    // Inyectamos los repositorios para validar las relaciones
    @Autowired
    private VentaRepository repoVenta;

    @Autowired
    private TipoPagoRepository repoTipoPago;

    @GetMapping("/multi-pago")
    public List<MultiPago> buscarTodos() {
        return serviceMultiPago.bucarTodos();
    }

    @GetMapping("/multi-pago/{idMultiPago}")
    public ResponseEntity<?> buscarId(@PathVariable("idMultiPago") Integer idMultiPago) {
        Optional<MultiPago> pagoOpt = serviceMultiPago.buscarId(idMultiPago);
        if (pagoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pago con id " + idMultiPago + " no encontrado.");
        }
        return ResponseEntity.ok(pagoOpt.get());
    }

    @PostMapping("/multi-pago")
    public ResponseEntity<?> guardar(@RequestBody MultiPagoDTO dto) {
        // Validar que las entidades relacionadas existen
        if (repoVenta.findById(dto.getIdVenta()).isEmpty()) {
            return ResponseEntity.badRequest().body("Error: La Venta con id " + dto.getIdVenta() + " no existe.");
        }
        if (repoTipoPago.findById(dto.getIdTipoPago()).isEmpty()) {
            return ResponseEntity.badRequest().body("Error: El Tipo de Pago con id " + dto.getIdTipoPago() + " no existe.");
        }
        
        MultiPago nuevoPago = new MultiPago();
        nuevoPago.setMontoPagado(dto.getMontoPagado());
        // Asignamos las relaciones usando el truco 'new Entidad(id)'
        nuevoPago.setVenta(new Venta(dto.getIdVenta()));
        nuevoPago.setTipoPago(new TipoPago(dto.getIdTipoPago()));
        
        MultiPago pagoGuardado = serviceMultiPago.guardar(nuevoPago);
        return ResponseEntity.ok(pagoGuardado);
    }

    @PutMapping("/multi-pago")
    public ResponseEntity<?> modificar(@RequestBody MultiPagoDTO dto) {
        if (dto.getIdMultiPago() == null) {
            return ResponseEntity.badRequest().body("El ID del pago es requerido para modificar.");
        }
        if (serviceMultiPago.buscarId(dto.getIdMultiPago()).isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El pago con id " + dto.getIdMultiPago() + " no existe.");
        }
        
        MultiPago pagoAActualizar = new MultiPago();
        pagoAActualizar.setIdMultiPago(dto.getIdMultiPago());
        pagoAActualizar.setMontoPagado(dto.getMontoPagado());
        pagoAActualizar.setVenta(new Venta(dto.getIdVenta()));
        pagoAActualizar.setTipoPago(new TipoPago(dto.getIdTipoPago()));
        // Importante: Debemos mantener el estado, o JPA lo pondrá a 1 por defecto
        pagoAActualizar.setEstado(1);

        MultiPago pagoModificado = serviceMultiPago.modificar(pagoAActualizar);
        return ResponseEntity.ok(pagoModificado);
    }

    @DeleteMapping("/multi-pago/{idMultiPago}")
    public String eliminar(@PathVariable Integer idMultiPago){
        serviceMultiPago.eliminar(idMultiPago);
        return "Multi Pago eliminado";
    }
}