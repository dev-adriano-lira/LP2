package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class JogaMenoresPrimeiroTest {

    private Mesa mesa;

    @BeforeEach
    void setup() throws Exception{
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(1,2));
        mesa.jogaNaDireita(new Peca(2, 3));
    }

    @Test
    void testJogaPrimeiraPossivelMesaSemPecas(){
        JogaMenoresPrimeiro estrategia = new JogaMenoresPrimeiro();
        Mesa mesaVazia= new Mesa();

        Jogada j1 = estrategia.decideJogada(mesaVazia, List.of(new Peca(5,5), new Peca(1,1)));

        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(1, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaPrimeiraPossivelEncaixaNaDireita(){
        JogaMenoresPrimeiro estrategia = new JogaMenoresPrimeiro();

        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(5,5), new Peca(3,5)));

        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(3, j1.getPeca().getNumEsquerdo());
        assertEquals(5, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaPrimeiraPossivelEncaixaNaEsquerda(){
        JogaMenoresPrimeiro estrategia = new JogaMenoresPrimeiro();

        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(5,5), new Peca(1,5)));

        assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(5, j1.getPeca().getNumDireito());
    }

}
