package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n03.S05T01N03FernandezVidalAlejandro.controllers;

import java.util.List;

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
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n03.S05T01N03FernandezVidalAlejandro.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n03.S05T01N03FernandezVidalAlejandro.model.dto.FlorDTO;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flor")
public class FlorController {

	WebClient webClient = WebClient.create();

	@PostMapping("/clientFlorsAdd")
	public Object add(@RequestBody FlorEntity florEntity) {
		WebClient.ResponseSpec responseSpec = webClient.post().uri("http://localHost:9001/flor/add").body(Mono.just(florEntity), FlorEntity.class).retrieve();
		Object responseBody = responseSpec.bodyToMono(Object.class).onErrorReturn("Error con el ID " + florEntity.getPk_FlorID()).block();
		return responseBody;

	}

	@PutMapping("/clientFlorsUpdate")
	public Object update(@RequestBody FlorEntity florEntity) {

		WebClient.ResponseSpec responseSpec = webClient.put().uri("http://localHost:9001/flor/update").body(Mono.just(florEntity),FlorEntity.class).retrieve();
		Object responseBody = responseSpec.bodyToMono(Object.class).onErrorReturn("Error con el ID " + florEntity.getPk_FlorID()).block();
		return responseBody;
	}

	@DeleteMapping("/clientFlorsDelete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseEntity<?> responseBody;
		try {
		WebClient.ResponseSpec responseSpec = webClient.delete().uri("http://localHost:9001/flor/delete/" + id)
				.retrieve();
		responseBody = ResponseEntity.status(HttpStatus.OK).body(responseSpec.bodyToMono(String.class).block());
		} catch(WebClientResponseException e) {
			responseBody = ResponseEntity.status(e.getRawStatusCode()).body("Error con el ID " + id); 
		}
		return responseBody;

	}

	@GetMapping("/clientFlorsGetOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		ResponseEntity<?> responseBody;
		try {
			WebClient.ResponseSpec responseSpec = webClient.get().uri("http://localHost:9001/flor/getOne/" + id).retrieve();
		responseBody = ResponseEntity.status(HttpStatus.OK).body(responseSpec.bodyToMono(FlorDTO.class).block());
		
		}catch(WebClientResponseException e) {
			
		responseBody = ResponseEntity.status(e.getRawStatusCode()).body(e.getMessage());
		}
		return responseBody;
		}
		//Para ignorar error al recibir respuesta de la API2
		/*Mono<FlorDTO> peticion = webClient.get()
	     .uri("http://localHost:9001/flor/getOne/" + id)
	     .retrieve()
	     .bodyToMono(FlorDTO.class)
	     .onErrorResume(WebClientResponseException.class,
	          ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
		return peticion;}*/
		//Obtengo respuesta correcta en la incorrecta no funciona
		/*Mono<FlorDTO> entityMono = webClient.get()
			     .uri("http://localHost:9001/flor/getOne/" + id)
			     .accept(MediaType.APPLICATION_JSON)
			     .exchangeToMono(response -> {
			         if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToMono(FlorDTO.class);
			         }
			         else {
			             return response.createException().flatMap(Mono::error);
			         }
			     });
		return entityMono;*/

	@GetMapping("/clientFlorsAll")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> responseBody;
		try {
		WebClient.ResponseSpec responseSpec = webClient.get().uri("http://localHost:9001/flor/getAll").retrieve();
		
		
			responseBody = ResponseEntity.status(HttpStatus.OK).body(responseSpec.bodyToMono(List.class).block());
		}catch(WebClientResponseException e) {
			responseBody = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La llista es buida.");
		}
		
		return responseBody;

	}

}
