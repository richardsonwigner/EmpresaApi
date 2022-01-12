package com.example.EmpresaApi.Repository;

import java.util.Optional;

import com.example.EmpresaApi.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    Optional<Usuario> findByEmail(String email);
}
