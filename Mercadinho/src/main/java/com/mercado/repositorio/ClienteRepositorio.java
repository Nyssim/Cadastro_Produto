package com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.modelo.ClienteModelo;

public interface ClienteRepositorio extends JpaRepository<ClienteModelo, Long>{

}
