package com.soltec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministradorController {
	@RequestMapping("/")
    public String index() {
       
        return "index";
    }
	
	@PostMapping({"/validacion"})
	public String validacion() {
		System.out.println("bien");
		return "prueba";
	}
	
}
