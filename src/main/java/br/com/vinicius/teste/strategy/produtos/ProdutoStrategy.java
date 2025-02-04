package br.com.vinicius.teste.strategy.produtos;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;

import java.util.List;

public interface ProdutoStrategy {

    List<PortfolioProdutoDto> processarProduto(List<PortfolioProdutoDto> produtos);

    void setNextProductStrategy(ProdutoStrategy productStrategy);
}
