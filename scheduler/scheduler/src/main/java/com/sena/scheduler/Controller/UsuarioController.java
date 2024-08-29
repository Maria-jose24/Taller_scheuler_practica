package com.sena.scheduler.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.scheduler.InterfacesService.IUsuarioService;
import com.sena.scheduler.Models.Usuario;
import com.sena.scheduler.Service.emailService;

@RestController
@RequestMapping("/api/v1/usuario/")
public class UsuarioController {

	
	@Autowired
    private IUsuarioService UsuarioService;
	
	@Autowired
	private emailService emailService;
	

	@PostMapping("/")
    public ResponseEntity<Object> save (@ModelAttribute("Usuario") Usuario usuario){
        UsuarioService.save(usuario);
        emailService.enviarCorreoBienvenida(usuario.getCorreoElectronico());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var listaUsuario = UsuarioService.findAll();
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }

    @GetMapping("/busquedaFiltros/{filtro}")
    public ResponseEntity<Object> findFiltro(@PathVariable String filtro) {
        var listaUsuario = UsuarioService.filtroUsuario(filtro);
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var usuario = UsuarioService.findOne(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<Object> deleteForever(@PathVariable String id) {
        UsuarioService.deleteForever(id);
        return new ResponseEntity<>("Libro eliminado Permanentemente", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("usuario") Usuario usuarioUpdate) {
        var usuario = UsuarioService.findOne(id).get();

        if (usuario != null) {
        	usuario.setNombre(usuarioUpdate.getNombre());
        	usuario.setCorreoElectronico(usuarioUpdate.getCorreoElectronico());
        	usuario.setTipoDocumento(usuarioUpdate.getTipoDocumento());
        	usuario.setNumeroDocumento(usuarioUpdate.getNumeroDocumento());
        	usuario.setFechaNacimiento(usuarioUpdate.getFechaNacimiento());
        	usuario.setContrasena(usuarioUpdate.getContrasena());
        	usuario.setFechaUltimaActualizacionContrasena(usuarioUpdate.getFechaUltimaActualizacionContrasena());
        	usuario.setFechaUltimoInicioSesion(usuarioUpdate.getFechaUltimoInicioSesion());
        	usuario.setEstado(usuarioUpdate.getEstado());
        	usuario.setNotificado(usuarioUpdate.isNotificado());
        	
        	UsuarioService.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Error usuario No encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}