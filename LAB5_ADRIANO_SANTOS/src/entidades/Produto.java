package entidades;

/**
 * Representa um produto. Todo produtno necessita ter um nome do produto, um preco e uma descricao.
 *
 * @author Adriano Lira.
 */
public class Produto implements Comparable<Produto> {

    private String nomeDoProduto;
    private double preco;
    private String descricao;

    /**
     * Constroi um produto a partir do nome do produto, preco e descricao do mesmo.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param preco         para o preco do produto.
     * @param descricao     para a descricao do produto.
     */
    public Produto(String nomeDoProduto, double preco, String descricao) {
        this.nomeDoProduto = nomeDoProduto;
        this.preco = preco;
        this.descricao = descricao;
    }

    /**
     * Pega o preco de um produto.
     *
     * @return o preco do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Modifica o preco de um produto recebendo uma String para fazer a modificacao.
     *
     * @param preco para o preco de um produto modificado.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Pega o nome de um Produto.
     *
     * @return o nome de um produto.
     */
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    /**
     * Pega a decricao de um produto.
     *
     * @return a decricao de um produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Formata a representacao em String do toString para o que se eh neccessario para a saida.
     *
     * @return retorna uma representação em String contendo o nome do produto, a descricao e
     * * o preco formadao em duas casas decimais, alem de trocar uma virgula por um
     * * ponto
     */
    public String toString() {
        return this.nomeDoProduto + " - " + this.descricao + " - " + "R$"
                + String.format("%.2f", this.preco).replace(".", ",");
    }

    /**
     * Compara dois objetos para verificar se possuem o mesmo nome do produto.
     */
    @Override
    public int compareTo(Produto produto2) {
        return this.nomeDoProduto.compareTo(produto2.getNomeDoProduto());
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((nomeDoProduto == null) ? 0 : nomeDoProduto.hashCode());
        return result;
    }

    /**
     * Verifica se o objeto atual é igual ao objeto comparado.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (nomeDoProduto == null) {
            if (other.nomeDoProduto != null)
                return false;
        } else if (!nomeDoProduto.equals(other.nomeDoProduto))
            return false;
        return true;
    }

}
