package br.com.vinicius.teste.models.produto;

import lombok.Builder;

@Builder
public record ProdutoApiDto(String codigoProduto, String nomeProduto, String risco, String duration, String idClasse, String classeAtivo) {
}
