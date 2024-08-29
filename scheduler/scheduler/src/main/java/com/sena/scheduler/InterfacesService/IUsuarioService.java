package com.sena.scheduler.InterfacesService;

import java.util.List;
import java.util.Optional;

import com.sena.scheduler.Models.Usuario;

public interface IUsuarioService {
	Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(String id);

    void deleteForever(String id);
}