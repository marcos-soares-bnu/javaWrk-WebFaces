package br.com.proway.view;

import java.util.Date;

public class Cliente {

	private int codigo;
	private String nome;
	private int cpf;
	private int rg;
	private Date dataNascimento;

	public Cliente() {

	}

	
	
	


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente(int codigo, String nome, int cpf, int rg, Date dataNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

}