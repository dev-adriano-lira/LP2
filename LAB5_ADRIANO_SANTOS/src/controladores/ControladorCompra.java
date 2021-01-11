package controladores;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Cliente;
import entidades.Compra;
import entidades.Fornecedor;
import validadores.Validador;
import comparadores.OrdenaCompraCliente;
import comparadores.OrdenaCompraData;
import comparadores.OrdenaCompraFornecedor;

/**
 * Classe controle de Compra. É nessa classe que temos métodos que cadastram compras, pegam o debito, exibe contas,
 * muda o criterio de ordenacao e lista todas as contas de acordo com a opcao do que o usuario deseja.
 *
 * @author Adriano Lira.
 */
public class ControladorCompra {

    /**
     * Controlador da classe ControladorCliente.
     */
    private ControladorCliente controllerClientes;

    /**
     * Controlador da classe ControladorFornecedor.
     */
    private ControladorFornecedor controllerFornecedores;

    /**
     * String que define o criterio de ordenacao.
     */
    private String criterioOrdenacao;

    /**
     * Objeto da classe validacao que verifica se as entradas sao validas, vazias ou nulas.
     */
    private Validador validator;

    /**
     * Construtor da classe ControladorCompra a partir do ControladorCliente e do ControladorFornecedor.
     *
     * @param controllerClientes     para o ControladorCliente.
     * @param controllerFornecedores para o ControladorFornecedor.
     */
    public ControladorCompra(ControladorCliente controllerClientes, ControladorFornecedor controllerFornecedores) {
        this.controllerClientes = controllerClientes;
        this.controllerFornecedores = controllerFornecedores;
        this.criterioOrdenacao = "indefinida";
        this.validator = new Validador();
    }

