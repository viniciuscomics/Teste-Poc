package br.com.vinicius.teste.strategy.cliente.impl;

import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.cliente.ClienteStrategy;

import java.util.List;

public class ClientePrivateStrategyImpl implements ClienteStrategy {

    @Override
    public PortfolioDto processarProdutosPortfolio(List<PortfolioProdutoDto> portfolioProduto) {
        return null;
    }

    @Override
    public String getTipoCliente() {
        return "PRIVATE";
    }
}
