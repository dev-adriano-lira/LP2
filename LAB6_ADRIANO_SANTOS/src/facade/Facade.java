package facade;

import controladores.ControlerCentral;
import easyaccept.EasyAccept;

public class Facade {
    private ControlerCentral cc;

    public Facade() {
        this.cc = new ControlerCentral();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.cc.adicionaCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.cc.exibeCliente(cpf);
    }

    public String exibeClientes() {
        return this.cc.exibeClientes();
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.cc.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        this.cc.removeCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.cc.adicionaFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome) {
        return this.cc.exibeFornecedor(nome);
    }

    public String exibeFornecedores() {
        return this.cc.exibeFornecedores();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.cc.editaFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.cc.removeFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        this.cc.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String fornecedor, String nome, String descricao) {
        return this.cc.exibeProduto(fornecedor, nome, descricao);
    }

    public String exibeProdutosFornecedor(String fornecedor) {
        return this.cc.exibeProdutosFornecedor(fornecedor);
    }

    public String exibeProdutos() {
        return this.cc.exibeProdutos();
    }

    public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
        this.cc.editaProduto(fornecedor, nome, descricao, novoPreco);
    }

    public void removeProduto(String fornecedor, String nome, String descricao) {
        this.cc.removeProduto(fornecedor, nome, descricao);
    }

    public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto,
                               String descricaoProduto) {
        this.cc.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto);
    }

    public double getDebito(String cpf, String fornecedor) {
        return this.cc.getDebito(cpf, fornecedor);
    }

    public String exibeContas(String cpf, String fornecedor) {
        return this.cc.exibeContas(cpf, fornecedor);
    }

    public String exibeContasClientes(String cpf) {
        return this.cc.exibeContasClientes(cpf);
    }

    public void ordenaPor(String criterio) {
        this.cc.ordenaPor(criterio);
    }

    public String listarCompras() {
        return this.cc.listarCompras();
    }

    public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        this.cc.adicionaCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);
    }

    public void editaCombo(String nomeCombo, String descricaoCombo, String fonrecedor, double novoFator) {
        this.cc.editaCombo(nomeCombo, descricaoCombo, fonrecedor, novoFator);
    }

    public static void main(String[] args) {
        args = new String[]{"facade.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt",
                "testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt",
                "testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_6.txt", "testes_aceitacao/use_case_7.txt"};
        EasyAccept.main(args);
    }

}
