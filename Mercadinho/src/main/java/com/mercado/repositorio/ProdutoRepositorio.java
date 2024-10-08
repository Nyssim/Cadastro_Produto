package com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long>{

}