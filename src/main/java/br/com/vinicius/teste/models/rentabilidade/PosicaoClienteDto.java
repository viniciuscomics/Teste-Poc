package br.com.vinicius.teste.models.rentabilidade;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PosicaoClienteDto(Integer codigoCliente, LocalDateTime dataBase, List<ProdutoRentabilidadeDto> produtos) {
}
