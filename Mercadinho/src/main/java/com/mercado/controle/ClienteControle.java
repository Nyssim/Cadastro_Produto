package com.mercado.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.modelo.ClienteModelo;
import com.mercado.modelo.ProdutoModelo;
import com.mercado.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {
	
	@Autowired
	ClienteRepositorio cliente;
	
	@PostMapping("/salvar")
	public ClienteModelo salvar(@RequestBody ClienteModelo entity) {
		return cliente.save(entity);
	}

}
