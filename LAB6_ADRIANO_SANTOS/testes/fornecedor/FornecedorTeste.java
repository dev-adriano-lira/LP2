package fornecedor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;

public class FornecedorTeste {

    public Fornecedor FornecedorTeste;

    @BeforeEach
    public void Fornecedor() {
        FornecedorTeste = new Fornecedor("alexandre", "alexandre@gmail.com", "984891561");
    }

    @Test
    public void testAdicionaCombo() {
        FornecedorTeste.adicionaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                4.0, 3.0, 0.20);
        String mensagem = "X-burguer + suco - X-burguer com suco de maracuja - R$4,00";
        assertEquals(mensagem, FornecedorTeste.exibeProduto("X-burguer + suco", "X-burguer com suco de maracuja"));
    }

    @Test
    public void testAdicionaComboJaExiste() {
        FornecedorTeste.adicionaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                4.0, 3.0, 0.20);
        assertThrows(IllegalArgumentException.class, () -> FornecedorTeste.adicionaCombo("X-burguer + suco",
                "X-burguer com suco de maracuja", 4.0, 3.0, 0.20));
    }

    @Test
    public void testConsultaProduto() {
        Produto produto = new Produto("xburguer", "do bom", 4.00);
        FornecedorTeste.adicionaProduto("xburguer", "do bom", 4.00);
        assertEquals(produto, FornecedorTeste.consultaProduto("xburguer", "do bom"));
    }

    @Test
    public void testEditaCombo() {
        FornecedorTeste.adicionaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                4.0, 3.0, 0.20);
        FornecedorTeste.editaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                0.20);
        assertEquals("X-burguer + suco - X-burguer com suco de maracuja - R$2,40", FornecedorTeste.exibeProduto
                ("X-burguer + suco", "X-burguer com suco de maracuja"));
    }

    @Test
    public void testEditaComboProdutoNaoExiste(){
        FornecedorTeste.adicionaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                4.0, 3.0, 0.20);
        FornecedorTeste.editaCombo("X-burguer + suco", "X-burguer com suco de maracuja",
                0.20);
        assertThrows(IllegalArgumentException.class, () -> FornecedorTeste.editaCombo("X-burguer + coca",
                "X-burguer com suco de maracuja", 0.20));
    }

}
