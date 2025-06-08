package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.DetalleTraslado;
import com.sipsoft.licoreria.repository.DetalleTrasladoRepository;
import com.sipsoft.licoreria.services.IDetalleTrasladoService;

@Service
public class DetalleTrasladoService implements IDetalleTrasladoService {
    @Autowired
    private DetalleTrasladoRepository repoDetalleTraslado;
    
    public List<DetalleTraslado> bucarTodos() {
        return repoDetalleTraslado.findAll();
    }
    
    public void guardar(DetalleTraslado detalleTraslado) {
        repoDetalleTraslado.save(detalleTraslado);
    }
    
    public void modificar(DetalleTraslado detalleTraslado) {
        repoDetalleTraslado.save(detalleTraslado);
    }
    
    public Optional<DetalleTraslado> buscarId(Integer idDetalleTraslado) {
        return repoDetalleTraslado.findById(idDetalleTraslado);
    }
    
    public void eliminar(Integer idDetalleTraslado) {
        repoDetalleTraslado.deleteById(idDetalleTraslado);
    }
}
