package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Caja;

public interface ICajaService {
    List<Caja> bucarTodos();
    void guardar(Caja caja);
    void modificar(Caja caja);
    Optional<Caja> buscarId(Integer idCaja);
    void eliminar(Integer idCaja);
}
