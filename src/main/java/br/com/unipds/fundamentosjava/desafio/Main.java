package br.com.unipds.fundamentosjava.desafio;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Criando Produtos e Alterando Atributos ---");

        Produto produto1 = new Produto(101, "Caneta Azul", 1.50, 100);
        System.out.println("Produto 1 (Inicial): " + produto1);

        produto1.preco = -2.00;
        System.out.println("Produto 1 (Preço alterado): " + produto1);

        Produto produto2 = new Produto(102, "Azul Caneta", 15.00, 50);
        System.out.println("Produto 2 (Inicial): " + produto2);

        produto2.quantidadeEmEstoque = -5;
        System.out.println("Produto 2 (Estoque alterado): " + produto2);

        Produto produto3 = new Produto(103, "Borracha Branca", -0.50, 0);
        System.out.println("Produto 3 (Inicial): " + produto3);

        Produto produto4 = new Produto(104, null, 10.00, 10);
        System.out.println("Produto 4 (Inicial): " + produto4);

    }
}