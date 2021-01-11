package entidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa uma compra. Toda compra precisa ter uma dada, nome do produto, preco, nome do cliente, nome do fornecedor
 * e a descricao de um produto.
 *
 * @author Adriano Lira.
 */
public class Compra {

    private Date data;
    private String nomeDoProduto;
    private double preco;
    private String nomeDoCliente;
    private String nomeDoFornecedor;
    private String descricao;

    /**
     * Constroi uma compra com o nome do produto, nome do cliente, nome do fornecedor, descricao de um produto
     * e uma data.
     *
     * @param nomeDoProduto    para o nome do produto.
     * @param nomeDoCliente    para o nome do cliente.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param descricao        para a descricao de um produto.
     * @param data             para a data da compra.
     * @param preco            para o preco do produto.
     * @throws ParseException lanca uma excessao.
     */
    public Compra(String nomeDoProduto, String nomeDoCliente, String nomeDoFornecedor, String descricao, String data,
                  double preco) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dateFormat.parse(data);
        this.nomeDoProduto = nomeDoProduto;
        this.preco = preco;
        this.nomeDoCliente = nomeDoCliente;
        this.nomeDoFornecedor = nomeDoFornecedor;
        this.descricao = descricao;
    }

    /**
     * Pega o nome do cliente.
     *
     * @return o nome do cliente.
     */
    public String getNomeDoCliente() {
        return this.nomeDoCliente;
    }

    /**
     * Pega o nome do fornecedor.
     *
     * @return o nome do fornecedor.
     */
    public String getNomeDoFornecedor() {
        return this.nomeDoFornecedor;
    }

    /**
     * Pega a descricao do produto.
     *
     * @return a descricao do produto.
     */
    public String getDescricaoProduto() {
        return this.descricao;
    }

    /**
     * Pega a data de compra.
     *
     * @return a data de compra.
     */
    public Date getData() {
        return this.data;
    }

    /**
     * Formata como devera ser a saida da data.
     *
     * @return a data formatada.
     */
    public String getStringData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(this.data);
    }

    /**
     * Formada o toString.
     *
     * @return Retorna a representacao em String a partir do nome do produto formatada.
     */
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return nomeDoProduto + " - " + simpleDateFormat.format(this.data);
    }

    /**
     * Formata a lista de compras em cada fornecedor a partir do nome do cliente.
     *
     * @return retorna a representacao em String a partir do nome do cliente formatada.
     */
    public String formataCliente() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return nomeDoCliente + ", " + nomeDoFornecedor + ", " + descricao + ", " + simpleDateFormat.format(this.data);
    }

    /**
     * Formata a lista de compras para cada fornecedor a partir do nome do fornecedor.
     *
     * @return retorna a representacao em String a partir do nome do fornecedor formatada.
     */
    public String formataFornecedor() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return nomeDoFornecedor + ", " + nomeDoCliente + ", " + descricao + ", " + simpleDateFormat.format(this.data);
    }

    /**
     * Formata a lista de compras para cada data a partir da data de compra.
     *
     * @return a representacao em String a partir da data formatada.
     */
    public String formataData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(this.data) + ", " + nomeDoCliente + ", " + nomeDoFornecedor + ", " + descricao;
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Compra other = (Compra) obj;
        if (nomeDoProduto == null) {
            if (other.nomeDoProduto != null)
                return false;
        } else if (!nomeDoProduto.equals(other.nomeDoProduto))
            return false;
        return true;
    }

}
