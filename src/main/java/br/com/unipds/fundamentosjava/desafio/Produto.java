package br.com.unipds.fundamentosjava.desafio;

public class Produto {

	private int id;
	private String nome;
	private double preco;
	private int quantidadeEmEstoque;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome do produto deve ser preenchido");
		}
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("O preço não pode ser negativo");
		}
		this.preco = preco;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		if (quantidadeEmEstoque < 0) {
			throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa");
		}
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
		this.id = id;
		setNome(nome);
		setPreco(preco);
		setQuantidadeEmEstoque(quantidadeEmEstoque);
	}

	@Override
	public String toString() {
		return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
	}
}
