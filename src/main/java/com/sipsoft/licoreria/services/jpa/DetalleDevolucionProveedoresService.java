package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.DetalleDevolucionProveedores;
import com.sipsoft.licoreria.repository.DetalleDevolucionProveedoresRepository;
import com.sipsoft.licoreria.services.IDetalleDevolucionProveedoresService;

@Service
public class DetalleDevolucionProveedoresService implements IDetalleDevolucionProveedoresService {
    @Autowired
    private DetalleDevolucionProveedoresRepository repoDetalleDevolucionProveedores;
    
    public List<DetalleDevolucionProveedores> bucarTodos() {
        return repoDetalleDevolucionProveedores.findAll();
    }
    
    public void guardar(DetalleDevolucionProveedores detalleDevolucionProveedores) {
        repoDetalleDevolucionProveedores.save(detalleDevolucionProveedores);
    }
    
    public void modificar(DetalleDevolucionProveedores detalleDevolucionProveedores) {
        repoDetalleDevolucionProveedores.save(detalleDevolucionProveedores);
    }
    
    public Optional<DetalleDevolucionProveedores> buscarId(Integer idDetalleDevolucion) {
        return repoDetalleDevolucionProveedores.findById(idDetalleDevolucion);
    }
    
    public void eliminar(Integer idDetalleDevolucion) {
        repoDetalleDevolucionProveedores.deleteById(idDetalleDevolucion);
    }
}
