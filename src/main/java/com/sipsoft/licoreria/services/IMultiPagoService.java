package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.MultiPago;

public interface IMultiPagoService {
    List<MultiPago> bucarTodos();
    void guardar(MultiPago multiPago);
    void modificar(MultiPago multiPago);
    Optional<MultiPago> buscarId(Integer idMultiPago);
    void eliminar(Integer idMultiPago);
}
