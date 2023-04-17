package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import com.cursospring.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping(value = "api/login")
    public String verifyUsers(@RequestBody Usuario usuario) {

        Usuario userLog = usuarioDao.getUserByCredentials(usuario);
        System.out.println(usuario);
        if (userLog != null) {
            String token = jwtUtil.create(String.valueOf(userLog.getId()), userLog.getEmail());
            System.out.println(token);
            return token;
        }
        return "False";
    }

    //Min 3:54:46
}
