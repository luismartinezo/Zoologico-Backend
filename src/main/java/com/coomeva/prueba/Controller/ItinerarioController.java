/**
 * 
 */
package com.coomeva.prueba.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.coomeva.prueba.Exception.ResourceNotFoundException;
import com.coomeva.prueba.Exception.coomevaExcepcion;
import com.coomeva.prueba.Model.Itinerario;
import com.coomeva.prueba.Repository.ItinerarioRepository;
import com.coomeva.prueba.Util.restResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */ 
@RestController
@RequestMapping("/api/v1/itinerarios")
@CrossOrigin(origins = "*")
public class ItinerarioController {

	@Autowired
	private ItinerarioRepository itinerarioRepository;
	
	protected ObjectMapper mapper;
	
	@GetMapping
	private ResponseEntity<List<Itinerario>> getAllItinerarios (){
		return ResponseEntity.ok(itinerarioRepository.findAll());
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Itinerario> getItinerarioById(@PathVariable(value = "id") Long itinerarioId)
			throws ResourceNotFoundException {
		Itinerario itinerario = itinerarioRepository.findById(itinerarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Itinerario no funciona para el id :: " + itinerarioId));
		return ResponseEntity.ok().body(itinerario);
	}

	@PostMapping("/create")
	public restResponse createItinerario(@Validated @RequestBody String itinerarioJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();
        Itinerario itinerario = this.mapper.readValue(itinerarioJson, Itinerario.class);
        
		if (!this.validate(itinerario)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
		if (itinerarioRepository.existsById(itinerario.getId())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "El Itinerario ya existe");
        }
		this.itinerarioRepository.save(itinerario);
		 return new restResponse(HttpStatus.OK.value(), "Itinerario creado con exito");
		
	}
	
	@PostMapping("/update")
	public restResponse update(@RequestBody String itinerarioJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();

		Itinerario itinerario = this.mapper.readValue(itinerarioJson, Itinerario.class);

		if (!itinerarioRepository.existsById(itinerario.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el itinerario en la base de datos");
		}

		if (!this.validate(itinerario)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		this.itinerarioRepository.save(itinerario);
		return new restResponse(HttpStatus.OK.value(), "Itinerario actualizo con exito");
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteItinerario(@PathVariable(value = "id") Long itinerarioId)
			throws ResourceNotFoundException {
		Itinerario itinerario = itinerarioRepository.findById(itinerarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Rol con id :: " + itinerarioId +" No existe"));

		itinerarioRepository.delete(itinerario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Itinerario Eliminado", Boolean.TRUE);
		return response;
	}
	
	// Validaciones
		private boolean validate(Itinerario itinerario) {
			boolean isValid = true;

			if (itinerario.getCodigo() == 0 ) {
				isValid = false;
			}
			
			return isValid;
		}
}
