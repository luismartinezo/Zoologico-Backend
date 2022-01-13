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
import com.coomeva.prueba.Model.Guia;
import com.coomeva.prueba.Repository.GuiaRepository;
import com.coomeva.prueba.Util.restResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */ 
@RestController
@RequestMapping("/api/v1/guias")
@CrossOrigin(origins = "*")
public class GuiaController {

	@Autowired
	private GuiaRepository guiaRepository;
	
	protected ObjectMapper mapper;
	
	@GetMapping
	private ResponseEntity<List<Guia>> getAllGuias (){
		return ResponseEntity.ok(guiaRepository.findAll());
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Guia> getGuiaById(@PathVariable(value = "id") Long guiaId)
			throws ResourceNotFoundException {
		Guia guia = guiaRepository.findById(guiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Guia no funciona para el id :: " + guiaId));
		return ResponseEntity.ok().body(guia);
	}

	@PostMapping("/create")
	public restResponse createGuia(@Validated @RequestBody String guiaJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();
        Guia guia = this.mapper.readValue(guiaJson, Guia.class);
        
		if (!this.validate(guia)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
		if (guiaRepository.existsById(guia.getId())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "El Guia ya existe");
        }
		this.guiaRepository.save(guia);
		 return new restResponse(HttpStatus.OK.value(), "Guia creado con exito");
		
	}
	
	@PostMapping("/update")
	public restResponse update(@RequestBody String guiaJson)
			throws JsonMappingException, JsonProcessingException, coomevaExcepcion {
		this.mapper = new ObjectMapper();

		Guia guia = this.mapper.readValue(guiaJson, Guia.class);

		if (!guiaRepository.existsById(guia.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el guia en la base de datos");
		}

		if (!this.validate(guia)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		this.guiaRepository.save(guia);
		return new restResponse(HttpStatus.OK.value(), "Guia actualizo con exito");
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteGuia(@PathVariable(value = "id") Long guiaId)
			throws ResourceNotFoundException {
		Guia guia = guiaRepository.findById(guiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Rol con id :: " + guiaId +" No existe"));

		guiaRepository.delete(guia);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Guia Eliminado", Boolean.TRUE);
		return response;
	}
	
	// Validaciones
		private boolean validate(Guia guia) {
			boolean isValid = true;

			if (guia.getNombre() == null || guia.getNombre() == "" ) {
				isValid = false;
			}
			
			return isValid;
		}
}
