package br.com.vinicius.teste.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PortfolioClienteDto {

    private Integer id;
    private LocalDateTime dataCriacao;
    private String ag;
    private String conta;
    private String digito;
}
