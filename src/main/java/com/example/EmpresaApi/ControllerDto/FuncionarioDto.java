package com.example.EmpresaApi.ControllerDto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.EmpresaApi.models.Funcionario;

import lombok.Data;

@Data
public class FuncionarioDto 
{
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private double salario;

    public FuncionarioDto(Funcionario funcionario)
    {
        this.nome = funcionario.getNome();
        this.salario = funcionario.getSalario();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static List<FuncionarioDto> converter(List<Funcionario> funcionario)
    {

        return funcionario.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }
}
