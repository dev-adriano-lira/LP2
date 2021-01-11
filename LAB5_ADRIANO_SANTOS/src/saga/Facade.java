package saga;

import java.text.ParseException;

import controladores.ControladorCliente;
import controladores.ControladorCompra;
import controladores.ControladorFornecedor;
import easyaccept.EasyAccept;

public class Facade {
	private ControladorCliente controllerCliente;
	private ControladorFornecedor controllerFornecedor;
	private ControladorCompra controllerCompra;

	public Facade() {
		controllerCliente = new ControladorCliente();
		controllerFornecedor = new ControladorFornecedor();
		controllerCompra = new ControladorCompra(controllerCliente, controllerFornecedor);
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return controllerCliente.adicionaCliente(cpf, nome, email, localizacao);
	}

	public String getDebito(String cpf, String nomeDoFornecedor) {
		return controllerCompra.getDebito(cpf, nomeDoFornecedor);
	}

	public String exibeCliente(String cpf) {
		return controllerCliente.exibeCliente(cpf);
	}

	public void editaCliente(String cpf, String alteraDado, String novoDado) {
		controllerCliente.editaCliente(cpf, alteraDado, novoDado);
	}

	public void removeCliente(String cpf) {
		controllerCliente.removeCliente(cpf);
	}

	public String exibeClientes() {
		return controllerCliente.exibeClientes();
	}

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controllerFornecedor.adicionaFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return controllerFornecedor.exibeFornecedor(nome);
	}

	public void editaFornecedor(String nome, String alteraDado, String novoDado) {
		controllerFornecedor.editaFornecedor(nome, alteraDado, novoDado);
	}

	public void removeFornecedor(String nome) {
		controllerFornecedor.removeFornecedor(nome);
	}

	public String exibeFornecedores() {
		return controllerFornecedor.exibeFornecedores();
	}

	public void adicionaProduto(String nome, String nomeDoProduto, String descricao, double preco) {
		controllerFornecedor.colocaProdutoEmFornecedor(nome, nomeDoProduto, preco, descricao);
	}

	public String exibeProduto(String nomeDoProduto, String descricao, String nome) {
		return controllerFornecedor.exibeProduto(nomeDoProduto, descricao, nome);
	}

	public void editaProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor, double novoDado) {
		controllerFornecedor.editaProduto(nomeDoProduto, descricao, nomeDoFornecedor, novoDado);
	}

	public void removeProduto(String nomeDoProduto, String descricao, String nomeDoFornecedor) {
		controllerFornecedor.removeProduto(nomeDoProduto, descricao, nomeDoFornecedor);
	}

	public String exibeProdutosFornecedor(String nomeDoFornecedor) {
		return controllerFornecedor.exibeProdutosFornecedor(nomeDoFornecedor);
	}

	public String exibeProdutos() {
		return controllerFornecedor.exibeProdutos();
	}

	public void adicionaCompra(String cpf, String nomeDoFornecedor, String data, String nomeDoProduto, String descricao)
			throws ParseException {
		controllerCompra.adicionaCompra(cpf, nomeDoFornecedor, data, nomeDoProduto, descricao);
	}

	public String exibeContas(String cpf, String nomeDoFornecedor) {
		return controllerCompra.exibeContas(cpf, nomeDoFornecedor);
	}

	public String exibeContasClientes(String cpf) {
		return controllerCompra.exibeContasClientes(cpf);
	}
	
	public void ordenaPor(String criterioOrdenacao) {
		controllerCompra.setCriterioOrdenacao(criterioOrdenacao);
	}
	
	public String listarCompras() {
		return controllerCompra.listarCompras();
	}
	
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt" };
		EasyAccept.main(args);
	}

}