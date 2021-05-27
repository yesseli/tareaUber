package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Piloto;
import com.example.demo.repositories.pilotoRepository;

@RestController
@RequestMapping(value="/piloto")
public class pilotoController {
	
	@Autowired
	pilotoRepository repository;
	
	//mostrar
	@GetMapping
	public Iterable <Piloto> findAll(){
		Iterable<Piloto>PilotoList= repository.findAll();
		return PilotoList;
	}
	
	//crear
	@PostMapping
	public Piloto createPiloto (@RequestBody Piloto pilotos) {
		return repository.save(pilotos);
	}
	
	
	//buscar
	@GetMapping(value="/{id}")
	public Piloto getPiloto(@PathVariable(name="id")Long id){
		
		
		Optional<Piloto> pilotos = repository.findById(id);
		
		Piloto busqueda = null;
		if(pilotos.isPresent()) {
			busqueda = pilotos.get();
			
		}
		return busqueda;
		
	}
	
	
	//borrar
	@DeleteMapping (value="/{id}")
	public void borrarPiloto(@PathVariable(name="id")Long id) {
		
		
		repository.deleteById(id);
	}
	
	
	//Actualizar
	@PutMapping(value="/{id}")
	public Piloto actualizarInfoPiloto(@PathVariable(name="id")Long id,
			@RequestBody Piloto pilotos) {
		Optional <Piloto>nPiloto=repository.findById(id);
		
		if (nPiloto.isPresent()) {
			
			Piloto infActual = nPiloto.get();
			infActual.setId(pilotos.getId());
			infActual.setNombre(pilotos.getNombre());
			infActual.setApellido(pilotos.getApellido());
			infActual.setLicencia(pilotos.getLicencia());
			infActual.setMatricula(pilotos.getMatricula());
			Piloto pModificado=repository.save(infActual);
			
			return pModificado;	
		}
		return null;
	}
	
}
