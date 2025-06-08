package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DetalleTraslado;

public interface IDetalleTrasladoService {
    List<DetalleTraslado> bucarTodos();
    void guardar(DetalleTraslado detalleTraslado);
    void modificar(DetalleTraslado detalleTraslado);
    Optional<DetalleTraslado> buscarId(Integer idDetalleTraslado);
    void eliminar(Integer idDetalleTraslado);
}
