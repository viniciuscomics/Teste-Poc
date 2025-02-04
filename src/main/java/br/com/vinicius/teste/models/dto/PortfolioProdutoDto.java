package br.com.vinicius.teste.models.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PortfolioProdutoDto {

    private Integer id;
    private String codigoProduto;
    private String nomeProduto;
    private String risco;
    private BigDecimal totalAlocado;
    private BigDecimal quantidade;
    private BigDecimal taxa;
    private LocalDateTime dataPosicao;
    private String tipoProduto;
    private String idClasseAtivo;
    private String classeAtivo;
    private String veiculo;
    private boolean isUpdate;
}
