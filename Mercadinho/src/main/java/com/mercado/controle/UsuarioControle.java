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

import com.mercado.modelo.UsuarioModelo;
import com.mercado.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
	
	@Autowired
	UsuarioRepositorio user;
	
	@GetMapping("/listar")
	public List<UsuarioModelo> listar() {
		return user.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<UsuarioModelo> buscar(@PathVariable Long id) {
		return user.findById(id);
	}
	
	@PostMapping("/salvar")
	public UsuarioModelo salvar(@RequestBody UsuarioModelo modelo) {
		return user.save(modelo);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		user.deleteById(id);
	}

}
