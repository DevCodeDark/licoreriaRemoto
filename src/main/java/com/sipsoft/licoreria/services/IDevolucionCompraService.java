package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DevolucionCompra;

public interface IDevolucionCompraService {
    List<DevolucionCompra> bucarTodos();
    void guardar(DevolucionCompra devolucionCompra);
    void modificar(DevolucionCompra devolucionCompra);
    Optional<DevolucionCompra> buscarId(Integer idDevolucionCompra);
    void eliminar(Integer idDevolucionCompra);
}
