package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Venta;

public interface IVentaService {
    List<Venta> bucarTodos();
    void guardar(Venta venta);
    void modificar(Venta venta);
    Optional<Venta> buscarId(Integer idVenta);
    void eliminar(Integer idVenta);
}
