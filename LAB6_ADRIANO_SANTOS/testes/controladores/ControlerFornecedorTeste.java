package controladores;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ControlerFornecedorTeste {

    public ControlerFornecedor ControlerFornecedorTeste;

    @BeforeEach
    public void ControlerFornecedor() {
        ControlerFornecedorTeste = new ControlerFornecedor();
    }

    @Test
    public void testeAdicionaCombo() {
        ControlerFornecedorTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerFornecedorTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        ControlerFornecedorTeste.adicionaCombo("Joao", "Salada + suco",
                "salada fresca", 0.20, "Salada - fresca, suco - geladinho");
        assertEquals("Salada + suco - salada fresca - R$3,20", ControlerFornecedorTeste.exibeProduto
                ("Salada + suco", "salada fresca", "Joao"));
    }

    @Test
    public void testeAdicionaComboFornecedorNullouVazio(){
        assertThrows(IllegalArgumentException.class, () ->ControlerFornecedorTeste.adicionaCombo("",
                "Salada + suco", "salada fresca", 0.20,
                "Salada - fresca, suco - geladinho"));
        assertThrows(NullPointerException.class, () ->ControlerFornecedorTeste.adicionaCombo(null,
                "Salada + suco", "salada fresca", 0.20,
                "Salada - fresca, suco - geladinho"));
    }

    @Test
    public void testeAdicionaNomeComboNullouVazio(){
        assertThrows(IllegalArgumentException.class, () ->ControlerFornecedorTeste.adicionaCombo("Joao",
                "", "salada fresca", 0.20,
                "Salada - fresca, suco - geladinho"));
        assertThrows(NullPointerException.class, () ->ControlerFornecedorTeste.adicionaCombo("Joao",
                null, "salada fresca", 0.20,
                "Salada - fresca, suco - geladinho"));
    }

    @Test
    public void testeAdicionaDescricaoComboNullouVazio() {
        assertThrows(IllegalArgumentException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", "", 0.20,
                "Salada - fresca, suco - geladinho"));
        assertThrows(NullPointerException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", null, 0.20,
                "Salada - fresca, suco - geladinho"));
    }

    @Test
    public void testeAdicionaFatorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", "salada fresca", 1,
                "Salada - fresca, suco - geladinho"));
    }

    @Test
    public void testeAdicionaProdutoNullouVazio() {
        assertThrows(IllegalArgumentException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", "salada fresca", 0.20,
                ""));
        assertThrows(NullPointerException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", "salada fresca", 0.20,
                null));
    }

    @Test
    public void testeAdicionaComboFornecedorNaoExiste() {
        ControlerFornecedorTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerFornecedorTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        assertThrows(IllegalArgumentException.class, () ->  ControlerFornecedorTeste.adicionaCombo("maria", "Salada + suco",
                "salada fresca", 0.20, "Salada - fresca, suco - geladinho"));
    }

    @Test
    public void testeAdicionaComboJaAdicionado() {
        ControlerFornecedorTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerFornecedorTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "coxinha", "de frango", 4.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "coca", "geladinha", 1.50);
        ControlerFornecedorTeste.adicionaCombo("Joao",
                "Salada + suco", "salada fresca", 0.20, "Salada - fresca, " +
                        "suco - geladinho");

        assertThrows(IllegalArgumentException.class, () -> ControlerFornecedorTeste.adicionaCombo("Joao",
                "Combao + hipertensao", "salada fresca", 0.20,
                "salada + suco - salada fresca, coxinha - de frango, coca - geladinha"));
    }

    @Test
    public void testeEditaCombo(){
        ControlerFornecedorTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerFornecedorTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        ControlerFornecedorTeste.adicionaCombo("Joao", "Salada + suco",
                "salada fresca", 0.20, "Salada - fresca, suco - geladinho");
        ControlerFornecedorTeste.editaCombo("Salada + suco",
                "salada fresca", "Joao", 0.1);
        assertEquals("Salada + suco - salada fresca - R$3,60", ControlerFornecedorTeste.exibeProduto(
                "Salada + suco",
                "salada fresca", "Joao"));
    }

    @Test
    public void testeEditaComboFornecedorNaoExiste() {
        ControlerFornecedorTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerFornecedorTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerFornecedorTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        ControlerFornecedorTeste.adicionaCombo("Joao", "Salada + suco",
                "salada fresca", 0.20, "Salada - fresca, suco - geladinho");
        assertThrows(IllegalArgumentException.class, () ->  ControlerFornecedorTeste.editaCombo("Salada + suco",
                "salada fresca", "Maria", 0.1));
    }

}
