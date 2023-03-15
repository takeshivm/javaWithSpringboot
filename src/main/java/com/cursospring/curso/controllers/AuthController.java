package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;
    @PostMapping(value = "api/login")
    public String verifyUsers(@RequestBody Usuario usuario) {
        if (usuarioDao.verifyCredentials(usuario)) {
            return "OK";
        }
        return "False";
    }

}
