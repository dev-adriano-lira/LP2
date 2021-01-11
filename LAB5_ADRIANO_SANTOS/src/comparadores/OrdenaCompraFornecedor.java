package comparadores;

import java.util.Comparator;

import entidades.Compra;

public class OrdenaCompraFornecedor implements Comparator<Compra> {

    /**
     * Compara os nomes dos fornecedores por ordem alfabetica e concatena o nome do cliente com a descrica do produto
     * e a data para tambem serem comparados.
     *
     * @param compra1 para uma compra.
     * @param compra2 para outra compra.
     * @return a comparacao entre uma compra com outra por ordem alfabetica pelo nome do do fornecedor.
     */
    public int compare(Compra compra1, Compra compra2) {
        if (compra1.getNomeDoFornecedor().equals(compra2.getNomeDoFornecedor())) {
            String representacao1 = compra1.getNomeDoCliente() + compra1.getDescricaoProduto() + compra1.getStringData();
            String representacao2 = compra2.getNomeDoCliente() + compra2.getDescricaoProduto() + compra2.getStringData();
            return representacao1.compareTo(representacao2);
        }
        return compra1.getNomeDoFornecedor().compareTo(compra2.getNomeDoFornecedor());
    }

}
