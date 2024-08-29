package com.sena.scheduler.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String enviarCorreoBienvenida(String destinatario, String nombre) {
		try {
			String asunto = "¡Bienvenid@ a Nuestra Plataforma!";
			String cuerpo = "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
					+ "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
					+ "  <h1 style=\"font-size: 24px; font-weight: bold; color: #4a90e2;\">¡Hola " + nombre + "!</h1>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Estamos emocionados de darte la bienvenida a nuestra plataforma.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Nuestra plataforma está diseñada para ofrecerte la mejor experiencia posible.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">No dudes en explorar todas las funciones y contactarnos si necesitas ayuda.</p>\r\n"
					+ "</div>\r\n"
					+ "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Términos y condiciones</a> | \r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Política de privacidad</a>\r\n"
					+ "</div>\r\n"
					+ "</body>";

			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}

		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}

	public String iniciosesionNotificar(String destinatario, String nombre) {
		try {
			String asunto = "Inicia sesión para evitar el bloqueo de tu cuenta";
			String cuerpo = "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
					+ "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
					+ "  <h1 style=\"font-size: 24px; font-weight: bold; color: #4a90e2;\">¡Hola " + nombre + "!</h1>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Para mantener tu cuenta activa, por favor inicia sesión regularmente.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Si no inicias sesión en los próximos días, tu cuenta podría ser bloqueada.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Accede ahora y evita cualquier inconveniente.</p>\r\n"
					+ "</div>\r\n"
					+ "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Términos y condiciones</a> | \r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Política de privacidad</a>\r\n"
					+ "</div>\r\n"
					+ "</body>";

			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}

		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}

	public String actualizarContraseña(String destinatario, String nombre) {
		try {
			String asunto = "Actualiza tu contraseña";
			String cuerpo = "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
					+ "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
					+ "  <h1 style=\"font-size: 24px; font-weight: bold; color: #4a90e2;\">¡Hola " + nombre + "!</h1>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Es hora de actualizar tu contraseña para mantener tu cuenta segura.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Te recomendamos hacer esto cada cierto tiempo para proteger tu información.</p>\r\n"
					+ "  <p style=\"font-size: 16px; color: #555555;\">Accede a tu cuenta y cambia tu contraseña en la sección de configuración.</p>\r\n"
					+ "</div>\r\n"
					+ "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Términos y condiciones</a> | \r\n"
					+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Política de privacidad</a>\r\n"
					+ "</div>\r\n"
					+ "</body>";


			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}

		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}

	public String cambiarTipoDocumento(String destinatario, String nombre) {
		try {
		String asunto = "Es hora de actualizar tu tipo de documento";
		String cuerpo = "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
				+ "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
				+ "  <h1 style=\"font-size: 24px; font-weight: bold; color: #4a90e2;\">¡Hola " + nombre + "!</h1>\r\n"
				+ "  <p style=\"font-size: 16px; color: #555555;\">Queremos recordarte que es el momento de actualizar tu tipo de documento.</p>\r\n"
				+ "  <p style=\"font-size: 16px; color: #555555;\">Es un proceso rápido que te ayudará a mantener tus datos al día.</p>\r\n"
				+ "  <p style=\"font-size: 16px; color: #555555;\">Por favor, accede a tu cuenta y realiza la actualización lo antes posible.</p>\r\n"
				+ "</div>\r\n"
				+ "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
				+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Términos y condiciones</a> | \r\n"
				+ "  <a href=\"#\" style=\"font-size: 14px; color: #4a90e2; text-decoration: none;\">Política de privacidad</a>\r\n"
				+ "</div>\r\n"
				+ "</body>";

		 var retorno=enviarCorreo(destinatario,asunto,cuerpo);
         if(retorno) {
             return "se envió correctamente";
         }else {
             return "No se pudo envíar";
         }

     }catch (Exception e) {
         // TODO: handle exception
         return "Error al envíar "+e.getMessage();
     }
 }

	public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo, true);

			javaMailSender.send(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}