package com.cursospring.curso.controllers;

import com.cursospring.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Takeshi");
        usuario.setApellido("Vargas");
        usuario.setEmail("takeshi@gmail.com");
        usuario.setTelefono("987654321");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Takeshi");
        usuario.setApellido("Vargas");
        usuario.setEmail("takeshi@gmail.com");
        usuario.setTelefono("987654321");

        Usuario usuario2 = new Usuario();
        usuario.setId(124L);
        usuario.setNombre("Obed");
        usuario.setApellido("murillo");
        usuario.setEmail("obed@gmail.com");
        usuario.setTelefono("987654321");

        usuarios.add(usuario);
        usuarios.add(usuario2);

        return usuarios;
    }

}
