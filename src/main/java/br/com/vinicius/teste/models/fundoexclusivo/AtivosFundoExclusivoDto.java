package br.com.vinicius.teste.models.fundoexclusivo;

import lombok.Builder;

import java.util.List;

@Builder
public record AtivosFundoExclusivoDto (String codigoProduto, String nomeFundo, List<ProdutoFundoExclusivoDto> produtosFundoExclusivo){
}
