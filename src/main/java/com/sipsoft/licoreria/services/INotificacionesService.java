package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Notificaciones;

public interface INotificacionesService {
    List<Notificaciones> bucarTodos();
    void guardar(Notificaciones notificaciones);
    void modificar(Notificaciones notificaciones);
    Optional<Notificaciones> buscarId(Integer idNotificacion);
    void eliminar(Integer idNotificacion);
}
