package com.sena.scheduler.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    
    @Column(name = "tipo_documento", nullable = false, length = 3)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 11)
    private String numeroDocumento;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_nacimiento", nullable = false, length = 15)
    private LocalDate fechaNacimiento;

    @Column(name = "contrasena", nullable = false )
    private String contrasena;

    @Column(name = "fecha_ultima_actualizacion_contrasena", nullable = false, length = 15)
    private LocalDate fechaUltimaActualizacionContrasena;

    @Column(name = "fecha_ultimo_inicio_sesion", nullable = false, length = 15)
    private LocalDate fechaUltimoInicioSesion;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "correo_electronico", nullable = true, length = 100)
    private String correoElectronico;

    @Column(name = "notificado", nullable = false)
    private boolean notificado;

	public Usuario() {
		super();
	}

	public Usuario(String id, String tipoDocumento, String numeroDocumento, String nombre,
			LocalDate fechaNacimiento, String contrasena, LocalDate fechaUltimaActualizacionContrasena,
			LocalDate fechaUltimoInicioSesion, String estado, String correoElectronico, boolean notificado) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.fechaUltimaActualizacionContrasena = fechaUltimaActualizacionContrasena;
		this.fechaUltimoInicioSesion = fechaUltimoInicioSesion;
		this.estado = estado;
		this.correoElectronico = correoElectronico;
		this.notificado = notificado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public LocalDate getFechaUltimaActualizacionContrasena() {
		return fechaUltimaActualizacionContrasena;
	}

	public void setFechaUltimaActualizacionContrasena(LocalDate fechaUltimaActualizacionContrasena) {
		this.fechaUltimaActualizacionContrasena = fechaUltimaActualizacionContrasena;
	}

	public LocalDate getFechaUltimoInicioSesion() {
		return fechaUltimoInicioSesion;
	}

	public void setFechaUltimoInicioSesion(LocalDate fechaUltimoInicioSesion) {
		this.fechaUltimoInicioSesion = fechaUltimoInicioSesion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public boolean isNotificado() {
		return notificado;
	}

	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}
}