package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Modulo;
import com.sipsoft.licoreria.repository.ModuloRepository;
import com.sipsoft.licoreria.services.IModuloService;

@Service
public class ModuloService implements IModuloService {
    @Autowired
    private ModuloRepository repoModulo;
    
    public List<Modulo> bucarTodos() {
        return repoModulo.findAll();
    }
    
    public void guardar(Modulo modulo) {
        repoModulo.save(modulo);
    }
    
    public void modificar(Modulo modulo) {
        repoModulo.save(modulo);
    }
    
    public Optional<Modulo> buscarId(Integer idModulo) {
        return repoModulo.findById(idModulo);
    }
    
    public void eliminar(Integer idModulo) {
        repoModulo.deleteById(idModulo);
    }
}
