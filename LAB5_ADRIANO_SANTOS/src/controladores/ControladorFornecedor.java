package controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import entidades.Fornecedor;
import entidades.Produto;
import validadores.Validador;

/**
 * Classe controle de Fornecedor. É nessa classe que temos os métodos que temos os métodos que cadastram, alteram e
 * exibem Fornecedores e Produtos.
 *
 * @author Adriano Lira.
 */
public class ControladorFornecedor {

    /**
     * Objeto da classe validacao que verifica se as entradas sao validas, vazias ou nulas.
     */
    private Validador validator;

    /**
     * HashMap que tem como chave uma String com o nome do fornecedor e armazena objetos do tipo Fornecedor.
     */
    private Map<String, Fornecedor> fornecedores;

    /**
     * Construtor da classe ControladorFornecedor.
     */
    public ControladorFornecedor() {
        this.fornecedores = new HashMap<>();
        this.validator = new Validador();
    }

    /**
     * Cadastra um fornecedor a partir do nome de um nome, de um email e de um
     * telefone, recebendo parametros que nao podem ser vazios ou nulos, caso
     * contrario, lanca uma excecao.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param email            para o email do fornecedor
     * @param telefone         para o telefone do fornecedor.
     * @return nome do fornecedor como a chave do hashMap.
     */
    public String adicionaFornecedor(String nomeDoFornecedor, String email, String telefone) {
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        this.nomeCadastrado(nomeDoFornecedor);
        this.fornecedores.put(nomeDoFornecedor, new Fornecedor(nomeDoFornecedor, email, telefone));
        return nomeDoFornecedor;
    }

    /**
     * Pega um fornecedor do objeto fornecedor pelo nome do fornecedor.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return o nome do fornecedor.
     */
    public Fornecedor getFornecedor(String nomeDoFornecedor) {
        return this.fornecedores.get(nomeDoFornecedor);
    }

    /**
     * Retorna uma colecao contendo todos os fornecedores cadastrados.
     *
     * @return todos os fornecedores cadastrados.
     */
    public Collection<Fornecedor> getFornecedores() {
        return this.fornecedores.values();
    }

