package br.com.vinicius.teste.strategy.cliente.impl;

import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.cliente.ClienteStrategy;
import br.com.vinicius.teste.strategy.produtos.ProductStrategyChainBuilder;
import br.com.vinicius.teste.strategy.produtos.ProdutoStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ClienteVarejoStrategyImpl implements ClienteStrategy {

    private final ProdutoStrategy chainOfStrategy;

    public ClienteVarejoStrategyImpl(ProductStrategyChainBuilder chainBuilder) {

        this.chainOfStrategy = chainBuilder.buildChainPortfolioVarejo();
    }

    @Override
    public PortfolioDto processarProdutosPortfolio(List<PortfolioProdutoDto> portfolioProdutos) {

        log.info("Iniciando aplicação de regras para de produtos cliente varejo.");

         var produtos = chainOfStrategy.processarProduto(portfolioProdutos);

         return PortfolioDto.builder().portfolioProduto(produtos).build();
    }

    @Override
    public String getTipoCliente() {
        return "VAREJO";
    }
}
