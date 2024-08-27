package com.example.scheuler.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, unique = true, length = 10)
    private String numeroDocumento;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "contrasena", nullable = false, length = 100)
    private String contrasena;

    @Column(name = "fecha_ultima_actualizacion_contrasena", nullable = true)
    private LocalDate fechaUltimaActualizacionContrasena;

    @Column(name = "fecha_ultimo_inicio_sesion", nullable = true)
    private LocalDate fechaUltimoInicioSesion;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "correo_electronico", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(name = "notificado", nullable = false)
    private boolean notificado;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String tipoDocumento, String numeroDocumento, LocalDate fechaNacimiento, String contrasena,
			LocalDate fechaUltimaActualizacionContrasena, LocalDate fechaUltimoInicioSesion, String estado,
			String correoElectronico, boolean notificado) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.fechaUltimaActualizacionContrasena = fechaUltimaActualizacionContrasena;
		this.fechaUltimoInicioSesion = fechaUltimoInicioSesion;
		this.estado = estado;
		this.correoElectronico = correoElectronico;
		this.notificado = notificado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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