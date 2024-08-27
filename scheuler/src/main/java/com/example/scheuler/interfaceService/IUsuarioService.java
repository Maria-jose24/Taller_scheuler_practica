package com.example.scheuler.interfaceService;

import java.util.List;
import java.util.Optional;
import com.example.scheuler.model.Usuario;

public interface IUsuarioService {
	 List<Usuario> findAll();
	    Optional<Usuario> findById(Long id);
	    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
	    Usuario save(Usuario usuario);
	    void deleteById(Long id);
	    void notifyUser(Usuario usuario);
	    void bloquearUsuario(Usuario usuario);
}