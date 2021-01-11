package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class CarrocaPrimeiroTest {

    private Mesa mesa;

    @BeforeEach
    void setup() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(2, 1));
        mesa.jogaNaEsquerda(new Peca(3, 2));
    }

    @Test
    void testJogaCarrocaMesaSemPeca() {
        JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();
        Mesa mesaVazia = new Mesa();

        Jogada j1 = estrategia.decideJogada(mesaVazia, List.of(new Peca(3, 5), new Peca(1, 1)));

        assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(1, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaCarrocaNaDireita() throws Exception{
        JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(2, 1));
        mesa.jogaNaDireita(new Peca(1, 3));
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(1, 1)));

        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(3, j1.getPeca().getNumEsquerdo());
        assertEquals(3, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaCarrocaNaEsquerda() throws JogadaInvalidaException {
        JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();
        mesa = new Mesa();
        mesa.jogaNaEsquerda(new Peca(3, 2));

        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(1, 1)));

        assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(3, j1.getPeca().getNumEsquerdo());
        assertEquals(3, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaCarrocaNaoExisteCarrocaNaEsquerda() throws JogadaInvalidaException {
        JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();
        mesa = new Mesa();
        mesa.jogaNaEsquerda(new Peca(3, 2));

        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 6), new Peca(6, 1)));

        assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(3, j1.getPeca().getNumEsquerdo());
        assertEquals(6, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaCarrocaNaoExisteCarrocaNaDireita() throws JogadaInvalidaException {
        JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(3, 2));

        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 5), new Peca(6, 1)));

        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(2, j1.getPeca().getNumEsquerdo());
        assertEquals(5, j1.getPeca().getNumDireito());
    }

}
