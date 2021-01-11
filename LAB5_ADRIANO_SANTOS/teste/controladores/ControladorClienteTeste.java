package controladores;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorClienteTeste {

    public ControladorCliente controladorClienteTeste;

    @BeforeEach
    public void ControladorCliente() {
        controladorClienteTeste = new ControladorCliente();
    }

    @Test
    public void testAdicionaCliente() {
        assertEquals("46546541651", controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab"));
    }

    @Test
    public void testAdicionaClienteNomeDoClienteNullOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", "", "elizabete@gmail.com", "splab"));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", null, "elizabete@gmail.com", "splab"));
    }

    @Test
    public void testAdicionaClienteEmailNullOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "", "splab"));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", "elizabete", null, "splab"));
    }

    @Test
    public void testAdicionaClienteLocalizacaoNullOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", ""));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", null));
    }

    @Test
    public void testAdicionaClienteCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.adicionaCliente("546541651", "elizabete", "elizabete@gmail.com", "splab"));
    }

    @Test
    public void testAdicionaClienteCpfCadastrado() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.verificaCpfCadastrado("46546541651"));
    }

    @Test
    public void testVerificaCpfCadastrado() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.verificaCpfCadastrado("46546541651"));
    }

    @Test
    public void testVerificaCpfNaoCadastrado() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.verificaCpfNaoCadastrado("46546541621"));
    }

    @Test
    public void testExibeCliente() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertEquals("elizabete - splab - elizabete@gmail.com", controladorClienteTeste.exibeCliente("46546541651"));
    }

    @Test
    public void testExibeClienteCpfNullOuVazio() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.exibeCliente(""));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.exibeCliente(null));
    }

    @Test
    public void testExibeClienteCpfNaoCadastrado() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.exibeCliente("46546541621"));
    }

    @Test
    public void testExibeClientes() {
        controladorClienteTeste.adicionaCliente("46546541651", "elizabete", "elizabete@gmail.com", "splab");
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertEquals("elizabete - splab - elizabete@gmail.com | rihanna - lcc3 - rihanna@gmail.com", controladorClienteTeste.exibeClientes());
    }

    @Test
    public void testEditaCienteCpf() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("69849844125", "cpf", "93446546345"));
    }

    @Test
    public void testEditaCienteNomeDoCliente() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        controladorClienteTeste.editaCliente("69849844125", "nome", "hamtaro");
        String mensagem = "hamtaro - lcc3 - rihanna@gmail.com";
        assertEquals(mensagem, controladorClienteTeste.exibeCliente("69849844125"));
    }

    @Test
    public void testEditaCienteLocalizacao() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        controladorClienteTeste.editaCliente("69849844125", "localizacao", "splab");
        String mensagem = "rihanna - splab - rihanna@gmail.com";
        assertEquals(mensagem, controladorClienteTeste.exibeCliente("69849844125"));
    }

    @Test
    public void testEditaCienteEmail() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        controladorClienteTeste.editaCliente("69849844125", "email", "rihanninha@gmail.com");
        String mensagem = "rihanna - lcc3 - rihanninha@gmail.com";
        assertEquals(mensagem, controladorClienteTeste.exibeCliente("69849844125"));
    }

    @Test
    public void testEditaCienteAtributoNaoExiste() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("69849844125", "telefone", "83998026464"));
    }

    @Test
    public void testEditaCienteClienteNaoExiste() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("16346465156", "nome", "hamtaro"));
    }

    @Test
    public void testEditaCienteCpfNullOuVazio() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("", "nome", "hamtaro"));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.editaCliente(null, "nome", "hamtaro"));
    }

    @Test
    public void testEditaCienteAlteraDadoNullOuVazio() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("69849844125", "", "hamtaro"));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.editaCliente("69849844125", null, "hamtaro"));
    }

    @Test
    public void testEditaCienteNovoDadoNullOuVazio() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.editaCliente("69849844125", "", "hamtaro"));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.editaCliente("69849844125", null, "hamtaro"));
    }

    @Test
    public void testRemoveCliente() {
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        controladorClienteTeste.removeCliente("69849844125");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.exibeCliente("69849844125"));
    }

    @Test
    public void testRemoveClienteNaoExiste(){
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.exibeCliente("87515616546"));
    }

    @Test
    public void testRemoveClieneNomeDoClienteNullOuVazio(){
        controladorClienteTeste.adicionaCliente("69849844125", "rihanna", "rihanna@gmail.com", "lcc3");
        assertThrows(IllegalArgumentException.class, () -> controladorClienteTeste.removeCliente(""));
        assertThrows(NullPointerException.class, () -> controladorClienteTeste.removeCliente(null));
    }


}

