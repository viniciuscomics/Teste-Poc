package br.com.vinicius.teste.models.fundoexclusivo;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoFundoExclusivoDto (String codigoAtivo, String classeAtivo, String veiculo, String risco, BigDecimal totalAlocado, BigDecimal quantidade){
}
