package br.com.unipds.fundamentosjava.desafio;

import java.util.Objects;

public class Produto {

    private final int id;
    private final String nome;
    private final double preco;
    private final int quantidadeEmEstoque;

    private Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public static Produto criarProduto(int id, String nome, double preco, int quantidadeEmEstoque) {
        try {
            validarId(id);
            validarNome(nome);
            validarPreco(preco);
            validarQuantidadeEmEstoque(quantidadeEmEstoque);
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível criar um novo produto, pois não foi atendida a seguinte condição: " + e.getMessage());
            return null;
        }
        return new Produto(id, nome, preco, quantidadeEmEstoque);
    }

    private static void validarId(int id) {
        if (id < 1) throw new IllegalArgumentException("O identificador do produto deve ser maior que zero");
    }

    private static void validarNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        if (!nome.matches("[a-zA-Z0-9\\s\\-_.,()&']+")) throw new IllegalArgumentException("O nome não pode conter caracteres especiais");
    }

    private static void validarPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("O preço não pode ser menor que zero");
    }

    private static void validarQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) throw new IllegalArgumentException("A quantidade em estoque não pode ser menor que zero");
    }

    public static Produto alterarNome(String nome, Produto produto) {
        if (!produto.nome.equals(nome)) {
            try {
                validarNome(nome);
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível alterar o nome, pois não foi atendida a seguinte condição: " + e.getMessage());
                return produto;
            }
            return new Produto(produto.id, nome, produto.preco, produto.quantidadeEmEstoque);
        }
        return produto;
    }

    public static Produto alterarPreco(double preco, Produto produto) {
        if (produto.preco != preco) {
            try {
                validarPreco(preco);
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível alterar o preço, pois não foi atendida a seguinte condição: " + e.getMessage());
                return produto;
            }
            return new Produto(produto.id, produto.nome, preco, produto.quantidadeEmEstoque);
        }
        return produto;
    }

    public static Produto alterarQuantidadeEmEstoque(int quantidadeEmEstoque, Produto produto) {
        if (produto.quantidadeEmEstoque != quantidadeEmEstoque) {
            try {
                validarQuantidadeEmEstoque(quantidadeEmEstoque);
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível alterar a quantidade em estoque, pois não foi atendida a seguinte condição: " + e.getMessage());
                return produto;
            }
            return new Produto(produto.id, produto.nome, produto.preco, quantidadeEmEstoque);
        }
        return produto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id &&
                Double.compare(preco, produto.preco) == 0 &&
                quantidadeEmEstoque == produto.quantidadeEmEstoque &&
                Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, quantidadeEmEstoque);
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }
}
