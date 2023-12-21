package br.com.crud.model;

public class Cliente {

	private int id;
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	private String senha;
	
	public Cliente() {
	}
	
	public Cliente (int id, String nome, String cpf, String celular, String email, String senha ) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente (String nome, String cpf, String celular, String email, String senha ) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
	}
	
	
	public int getId() {
	return id;
	}
	
	public void setId(int id) {
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
	
	public String getCelular() {
	return celular;
	}
	
	public void setCelular(String celular) {
	this.celular = celular;
	}
	
	public String getEmail() {
	return email;
	}
	
	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getSenha() {
	return senha;
	}
	
	public void setSenha(String senha) {
	this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", email=" + email + ", senha=" + senha + "]";
	}
}