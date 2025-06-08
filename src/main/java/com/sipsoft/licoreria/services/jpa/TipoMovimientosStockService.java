package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.TipoMovimientosStock;
import com.sipsoft.licoreria.repository.TipoMovimientosStockRepository;
import com.sipsoft.licoreria.services.ITipoMovimientosStockService;

@Service
public class TipoMovimientosStockService implements ITipoMovimientosStockService {
    @Autowired
    private TipoMovimientosStockRepository repoTipoMovimientosStock;
    
    public List<TipoMovimientosStock> bucarTodos() {
        return repoTipoMovimientosStock.findAll();
    }
    
    public void guardar(TipoMovimientosStock tipoMovimientosStock) {
        repoTipoMovimientosStock.save(tipoMovimientosStock);
    }
    
    public void modificar(TipoMovimientosStock tipoMovimientosStock) {
        repoTipoMovimientosStock.save(tipoMovimientosStock);
    }
    
    public Optional<TipoMovimientosStock> buscarId(Integer idTipoMovimiento) {
        return repoTipoMovimientosStock.findById(idTipoMovimiento);
    }
    
    public void eliminar(Integer idTipoMovimiento) {
        repoTipoMovimientosStock.deleteById(idTipoMovimiento);
    }
}
