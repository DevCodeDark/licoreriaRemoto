package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Lote;

public interface ILoteService {
    List<Lote> bucarTodos();
    void guardar(Lote lote);
    void modificar(Lote lote);
    Optional<Lote> buscarId(Integer idLote);
    void eliminar(Integer idLote);
}
