package com.example.EmpresaApi.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.EmpresaApi.Repository.CargoRepository;
import com.example.EmpresaApi.Repository.FuncionarioRepository;
import com.example.EmpresaApi.models.Cargo;
import com.example.EmpresaApi.models.Funcionario;

import lombok.Data;


@Data
public class FuncionarioForm
{

    @NotNull @NotEmpty 
    private String nomeFuncionario;
    @NotNull @NotEmpty
    private String funcaoFuncionario;
    @NotNull @NotEmpty
    private String cpf;
    //@NotNull @NotEmpty
    //private Double salario;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }
    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }
    /*
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    */

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Funcionario criarFuncionario(Long id, CargoRepository cargoRepository)
    {
        Cargo cargo = cargoRepository.findByfuncao(this.funcaoFuncionario);

        return new Funcionario(id ,this.nomeFuncionario, cargo, this.cpf);
    }
    public Funcionario atualizarFuncionario(Long id, FuncionarioRepository funcionarioRepository)
    {
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        funcionario.setCpf(this.cpf);

        return funcionario;
   
    }
}
