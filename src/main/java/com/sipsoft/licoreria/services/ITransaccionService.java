package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Transaccion;

public interface ITransaccionService {
    List<Transaccion> bucarTodos();
    void guardar(Transaccion transaccion);
    void modificar(Transaccion transaccion);
    Optional<Transaccion> buscarId(Integer idTransaccion);
    void eliminar(Integer idTransaccion);
}
