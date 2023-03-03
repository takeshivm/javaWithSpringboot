package com.cursospring.curso.controllers;

import com.cursospring.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    @ResponseBody
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Takeshi");
        usuario.setApellido("Vargas");
        usuario.setEmail("takeshi@gmail.com");
        usuario.setTelefono("987654321");
        return usuario;
    }

}
