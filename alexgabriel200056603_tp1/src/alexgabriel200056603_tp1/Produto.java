package alexgabriel200056603_tp1;

import java.util.Random;
public class Produto {
	//Declarações
	private String nome, descricao;
	private Float valor, porcentagem;
	private int quantidade;
	private Random gerador = new Random();
	//instruções
	public Produto() {
		this.nome = "produto";
		this.descricao = "sem descrição";
		this.valor = gerador.nextFloat() * 100;
		this.porcentagem = gerador.nextFloat() * 100;;
		this.quantidade = gerador.nextInt(100);
	}
	
	//----------------------getters and setters------------------------
	public String getNome() {
		return this.nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String desc) {
		this.descricao = desc;
	}
	
	public Float getValor() {
		return this.valor;
	}
	public void setValor(Float value) {
		this.valor = value;
	}
	
	public Float getPorcentagem() {
		return this.porcentagem;
	}
	public void setPorcentagem(Float percent) {
		this.porcentagem = percent;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int qtd) {
		this.quantidade = qtd;
	}
	//----------------------------------------------------------------------
	
}









