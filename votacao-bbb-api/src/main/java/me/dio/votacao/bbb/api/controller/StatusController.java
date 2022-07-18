package me.dio.votacao.bbb.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	@RequestMapping("/api/status")
	public ResponseEntity<String> status (){
		return ResponseEntity.ok("Ok, estamos online!");
	}
}
