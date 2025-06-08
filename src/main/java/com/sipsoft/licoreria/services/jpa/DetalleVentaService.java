package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.DetalleVenta;
import com.sipsoft.licoreria.repository.DetalleVentaRepository;
import com.sipsoft.licoreria.services.IDetalleVentaService;

@Service
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    private DetalleVentaRepository repoDetalleVenta;
    
    public List<DetalleVenta> bucarTodos() {
        return repoDetalleVenta.findAll();
    }
    
    public void guardar(DetalleVenta detalleVenta) {
        repoDetalleVenta.save(detalleVenta);
    }
    
    public void modificar(DetalleVenta detalleVenta) {
        repoDetalleVenta.save(detalleVenta);
    }
    
    public Optional<DetalleVenta> buscarId(Integer idDetalleVenta) {
        return repoDetalleVenta.findById(idDetalleVenta);
    }
    
    public void eliminar(Integer idDetalleVenta) {
        repoDetalleVenta.deleteById(idDetalleVenta);
    }
}