    /**
     * Adiciona uma compra a partir do cpf, nome do fornecedor, data de compra, nome
     * do produto e a discricao do produto. Verifica se o cliente, fornecedor e o
     * produto existem para adicionar uma compra.
     *
     * @param cpf              para o cpf do cliente.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @param data             para a data de compra.
     * @param nomeDoProduto    para o nome do produto.
     * @param descricao        para a descricao do produto.
     * @throws ParseException lanca uma excessao.
     */
    public void adicionaCompra(String cpf, String nomeDoFornecedor, String data, String nomeDoProduto, String descricao)
            throws ParseException {
        validator.validaNulleVazio(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        validator.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        validator.validaData(data, "Erro ao cadastrar compra: data invalida.");
        validator.validaNulleVazio(nomeDoProduto,
                "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(descricao,
                "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
        Cliente cliente = controllerClientes.getCliente(cpf);
        if (cliente == null) {
            throw new NullPointerException("Erro ao cadastrar compra: cliente nao existe.");
        }
        Fornecedor fornecedor = controllerFornecedores.getFornecedor(nomeDoFornecedor);
        if (fornecedor == null) {
            throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao existe.");
        }
        if (fornecedor.getProduto(nomeDoProduto, descricao) == null) {
            throw new NullPointerException("Erro ao cadastrar compra: produto nao existe.");
        }
        fornecedor.cadastraCompra(cliente.getCpf(), cliente.getNomeDoCliente(), nomeDoProduto, descricao, data);
        cliente.adicionaContaFornecedor(fornecedor.getNomeDoFornecedor());
    }

    /**
     * Acessa o objeto de fornecedor, em seguida verifica se existe conta para o
     * cliente, se sim retorna o debito da conta. Verifica se o cliente e o
     * fornecedor existem para assim pegar o debito da conta.
     *
     * @param cpf              para o cpf do cliente.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return retorna o debito da conta.
     */
    public String getDebito(String cpf, String nomeDoFornecedor) {
        validator.validaNulleVazio(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
        validator.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
        Cliente cliente = controllerClientes.getCliente(cpf);
        if (cliente == null) {
            throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
        }
        Fornecedor fornecedor = controllerFornecedores.getFornecedor(nomeDoFornecedor);
        if (fornecedor == null) {
            throw new NullPointerException("Erro ao recuperar debito: fornecedor nao existe.");
        }
        return fornecedor.getDebitoConta(cliente.getCpf());
    }

    /**
     * Exibe todas as contas a partir do cpf do cliente e do nome do fornecedor.
     * Verifica se existe um cliente e um fornecedor para assim poder exibir as
     * contas.
     *
     * @param cpf              para o cpf do cliente.
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return todas as contas de um cliente em um fornecedor.
     */
    public String exibeContas(String cpf, String nomeDoFornecedor) {
        validator.validaNulleVazio(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        validator.validaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
        validator.validaNulleVazio(nomeDoFornecedor,
                "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        Cliente cliente = controllerClientes.getCliente(cpf);
        if (cliente == null) {
            throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao existe.");
        }
        Fornecedor fornecedor = controllerFornecedores.getFornecedor(nomeDoFornecedor);
        if (fornecedor == null) {
            throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao existe.");
        }
        return fornecedor.exibeConta(cliente.getCpf());
    }

    /**
     * Exibe todas as contas de um cliente em todos os fornecedores a partir do cpf
     * de um cliente. Verifica se existe um cliente e se os clientes possuem uma
     * conta para assim exibir suas contas.
     *
     * @param cpf para o cpf do cliente.
     * @return todas as contas de um cliente em todos o fornecedores.
     */
    public String exibeContasClientes(String cpf) {
        validator.validaNulleVazio(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        validator.validaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
        Cliente cliente = controllerClientes.getCliente(cpf);
        if (cliente == null) {
            throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao existe.");
        }
        ArrayList<String> fornecedores = new ArrayList<>(cliente.getContasFornecedores());
        if (fornecedores.isEmpty()) {
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
        }
        ArrayList<String> exibeContas = new ArrayList<>();
        exibeContas.add(cliente.nomeFormatado());
        for (String nomeDoFornecedor : fornecedores) {
            exibeContas.add(
                    this.controllerFornecedores.getFornecedor(nomeDoFornecedor).exibeContaFornecedorFormatada(cpf));
        }
        return String.join(" | ", exibeContas);
    }

    /**
     * Define qual eh o estado que se encontra o criterio de alteracao e verifica se o estado eh oferecido pelo sistema,
     * caso contario, lanca uma excecao.
     *
     * @param criterioOrdenacao para o criterio de ordenacao.
     */
    public void setCriterioOrdenacao(String criterioOrdenacao) {
        validator.validaNulleVazio(criterioOrdenacao,
                "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
        if (criterioOrdenacao.equals("Cliente") || criterioOrdenacao.equals("Fornecedor")
                || criterioOrdenacao.equals("Data")) {
            this.criterioOrdenacao = criterioOrdenacao;
        } else {
            throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
        }
    }

    /**
     * Lista todas as compras a partir da opcao do usuario para cada especificidade.
     *
     * @return uma String vazia caso nao escolha nenhuma das opcoes.
     */
    public String listarCompras() {
        if (criterioOrdenacao.equals("indefinida")) {
            throw new IllegalArgumentException(
                    "Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
        } else if (criterioOrdenacao.equals("Cliente")) {
            return ordenaContasCliente();
        } else if (criterioOrdenacao.equals("Fornecedor")) {
            return ordenaContasFornecedor();
        } else if (criterioOrdenacao.equals("Data")) {
            return ordenaContasData();
        }
        return "";
    }

    /**
     * Pega as compras da List de Compra.
     *
     * @return todas as compras.
     */
    private List<Compra> getCompras() {
        List<Compra> compras = new ArrayList<>();
        for (Fornecedor fornecedor : controllerFornecedores.getFornecedores()) {
            if (fornecedor.existeContas()) {
                compras.addAll(fornecedor.getCompras());
            }
        }
        return compras;
    }

    /**
     * Lista todas as compras realizadas em cada conta do fornecedor ordenados por ordem alfabetica dos clientes
     * cadastrados.
     *
     * @return as contas formatadas, sendo cada conta separada por um "|".
     */
    public String ordenaContasCliente() {
        List<Compra> compras = this.getCompras();
        Collections.sort(compras, new OrdenaCompraCliente());
        List<String> formataCompras = new ArrayList<>();
        for (Compra compra : compras) {
            formataCompras.add(compra.formataCliente());
        }
        return String.join(" | ", formataCompras);
    }

    /**
     * Lista todas as compras para cada fornecedor cadastrado ordenados por ordem alfabetica.
     *
     * @return as contas formatadas, sendo cada conta separada por um "|".
     */
    public String ordenaContasFornecedor() {
        List<Compra> compras = this.getCompras();
        Collections.sort(compras, new OrdenaCompraFornecedor());
        List<String> formataCompras = new ArrayList<>();
        for (Compra compra : compras) {
            formataCompras.add(compra.formataFornecedor());
        }
        return String.join(" | ", formataCompras);
    }

    /**
     * Lista todas as compras para cada data ordenadas em forma crescente.
     *
     * @return todas as contas formatadas, sendo cada conta separada por um "|".
     */
    public String ordenaContasData() {
        List<Compra> compras = this.getCompras();
        Collections.sort(compras, new OrdenaCompraData());
        List<String> formataCompras = new ArrayList<>();
        for (Compra compra : compras) {
            formataCompras.add(compra.formataData());
        }
        return String.join(" | ", formataCompras);
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((controllerClientes == null) ? 0 : controllerClientes.hashCode());
        result = prime * result + ((controllerFornecedores == null) ? 0 : controllerFornecedores.hashCode());
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
        ControladorCompra other = (ControladorCompra) obj;
        if (controllerClientes == null) {
            if (other.controllerClientes != null)
                return false;
        } else if (!controllerClientes.equals(other.controllerClientes))
            return false;
        if (controllerFornecedores == null) {
            if (other.controllerFornecedores != null)
                return false;
        } else if (!controllerFornecedores.equals(other.controllerFornecedores))
            return false;
        return true;
    }

}