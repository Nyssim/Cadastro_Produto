package com.mercado.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/listar")
	public List<ProdutoModelo> listar() {
		return prod.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<ProdutoModelo> buscar(@PathVariable Long id) {
		return prod.findById(id);
	}
	
	@PostMapping("/salvar")
	public ProdutoModelo salvar(@RequestBody ProdutoModelo modelo) {
		return prod.save(modelo);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		prod.deleteById(id);
	}
}
