package entidades;

import java.util.ArrayList;
import java.util.List;

import validadores.Validador;

/**
 * Representa um cliente. todo cliente precisa ter um cpf, um nome, um email e uma localizacao.
 *
 * @author Adriano Lira.
 */
public class Cliente implements Comparable<Cliente> {
    private Validador validator;
    private String cpf;
    private String nomeDoCliente;
    private String email;
    private String localizacao;
    private List<String> contasFornecedores;

    /**
     * Constroi um cliente a partir do cpf de um cliente, com o nome, email e localizacao do mesmo.
     *
     * @param cpf           para o cpf do cliente
     * @param nomeDoCliente para o nome do cliente.
     * @param email         para o email do cliente.
     * @param localizacao   para a localizacao do cliente.
     */
    public Cliente(String cpf, String nomeDoCliente, String email, String localizacao) {
        this.cpf = cpf;
        this.nomeDoCliente = nomeDoCliente;
        this.email = email;
        this.localizacao = localizacao;
        this.contasFornecedores = new ArrayList<>();
    }

    /**
     * Pega o nome do cliente.
     *
     * @return o nome do cliente.
     */
    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    /**
     * Modifica o nome do cliente tendo como parametro uma String que ira receber o nome modificado.
     *
     * @param nomeDoCliente para o nome do cliente.
     */
    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    /**
     * Pega o email do cliente.
     *
     * @return o email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email do cliente tendo como parametro uma String que ira receber o email modificado.
     *
     * @param email para o email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pega a localização do cliente.
     *
     * @return a localização do cliente.
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Modifica a localizacao do cliente tendo como parametro uma String que ira receber a localizacao modificada.
     *
     * @param localizacao para a localizacao do cliente.
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Pega o cpf do cliente.
     *
     * @return o cpf do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Adiciona uma conta do fornecedor recendo o nome do fornecedor como parametro.
     *
     * @param nomeDoFornecedor para o nome do fornecedor
     */

    /**
     * Adiciona uma conta do fornecedor recendo o nome do fornecedor como parametro.
     *
     * @param nomeDoFornecedor para o nome do fornecedor.
     * @return true se nao existe uma conta do fornecedor e adiciona, se nao retorna false.
     */
    public boolean adicionaContaFornecedor(String nomeDoFornecedor) {
        if (!contasFornecedores.contains(nomeDoFornecedor)) {
            contasFornecedores.add(nomeDoFornecedor);
            return true;
        }
        return false;
    }

    /**
     * Pega o nome de quem está devendo.
     *
     * @return o nome de quem deve.
     */
    public List<String> getContasFornecedores() {
        return this.contasFornecedores;
    }

    /**
     * Exibe um cliente.
     *
     * @return o cliente.
     */
    public String exibeCliente() {
        return this.nomeDoCliente + " - " + this.localizacao + " - " + this.email;
    }

    /**
     * Formata a saída.
     *
     * @return a saída com a palavra "Cliente: " e em seguida o nome do cliente.
     */
    public String nomeFormatado() {
        return "Cliente: " + this.nomeDoCliente;
    }

    /**
     * Compara dois objetos para verificar se possuem o mesmo nome do cliente.
     */
    @Override
    public int compareTo(Cliente cliente2) {
        return this.nomeDoCliente.compareTo(cliente2.getNomeDoCliente());
    }

    /**
     * Gera um hashCode unico para o objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

}
