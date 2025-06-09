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

import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.dto.TrasladoDTO;
import com.sipsoft.licoreria.entity.Almacen;
import com.sipsoft.licoreria.repository.AlmacenesRepository;
import com.sipsoft.licoreria.services.ITrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class TrasladoController {
    @Autowired
    private ITrasladoService serviceTraslado;

    @Autowired
    private AlmacenesRepository repoAlmacen;

    @GetMapping("/traslados")
    public List<Traslado> buscarTodos() {
        return serviceTraslado.bucarTodos();
    }

    @PostMapping("/traslados")
    public Traslado guardar(@RequestBody TrasladoDTO dto) {
        Traslado traslado = new Traslado();
        traslado.setFechaTraslado(dto.getFechaTraslado());
        traslado.setEstadoTraslado(dto.getEstadoTraslado());
        Almacen origen = repoAlmacen.findById(dto.getIdAlmacenOrigen()).orElse(null);
        traslado.setIdAlmacenOrigen(origen);
        Almacen destino = repoAlmacen.findById(dto.getIdAlmacenDestino()).orElse(null);
        traslado.setIdAlmacenDestino(destino);
        serviceTraslado.guardar(traslado);
        return traslado;
    }

    @PutMapping("/traslados")
    public Traslado modificar(@RequestBody TrasladoDTO dto) {
        Traslado traslado = new Traslado();
        traslado.setIdTraslado(dto.getIdTraslado());
        traslado.setFechaTraslado(dto.getFechaTraslado());
        traslado.setEstadoTraslado(dto.getEstadoTraslado());
        Almacen origen = repoAlmacen.findById(dto.getIdAlmacenOrigen()).orElse(null);
        traslado.setIdAlmacenOrigen(origen);
        Almacen destino = repoAlmacen.findById(dto.getIdAlmacenDestino()).orElse(null);
        traslado.setIdAlmacenDestino(destino);
        serviceTraslado.modificar(traslado);
        return traslado;
    }

    @GetMapping("/traslados/{idTraslado}")
    public Optional<Traslado> buscarId(@PathVariable("idTraslado") Integer idTraslado) {
        return serviceTraslado.buscarId(idTraslado);
    }

    @DeleteMapping("/traslados/{idTraslado}")
    public String eliminar(@PathVariable Integer idTraslado){
        serviceTraslado.eliminar(idTraslado);
        return "Traslado eliminado";
    }
}
