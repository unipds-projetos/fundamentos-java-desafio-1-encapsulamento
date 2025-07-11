package br.com.unipds.fundamentosjava.desafio;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Criando Produtos e Alterando Atributos ---");

        Produto produto1 = Produto.criarProduto(101, "Caneta Azul", 1.50, 100);
        System.out.println("Produto 1 (Inicial): " + produto1);

        Produto.alterarPreco(-2.00, produto1);
        System.out.println("Produto 1 (Preço não alterado): " + produto1);

        Produto produto2 = Produto.criarProduto(102, "Azul Caneta", 15.00, 50);
        System.out.println("Produto 2 (Inicial): " + produto2);

        Produto.alterarQuantidadeEmEstoque(-5, produto2);
        System.out.println("Produto 2 (Estoque não alterado): " + produto2);

        Produto produto3 = Produto.criarProduto(103, "Borracha Branca", -0.50, 0);
        System.out.println("Produto 3 (Inicial): " + produto3);

        Produto produto4 = Produto.criarProduto(104, null, 10.00, 10);
        System.out.println("Produto 4 (Inicial): " + produto4);

    }
}