package comparadores;

import java.util.Comparator;

import entidades.Compra;

public class OrdenaCompraData implements Comparator<Compra> {

    /**
     * Compara as datas de um compra com outra por ordem alfabetica e concatena o nome do cliente com o nome do
     * fornecedor e a descricao do produto para tambem serem comparados.
     *
     * @param compra1 para uma compra.
     * @param compra2 para outra compra.
     * @return a comparacao entre uma compra com outra por ordem alfabetica da data de compra de um produto.
     */
    public int compare(Compra compra1, Compra compra2) {
        if (compra1.getData().equals(compra2.getData())) {
            String representacao1 = compra1.getNomeDoCliente() + compra1.getNomeDoFornecedor() + compra1.getDescricaoProduto();
            String representacao2 = compra2.getNomeDoCliente() + compra2.getNomeDoFornecedor() + compra2.getDescricaoProduto();
            return representacao1.compareTo(representacao2);
        }
        return compra1.getData().compareTo(compra2.getData());
    }
}
