package com.example.EmpresaApi.ControllerDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.EmpresaApi.models.Funcionario;

import org.springframework.data.domain.Page;

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

    public static Page<FuncionarioDto> converter(Page<Funcionario> funcionario)
    {
        return funcionario.map(FuncionarioDto::new);
    }
}
