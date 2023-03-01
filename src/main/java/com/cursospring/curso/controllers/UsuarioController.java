package com.cursospring.curso.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class UsuarioController {

    @RequestMapping(value = "prueba")
    public String prueba() {
        return "prueba";
    }

}
