package produto;

/**
 * Classe que representa um produto, que tem nome, descricao e preco.
 *
 * @author Adriano Santos.
 */
public class Produto {
    /**
     * Nome do produto
     */
    private String nome;

    /**
     * Descricao do produto
     */
    private String descricao;

    /**
     * Preço do produto
     */
    private double preco;

    /**
     * @param nome
     * @param descricao
     * @param preco
     */
    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return this.getNome() + " - " + this.getDescricao() + " - R$" + String.format("%.2f", this.getPreco()).replace(".", ",");
    }

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco
     */
    protected void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Metodo responsavel de alterar o fator de desconto.
     *
     * @param novoValor para o novo valor a ser alterado.
     */
    public void modificaProduto(double novoValor) {
        this.setPreco(novoValor);
    }

    /**
     *
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Produto) {
            Produto p = (Produto) o;

            if ((this.getNome() + this.getDescricao()).equals(p.getNome() + p.getDescricao())) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return (this.getNome() + this.getDescricao()).hashCode();
    }

}
