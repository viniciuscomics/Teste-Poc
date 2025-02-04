package br.com.vinicius.teste.strategy.produtos;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;

import java.util.List;

public abstract class ProductRuleTemplateMethod implements ProdutoStrategy {

    private ProdutoStrategy nextProductStrategy;

    @Override
    public final List<PortfolioProdutoDto> processarProduto(List<PortfolioProdutoDto> produtos) {

        List<PortfolioProdutoDto> resultado = aplicarEstrategia(produtos);

        return executarProximaRegra(resultado);
    }

    protected abstract List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos);


    private List<PortfolioProdutoDto> executarProximaRegra(List<PortfolioProdutoDto> produtos) {
        if (nextProductStrategy != null) {
            return nextProductStrategy.processarProduto(produtos);
        }
        return produtos;
    }

    @Override
    public void setNextProductStrategy(ProdutoStrategy productStrategy) {

        this.nextProductStrategy = productStrategy;
    }
}
