package com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.modelo.UsuarioModelo;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long>{

}
