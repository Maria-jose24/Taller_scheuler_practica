package com.example.scheuler.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheuler.interfaceService.IUsuarioService;
import com.example.scheuler.model.Usuario;
import com.example.scheuler.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario/")
public class UsuarioController {
	 
	@Autowired
    private IUsuarioService UsuarioService;

    @GetMapping
    public List<Usuario> getUsuario() {
        return UsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable String id) {
        return UsuarioService.findById(id);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return UsuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return UsuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        UsuarioService.deleteForever(id);
    }
}