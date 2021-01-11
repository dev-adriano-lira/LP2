package ufcg.ccc.domino;

/**
 * Uma peça de dominó com dois lados.
 */
public class Peca implements Comparable<Peca> {

    private int numEsquerdo;
    private int numDireito;

    /**
     * Cria uma peça.
     *
     * @param numEsquerdo Número do lado esquerdo.
     * @param numDireito  Número do lado direito.
     */
    public Peca(int numEsquerdo, int numDireito) {
        this.numEsquerdo = numEsquerdo;
        this.numDireito = numDireito;
    }

    /**
     * Inverte os lados dos números na peça.
     */
    public void gira() {
        int tmp = numEsquerdo;
        numEsquerdo = numDireito;
        numDireito = tmp;
    }

    /**
     * @return O número da direita.
     */
    public int getNumDireito() {
        return numDireito;
    }

    public boolean verificaCarrocao() {
        return this.numDireito == this.numEsquerdo;
    }

    /**
     * @return O número da esquerda.
     */
    public int getNumEsquerdo() {
        return numEsquerdo;
    }

    @Override
    public String toString() {
        return this.getNumEsquerdo() + ":" + this.getNumDireito();
    }

    /**
     * Testa se CarrocaPrimeiro peça encaixa com um número.
     *
     * @param numero O número CarrocaPrimeiro testar.
     * @return true se um dos lados ao menos combinar com o númer.
     */
    public boolean encaixa(int numero) {
        return this.numDireito == numero || this.numEsquerdo == numero;
    }

    /**
     * Compara dois objetos.
     *
     * @param o para o objeto comparado.
     * @return a sina de duas pecas.
     */
    public int compareTo(Peca o) {
        int somaPeca1 = this.numDireito - this.numEsquerdo;
        int somaPeca2 = o.getNumDireito() - o.getNumEsquerdo();
        return somaPeca1 + somaPeca2;
    }

}
