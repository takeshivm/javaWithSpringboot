package com.cursospring.curso.dao;

import com.cursospring.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void delete(Long id);


    void registrar(Usuario usuario);

    Usuario getUserByCredentials(Usuario usuario);
}
