package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Takeshi");
        usuario.setApellido("Vargas");
        usuario.setEmail("takeshi@gmail.com");
        usuario.setTelefono("987654321");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }
    @PostMapping(value = "api/usuarios")
    public void registerUsers(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    @DeleteMapping(value = "api/usuario/{id}")
    public void delete(@PathVariable Long id) {
        usuarioDao.delete(id);
    }

}
