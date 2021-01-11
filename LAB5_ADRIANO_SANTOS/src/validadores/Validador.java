package validadores;

/**
 * Classe que faz a verificacao de dados, se o dado eh valido.
 *
 * @author Adriano Lira.
 */
public class Validador {

    public Validador() {

    }

    /**
     * Metodo que verifica o dado inserido, lançando a excessao se o dado for nulo ou
     * vazio.
     *
     * @param verifica       para o parametro a ser verificado.
     * @param mensagemDeErro para a mensagem de erro que sera lancada junto com o tipo do erro.
     */
    public void validaNulleVazio(String verifica, String mensagemDeErro) {
        validaNull(verifica, mensagemDeErro);
        validaVazio(verifica, mensagemDeErro);
    }

    /**
     * Metodo que verifica o preco de um produto, lancando a excessao se o preco for menor ou igual a zero.
     *
     * @param preco    para o preco do produto.
     * @param mensagem para a mensagem de erro que sera lancanda junto com o topo do erro.
     */
    public void validaPreco(double preco, String mensagem) {
        String msg = "";
        if (preco <= 0) {
            msg += mensagem;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Metodo que verifica o tamanho do CPF, lancando a excessao se o dado for diferente de onze.
     *
     * @param cpf      para o cpf do cliente.
     * @param mensagem para a mensagem de erro que sera lancanda junto com o topo do erro.
     */
    public void validaCpf(String cpf, String mensagem) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo que verifica o dado inserido, lançando a excessao se o dado for nulo.
     *
     * @param verifica       para o parametro a ser verificado.
     * @param mensagemDeErro para a mensagem de erro que sera lançada junto com o tipo do erro.
     */
    public void validaNull(Object verifica, String mensagemDeErro) {
        if (verifica == null) {
            throw new NullPointerException(mensagemDeErro);
        }
    }

    /**
     * Metodo que verifica o dado inserido, lançando a excessao se o dado for vazio.
     *
     * @param verifica       para o parametro a ser verificado.
     * @param mensagemDeErro para a mensagem de erro que sera lançada junto com o tipo do erro.
     */
    public void validaVazio(String verifica, String mensagemDeErro) {
        if ("".equals(verifica)) {
            throw new IllegalArgumentException(mensagemDeErro);
        }
    }

    /**
     * Metodo que lanca um erro se verificado algum erro durante a execucao do codigo do SAGA.
     *
     * @param mensagem para a mensagem que sera lancada como erro.
     */
    public void validaExcecao(String mensagem) {
        throw new IllegalArgumentException(mensagem);
    }

    /**
     * Metodo que verifica se a data inserida eh valida, caso nao seja, lanca um erro.
     *
     * @param data     para a data a ser verificada.
     * @param mensagem para a mensagem de erro com o erro a ser lancado.
     */
    public void validaData(String data, String mensagem) {
        if (data.length() != 10) {
            throw new IllegalArgumentException(mensagem);
        }
    }

}
