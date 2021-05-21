package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.clienteRepository;

//Mostrar lista
@RestController
@RequestMapping(value = "/cliente")
public class clienteController {

	@Autowired
	clienteRepository repositorio;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	public Collection<Cliente> getClientesList() {

		Iterable<Cliente> ClientesList = repositorio.findAll();
		return (Collection<Cliente>) ClientesList;

	}

	// crear Cliente
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente registrarCliente(@RequestBody Cliente cliente) {
		Cliente nCliente = repositorio.save(cliente);
		return nCliente;

	}

	// Buscar

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente getCliente(@PathVariable(name = "id") Long id) {

		Optional<Cliente> cliente = repositorio.findById(id);

		Cliente resultado = null;
		if (cliente.isPresent()) {
			resultado = cliente.get();
		}
		return resultado;
	}

	// modificar
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Cliente actCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> nCliente = repositorio.findById(id);

		if (nCliente.isPresent()) {
			Cliente actual = nCliente.get();
			actual.setId(cliente.getId());
			actual.setNombre(cliente.getNombre());
			actual.setApellido(cliente.getApellido());
			actual.setTelefono(cliente.getTelefono());
			actual.setCorreo(cliente.getCorreo());
			Cliente modificado = repositorio.save(actual);

			return modificado;
		}
		return null;
	}
	
	//borrar
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void borrar(@PathVariable(name = "id") Long id) {

		repositorio.deleteById(id);

	}

}
