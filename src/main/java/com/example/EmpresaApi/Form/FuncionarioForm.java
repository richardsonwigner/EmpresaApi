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
    @NotNull @NotEmpty
    private Cargo cargo;
    @NotNull @NotEmpty
    private Double salario;


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

    public Funcionario converterFuncionario(CargoRepository cargoRepository)
    {
        Cargo cargo = cargoRepository.findByfuncao(this.funcaoFuncionario);

        return new Funcionario(this.nomeFuncionario, cargo, this.cpf, this.salario);
    }
    public Funcionario atualizarFuncionario(Integer id, FuncionarioRepository funcionarioRepository)
    {
        Funcionario funcionario = funcionarioRepository.getById(id);

        funcionario.setCargo(this.cargo);
        return funcionario;
   

    }
}
