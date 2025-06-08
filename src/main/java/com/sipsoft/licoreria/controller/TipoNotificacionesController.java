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

import com.sipsoft.licoreria.entity.TipoNotificaciones;
import com.sipsoft.licoreria.services.ITipoNotificacionesService;

@RestController
@RequestMapping("/sipsoft")
public class TipoNotificacionesController {
    @Autowired
    private ITipoNotificacionesService serviceTipoNotificaciones;

    @GetMapping("/tipos-notificaciones")
    public List<TipoNotificaciones> buscarTodos() {
        return serviceTipoNotificaciones.bucarTodos();
    }
    @PostMapping("/tipos-notificaciones")
    public TipoNotificaciones guardar(@RequestBody TipoNotificaciones tipoNotificaciones) {
        serviceTipoNotificaciones.guardar(tipoNotificaciones);
        return tipoNotificaciones;
    }

    @PutMapping("/tipos-notificaciones")
    public TipoNotificaciones modificar(@RequestBody TipoNotificaciones tipoNotificaciones) {
        serviceTipoNotificaciones.modificar(tipoNotificaciones);
        return tipoNotificaciones;
    }

    @GetMapping("/tipos-notificaciones/{idTipoNotificacion}")
    public Optional<TipoNotificaciones> buscarId(@PathVariable("idTipoNotificacion") Integer idTipoNotificacion) {
        return serviceTipoNotificaciones.buscarId(idTipoNotificacion);
    }

    @DeleteMapping("/tipos-notificaciones/{idTipoNotificacion}")
    public String eliminar(@PathVariable Integer idTipoNotificacion){
        serviceTipoNotificaciones.eliminar(idTipoNotificacion);
        return "Tipo Notificacion eliminado";
    }
}
