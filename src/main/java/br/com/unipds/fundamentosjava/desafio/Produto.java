package br.com.unipds.fundamentosjava.desafio;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        validarParametros(id, nome, preco, quantidadeEmEstoque);

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        validaId(id);
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validaNome(nome);
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validaPreco(preco);
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        validaQuantidadeEmEstooque(quantidadeEmEstoque);
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    private void validarParametros(int id, String nome, double preco, int quantidadeEmEstoque) {
        validaId(id);
        validaNome(nome);
        validaPreco(preco);
        validaQuantidadeEmEstooque(quantidadeEmEstoque);
    }

    private void validaId(int id) {
        if(id < 0) throw new IllegalArgumentException("Id inválido");
    }

    private void validaNome(String nome) {
        if(nome == null || nome.isBlank() || Character.isDigit(nome.charAt(0))) throw new IllegalArgumentException("Nome inválido");
    }

    private void validaPreco(double preco) {
        if(preco < 0) throw new IllegalArgumentException("Preço inválido");
    }

    private void validaQuantidadeEmEstooque(int quantidadeEmEstoque) {
        if(quantidadeEmEstoque < 0) throw new IllegalArgumentException("Quantidade em estoque inválida");
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }
}
