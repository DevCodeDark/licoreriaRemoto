package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoNotificaciones;

public interface ITipoNotificacionesService {
    List<TipoNotificaciones> bucarTodos();
    void guardar(TipoNotificaciones tipoNotificaciones);
    void modificar(TipoNotificaciones tipoNotificaciones);
    Optional<TipoNotificaciones> buscarId(Integer idTipoNotificacion);
    void eliminar(Integer idTipoNotificacion);
}
