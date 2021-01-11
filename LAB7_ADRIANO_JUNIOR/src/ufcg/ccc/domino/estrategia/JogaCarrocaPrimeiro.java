package ufcg.ccc.domino.estrategia;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

import java.util.List;

/**
 * Classe responsavel por sempre jogar o carrocao primeiro antes de qualquer peca, isso se o jogador possuir um carrocao
 * pegando o carrocao que se encontra em ordem da esquerda pra direita.
 */
public class JogaCarrocaPrimeiro implements EstrategiaDeJogo {

    /**
     * Metodo responsavel por verificar se existe alguma peca na mesa inicialmente e se existe um carrocao na mao do
     * jogador, caso nao exista nenhuma peca na mesa e o jogador possua um carrocao ele jogara esta peca, caso contrario
     * jogara uma peca normal para dar continuidade ao jogo do jogador.
     *
     * @param mesa O estado atual da mesa, com as peças já jogadas.
     * @param mao  As peças disponíveis para o jogador.
     * @return uma nova jogada a partir das pecas na mao do jogador.
     */
    public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {

        for (Peca peca : mao) {
            if (mesa.getNumPecas() == 0) {
                if (peca.verificaCarrocao()) {
                    return new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);
                }
            } else if (peca.verificaCarrocao()) {
                if (peca.encaixa(mesa.getNumNaDireita())) {
                    return new Jogada(peca, Jogada.TipoJogada.NA_DIREITA);
                } else if (peca.encaixa(mesa.getNumNaEsquerda())) {
                    return new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);
                }
            } else {
                if (peca.encaixa(mesa.getNumNaDireita())) {
                    return new Jogada(peca, Jogada.TipoJogada.NA_DIREITA);
                }
                if (peca.encaixa(mesa.getNumNaEsquerda())) {
                    return new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);
                }
            }
        }
        return new Jogada();
    }

}
