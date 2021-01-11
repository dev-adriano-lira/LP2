package comparadores;

import java.util.Comparator;
import entidades.Compra;


public class OrdenaCompraCliente implements Comparator<Compra> {

    /**
     * Compara os nomes dos clientes por ordem alfabetica e concatena o nome do fornecedor com a descricao
	 * do produto e a data para tambem serem comparados.
     *
     * @param compra1 para uma compra.
     * @param compra2 para outra compra.
     * @return a comparacao entre uma compra com outra por ordem alfabetica pelo nome do cliente.
     */
    @Override
    public int compare(Compra compra1, Compra compra2) {
        if (compra1.getNomeDoCliente().equals(compra2.getNomeDoCliente())) {
            String representacao1 = compra1.getNomeDoFornecedor() + compra1.getDescricaoProduto() + compra1.getStringData();
            String representacao2 = compra2.getNomeDoFornecedor() + compra2.getDescricaoProduto() + compra2.getStringData();
            return representacao1.compareTo(representacao2);
        }
        return compra1.getNomeDoCliente().compareTo(compra2.getNomeDoCliente());
    }

}