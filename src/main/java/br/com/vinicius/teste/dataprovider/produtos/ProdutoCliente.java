package br.com.vinicius.teste.dataprovider.produtos;

import br.com.vinicius.teste.models.produto.ProdutoApiDto;

import java.util.Random;

public class ProdutoCliente {

    public ProdutoApiDto buscarProdutoFake(String codigoProduto) {
        return ProdutoApiDto.builder()
                .codigoProduto(codigoProduto)
                .nomeProduto("NOME_API_".concat(codigoProduto))
                .risco("1")
                .idClasse(String.valueOf(new Random(10000).nextInt()))
                .classeAtivo("CLASSE_API_".concat(codigoProduto))
                .duration("DURATION_FAKE")
                .build();
    }

    public ProdutoApiDto buscarProdutoSac(String codigoProduto) {
        return ProdutoApiDto.builder()
                .codigoProduto(codigoProduto)
                .nomeProduto("PRODUCT SAC ".concat(codigoProduto))
                .build();
    }

}
