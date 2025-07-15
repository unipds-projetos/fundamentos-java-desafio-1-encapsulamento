package br.com.unipds.fundamentosjava.desafio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private Produto produtoValido;

    @BeforeEach
    void setUp() {
        produtoValido = new Produto(1, "Notebook", 3500.00, 10);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'Produto A', 10.5, 5",
            "999, 'Nome Longo de Produto', 9999.99, 9999",
            "2, 'A', 0.01, 1"
    })
    @DisplayName("Deve aceitar diferentes combinações válidas de parâmetros")
    void deveAceitarDiferentesCombinacoesValidas(int id, String nome, double preco, int quantidade) {
        Produto produto = new Produto(id, nome, preco, quantidade);
        assertAll(
                () -> assertEquals(id, produto.getId()),
                () -> assertEquals(nome, produto.getNome()),
                () -> assertEquals(preco, produto.getPreco()),
                () -> assertEquals(quantidade, produto.getQuantidadeEmEstoque())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("Deve lançar exceção quando ID for inválido no construtor")
    void construtorDeveLancarExcecaoParaIdInvalido(int idInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Produto(idInvalido, "Produto Válido", 10.0, 5));
        assertEquals("Id inválido", exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "1Produto", "9Teste"})
    @DisplayName("Deve lançar exceção quando nome for inválido no construtor")
    void construtorDeveLancarExcecaoParaNomeInvalido(String nomeInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Produto(1, nomeInvalido, 10.0, 5));
        assertEquals("Nome inválido", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -10.0, -1000.0})
    @DisplayName("Deve lançar exceção quando preço for inválido no construtor")
    void construtorDeveLancarExcecaoParaPrecoInvalido(double precoInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Produto(1, "Produto Válido", precoInvalido, 5));
        assertEquals("Preço inválido", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    @DisplayName("Deve lançar exceção quando quantidade em estoque for inválida no construtor")
    void construtorDeveLancarExcecaoParaQuantidadeEstoqueInvalida(int quantidadeInvalida) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Produto(1, "Produto Válido", 10.0, quantidadeInvalida));
        assertEquals("Quantidade em estoque inválida", exception.getMessage());
    }

    @Test
    @DisplayName("Deve alterar ID para valor válido")
    void setIdDeveAceitarValorValido() {
        produtoValido.setId(2);
        assertEquals(2, produtoValido.getId());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("Deve lançar exceção quando ID for inválido no setter")
    void setIdDeveLancarExcecaoParaIdInvalido(int idInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> produtoValido.setId(idInvalido));
        assertEquals("Id inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Deve alterar nome para valor válido")
    void setNomeDeveAceitarValorValido() {
        produtoValido.setNome("Novo Nome");
        assertEquals("Novo Nome", produtoValido.getNome());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "1Produto", "9Teste"})
    @DisplayName("Deve lançar exceção quando nome for inválido no setter")
    void setNomeDeveLancarExcecaoParaNomeInvalido(String nomeInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> produtoValido.setNome(nomeInvalido));
        assertEquals("Nome inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Deve alterar preço para valor válido")
    void setPrecoDeveAceitarValorValido() {
        produtoValido.setPreco(4000.00);
        assertEquals(4000.00, produtoValido.getPreco());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -10.0, -1000.0})
    @DisplayName("Deve lançar exceção quando preço for inválido no setter")
    void setPrecoDeveLancarExcecaoParaPrecoInvalido(double precoInvalido) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> produtoValido.setPreco(precoInvalido));
        assertEquals("Preço inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Deve alterar quantidade em estoque para valor válido")
    void setQuantidadeEmEstoqueDeveAceitarValorValido() {
        produtoValido.setQuantidadeEmEstoque(20);
        assertEquals(20, produtoValido.getQuantidadeEmEstoque());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    @DisplayName("Deve lançar exceção quando quantidade em estoque for inválida no setter")
    void setQuantidadeEmEstoqueDeveLancarExcecaoParaQuantidadeInvalida(int quantidadeInvalida) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> produtoValido.setQuantidadeEmEstoque(quantidadeInvalida));
        assertEquals("Quantidade em estoque inválida", exception.getMessage());
    }

    @Test
    @DisplayName("Deve aceitar preço zero")
    void deveAceitarPrecoZero() {
        Produto produto = new Produto(1, "Produto Gratuito", 0.0, 10);
        assertEquals(0.0, produto.getPreco());
    }

    @Test
    @DisplayName("Deve aceitar quantidade em estoque zero")
    void deveAceitarQuantidadeEstoqueZero() {
        Produto produto = new Produto(1, "Produto Sem Estoque", 10.0, 0);
        assertEquals(0, produto.getQuantidadeEmEstoque());
    }

    @Test
    @DisplayName("Deve aceitar nome com números após o primeiro caractere")
    void deveAceitarNomeComNumerosAposPrimeiroCaractere() {
        Produto produto = new Produto(1, "Produto123", 10.0, 5);
        assertEquals("Produto123", produto.getNome());
    }
}