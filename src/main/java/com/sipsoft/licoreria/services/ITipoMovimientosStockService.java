package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoMovimientosStock;

public interface ITipoMovimientosStockService {
    List<TipoMovimientosStock> bucarTodos();
    void guardar(TipoMovimientosStock tipoMovimientosStock);
    void modificar(TipoMovimientosStock tipoMovimientosStock);
    Optional<TipoMovimientosStock> buscarId(Integer idTipoMovimiento);
    void eliminar(Integer idTipoMovimiento);
}
