package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.OrdenCompra;

public interface IOrdenCompraService {
    List<OrdenCompra> bucarTodos();
    void guardar(OrdenCompra ordenCompra);
    void modificar(OrdenCompra ordenCompra);
    Optional<OrdenCompra> buscarId(Integer idOrden);
    void eliminar(Integer idOrden);
}
