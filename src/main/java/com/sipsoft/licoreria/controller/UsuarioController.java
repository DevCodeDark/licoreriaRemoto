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

import com.sipsoft.licoreria.dto.UsuarioDTO;
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
    
    /**
     * Endpoint para crear un nuevo usuario.
     * @param usuarioDto DTO con la información del usuario a crear.
     * @return El usuario creado con sus credenciales generadas.
     */
    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        
        // Mapeo de campos desde el DTO
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuario.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuario.setDniUsuario(usuarioDto.getDniUsuario());
        usuario.setEmailUsuario(usuarioDto.getEmailUsuario());
        usuario.setIdRol(usuarioDto.getIdRol());
        usuario.setIdEmpresa(usuarioDto.getIdEmpresa());

        // Cifrar la contraseña
        if (usuarioDto.getContrasenaUsuario() != null && !usuarioDto.getContrasenaUsuario().isEmpty()) {
            usuario.setContrasenaUsuario(passwordEncoder.encode(usuarioDto.getContrasenaUsuario()));
        }

        // Generar credenciales (clienteId, llaveSecreta, accessToken)
        String claveOriginal = usuarioDto.getEmailUsuario() + usuarioDto.getNombreUsuario() + usuarioDto.getApellidoUsuario();
        usuario.generarCredenciales(claveOriginal);
        
        // Establecer estado por defecto
        usuario.setEstadoUsuario(1);

        return serviceUsuario.guardar(usuario);
    }

    /**
     * Endpoint para modificar un usuario existente.
     * @param usuarioDto DTO con la información a actualizar.
     * @return El usuario modificado o un mensaje de error si no se encuentra.
     */
    @PutMapping("/usuarios")
    public ResponseEntity<?> modificar(@RequestBody UsuarioDTO usuarioDto) {
        if (usuarioDto.getIdUsuario() == null) {
            return ResponseEntity.badRequest().body("El idUsuario es requerido para modificar.");
        }
        
        Optional<Usuario> usuarioOpt = serviceUsuario.buscarId(usuarioDto.getIdUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el Usuario con ID: " + usuarioDto.getIdUsuario());
        }

        Usuario usuarioExistente = usuarioOpt.get();

        // Mapeo de campos desde el DTO
        usuarioExistente.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuarioExistente.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuarioExistente.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuarioExistente.setDniUsuario(usuarioDto.getDniUsuario());
        usuarioExistente.setEmailUsuario(usuarioDto.getEmailUsuario());
        usuarioExistente.setIdRol(usuarioDto.getIdRol());
        usuarioExistente.setIdEmpresa(usuarioDto.getIdEmpresa());

        // Actualizar contraseña solo si se proporciona una nueva
        if (usuarioDto.getContrasenaUsuario() != null && !usuarioDto.getContrasenaUsuario().isEmpty()) {
            usuarioExistente.setContrasenaUsuario(passwordEncoder.encode(usuarioDto.getContrasenaUsuario()));
        }
        
        Usuario usuarioModificado = serviceUsuario.modificar(usuarioExistente);
        return ResponseEntity.ok(usuarioModificado);
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