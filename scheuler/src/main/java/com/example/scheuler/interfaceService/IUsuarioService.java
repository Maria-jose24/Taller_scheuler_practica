package com.example.scheuler.interfaceService;

import java.util.List;
import java.util.Optional;
import com.example.scheuler.model.Usuario;

public interface IUsuarioService {
	
	Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(String id);

    void deleteForever(String id);
}