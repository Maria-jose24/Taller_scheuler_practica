package com.example.scheuler.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.scheuler.model.Usuario;

public interface IUsuario extends CrudRepository <Usuario, String>{
}