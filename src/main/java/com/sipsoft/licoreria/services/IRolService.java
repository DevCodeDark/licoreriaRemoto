package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Rol;

public interface IRolService {
    List<Rol> bucarTodos();
    void guardar(Rol rol);
    void modificar(Rol rol);
    Optional<Rol> buscarId(Integer idRol);
    void eliminar(Integer idRol);
}
