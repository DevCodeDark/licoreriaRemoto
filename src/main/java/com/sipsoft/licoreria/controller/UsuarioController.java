package com.sipsoft.licoreria.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.security.JwtUtil;
import com.sipsoft.licoreria.services.IUsuarioService;

@RestController
@RequestMapping("/sipsoft")
public class UsuarioController {
    @Autowired
    private IUsuarioService serviceUsuario;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public List<Usuario> buscarTodos() {
        return serviceUsuario.bucarTodos();
    }
    
    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody Usuario usuario) {
        // Generar credenciales automáticamente
        String claveOriginal = usuario.getEmailUsuario() + usuario.getNombreUsuario() + usuario.getApellidoUsuario();
        usuario.generarCredenciales(claveOriginal);
        serviceUsuario.guardar(usuario);
        return usuario;
    }

    @PutMapping("/usuarios")
    public Usuario modificar(@RequestBody Usuario usuario) {
        serviceUsuario.modificar(usuario);
        return usuario;
    }

    @GetMapping("/usuarios/{idUsuario}")
    public Optional<Usuario> buscarId(@PathVariable("idUsuario") Integer idUsuario) {
        return serviceUsuario.buscarId(idUsuario);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    public String eliminar(@PathVariable Integer idUsuario){
        serviceUsuario.eliminar(idUsuario);
        return "Usuario eliminado";
    }

    @PostMapping("/token")
    public ResponseEntity<?> obtenerToken(@RequestBody Map<String, String> credenciales) {
        String clienteId = credenciales.get("cliente_id");
        String llaveSecreta = credenciales.get("llave_secreta");
        
        Optional<Usuario> user = serviceUsuario.bucarTodos().stream()
            .filter(u -> u.getClienteId().equals(clienteId))
            .findFirst();
            
        if (user.isPresent() && passwordEncoder.matches(llaveSecreta, user.get().getLlaveSecreta())) {
            String token = jwtUtil.generarToken(clienteId);

            Usuario usuario = user.get();
            usuario.setAccessToken(token);
            serviceUsuario.guardar(usuario);

            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}
