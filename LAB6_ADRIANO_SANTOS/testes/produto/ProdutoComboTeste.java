package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoComboTeste {

    public ProdutoCombo ProdutoComboTeste;

    @BeforeEach
    public void PrudutoCombo(){
        ProdutoComboTeste = new ProdutoCombo("x-tudo", "tudo por 5", 4.00, 3.00, 0.20);
    }

    @Test
    public void testModificaProdutoInvalido(){
        assertThrows(IllegalArgumentException.class, () -> ProdutoComboTeste.modificaProduto(0));
    }

    @Test
    public void testModificaProduto(){
       ProdutoComboTeste.modificaProduto(0.2);
       assertEquals(2.4, ProdutoComboTeste.getPreco());
    }

}