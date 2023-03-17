package com.cursospring.curso.dao;

import com.cursospring.curso.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verifyCredentials(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> list =  entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if (!list.isEmpty()){
            return false;
        }

        String salt = "s0uewk114lijs";
        String passwordHashed = list.get(0).getPassword();

        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 64, 1, 65536, 8);

        // Verificar si la contraseña ingresada coincide con el hash almacenado
        return passwordEncoder.matches(usuario.getPassword() + salt, passwordHashed);

    }

}
