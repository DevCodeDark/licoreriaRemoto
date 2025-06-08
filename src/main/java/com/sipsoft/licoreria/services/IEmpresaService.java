package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Empresa;

public interface IEmpresaService {
    List<Empresa> bucarTodos();
    void guardar(Empresa empresa);
    void modificar(Empresa empresa);
    Optional<Empresa> buscarId(Integer idEmpresa);
    void eliminar(Integer idEmpresa);
}
