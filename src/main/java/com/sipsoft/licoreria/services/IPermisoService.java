package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Permiso;

public interface IPermisoService {
    List<Permiso> bucarTodos();
    void guardar(Permiso permiso);
    void modificar(Permiso permiso);
    Optional<Permiso> buscarId(Integer idPermiso);
    void eliminar(Integer idPermiso);
}
