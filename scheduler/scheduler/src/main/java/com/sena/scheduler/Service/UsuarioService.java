package com.sena.scheduler.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.scheduler.Interfaces.IUsuario;
import com.sena.scheduler.InterfacesService.IUsuarioService;
import com.sena.scheduler.Models.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	 
    @Autowired
    private IUsuario data;

    @Override
    public Usuario save(Usuario usuario) {
        return data.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) data.findAll();
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return data.findById(id);
    }

    @Override
    public void deleteForever(String id) {
        data.deleteById(id);
    }
}
