package com.example.EmpresaApi.Repository;

import com.example.EmpresaApi.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>
{
    Funcionario findByNome(String nome);
}
