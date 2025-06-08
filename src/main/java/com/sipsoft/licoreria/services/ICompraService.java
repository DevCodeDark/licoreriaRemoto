package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Compra;

public interface ICompraService {
    List<Compra> bucarTodos();
    void guardar(Compra compra);
    void modificar(Compra compra);
    Optional<Compra> buscarId(Integer idCompra);
    void eliminar(Integer idCompra);
}
