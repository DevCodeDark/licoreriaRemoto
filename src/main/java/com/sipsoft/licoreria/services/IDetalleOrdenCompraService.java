package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DetalleOrdenCompra;

public interface IDetalleOrdenCompraService {
    List<DetalleOrdenCompra> bucarTodos();
    void guardar(DetalleOrdenCompra detalleOrdenCompra);
    void modificar(DetalleOrdenCompra detalleOrdenCompra);
    Optional<DetalleOrdenCompra> buscarId(Integer idDetalleOrden);
    void eliminar(Integer idDetalleOrden);
}
