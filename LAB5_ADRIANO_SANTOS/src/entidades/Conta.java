package entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma conta. Toda conta necessita ter um nome de um fornecedor, nome de um cliente e um debito.
 *
 * @author Adriano Lira .
 */
public class Conta {

    private String nomeDoFornecedor;
    private String nomeCliente;
    private double debito;
    private List<Compra> compras;

    /**
     * Constroi uma conta a partir do nome do fornecedor e o nome do cliente.
     *
     * @param nomeDofornecedor para o nome do fornecedor.
     * @param nomeCliente      para o nome do cliente.
     */
    public Conta(String nomeDofornecedor, String nomeCliente) {
        this.nomeDoFornecedor = nomeDofornecedor;
        this.nomeCliente = nomeCliente;
        this.debito = 0.0;
        this.compras = new ArrayList<>();
    }

    /**
     * Adiciona uma compra recebendo o nome do produto, descricao, data e preco como parametro alem de ja calcular o
     * debito ao realizar uma compra.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param descricao     para a descricao do produto.
     * @param data          para a data de compra
     * @param preco         para o preco da compra.
     * @throws ParseException lanca uma excessao
     */
    public void adicionaCompra(String nomeDoProduto, String descricao, String data, double preco) throws ParseException {
        Compra novaCompra = new Compra(nomeDoProduto, this.nomeCliente, this.nomeDoFornecedor, descricao, data, preco);
        this.compras.add(novaCompra);
        this.debito += preco;
    }

    /**
     * Pega o debito.
     *
     * @return o debito com a String formatada.
     */
    public String getDebito() {
        return String.format("%.2f", this.debito);
    }

    /**
     * Formata a String de todas as compras.
     *
     * @return a String formatada separada por "|".
     */
    public String formataCompras() {
        ArrayList<String> formataString = new ArrayList<>();
        for (int i = 0; i < compras.size(); i++) {
            formataString.add(compras.get(i).toString());
        }
        return String.join(" | ", formataString);
    }

    /**
     * Exibe a conta do fornecedor formatada.
     *
     * @return a String formatada pegando o nome do fornecedor e todas as compras separado por "|".
     */
    public String exibeContaFornecedorFormatada() {
        return this.nomeDoFornecedor + " | " + formataCompras();
    }

    /**
     * Formata o toString para a saida desejada.
     *
     * @return uma String contendo o nome do cliente, nome do fornecedor e todas as compras todos separados por "|".
     */
    public String toString() {
        return "Cliente: " + this.nomeCliente + " | " + this.nomeDoFornecedor + " | " + formataCompras();
    }

    /**
     * Pega todas as compras da List de Compra.
     *
     * @return todas as compras.
     */
    public List<Compra> getCompras() {
        return compras;
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
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
        Conta other = (Conta) obj;
        if (nomeCliente == null) {
            if (other.nomeCliente != null)
                return false;
        } else if (!nomeCliente.equals(other.nomeCliente))
            return false;
        return true;
    }

}
