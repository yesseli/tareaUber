package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.viaje;
import com.example.demo.repositories.viajeRepository;

//Mostrar lista de viajes
@RestController
@RequestMapping(value = "/viaje")
public class viajeController {

	@Autowired
	viajeRepository repository;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	public Collection<viaje> getViajeList() {

		Iterable<viaje> ViajeList = repository.findAll();
		return (Collection<viaje>) ViajeList;

	}

	// crear viaje
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public viaje nuevoViaje(@RequestBody viaje viajes) {
		viaje nViaje = repository.save(viajes);
		return nViaje;

	}

	// Buscar viajes creados

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public viaje getViaje(@PathVariable(name = "id") Long id) {

		Optional<viaje> viajes = repository.findById(id);

		viaje resultado = null;
		if (viajes.isPresent()) {
			resultado = viajes.get();
		}
		return resultado;
	}

	// modificar viajes
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public viaje modificarViaje(@PathVariable(name = "id") Long id, @RequestBody viaje viajes) {
		Optional<viaje> modViaje = repository.findById(id);

		if (modViaje.isPresent()) {
			viaje actual = modViaje.get();
			actual.setId(viajes.getId());
			actual.setId_Cliente(viajes.getId_Cliente());
			actual.setId_Piloto(viajes.getId_Piloto());
			actual.setOrigen(viajes.getOrigen());
			actual.setDestino(viajes.getDestino());
			actual.setEstado(viajes.getEstado());
			actual.setMonto(viajes.getMonto());

			viaje modificado = repository.save(actual);

			return modificado;
		}
		return null;
	}

}
