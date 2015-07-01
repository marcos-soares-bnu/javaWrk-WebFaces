package br.com.proway.model;

public class Atividade {

	private int codigo;
	private String titulo;
	private String descricao;
	private int codigocliente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigocliente() {
		return codigocliente;
	}
	public void setCodigocliente(int codigocliente) {
		this.codigocliente = codigocliente;
	}
	
	public Atividade() {
		
	}
	
	public Atividade(int codigo, String titulo, String descricao,
			int codigocliente) {

		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigocliente = codigocliente;
	}	
	
	
	
}
