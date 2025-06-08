package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.repository.ProveedorCategoriaRepository;
import com.sipsoft.licoreria.services.IProveedorCategoriaService;

@Service
public class ProveedorCategoriaService implements IProveedorCategoriaService {
    @Autowired
    private ProveedorCategoriaRepository repoProveedorCategoria;
    
    public List<ProveedorCategoria> bucarTodos() {
        return repoProveedorCategoria.findAll();
    }
    
    public void guardar(ProveedorCategoria proveedorCategoria) {
        repoProveedorCategoria.save(proveedorCategoria);
    }
    
    public void modificar(ProveedorCategoria proveedorCategoria) {
        repoProveedorCategoria.save(proveedorCategoria);
    }
    
    public Optional<ProveedorCategoria> buscarId(Integer idProveedorCategoria) {
        return repoProveedorCategoria.findById(idProveedorCategoria);
    }
    
    public void eliminar(Integer idProveedorCategoria) {
        repoProveedorCategoria.deleteById(idProveedorCategoria);
    }
}
