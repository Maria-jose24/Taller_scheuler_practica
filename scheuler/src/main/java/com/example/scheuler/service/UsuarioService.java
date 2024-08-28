package com.example.scheuler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scheuler.interfaceService.IUsuarioService;
import com.example.scheuler.interfaces.IUsuario;
import com.example.scheuler.model.Usuario;

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