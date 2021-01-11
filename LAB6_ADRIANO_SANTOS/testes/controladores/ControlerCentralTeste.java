package controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControlerCentralTeste {

    public ControlerCentral ControlerCentralTeste;

    @BeforeEach
    public void ControlerCliente() {
        ControlerCentralTeste = new ControlerCentral();
    }

    @Test
    public void testeAdicionaCombo() {
        ControlerCentralTeste.adicionaFornecedor("joao", "joao@gmail.com", "986546541");
        ControlerCentralTeste.adicionaProduto("joao", "bolo", "de chocolate", 2.00);
        ControlerCentralTeste.adicionaProduto("joao", "cafe", "preto", 1.00);
        ControlerCentralTeste.adicionaCombo("joao", "bolo + cafe",
                "cafezin quentin", 0.2, "bolo - de chocolate, cafe - preto");
    }

    @Test
    public void testeEditaCombo() {
        ControlerCentralTeste.adicionaFornecedor("Joao", "Joao@gmail.com", "984765156");
        ControlerCentralTeste.adicionaProduto("Joao", "Salada", "fresca", 3.00);
        ControlerCentralTeste.adicionaProduto("Joao", "suco", "geladinho", 1.00);
        ControlerCentralTeste.adicionaCombo("Joao", "Salada + suco",
                "salada fresca", 0.20, "Salada - fresca, suco - geladinho");
        ControlerCentralTeste.editaCombo("Salada + suco", "salada fresca",
                "Joao", 0.1);
    }

}
