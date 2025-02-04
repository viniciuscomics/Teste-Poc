package br.com.vinicius.teste.strategy.cliente;

import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.models.rentabilidade.PosicaoClienteDto;

import java.util.List;

public interface ClienteStrategy {

    PortfolioDto processarPortfolio(List<PortfolioProdutoDto> portfolioProduto);
    String getTipoCliente();
}
