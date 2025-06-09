package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.repository.CajaRepository;
import com.sipsoft.licoreria.services.ICajaService;

@Service
public class CajaService implements ICajaService {
    @Autowired
    private CajaRepository repoCaja;
    
 
    public List<Caja> bucarTodos() {
        return repoCaja.findAll();
    }
    
    
    public Caja guardar (Caja caja) {
        return repoCaja.save(caja); // <<< CAMBIO: Devolver el resultado de save
    }
    
   
    public Caja modificar (Caja caja) {
        return repoCaja.save(caja); // <<< CAMBIO: Devolver el resultado de save
    }
    

    public Optional<Caja> buscarId(Integer idCaja) {
        return repoCaja.findById(idCaja);
    }
    
   
    public void eliminar(Integer idCaja) {
        repoCaja.deleteById(idCaja);
    }
}
