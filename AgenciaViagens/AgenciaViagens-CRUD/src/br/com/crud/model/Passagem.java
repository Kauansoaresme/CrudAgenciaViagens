package br.com.crud.model;

public class Passagem {

	private int id;
	private String classe;
	private Double preco;
	
	private Cliente cliente;
	private Voo voo;
	
	public Passagem() {
	}
	
	public Passagem(int id, String classe, Double preco, Cliente cliente, Voo voo) {
		this.id = id;
		this.classe = classe;
		this.preco = preco;
		this.cliente = cliente;
		this.voo = voo;
	}
	public Passagem(String classe, Double preco, Cliente cliente, Voo voo) {
		this.classe = classe;
		this.preco = preco;
		this.cliente = cliente;
		this.voo = voo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Voo getVoo() {
		return voo;
	}
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	@Override
	public String toString() {
		return " [id=" + id + ", classe=" + classe + ", preco=" + preco + ", cliente=" + cliente + ", voo=" + voo + "]";
	}
	
	
}