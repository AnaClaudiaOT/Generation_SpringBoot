package com.habilidades.habilidades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade")
public class BSM {
	@GetMapping
	public String hab() {
		return "\nPersistência \nProatividade \nAtenção aos Detalhes";
	}

}
