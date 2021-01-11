package entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import validadores.Validador;

/**
 * Representa um fornecedor. Todo fornecedor necessita ter um nome do fornecedor, um email e um telefone.
 *
 * @author Adriano Lira.
 */
public class Fornecedor implements Comparable<Fornecedor> {

    private Validador validator;
    public String nomeDoFornecedor;
    public String email;
    public String telefone;
    private Map<String, Produto> produtos;
    private Map<String, Conta> contas;

    /**
     * Constroi um fornecedor a partir do nome do fornecedor, do email e telefone do mesmo.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param email            para o email do fornecedor.
     * @param telefone         para o telefone do fornecedor.
     */
    public Fornecedor(String nomeDoFornecedor, String email, String telefone) {
        this.nomeDoFornecedor = nomeDoFornecedor;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
        this.contas = new HashMap<>();
        this.validator = new Validador();
    }

    /**
     * Cadastra uma compra a partir do cpf do cliente, do nome do cliente, do nome do produto, da descricao do produto e
     * da data de compra.
     *
     * @param cpf           para o nome do cpf.
     * @param nomeDoCliente para o nome do cliente.
     * @param nomeDoProduto para o nome do produto.
     * @param descricao     para a descricao do produto
     * @param data          para a data de compra.
     * @throws ParseException lanca uma excessao.
     */
    public void cadastraCompra(String cpf, String nomeDoCliente, String nomeDoProduto, String descricao, String data) throws ParseException {
        if (existeProduto(nomeDoProduto, descricao)) {
            if (!contas.containsKey(cpf)) {
                contas.put(cpf, new Conta(this.nomeDoFornecedor, nomeDoCliente));
            }
            contas.get(cpf).adicionaCompra(nomeDoProduto, descricao, data, produtos.get(nomeDoProduto + descricao).getPreco());
        }
    }

    /**
     * Pega o debito de uma conta a partir do cpf do cliente.
     *
     * @param cpf para o cpf de um cliente.
     * @return o debito de um cliente a partir do seu cpf.
     */
    public String getDebitoConta(String cpf) {
        if (contas.containsKey(cpf)) {
            return contas.get(cpf).getDebito();
        }
        throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
    }

    /**
     * Cria um produto a partir do nome, preco e descricao de um produto.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param preco         para o preco do produto.
     * @param descricao     para a descricao do produto.
     */
    public void criaProduto(String nomeDoProduto, double preco, String descricao) {
        if (produtos.containsKey(nomeDoProduto + descricao)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }
        Produto produtoCriado = new Produto(nomeDoProduto, preco, descricao);
        this.produtos.put(nomeDoProduto + descricao, produtoCriado);
    }

    /**
     * Pega o produto de Produto a partir do nome do produto e a descricao concatenadas.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param descricao     para a descricao do produto.
     * @return o produto a partir do nome do produto e descricao.
     */
    public Produto getProduto(String nomeDoProduto, String descricao) {
        if (!produtos.containsKey(nomeDoProduto + descricao)) {
            return null;
        }
        return this.produtos.get(nomeDoProduto + descricao);
    }

