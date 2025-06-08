package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.IEmpresaService;

@Service
public class EmpresaService implements IEmpresaService {
    @Autowired
    private EmpresaRepository repoEmpresa;
    
    public List<Empresa> bucarTodos() {
        return repoEmpresa.findAll();
    }
    
    public void guardar(Empresa empresa) {
        repoEmpresa.save(empresa);
    }
    
    public void modificar(Empresa empresa) {
        repoEmpresa.save(empresa);
    }
    
    public Optional<Empresa> buscarId(Integer idEmpresa) {
        return repoEmpresa.findById(idEmpresa);
    }
    
    public void eliminar(Integer idEmpresa) {
        repoEmpresa.deleteById(idEmpresa);
    }
}
