package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.services.FlorServiceImpl;

@RestController
@RequestMapping("/flor")
public class FlorController {

	@Autowired
	FlorServiceImpl florServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<?> addFlor(@RequestBody FlorDTO florDTO) {
		ResponseEntity<?> responseEntity;

		FlorDTO florDTOBuscar = florServiceImpl.addFlor(florDTO);
		if (florDTOBuscar != null) {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(florDTO);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("La flor amb id " + florDTO.getPk_FlorID() + " ya existeix.");
		}
		return responseEntity;

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateFlor(@RequestBody FlorDTO florDTO) {
		ResponseEntity<?> responseEntity;
		try {
			florServiceImpl.getOneFlor(florDTO.getPk_FlorID());
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(florServiceImpl.updateFlor(florDTO));

		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("La flor amb id " + florDTO.getPk_FlorID() + " no existeix.");
		}

		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFlor(@PathVariable int id) {
		ResponseEntity<?> responseEntity;
		try {
			florServiceImpl.deleteFlor(id);
			responseEntity = ResponseEntity.status(HttpStatus.OK)
					.body("Flor amd id " + id + " eliminada correctament.");
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La flor amb id " + id + " no existeix.");
		}

		return responseEntity;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOneFlor(@PathVariable int id) {
		ResponseEntity<?> responseEntity;
		try {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(florServiceImpl.getOneFlor(id));
		} catch (NullPointerException e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La flor amb id " + id + " no existeix.");
		}
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllFlor() {
		ResponseEntity<?> responseEntity;
		List<FlorDTO> listadoFlorDTO = florServiceImpl.getAllFlor();
		if (listadoFlorDTO.size() > 0) {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(listadoFlorDTO);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La llista es buida.");
		}
		return responseEntity;
	}
}