package ufcg.ccc.domino.estrategia;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsavel por verificar qual peca eh a menor e jogar elas primeiramente.
 */
public class JogaMenoresPrimeiro implements EstrategiaDeJogo {

    /**
     * Metodo responsavel por verificar quais pecas sao as menores e assim joga-las sempre primeiro que as maiores.
     *
     * @param mesa O estado atual da mesa, com as peças já jogadas.
     * @param mao  As peças disponíveis para o jogador.
     * @return uma nova jogada com a menor peca na mao do jogador.
     */
    public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
        List<Peca> pecas = new ArrayList<>();
        for (Peca peca : mao) {
            pecas.add(peca);
        }
        Collections.sort(pecas);
        if (mesa.getNumPecas() == 0) {
            return new Jogada(mao.get(mao.size() - 1), Jogada.TipoJogada.NA_DIREITA);
        }
        for (Peca peca : pecas) {
            if (peca.encaixa(mesa.getNumNaDireita())) {
                return new Jogada(peca, Jogada.TipoJogada.NA_DIREITA);
            } else if (peca.encaixa(mesa.getNumNaEsquerda())) {
                return new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);
            }
        }
        return new Jogada();
    }

}
