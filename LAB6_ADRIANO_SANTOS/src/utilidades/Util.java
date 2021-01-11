package utilidades;

/**
 * Classe de verificacao de dados.
 *
 * @author Adriano Santos.
 */
public class Util {
    /**
     * Verifica o dado inserido, lancando uma excessao se o mesmo for nulo.
     *
     * @param o        para o objeto a ser verificado.
     * @param mensagem para a mensagem de erro a ser lancada junto com o tipo do erro.
     */
    public static void testaObjetoNull(Object o, String mensagem) {
        if (o == null) {
            throw new NullPointerException(mensagem);
        }
    }

    /**
     * @param s
     * @param mensagem
     */
    public static void testaVazio(String s, String mensagem) {
        if (s.equals("")) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Verifica se o dado inserido eh menor ou igual a zero e maior ou igual a um, caso seja, lanca uma excessao.
     *
     * @param fator    para o dado a ser verificado.
     * @param mensagem para a mensagem de erro a ser lancada junto com o tipo do erro.
     */
    public static void testaFator(double fator, String mensagem) {
        if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Verifica o dado inserido, lancando uma excessao se o mesmo for nulo.
     *
     * @param s        para a String a ser verificada.
     * @param mensagem para a mensagem de erro a ser lancada junto com o tipo do erro.
     */
    public static void testaNull(String s, String mensagem) {
        if (s == null) {
            throw new NullPointerException(mensagem);
        }
    }

    /**
     * Verifica o dado inserido, lancando uma excessao se o dado for nulo ou vazio.
     *
     * @param s        para o parametro a ser verificado.
     * @param mensagem para a mensagem de erro a ser lancada junto com o tipo do erro.
     */
    public static void testaNulleVazio(String s, String mensagem) {
        testaNull(s, mensagem);
        testaVazio(s, mensagem);
    }

}
