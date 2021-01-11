package controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import entidades.Cliente;
import validadores.Validador;

/**
 * Classe controle de Cliente. É nessa classe que temos os métodos que cadastram, alteram e exibem um certo Cliente.
 *
 * @author Adriano Lira.
 */
public class ControladorCliente {

    /**
     * Objeto da classe validacao que verifica se as entradas sao validas, vazias ou nulas.
     */
    private Validador validator;

    /**
     * HashMap que tem como chave uma String com o CPF do cliente e armazena objetos do tipo Cliente.
     */
    private Map<String, Cliente> clientes;

    /**
     * Construtor da classe ControladorCliente.
     */
    public ControladorCliente() {
        this.clientes = new HashMap<>();
        this.validator = new Validador();
    }

    /**
     * Adiciona um cliente a partir do seu cpf, nome, email e localizacao, recebendo
     * parametros que nao podem ser vazios ou nulos, alem disso verifica se o cpf eh
     * valido, caso contrario lanca uma excecao para cada caso.
     *
     * @param cpf           para o cpf do cliente.
     * @param nomeDoCliente para o nome do cliente.
     * @param email         para o email do cliente.
     * @param localizacao   para a localizacao do cliente.
     * @return o cpf do cliente.
     */
    public String adicionaCliente(String cpf, String nomeDoCliente, String email, String localizacao) {
        validator.validaNulleVazio(nomeDoCliente, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        validator.validaNulleVazio(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        validator.validaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
        this.verificaCpfCadastrado(cpf);
        this.clientes.put(cpf, new Cliente(cpf, nomeDoCliente, email, localizacao));
        return cpf;
    }

    /**
     * Retorna um cliente a partir do seu cpf.
     *
     * @param cpf para o cpf do cliente.
     * @return o cliente pela chave cpf.
     */
    public Cliente getCliente(String cpf) {
        return this.clientes.get(cpf);
    }

    /**
     * Verifica se existe um cliente cadastrado a partir do seu cpf.
     *
     * @param cpf para o cpf do cliente
     */
    public void verificaCpfCadastrado(String cpf) {
        if (this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
    }

    /**
     * Verifica se existe um cliente não cadastrado a partir do seu cpf.
     *
     * @param cpf para o cpf do cliente.
     */
    public void verificaCpfNaoCadastrado(String cpf) {
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Exibe um cliente a partir do seu cpf recebendo um parametro que nao podem ser
     * vazio ou nulo, caso contrario lanca uma excecao.
     *
     * @param cpf para o cpf do cliente.
     * @return um cliente a partir do seu cpf.
     */
    public String exibeCliente(String cpf) {
        validator.validaNulleVazio(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        this.verificaCpfNaoCadastrado(cpf);
        return this.clientes.get(cpf).exibeCliente();
    }

    /**
     * Exibe todos os clientes.
     *
     * @return todos os clientes separados por "|".
     */
    public String exibeClientes() {
        ArrayList<Cliente> Clientes = new ArrayList<>(this.clientes.values());
        Collections.sort(Clientes);
        ArrayList<String> ClientesString = new ArrayList<>();
        for (Cliente cliente : Clientes) {
            ClientesString.add(cliente.exibeCliente());
        }
        return String.join(" | ", ClientesString);
    }

    /**
     * Edita um cliente a partir do seu cpf recebendo parametros que nao podem ser
     * vazios ou nulos, caso contrario lanca uma excecao para cada caso. Alem disso
     * verifica se o usuario tenta editar o cpf, se o atributo nao existe e se o
     * cliente nao existe, lancando tambem uma excecao para cada caso.
     *
     * @param cpf        para o cpf do cliente.
     * @param alteraDado para alterar um dado.
     * @param novoDado   para atribuir um novo dado a um dado anterior.
     */
    public void editaCliente(String cpf, String alteraDado, String novoDado) {
        validator.validaNulleVazio(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(alteraDado, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        validator.validaNulleVazio(novoDado, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

        if (clientes.containsKey(cpf)) {
            switch (alteraDado) {
                case "cpf":
                    validator.validaExcecao("Erro na edicao do cliente: cpf nao pode ser editado.");
                case "nome":
                    clientes.get(cpf).setNomeDoCliente(novoDado);
                    break;
                case "localizacao":
                    clientes.get(cpf).setLocalizacao(novoDado);
                    break;
                case "email":
                    clientes.get(cpf).setEmail(novoDado);
                    break;
                default:
                    validator.validaExcecao("Erro na edicao do cliente: atributo nao existe.");
            }
        } else {
            validator.validaExcecao("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Remove um cliente a partir do seu cpf, recebendo parametros que nao podem ser
     * vazios ou nulos e verifica se o cliente existe, caso contrario lanca uma
     * excecao.
     *
     * @param cpf para o cpf do cliente.
     */
    public void removeCliente(String cpf) {
        validator.validaNulleVazio(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
        } else {
            validator.validaExcecao("Erro na remocao do cliente: cliente nao existe.");
        }
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
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
        ControladorCliente other = (ControladorCliente) obj;
        if (clientes == null) {
            if (other.clientes != null)
                return false;
        } else if (!clientes.equals(other.clientes))
            return false;
        return true;
    }

}
