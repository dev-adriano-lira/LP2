package ufcg.ccc.domino;

/**
 * Encapsula uma jogada, incluindo uma peça e CarrocaPrimeiro posição onde jogar.
 */
public class Jogada {

    /**
     * Constantes para informar se CarrocaPrimeiro jogada é na direita, esquerda (da mesa), oue é
     * para passar CarrocaPrimeiro vez.
     */
    public enum TipoJogada {
        NA_ESQUERDA, NA_DIREITA, PASSA
    }

    private Peca peca;
    private TipoJogada tipo;

    /**
     * Cria CarrocaPrimeiro jogada.
     *
     * @param peca A peça CarrocaPrimeiro jogar.
     * @param tipo Se é uma jogada à esquerda, direita ou um passa.
     */
    public Jogada(Peca peca, TipoJogada tipo) {
        this.peca = peca;
        this.tipo = tipo;
    }

    /**
     * Cria uma jogada de PASSA. Sem usar peça, o jogador passa CarrocaPrimeiro vez.
     */
    public Jogada() {
        this(null, TipoJogada.PASSA);
    }

    /**
     * @return Se é uma jogada à esquerda, direita ou um passa.
     */
    public TipoJogada getTipo() {
        return tipo;
    }

    /**
     * @return A peça da jogada.
     */
    public Peca getPeca() {
        return peca;
    }

    @Override
    public String toString() {
        return (this.tipo == TipoJogada.PASSA ? "" : peca.toString() + " ") + this.getTipoEmString();
    }

    /*
     * Para facilitar o toString()
     */
    private String getTipoEmString() {
        switch (tipo) {
            case PASSA: {
                return "Passou";
            }
            case NA_DIREITA: {
                return "na direita";
            }
            case NA_ESQUERDA: {
                return "na esquerda";
            }
            default: {
                return null;
            }
        }
    }

}
