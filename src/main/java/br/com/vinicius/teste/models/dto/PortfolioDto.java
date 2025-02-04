package br.com.vinicius.teste.models.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PortfolioDto {

    private Integer id;
    private BigDecimal valorTotal;
    private LocalDateTime dataReferencia;
    private TipoPortfolioDto tipoPortfolio;
    private PortfolioClienteDto portfolioCliente;
    private List<PortfolioDto> portfolioFundoExclusivo;
    private List<PortfolioProdutoDto> portfolioProduto;
}
