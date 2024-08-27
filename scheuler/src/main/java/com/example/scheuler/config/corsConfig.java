package com.example.scheuler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class corsConfig {
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		// Permitir solicitudes desde todos los orígenes
		config.addAllowedOrigin("http://127.0.0.1:5501");
		config.addAllowedOrigin("http://localhost:5500");

		// Permitir solicitudes con estos métodos HTTP
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");

		// Permitir el envío de ciertos encabezados en las solicitudes
		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}