    /**
     * Exibe uma conta a partir do cpf de um cliente e verifica se o mesmo possui uma conta em algum fornecedor.
     *
     * @param cpf para o cpf de um cliente.
     * @return uma conta de um cliente a partir de seu cpf.
     */
    public String exibeConta(String cpf) {
        if (contas.containsKey(cpf)) {
            return contas.get(cpf).toString();
        }
        throw new IllegalArgumentException(
                "Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
    }

    /**
     * Exibe uma conta de um cliente que contem suas dividas nos fornecedores e verifica se o mesmo possui uma conta
     * ou nao.
     *
     * @param cpf para o cpf de um cliente.
     * @return uma conta de um cliente que contém suas contas nos fornecedores que ele deve.
     */
    public String exibeContaFornecedorFormatada(String cpf) {
        if (contas.containsKey(cpf)) {
            return contas.get(cpf).exibeContaFornecedorFormatada();
        }
        throw new IllegalArgumentException(
                "Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
    }

    /**
     * Edita um produto a partir do nome do produto, da descricao e do nome do fornecedor.
     *
     * @param nomeDoProduto    para o nome do produto.
     * @param descricao        para a descricao do produto.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param novoDado         para o novo dado que ira ser alterado.
     */
    public void editaProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor, double novoDado) {
        if (produtos.containsKey(nomeDoProduto + descricao)) {
            getProduto(nomeDoProduto, descricao).setPreco(novoDado);
        } else {
            validator.validaExcecao("Erro na edicao de produto: produto nao existe.");
        }
    }

    /**
     * Remove um produto a partir do nome do produto e da descricao.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param descricao     para a descricao do produto.
     */
    public void removeProduto(String nomeDoProduto, String descricao) {
        if (produtos.containsKey(nomeDoProduto + descricao)) {
            produtos.remove(nomeDoProduto + descricao);
        } else {
            validator.validaExcecao("Erro na remocao de produto: produto nao existe.");
        }
    }

    /**
     * Exibe os produtos dos fornecedores.
     *
     * @return os nome do fornecedor com seus devidos produtos sendo cada fornecedor separado por "|".
     */
    public String exibeProdutosFornecedor() {
        ArrayList<Produto> produtos = new ArrayList<>(this.produtos.values());
        ArrayList<String> produtosFornecedorString = new ArrayList<>();
        Collections.sort(produtos);
        if (produtos.size() == 0) {
            produtosFornecedorString.add(nomeDoFornecedor + " -");
        } else {
            for (Produto produtoCriado : produtos) {
                produtosFornecedorString.add(nomeDoFornecedor + " - " + produtoCriado.toString());
            }
        }
        return String.join(" | ", produtosFornecedorString);
    }

    /**
     * Verifica se existe um produto a partir do nome do produto e da descricao.
     *
     * @param nomeDoProduto para o nome do produto.
     * @param descricao     para a descricao do produto.
     * @return o nome do produto e a descricao concatenadas como uma chave.
     */
    public boolean existeProduto(String nomeDoProduto, String descricao) {
        return this.produtos.containsKey(nomeDoProduto + descricao);
    }

    /**
     * Verifica se existem contas.
     *
     * @return verdadeiro se existe.
     */
    public boolean existeContas() {
        return !this.contas.isEmpty();
    }

    /**
     * Pega as compras de todas as contas cadastradas.
     *
     * @return todas as compras cadastradas.
     */
    public List<Compra> getCompras() {
        List<Compra> compras = new ArrayList<>();
        for (Conta conta : this.contas.values()) {
            compras.addAll(conta.getCompras());
        }
        return compras;
    }

    /**
     * Pega o email do fornecedor.
     *
     * @return o email do fornecedor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email do fornecedor e recebe uma String como parametro para modificar o email.
     *
     * @param email para o email do fornecedor modificado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pega o telefone do fornecedor.
     *
     * @return o telefone do fornecedor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Modifica o telefone do fornecedor.
     *
     * @param telefone para o telefone do fornecedor modificado.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Pega o nome do fornecedor.
     *
     * @return o nome do fornecedor.
     */
    public String getNomeDoFornecedor() {
        return nomeDoFornecedor;
    }

    /**
     * Formatacao do toString para o que se eh desejado como saida.
     *
     * @return Retorna uma String contendo o nome do fornecedor, o email e o telefone separados por "-".
     */
    public String toString() {
        return this.nomeDoFornecedor + " - " + this.email + " - " + this.telefone;
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeDoFornecedor == null) ? 0 : nomeDoFornecedor.hashCode());
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
        Fornecedor other = (Fornecedor) obj;
        if (nomeDoFornecedor == null) {
            if (other.nomeDoFornecedor != null)
                return false;
        } else if (!nomeDoFornecedor.equals(other.nomeDoFornecedor))
            return false;
        return true;
    }

    /**
     * Compara os dois objetos a partir do nome do fornecedor.
     */
    @Override
    public int compareTo(Fornecedor fornecedor2) {
        return this.nomeDoFornecedor.compareTo(fornecedor2.getNomeDoFornecedor());
    }

}
