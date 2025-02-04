package br.com.vinicius.teste.models.rentabilidade;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ProdutoRentabilidadeDto(String codigoProduto, String nomeProduto, String tipoProduto, BigDecimal valorUnitario, BigDecimal taxa, BigDecimal quantidade, LocalDateTime dataPosicao){
}
