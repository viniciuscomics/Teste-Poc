package br.com.vinicius.teste.models.dto;

import lombok.Builder;

@Builder
public record PortfolioFundoExclusivoAssociacaoDto(Integer id, PortfolioDto principal, PortfolioDto fundoExclusivo) {
}

