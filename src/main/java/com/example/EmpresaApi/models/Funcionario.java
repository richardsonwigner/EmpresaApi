package com.example.EmpresaApi.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Funcionario
{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	@ManyToOne
	@JoinColumn(name = "cargo_id" , nullable = false)
    private Cargo cargo;

	public Funcionario(String nome, Cargo cargo, String cpf, Double salario)
	{
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
	}
   
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario: " + "id:" + id + "| nome:'" + nome + "| cpf:" + cpf + "| salario:" + salario + "| cargo:" + cargo.getFuncao();
	}
}
