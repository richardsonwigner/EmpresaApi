package com.example.EmpresaApi.Repository;


import com.example.EmpresaApi.models.Funcionario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>
{
    Funcionario findByNome(String nome);
}
