package com.example.scheuler.task;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.example.scheuler.interfaceService.IUsuarioService;
import com.example.scheuler.model.Usuario;
import com.example.scheuler.service.UsuarioService;

import java.util.List;

public class Scheduler {
	
	@Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private JavaMailSender mailSender;

    // Método para notificar cada media hora que debe cambiar la contraseña
    @Scheduled(cron = "0 0/30 * * * ?")
    public void notificarCambioContrasena() {
        List<Usuario> usuarios = usuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getFechaUltimaActualizacionContrasena().isBefore(LocalDate.now().minusMonths(3))) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(usuario.getCorreoElectronico());
                message.setSubject("Cambio de contraseña requerido");
                message.setText("Han pasado 3 meses desde la última actualización de su contraseña. Por favor, cámbiela.");
                mailSender.send(message);
            }
        }
    }

    // Método para bloquear usuarios que no han iniciado sesión en más de un mes
    @Scheduled(cron = "0 0 0 * * SUN")
    public void verificarInactividad() {
        List<Usuario> usuarios = usuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getFechaUltimoInicioSesion().isBefore(LocalDate.now().minusMonths(1))) {
                UsuarioService.bloquearUsuario(usuario);
            }
        }
    }
}