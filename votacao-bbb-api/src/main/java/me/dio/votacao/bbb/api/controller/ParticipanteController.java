package me.dio.votacao.bbb.api.controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.votacao.bbb.api.model.ParticipanteModel;
import me.dio.votacao.bbb.api.repository.ParticipanteRepository;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

	private final ParticipanteRepository repository;

	public ParticipanteController(ParticipanteRepository repository) {
		this.repository = repository;
	}
	
    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
    	ParticipanteModel entidade = repository.save(participante);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consultar(@RequestParam String id) {
        Optional<ParticipanteModel> optParametro = repository.findById(id);
        if (optParametro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optParametro.get());
    }
}
