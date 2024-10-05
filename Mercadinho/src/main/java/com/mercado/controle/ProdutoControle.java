package com.mercado.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.modelo.ProdutoModelo;
import com.mercado.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
public class ProdutoControle {

	@Autowired
	ProdutoRepositorio prod;
	
	@PostMapping("/salvar")
	public ProdutoModelo salvar(@RequestBody ProdutoModelo entity) {
		return prod.save(entity);
	}
}