    /**
     * Verifica se o nome do fornecedor já existe a partir do nome do fornecedor, se
     * ja existe é lançada uma excecao.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     */
    public void nomeCadastrado(String nomeDoFornecedor) {
        if (this.fornecedores.containsKey(nomeDoFornecedor)) {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
    }

    /**
     * Verifica se o nome do fornecedor nao existe a partir do nome do fornecedor,
     * se não existe é lançada uma excecao.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param msg              para uma mensagem de erro.
     */
    public void nomeNaoExiste(String nomeDoFornecedor, String msg) {
        if (!this.fornecedores.containsKey(nomeDoFornecedor)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Exibe um fornecedor a partir de seu nome, recebe parametros que nao podem ser
     * vazios ou nulos e verifica se o nome existe, caso contrario, lanca uma
     * excecao.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return o nome do fornecedor com uma saida formatada.
     */
    public String exibeFornecedor(String nomeDoFornecedor) {
        validator.validaNulleVazio(nomeDoFornecedor, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo");
        this.nomeNaoExiste(nomeDoFornecedor, "Erro na exibicao do fornecedor: fornecedor nao existe.");
        return this.fornecedores.get(nomeDoFornecedor).toString();
    }

    /**
     * Edita email e o telefone de um fornecedor a partir do nome do fornecedor,
     * recebendo parametros que nao podem ser vazios ou nulos, verificando se o
     * usuario tenta editar o nome, se tenta mudar um atributo que nao existe ou
     * editar um fornecedor que nao existe, lancando uma excecao para cada caso.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param alteraDado       para o dado que vai ser alterado.
     * @param novoDado         para o novo dado que foi alterado.
     */
    public void editaFornecedor(String nomeDoFornecedor, String alteraDado, String novoDado) {
        validator.validaNulleVazio(nomeDoFornecedor, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(alteraDado, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(novoDado, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if (fornecedores.containsKey(nomeDoFornecedor)) {
            switch (alteraDado) {
                case "nome":
                    validator.validaExcecao("Erro na edicao do fornecedor: nome nao pode ser editado.");
                case "email":
                    fornecedores.get(nomeDoFornecedor).setEmail(novoDado);
                    break;
                case "telefone":
                    fornecedores.get(nomeDoFornecedor).setTelefone(novoDado);
                    break;
                default:
                    validator.validaExcecao("Erro na edicao do fornecedor: atributo nao existe.");
            }
        } else {
            validator.validaExcecao("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Remove um fornecedor a partir do nome do fornecedor, recebendo parametros que
     * nao podem ser vazios ou nulos, verifica se existe um fornecedor para poder
     * remover, caso contrario lanca uma excecao para cada caso.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     */
    public void removeFornecedor(String nomeDoFornecedor) {
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if (fornecedores.containsKey(nomeDoFornecedor)) {
            fornecedores.remove(nomeDoFornecedor);
        } else {
            validator.validaExcecao("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Atribue um produto a um fornecedor a partir do seu nome recebendo parametros
     * que nao podem ser vazios ou nulos, alem de verificar se o preco eh valido e
     * se o produto existe, caso contario, lanca uma excecao para cada caso.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param nomeDoProduto    para o nome do produto.
     * @param preco            para o preco do produto.
     * @param descricao        para a descricao do produto.
     */
    public void colocaProdutoEmFornecedor(String nomeDoFornecedor, String nomeDoProduto, double preco,
                                          String descricao) {
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(nomeDoProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        validator.validaPreco(preco, "Erro no cadastro de produto: preco invalido.");
        nomeNaoExiste(nomeDoFornecedor, "Erro no cadastro de produto: fornecedor nao existe.");
        this.fornecedores.get(nomeDoFornecedor).criaProduto(nomeDoProduto, preco, descricao);
    }

    /**
     * Exibe os produtos de um fornecedor a partir do nome do fornecedor, recebendo
     * parametros que nao podem ser vazios ou nulos, alem de verificar se o
     * fornecedor e o produto existem, caso contario, lanca uma excecao para cada
     * caso.
     *
     * @param nomeDoProduto    para o nome do produto.
     * @param descricao        para a descricao do produto.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return a representação em String do produto.
     */
    public String exibeProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor) {
        validator.validaNulleVazio(nomeDoProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        nomeNaoExiste(nomeDoFornecedor, "Erro na exibicao de produto: fornecedor nao existe.");
        Produto produto = fornecedores.get(nomeDoFornecedor).getProduto(nomeDoProduto, descricao);
        validator.validaNull(produto, "Erro na exibicao de produto: produto nao existe.");
        return produto.toString();
    }

    /**
     * Edita um produto a partir do nome do fornecedor recebendo parametros que nao
     * podem ser vazios ou nulos, alem de que verificar se o fornecedor existe, caso
     * contrario, lanca uma excecao.
     *
     * @param nomeDoProduto    para o nome do produto.
     * @param descricao        para a descricao do produto.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param novoDado         para o novo dado que sera alterado.
     */
    public void editaProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor, double novoDado) {
        validator.validaPreco(novoDado, "Erro na edicao de produto: preco invalido.");
        validator.validaNulleVazio(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        validator.validaNulleVazio(nomeDoProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (fornecedores.containsKey(nomeDoFornecedor)) {
            getFornecedor(nomeDoFornecedor).editaProduto(nomeDoProduto, descricao, nomeDoFornecedor, novoDado);
        } else {
            validator.validaExcecao("Erro na edicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Remove um produto de um fornecedor a partir do nome do fornecedor, nome do
     * protudo e descricao recebendo parametros que nao podem ser vazios ou nulos, e
     * verifica se o fornecedor existe, caso contrario, lanca uma excecao.
     *
     * @param nomeDoProduto    para o nome do produto.
     * @param descricao        para a descricao de um produto.
     * @param nomeDoFornecedor para o nome do fornecedor.
     */
    public void removeProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor) {
        validator.validaNulleVazio(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        validator.validaNulleVazio(nomeDoProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (fornecedores.containsKey(nomeDoFornecedor)) {
            getFornecedor(nomeDoFornecedor).removeProduto(nomeDoProduto, descricao);
        } else {
            validator.validaExcecao("Erro na remocao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Exibe todos os fornecedores de forma ordenada usando o nome em ordem
     * alfabetica para ordernar.
     *
     * @return todos os fornecedores ordenados por ordem alfabética tendo como seu
     * nome a referencia para ordenar sendo separados por um "|".
     */
    public String exibeFornecedores() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
        Collections.sort(fornecedores);
        ArrayList<String> fornecedoresString = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            fornecedoresString.add(fornecedor.toString());
        }
        return String.join(" | ", fornecedoresString);
    }

    /**
     * Exibe todos os produtos de um fornecedor a partir do nome do fornecedor
     * recebendo parametro que nao pode ser vazios ou nulos e verificando se o
     * fornecedor existe, caso contrario, lanca uma excecao.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return uma representacao em String de todos os produtos de um fornecedor.
     */
    public String exibeProdutosFornecedor(String nomeDoFornecedor) {
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (!fornecedores.containsKey(nomeDoFornecedor)) {
            validator.validaExcecao("Erro na exibicao de produto: fornecedor nao existe.");
        }
        return getFornecedor(nomeDoFornecedor).exibeProdutosFornecedor();
    }

    /**
     * Exibe os produtos de todos os fornecedores de forma ordenada usando o nome do
     * fornecedor e do produto em ordem alfabetica para ordernar.
     *
     * @return todos os produtos e fornecedores ordenados por ordem alfabetica tendo
     * como seu nome a referencia para ordenar sendo cada fornecedor
     * separado por um "|".
     */
    public String exibeProdutos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
        Collections.sort(fornecedores);
        ArrayList<String> fornecedoresString = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            fornecedoresString.add(fornecedor.exibeProdutosFornecedor());
        }
        return String.join(" | ", fornecedoresString);
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fornecedores == null) ? 0 : fornecedores.hashCode());
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
        ControladorFornecedor other = (ControladorFornecedor) obj;
        if (fornecedores == null) {
            if (other.fornecedores != null)
                return false;
        } else if (!fornecedores.equals(other.fornecedores))
            return false;
        return true;
    }

}
