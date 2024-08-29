package com.sena.scheduler.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.scheduler.Models.Usuario;

public interface IUsuario extends CrudRepository <Usuario, String>{

	@Query ("SELECT u FROM usuario u WHERE u.nombre LIKE %?1% OR u.correoElectronico LIKE %?1% OR u.numeroDocumento LIKE %?1% OR u.estado LIKE %?1%")
    List<Usuario> filtroUsuario(String filtro);

    @Query ("SELECT u FROM usuario u WHERE DATEDIFF( u.fechaNacimiento, NOW())>=18 AND td = 'TI'")
    List<Usuario> cambiarTipoDocumento();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fechaUltimaActualizacionContrasena) >= 90")
    List<Usuario> actualizarContrasena();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fechaUltimoInicioSesion) >= 30")
    List<Usuario> iniciosesionNotificar();

    @Query("SELECT u FROM usuario u WHERE TIMESTAMDIFF(MINUTE, u.notificado, CURRENT_TIMESTAMP)=1")
    List<Usuario>notificacionRegistro();
}