package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Almacen;

public interface IAlmacenesService {
    List<Almacen> bucarTodos();
    void guardar(Almacen almacen);
    void modificar(Almacen almacen);
    Optional<Almacen> buscarId(Integer idAlmacen);
    void eliminar(Integer idAlmacen);
}
