package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.ContratoProveedor;

public interface IContratoProveedorService {
    List<ContratoProveedor> bucarTodos();
    void guardar(ContratoProveedor contratoProveedor);
    void modificar(ContratoProveedor contratoProveedor);
    Optional<ContratoProveedor> buscarId(Integer idContratoProveedor);
    void eliminar(Integer idContratoProveedor);
}
