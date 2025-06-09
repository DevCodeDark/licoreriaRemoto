package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.entity.CajaDTO;
import com.sipsoft.licoreria.entity.Sucursal;
import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.repository.SucursalRepository;
import com.sipsoft.licoreria.repository.UsuarioRepository;
import com.sipsoft.licoreria.services.ICajaService;

@RestController
@RequestMapping("/sipsoft")
public class CajaController {
    @Autowired
    private ICajaService serviceCaja;
    @Autowired
    private UsuarioRepository repoUsuario;
    @Autowired
    private SucursalRepository repoSucursal;


    @GetMapping("/cajas")
    public List<Caja> buscarTodos() {
        return serviceCaja.bucarTodos();
    }
    @PostMapping("/cajas")
public ResponseEntity<?> guardar(@RequestBody CajaDTO dto) {
    Caja caja = new Caja();
    
    // Buscar y asignar entidades relacionadas
    Optional<Sucursal> sucursalOpt = repoSucursal.findById(dto.getIdSucursal());
    if (sucursalOpt.isEmpty()) {
        return ResponseEntity.badRequest().body("La sucursal con id " + dto.getIdSucursal() + " no existe.");
    }

    Optional<Usuario> usuarioOpt = repoUsuario.findById(dto.getIdUsuarioApertura());
    if (usuarioOpt.isEmpty()) {
        return ResponseEntity.badRequest().body("El usuario con id " + dto.getIdUsuarioApertura() + " no existe.");
    }

    // Mapeo de DTO a Entidad
    caja.setNumCaja(dto.getNumCaja());
    caja.setMontoinicialCaja(dto.getMontoinicialCaja());
    // Es mejor que la fecha de apertura se genere en el servidor para asegurar consistencia
    caja.setFechaaperturaCaja(LocalDateTime.now()); 
    caja.setEstadoCaja(1); // Asumimos que 1 es 'abierta'

    caja.setSucursal(sucursalOpt.get());
    caja.setUsuarioApertura(usuarioOpt.get());
    
    Caja cajaGuardada = serviceCaja.guardar(caja); // Asumiendo que serviceCaja.guardar hace un .save()
    return ResponseEntity.status(HttpStatus.CREATED).body(cajaGuardada);
    }


    @PutMapping("/cajas/{idCaja}") // <-- 1. AÑADIMOS EL ID A LA URL
    public ResponseEntity<?> modificar(@PathVariable Integer idCaja, @RequestBody CajaDTO dto) { // <-- 2. RECIBIMOS EL ID

    // 3. Ya no necesitamos el ID en el DTO, lo buscamos con el de la URL
    Optional<Caja> cajaOpt = serviceCaja.buscarId(idCaja);
    if (cajaOpt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La caja con id " + idCaja + " no fue encontrada.");
    }

    Caja cajaExistente = cajaOpt.get();
    
    // Actualizar campos desde el DTO
    cajaExistente.setMontofinalCaja(dto.getMontofinalCaja());
    cajaExistente.setFechacierreCaja(LocalDateTime.now()); // Es mejor que el servidor ponga la fecha
    cajaExistente.setEstadoCaja(0); // Suponiendo que 0 es cerrada
    
    // Actualizar usuario de cierre
    if (dto.getIdUsuarioCierre() != null) {
        Usuario usuarioCierre = repoUsuario.findById(dto.getIdUsuarioCierre()).orElse(null);
        if (usuarioCierre == null) {
            return ResponseEntity.badRequest().body("El usuario de cierre con id " + dto.getIdUsuarioCierre() + " no existe.");
        }
        cajaExistente.setUsuarioCierre(usuarioCierre);
    } else {
        return ResponseEntity.badRequest().body("El id del usuario de cierre es requerido para cerrar la caja.");
    }

    Caja cajaModificada = serviceCaja.modificar(cajaExistente);
    return ResponseEntity.ok(cajaModificada);
    }

    @GetMapping("/cajas/{idCaja}")
    public Optional<Caja> buscarId(@PathVariable("idCaja") Integer idCaja) {
        return serviceCaja.buscarId(idCaja);
    }

    @DeleteMapping("/cajas/{idCaja}")
    public String eliminar(@PathVariable Integer idCaja){
        serviceCaja.eliminar(idCaja);
        return "Caja eliminada";
    }
}
