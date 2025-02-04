package br.com.vinicius.teste.strategy.cliente;

import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;

import java.util.List;

public interface ClienteStrategy {

    PortfolioDto processarProdutosPortfolio(List<PortfolioProdutoDto> portfolioProduto);
    String getTipoCliente();
}
