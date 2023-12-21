package br.com.crud.model;

public class Voo {

	private int id;
	private String origem;
	private String destino;
	
	public Voo() {
	}
	
	public Voo (String origem, String destino) {
		this.origem = origem;
		this.destino = destino;
	}
	
	public Voo (int id, String origem, String destino) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
	}
	
	public int getId() {
	return id;
	}
	
	public void setId(int id) {
	this.id = id;
	}
	
	public String getOrigem() {
	return origem;
	}
	
	public void setOrigem(String origem) {
	this.origem = origem;	
	}
	
	public String getDestino() {
	return destino;
	}
	
	public void setDestino(String destino) {
	this.destino = destino;	
	}
	
	public String toString() {
		return "Voo [id=" + id + ", origem=" + origem + ", destino=" + destino + "]";
	}

}
