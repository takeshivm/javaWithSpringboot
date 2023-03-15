package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//import java.security.SecureRandom;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
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

        // Generar una sal aleatoria
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        String salt = Base64.getEncoder().encodeToString(saltBytes);

        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 64, 1, 65536, 8);
        String hashedPassword = passwordEncoder.encode(usuario.getPassword() + salt);
        usuario.setPassword(hashedPassword);
        usuarioDao.registrar(usuario);
    }

    @DeleteMapping(value = "api/usuario/{id}")
    public void delete(@PathVariable Long id) {
        usuarioDao.delete(id);
    }

}
