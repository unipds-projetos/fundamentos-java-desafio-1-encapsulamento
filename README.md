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

## Código Original vs Código Corrigido

### Classe Produto Original (Problema)

```java
package br.com.unipds.fundamentosjava.desafio;

public class Produto {

    public int id;
    public String nome;
    public double preco;
    public int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }
}
```

### Classe Produto Corrigida (Solução)

```java
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
```

## Comparação das Implementações

| Característica               | Implementação Original                                                                 | Implementação Corrigida                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| **Visibilidade dos atributos** | Atributos públicos (`public`)                                                         | Atributos privados (`private`)                                                          |
| **Acesso aos atributos**      | Acesso direto aos campos                                                              | Acesso através de métodos getters e setters                                             |
| **Validação de dados**        | Nenhuma validação                                                                     | Validação rigorosa em todos os setters e no construtor                                  |
| **Imutabilidade**             | Campos podem ser modificados livremente                                               | Modificações controladas com validações                                                |
| **Consistência**              | Permite valores inconsistentes (preços negativos, estoque negativo, nomes inválidos)  | Garante que todos os valores sejam válidos (lança exceções para dados inválidos)       |
| **Segurança**                 | Baixa - qualquer código pode modificar os dados                                        | Alta - modificações controladas e validadas                                             |

## Solução Implementada

A solução aplica os seguintes princípios de encapsulamento:

1. **Atributos privados**: Todos os campos foram tornados privados para evitar acesso direto.
2. **Métodos de acesso controlado**: Foram implementados getters e setters para cada atributo.
3. **Validações robustas**:
    - ID não pode ser negativo
    - Nome não pode ser nulo, vazio ou começar com dígito
    - Preço não pode ser negativo
    - Estoque não pode ser negativo
4. **Validação no construtor**: O construtor também valida todos os parâmetros antes de criar o objeto.
5. **Mensagens de erro claras**: Exceções com mensagens descritivas são lançadas para valores inválidos.

## Benefícios da Solução

- **Integridade dos dados garantida**: Impossível criar ou modificar um Produto com dados inválidos
- **Código mais seguro**: Previne erros de programação que poderiam passar despercebidos
- **Manutenibilidade**: Validações centralizadas em métodos privados (DRY - Don't Repeat Yourself)
- **Claro contrato de uso**: Exceções lançadas indicam claramente quando há uso incorreto da classe

A solução transforma a classe Produto em uma entidade robusta que protege sua própria integridade, seguindo os princípios de encapsulamento da POO.