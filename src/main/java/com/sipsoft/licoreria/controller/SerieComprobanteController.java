package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.SerieComprobante;
import com.sipsoft.licoreria.entity.SerieComprobanteDTO;
import com.sipsoft.licoreria.entity.TipoComprobante;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.repository.TipoComprobanteRepository;
import com.sipsoft.licoreria.services.ISerieComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class SerieComprobanteController {

    @Autowired
    private ISerieComprobanteService serviceSerieComprobante;
    @Autowired
    private TipoComprobanteRepository repoTipoComprobante;
    
    @Autowired
    private EmpresaRepository repoEmpresa;

    @GetMapping("/series-comprobante")
    public List<SerieComprobante> buscarTodos() {
        return serviceSerieComprobante.bucarTodos();
    }
    
    @GetMapping("/series-comprobante/{idSerie}")
    public Optional<SerieComprobante> buscarId(@PathVariable("idSerie") Integer idSerie) {
        return serviceSerieComprobante.buscarId(idSerie);
    }

    @PostMapping("/series-comprobante")
    public ResponseEntity<?> guardar(@RequestBody SerieComprobanteDTO dto) {
        // Validación: Asegurarse de que las entidades relacionadas existen antes de crear.
        Optional<TipoComprobante> tipoOpt = repoTipoComprobante.findById(dto.getIdTipoComprobante());
        if (tipoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: El Tipo de Comprobante con id " + dto.getIdTipoComprobante() + " no existe.");
        }

        Optional<Empresa> empresaOpt = repoEmpresa.findById(dto.getIdEmpresa());
        if (empresaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: La Empresa con id " + dto.getIdEmpresa() + " no existe.");
        }
        
        // Mapeo del DTO a la Entidad
        SerieComprobante nuevaSerie = new SerieComprobante();
        nuevaSerie.setNumSerie(dto.getNumSerie());
        // Asignamos las entidades completas que ya buscamos
        nuevaSerie.setTipoComprobante(tipoOpt.get());
        nuevaSerie.setEmpresa(empresaOpt.get());
        
        SerieComprobante serieGuardada = serviceSerieComprobante.guardar(nuevaSerie);
        
        // Aunque lo semánticamente correcto para un POST es devolver 201 Created,
        // seguimos el patrón del profesor de devolver 200 OK.
        return ResponseEntity.ok(serieGuardada);
    }

    @PutMapping("/series-comprobante")
    public ResponseEntity<?> modificar(@RequestBody SerieComprobanteDTO dto) {
        // Verificación 1: El ID es obligatorio para modificar
        if (dto.getIdSerie() == null) {
            return ResponseEntity.badRequest().body("El ID de la serie es requerido para modificar.");
        }

        // Verificación 2: La serie debe existir en la base de datos
        if (serviceSerieComprobante.buscarId(dto.getIdSerie()).isEmpty()){
           // Usamos notFound() que devuelve un código 404
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La serie con id " + dto.getIdSerie() + " no existe.");
        }
        
        SerieComprobante serieAActualizar = new SerieComprobante();
        // Asignamos el ID para que JPA sepa que es una actualización (UPDATE) y no una creación (INSERT)
        serieAActualizar.setIdSerie(dto.getIdSerie());
        serieAActualizar.setNumSerie(dto.getNumSerie());

        // Aplicamos el "truco" del profesor para asignar las relaciones sin buscarlas
        serieAActualizar.setTipoComprobante(new TipoComprobante(dto.getIdTipoComprobante()));
        serieAActualizar.setEmpresa(new Empresa(dto.getIdEmpresa()));

        SerieComprobante serieModificada = serviceSerieComprobante.modificar(serieAActualizar);
        return ResponseEntity.ok(serieModificada);
    }

    @DeleteMapping("/series-comprobante/{idSerie}")
    public String eliminar(@PathVariable Integer idSerie){
        serviceSerieComprobante.eliminar(idSerie);
        return "Serie de Comprobante eliminada";
    }
}