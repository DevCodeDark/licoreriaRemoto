package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> bucarTodos();
    void guardar(Usuario usuario);
    void modificar(Usuario usuario);
    Optional<Usuario> buscarId(Integer idUsuario);
    void eliminar(Integer idUsuario);
}
