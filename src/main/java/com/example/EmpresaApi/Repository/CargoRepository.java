package com.example.EmpresaApi.Repository;

import com.example.EmpresaApi.models.Cargo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer>
{
    Cargo findByfuncao(String funcao);
}
 