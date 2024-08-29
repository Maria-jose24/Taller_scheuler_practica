package com.sena.scheduler.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sena.scheduler.Service.UsuarioService;
import com.sena.scheduler.Service.emailService;

@Component
public class Task {
	
	@Autowired
	private UsuarioService data;
	
	@Autowired emailService email;

    /*private IUsuarioService UsuarioService;

    @Autowired
    private emailService emailService;

    // Verifica usuarios mayores de 18 años y con tarjeta de identidad
    @Scheduled(cron = "0 0 0 * * ?") // Ejecuta todos los días a medianoche
    public void verificarEdadUsuario() {
        List<Usuario> usuarios = UsuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoDocumento().equalsIgnoreCase("TI")) {
                Period edad = Period.between(usuario.getFechaNacimiento(), LocalDate.now());
                if (edad.getYears() >= 18) {
                    enviarCorreoRecordatorio(usuario, "Debes actualizar tu tarjeta de identidad.");
                }
            }
        }
    }

    // Notificación para cambiar la contraseña cada media hora
    @Scheduled(cron = "0 0/30 * * * ?") // Ejecuta cada 30 minutos
    public void notificarCambioContrasena() {
        List<Usuario> usuarios = UsuarioService.findAll();
        for (Usuario usuario : usuarios) {
            enviarCorreoRecordatorio(usuario, "Es recomendable que cambies tu contraseña.");
        }
    }

    // Verifica si el usuario no ha iniciado sesión hace más de un mes y bloquea la cuenta
    @Scheduled(cron = "0 0 0 * * SUN") // Ejecuta todos los domingos a medianoche
    public void verificarInactividadUsuario() {
        List<Usuario> usuarios = UsuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (Period.between(usuario.getFechaUltimoInicioSesion(), LocalDate.now()).getMonths() >= 1) {
                usuario.setEstado("BLOQUEADO");
                UsuarioService.save(usuario);
                enviarCorreoNotificacion(usuario, "Tu cuenta ha sido bloqueada por inactividad.");
            }
        }
    }

    // Verifica registros sin actualizar en más de 90 días
    @Scheduled(cron = "0 0 0 * * ?") // Ejecuta todos los días a medianoche
    public void verificarActualizacionUsuario() {
        List<Usuario> usuarios = UsuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (Period.between(usuario.getFechaUltimaActualizacionContrasena(), LocalDate.now()).getDays() >= 90) {
                enviarCorreoRecordatorio(usuario, "Hace más de 90 días que no actualizas tu información.");
            }
        }
    }

    // Enviar correo si no ha sido notificado
    @Scheduled(cron = "0 0 9 * * ?") // Ejecuta todos los días a las 9 AM
    public void enviarCorreoSiNoNotificado() {
        List<Usuario> usuarios = UsuarioService.findAll();
        for (Usuario usuario : usuarios) {
            if (!usuario.isNotificado()) {
                enviarCorreoNotificacion(usuario, "¡Bienvenido! Gracias por registrarte.");
                usuario.setNotificado(true);
                UsuarioService.save(usuario);
            }
        }
    }

    private void enviarCorreoNotificacion(Usuario usuario, String mensaje) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(usuario.getCorreoElectronico());
        mailMessage.setSubject("Notificación del sistema");
        mailMessage.setText(mensaje);
        emailService.sendEmail(mailMessage);
    }

    private void enviarCorreoRecordatorio(Usuario usuario, String mensaje) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(usuario.getCorreoElectronico());
        mailMessage.setSubject("Recordatorio del sistema");
        mailMessage.setText(mensaje);
        emailService.sendEmail(mailMessage);
    }*/
}