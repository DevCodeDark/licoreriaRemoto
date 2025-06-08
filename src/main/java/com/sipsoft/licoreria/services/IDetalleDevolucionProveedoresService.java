package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DetalleDevolucionProveedores;

public interface IDetalleDevolucionProveedoresService {
    List<DetalleDevolucionProveedores> bucarTodos();
    void guardar(DetalleDevolucionProveedores detalleDevolucionProveedores);
    void modificar(DetalleDevolucionProveedores detalleDevolucionProveedores);
    Optional<DetalleDevolucionProveedores> buscarId(Integer idDetalleDevolucion);
    void eliminar(Integer idDetalleDevolucion);
}
