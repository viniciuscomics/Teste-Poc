package br.com.vinicius.teste.dataprovider.rentabilidade;

import br.com.vinicius.teste.models.rentabilidade.PosicaoClienteDto;
import br.com.vinicius.teste.models.rentabilidade.ProdutoRentabilidadeDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class RentabilidadeCliente {

    public PosicaoClienteDto buscaPosicaoCliente(Integer codigoCliente){

        var produtos =
                List.of(ProdutoRentabilidadeDto.builder().codigoProduto("185").nomeProduto("CMIG4").tipoProduto("FY").taxa(new BigDecimal("1")).quantidade(new BigDecimal("100")).valorUnitario(new BigDecimal("10.50")).dataPosicao(LocalDateTime.now()).build(),
                        ProdutoRentabilidadeDto.builder().codigoProduto("145").nomeProduto("FUNDO-EXCLUSIVO-B12").tipoProduto("FY").taxa(new BigDecimal("1")).quantidade(new BigDecimal("1")).valorUnitario(new BigDecimal("100.000")).dataPosicao(LocalDateTime.now()).build(),
                        ProdutoRentabilidadeDto.builder().codigoProduto("154").nomeProduto("BBAS3").tipoProduto("IN").taxa(new BigDecimal("1")).quantidade(new BigDecimal("100")).valorUnitario(new BigDecimal("27.55")).dataPosicao(LocalDateTime.now()).build(),
                        ProdutoRentabilidadeDto.builder().codigoProduto("133").nomeProduto("Selic 2029").tipoProduto("NS").taxa(new BigDecimal("1")).quantidade(new BigDecimal("8.2")).valorUnitario(new BigDecimal("31.66")).dataPosicao(LocalDateTime.now()).build(),
                        ProdutoRentabilidadeDto.builder().codigoProduto("137").nomeProduto("IPCA 2035").tipoProduto("NS").taxa(new BigDecimal("1")).quantidade(new BigDecimal("4.8")).valorUnitario(new BigDecimal("59.74")).dataPosicao(LocalDateTime.now()).build());

        return PosicaoClienteDto.builder()
                .codigoCliente(123)
                .dataBase(LocalDateTime.now())
                .produtos(produtos)
                .build();
    }

}
