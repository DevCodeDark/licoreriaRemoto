package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.ProveedorCategoria;

public interface IProveedorCategoriaService {
    List<ProveedorCategoria> bucarTodos();
    void guardar(ProveedorCategoria proveedorCategoria);
    void modificar(ProveedorCategoria proveedorCategoria);
    Optional<ProveedorCategoria> buscarId(Integer idProveedorCategoria);
    void eliminar(Integer idProveedorCategoria);
}
