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
import com.coomeva.prueba.Model.Zona;
import com.coomeva.prueba.Repository.ZonaRepository;
import com.coomeva.prueba.Util.restResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */ 
@RestController
@RequestMapping("/api/v1/zonas")
@CrossOrigin(origins = "*")
public class ZonaController {

	@Autowired
	private ZonaRepository guiaRepository;
	
	protected ObjectMapper mapper;
	
	@GetMapping
	private ResponseEntity<List<Zona>> getAllZonas (){
		return ResponseEntity.ok(guiaRepository.findAll());
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Zona> getZonaById(@PathVariable(value = "id") Long guiaId)
			throws ResourceNotFoundException {
		Zona zona = guiaRepository.findById(guiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Zona no funciona para el id :: " + guiaId));
		return ResponseEntity.ok().body(zona);
	}

	@PostMapping("/create")
	public restResponse createZona(@Validated @RequestBody String guiaJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();
        Zona zona = this.mapper.readValue(guiaJson, Zona.class);
        
		if (!this.validate(zona)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
		if (guiaRepository.existsById(zona.getId())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "El Zona ya existe");
        }
		this.guiaRepository.save(zona);
		 return new restResponse(HttpStatus.OK.value(), "Zona creado con exito");
		
	}
	
	@PostMapping("/update")
	public restResponse update(@RequestBody String guiaJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();

		Zona zona = this.mapper.readValue(guiaJson, Zona.class);

		if (!guiaRepository.existsById(zona.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el zona en la base de datos");
		}

		if (!this.validate(zona)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		this.guiaRepository.save(zona);
		return new restResponse(HttpStatus.OK.value(), "Zona actualizo con exito");
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteZona(@PathVariable(value = "id") Long guiaId)
			throws ResourceNotFoundException {
		Zona zona = guiaRepository.findById(guiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Rol con id :: " + guiaId +" No existe"));

		guiaRepository.delete(zona);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Zona Eliminado", Boolean.TRUE);
		return response;
	}
	
	// Validaciones
		private boolean validate(Zona zona) {
			boolean isValid = true;

			if (zona.getNombre() == null || zona.getNombre() == "" ) {
				isValid = false;
			}
			
			return isValid;
		}
}
