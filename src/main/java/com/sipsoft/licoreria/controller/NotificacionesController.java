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

import com.sipsoft.licoreria.entity.Notificaciones;
import com.sipsoft.licoreria.services.INotificacionesService;

@RestController
@RequestMapping("/sipsoft")
public class NotificacionesController {
    @Autowired
    private INotificacionesService serviceNotificaciones;

    @GetMapping("/notificaciones")
    public List<Notificaciones> buscarTodos() {
        return serviceNotificaciones.bucarTodos();
    }
    @PostMapping("/notificaciones")
    public Notificaciones guardar(@RequestBody Notificaciones notificaciones) {
        serviceNotificaciones.guardar(notificaciones);
        return notificaciones;
    }

    @PutMapping("/notificaciones")
    public Notificaciones modificar(@RequestBody Notificaciones notificaciones) {
        serviceNotificaciones.modificar(notificaciones);
        return notificaciones;
    }

    @GetMapping("/notificaciones/{idNotificacion}")
    public Optional<Notificaciones> buscarId(@PathVariable("idNotificacion") Integer idNotificacion) {
        return serviceNotificaciones.buscarId(idNotificacion);
    }

    @DeleteMapping("/notificaciones/{idNotificacion}")
    public String eliminar(@PathVariable Integer idNotificacion){
        serviceNotificaciones.eliminar(idNotificacion);
        return "Notificacion eliminada";
    }
}
