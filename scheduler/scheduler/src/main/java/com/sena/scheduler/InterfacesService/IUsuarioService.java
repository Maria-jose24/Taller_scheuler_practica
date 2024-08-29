package com.sena.scheduler.InterfacesService;

import java.util.List;
import java.util.Optional;

import com.sena.scheduler.Models.Usuario;

public interface IUsuarioService {
	
	public String save(Usuario usuario);

    public List<Usuario> findAll();

    public 	Optional<Usuario> findOne(String id);

    public int deleteForever(String id);
    
    //Filtro
    
    public List<Usuario> filtroUsuario(String filtro);
    public List<Usuario> cambiarTipoDocumento(String cambiarTipoDocumento);
    public List<Usuario> actualizarContraseña(String actualizarContraseña);
    public List<Usuario> iniciosesionNotificar(String iniciosesionNotificar);
 
}