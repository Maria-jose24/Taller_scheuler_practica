package com.sena.scheduler.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.scheduler.Models.Usuario;
import com.sena.scheduler.Service.UsuarioService;
import com.sena.scheduler.Service.emailService;

@Component
public class Task {
	
	@Autowired
    private UsuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(cron = "0 * * * * *")
    public void sendNotificationRegistrocron() {

        var listaUsuario=data.notificacionRegistro();
        for(Usuario usuario:listaUsuario){
            System.out.println("Registro Exitoso "+ 
            usuario.getNombre());
            email.notificacionRegistro(usuario);
        }
    }

    @Scheduled(cron = "0 35 8 * * *")
    public void sendNotificationcron() {

        var listaUsuario=data.cambiarTipoDocumento();
        for(Usuario usuario:listaUsuario){
            System.out.println("Actualizar documento "+ 
            usuario.getNombre());
            email.cambiarTipoDocumento(usuario);
        }
    }

    @Scheduled(cron= "0 35 8 * * *" )
    public void sendNotificationcronactualizarcontrasena(){

        var listaUsuario=data.actualizarContrasena();
        for(Usuario usuario:listaUsuario){
            System.out.println("Cambiar contraseña"+
            usuario.getNombre());
            email.actualizarContrasena(usuario);
        }

    }

    @Scheduled(cron= "0 35 8 * * *" )
    public void sendNotificationcroniniciosesionNotificar(){

        var listaUsuario=data.iniciosesionNotificar();
        for(Usuario usuario:listaUsuario){
            System.out.println("Inicia pronto sesion en nuestra aplicación"+
            usuario.getNombre());
            email.iniciosesionNotificar(usuario);
        }
    }
}