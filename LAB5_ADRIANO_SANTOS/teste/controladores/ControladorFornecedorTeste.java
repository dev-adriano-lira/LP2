package controladores;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControladorFornecedorTeste {

    public ControladorFornecedor controlerFornecedorTeste;

    @BeforeEach
    public void ControleFornecedor() {
        controlerFornecedorTeste = new ControladorFornecedor();
    }

    @Test
    public void testAdicionaFornecedor() {
        assertEquals("pedro", controlerFornecedorTeste.adicionaFornecedor("pedro", "pedro@gmail.com", "998026405"));
    }

    @Test
    public void testAdicionaFornecedorNomeNullOuVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor("", "sebastiao@gmail.com", "911223344"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor(null, "sebastiao@gmail.com", "911223344"));
    }

    @Test
    public void testAdicionaFornecedorEmailNullOuVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor("flavio", "", "911223344"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor("flavio", null, "911223344"));
    }

    @Test
    public void testAdicionaFornecedorTelefoneNullOuVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor("flavio", "sebastiao@gmail.com", ""));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.adicionaFornecedor("flavio", "sebastiao@gmail.com", null));
    }

    @Test
    public void testNomeCadastrado() {
        controlerFornecedorTeste.adicionaFornecedor("pedro", "pedro@gmail.com", "998026405");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.nomeCadastrado("pedro"));
    }

    @Test
    public void testNomeNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("pedrao", "pedrao@gmail.com", "465465456");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.nomeNaoExiste("marcos",
                "Erro na exibicao do fornecedor: fornecedor nao existe."));
    }

    @Test
    public void testExibeFornecedor() {
        controlerFornecedorTeste.adicionaFornecedor("arthur", "arthur@gmail.com", "546154643");
        String mensagem = "arthur - arthur@gmail.com - 546154643";
        assertEquals(mensagem, controlerFornecedorTeste.exibeFornecedor("arthur"));
    }

    @Test
    public void testExibeFornecedorNomeNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("arthur", "arthur@gmail.com", "546154643");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.exibeFornecedor(""));
        assertThrows(NullPointerException.class, () -> controlerFornecedorTeste.exibeFornecedor(null));
    }

    @Test
    public void testEditaFornecedorNomeDoFornecedor() {
        controlerFornecedorTeste.adicionaFornecedor("brenda", "brenda@gmail.com", "849848941");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("brenda", "nome", "janaina"));
    }

    @Test
    public void testEditaFonecedorEmail() {
        controlerFornecedorTeste.adicionaFornecedor("brenda", "brendinhasapequinha@gmail.com", "849848941");
        controlerFornecedorTeste.editaFornecedor("brenda", "email", "brenda@gmail.com");
        String mensagem = "brenda - brenda@gmail.com - 849848941";
        assertEquals(mensagem, controlerFornecedorTeste.exibeFornecedor("brenda"));
    }

    @Test
    public void testEditaFornecedorTelefone() {
        controlerFornecedorTeste.adicionaFornecedor("brenda", "brendinhasapequinha@gmail.com", "849848941");
        controlerFornecedorTeste.editaFornecedor("brenda", "telefone", "964798789");
        String mensagem = "brenda - brendinhasapequinha@gmail.com - 964798789";
        assertEquals(mensagem, controlerFornecedorTeste.exibeFornecedor("brenda"));
    }

    @Test
    public void testEditaFornecedorNovoDadoVazioOuNulo() {
        controlerFornecedorTeste.adicionaFornecedor("harry", "harry@gmail.com", "965968798");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("harry", "", "965968798"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaFornecedor("harry", null, "965968798"));
    }

    @Test
    public void tesEditaFonecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("milena", "milena@gmail.com", "464687741");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("joaquim", "email", "joaquim@gmail.com"));
    }

    @Test
    public void testEditaFonecedorAlteraDadoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("harry", "harry@gmail.com", "965968798");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("harry", "", "965968798"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaFornecedor("harry", null, "965968798"));
    }

    @Test
    public void testEditaFornecedorNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("gustavo", "gustavo@gmail.com", "479864685");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("", "nome", "479864685"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaFornecedor(null, "nome", "479864685"));
    }

    @Test
    public void testEditaFornecedorAtributoNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("tadeu", "tadeu@gmail.com", "694654156");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaFornecedor("tadeu", "localizacao", "479864685"));
    }

    @Test
    public void testRemoveFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.removeFornecedor("juan"));
    }

    @Test
    public void tesRemoveFornecedor() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.removeFornecedor("juan");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.exibeFornecedor("juan"));
    }

    @Test
    public void testRemoveFornecedorNomeNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.removeFornecedor(""));
        assertThrows(NullPointerException.class, () -> controlerFornecedorTeste.removeFornecedor(null));
    }

    @Test
    public void testColocaProdutoEmFornecedor() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
    }

    @Test
    public void testColocaProdutoEmFornecedorNomeDoFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.nomeNaoExiste("juan",
                "Erro no cadastro de produto: fornecedor nao existe."));
    }

    @Test
    public void testColocaProdutoEmFornecedorNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("", "frango", 5.00, "frango do bom"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor(null, "frango", 5.00, "frango do bom"));
    }

    @Test
    public void testColocaProdutoEmFornecedorNomeDoProdutoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "", 5.00, "frango do bom"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", null, 5.00, "frango do bom"));
    }

    @Test
    public void testColocaProdutoEmFornecedorPrecoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 0, "frango do bom"));
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", -5, "frango do bom"));
    }

    @Test
    public void testColocaProdutoEmFornecedorDescricaoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, ""));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, null));
    }

    @Test
    public void testExibeProduto() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        String mensagem = "frango - frango do bom - R$5,00";
        assertEquals(mensagem, controlerFornecedorTeste.exibeProduto("frango", "frango do bom", "seu olavo"));
    }

    @Test
    public void testExibeProdutoFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.nomeNaoExiste("juan",
                "Erro na exibicao de produto: fornecedor nao existe."));
    }

    @Test
    public void testExibeProdutoNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "frango", 5.00, "frango do bom"));
    }

    @Test
    public void testExibeProdutoNomeDoProdutoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.exibeProduto("", "frango do bom", "seu olavo"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.exibeProduto(null, "frango do bom", "seu olavo"));
    }

    @Test
    public void testExibeProdutoDescricaoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.exibeProduto("frango", "", "seu olavo"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.exibeProduto("frango", null, "seu olavo"));
    }

    @Test
    public void testExibeProdutoNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.exibeProduto("frango", "frango do bom", ""));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.exibeProduto("frango", "frango do bom", null));
    }

    @Test
    public void testEditaProduto() {
        controlerFornecedorTeste.adicionaFornecedor("brenda", "brendinhasapequinha@gmail.com", "849848941");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("brenda", "frango", 5.00, "frango do bom");
        controlerFornecedorTeste.editaProduto("frango", "frango do bom", "brenda", 6.00);
        String mensagem = "frango - frango do bom - R$6,00";
        assertEquals(mensagem, controlerFornecedorTeste.exibeProduto("frango", "frango do bom", "brenda"));
    }

    @Test
    public void testEditaProdutoFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("brenda", "brendinhasapequinha@gmail.com", "849848941");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("brenda", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("juan", "frango", "frango do bom", 5.00));
    }

    @Test
    public void testEditaProdutoPrecoInvalido() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", "frango", "frango do bom", 0));
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", "frango", "frango do bom", -6));
    }

    @Test
    public void testEditaProdutoDescricaoNullOuVazia() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", "frango", "", 5.00));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", "frango", null, 5.00));
    }

    @Test
    public void testEditaProdutoNomeDoProdutoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", "", "frango do bom", 5.00));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaProduto("seu olavo", null, "frango do bom", 5.00));
    }

    @Test
    public void testEditaProdutoNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("seu olavo", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("seu olavo", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.editaProduto("", "frango", "frango do bom", 5.00));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.editaProduto(null, "frango", "frango do bom", 5.00));
    }

    @Test
    public void testRemoveProduto() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "frango", 5.00, "frango do bom");
        controlerFornecedorTeste.removeProduto("frango", "frango do bom", "juan");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.removeProduto("frango", "frango do bom", "juan"));
    }

    @Test
    public void testRemoveProdutoFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.removeProduto("frango", "frango do bom", "flavia"));
    }

    @Test
    public void testRemoveProdutoDescricaonNullOuVazia() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "frango", 5.00, "frango do bom");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.removeProduto("frango", "", "juan"));
        assertThrows(NullPointerException.class, () -> controlerFornecedorTeste.removeProduto("frango", null, "juan"));
    }

    @Test
    public void testRemoveProdutoNomeDoProdutoNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.removeProduto("", "acebolado", "juan"));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.removeProduto(null, "acebolado", "juan"));
    }

    @Test
    public void testRemoveProdutoNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        assertThrows(IllegalArgumentException.class,
                () -> controlerFornecedorTeste.removeProduto("sanduiche", "acebolado", ""));
        assertThrows(NullPointerException.class,
                () -> controlerFornecedorTeste.removeProduto("sanduiche", "acebolado", null));
    }

    @Test
    public void testExibeFornecedores() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.adicionaFornecedor("gabriel", "gabriel@gmail.com", "515984789");
        assertEquals("gabriel - gabriel@gmail.com - 515984789 | juan - seuolavo@gmail.com - 951564684",
                controlerFornecedorTeste.exibeFornecedores());
    }

    @Test
    public void testExibeProdutosFornecedor() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        String mensagem = "juan - sanduiche - acebolado - R$5,00";
        assertEquals(mensagem, controlerFornecedorTeste.exibeProdutosFornecedor("juan"));
    }

    @Test
    public void testExibeProdutosFornecedorNomeDoFornecedorNaoExiste() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.exibeProdutosFornecedor("pablo"));
    }

    @Test
    public void testExibeProdutosFornecedorNomeDoFornecedorNullOuVazio() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        assertThrows(IllegalArgumentException.class, () -> controlerFornecedorTeste.exibeProdutosFornecedor(""));
        assertThrows(NullPointerException.class, () -> controlerFornecedorTeste.exibeProdutosFornecedor(null));
    }

    @Test
    public void testExibeProdutos() {
        controlerFornecedorTeste.adicionaFornecedor("juan", "seuolavo@gmail.com", "951564684");
        controlerFornecedorTeste.adicionaFornecedor("gabriel", "gabriel@gmail.com", "515984789");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("juan", "sanduiche", 5.00, "acebolado");
        controlerFornecedorTeste.colocaProdutoEmFornecedor("gabriel", "bolo", 3.00, "de chocolate");
        assertEquals("gabriel - bolo - de chocolate - R$3,00 | juan - sanduiche - acebolado - R$5,00",
                controlerFornecedorTeste.exibeProdutos());
    }

}
