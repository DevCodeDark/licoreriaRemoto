package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DetalleVenta;

public interface IDetalleVentaService {
    List<DetalleVenta> bucarTodos();
    void guardar(DetalleVenta detalleVenta);
    void modificar(DetalleVenta detalleVenta);
    Optional<DetalleVenta> buscarId(Integer idDetalleVenta);
    void eliminar(Integer idDetalleVenta);
}
