# Desafio 1: Consistência de Dados com Encapsulamento

Este desafio foca em um dos pilares mais importantes da Programação Orientada a Objetos (POO): **Encapsulamento**.

## Objetivo do Desafio

O código inicial fornecido no arquivo `Produto.java` demonstra uma falha na forma como os dados de um item são geridos.

Atualmente, é possível criar e manipular produtos com informações inconsistentes, como preços negativos ou estoque insuficiente (também negativo ou nulo), ou até mesmo um nome de produto inválido.

Sua tarefa é **corrigir a classe `Produto`** para garantir que os dados sejam sempre válidos e consistentes, aplicando os conceitos de encapsulamento e validação.

## O Problema (Código Atual)

Execute o arquivo `Main.java`.

Você verá que o programa cria objetos `Produto` e até modifica seus atributos diretamente, permitindo valores que não fazem sentido no mundo real (ex: preço -2.00, estoque -5).

Isso é uma falha grave na integridade dos dados!
