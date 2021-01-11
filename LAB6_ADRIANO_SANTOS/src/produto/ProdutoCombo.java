package produto;

import produto.Produto;
import utilidades.Util;

/**
 * Classe que representa um Combo de Produtos do sistema SAGA, com nome, descricao, fator de desconto, preco final e
 * preco integral.
 *
 * @autor Adriano Santos.
 */
public class ProdutoCombo extends Produto {
    /**
     * preco inicial do combo de produtos.
     */
    private double precoIntegral;

    /**
     * fator de desconto que determina o preco do Combo a partir do preco de dois produtos.
     */
    private double fator;

    /**
     * Construtor da classe ProdutoCombo. Todo Combo necessita de um nome, descricao, preco final, preco integral e o
     * fator de desconto.
     *
     * @param nomeCombo      para o nome do combo.
     * @param descricaoCombo para a descricao do combo.
     * @param precoFinal     preco final de um combo calculado com o fator de desconto.
     * @param precoIntegral  preco inicial de um combo.
     * @param fator          para o fator de desconto.
     */
    public ProdutoCombo(String nomeCombo, String descricaoCombo, double precoFinal, double precoIntegral, double fator) {
        super(nomeCombo, descricaoCombo, precoFinal);
        this.precoIntegral = precoIntegral;
        this.fator = fator;
    }

    /**
     * Modifica o fator de desconto, alem de verificar se o fator eh valido, caso contrario, lanca uma excessao.
     *
     * @param novoFator para o novo fator a ser modificado.
     */
    public void modificaProduto(double novoFator) {
        Util.testaFator(novoFator, "Erro na edicao de combo: fator invalido.");
        this.fator = novoFator;
        double preco = this.precoIntegral - (this.precoIntegral * this.fator);
        super.setPreco(preco);
    }
}
