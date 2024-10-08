package com.mercado.controle;

import java.util.List;
import java.util.Optional;

import org.hibernate.loader.ast.internal.AbstractMultiIdEntityLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.modelo.ClienteModelo;
import com.mercado.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {
	
	@Autowired
	ClienteRepositorio cliente;
	
	@GetMapping("/listar")
	public List<ClienteModelo> listar(){
		return cliente.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<ClienteModelo> buscar(@PathVariable Long id) {
		return cliente.findById(id);
	}
	
	@PostMapping("/salvar")
	public ClienteModelo salvar(@RequestBody ClienteModelo modelo) {
		return cliente.save(modelo);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id, ClienteModelo clie) {
		cliente.delete(clie);
	}

	@PutMapping("/alterar/{id}")
	public ClienteModelo alterar(@PathVariable Long id, ClienteModelo entity) throws Exception {
		//Encontrando o cliente
		Optional<ClienteModelo> clienteEncontrado = cliente.findById(id);
		//Verificando se o cliente existe
		if(clienteEncontrado.isPresent()) {
			//Pegando as informações do Cliente encontrado
			ClienteModelo clienteAlterado = clienteEncontrado.get();
			//Atualizar os dados
			clienteAlterado.setNome(entity.getNome());
			clienteAlterado.setCpf(entity.getCpf());
			clienteAlterado.setEndereco(entity.getEndereco());
			clienteAlterado.setIsativo(true);
			return cliente.save(clienteAlterado);
		} else {
			throw new Exception("Produto com o ID " + id + " não encontrado");
		}
			
	}
	
}
