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
    public String save(Usuario usuario) {
        data.save(usuario);
        return usuario.getId();
    }

    @Override
    public List<Usuario> findAll(){
        List<Usuario> listaUsuario = (List<Usuario>) data.findAll();
        return listaUsuario;
    }

    @Override
    public Optional<Usuario> findOne(String id){
        Optional<Usuario> usuario = data.findById(id);
        return usuario;
    }

    @Override
    public int deleteForever(String id){
        data.deleteById(id);
        return 1;
    }

    // Filtro
    @Override
    public List<Usuario> filtroUsuario(String filtro) {
        List<Usuario> listaUsuario = data.filtroUsuario(filtro);
        return listaUsuario;
    }
    
    @Override
    public List<Usuario> cambiarTipoDocumento() {
        List<Usuario> listaUsuario = data.cambiarTipoDocumento();
        return listaUsuario;
    }

    @Override
    public List<Usuario> actualizarContrasena() {
        List<Usuario> listaUsuario = data.actualizarContrasena();
        return listaUsuario;
    }
    
    @Override
    public List<Usuario> iniciosesionNotificar() {
        List<Usuario> listaUsuario = data.iniciosesionNotificar();
        return listaUsuario;
    }
    
    @Override
    public List<Usuario> notificacionRegistro(){
    	List<Usuario> listaUsuario = data.notificacionRegistro();
    	return listaUsuario;
    }
}