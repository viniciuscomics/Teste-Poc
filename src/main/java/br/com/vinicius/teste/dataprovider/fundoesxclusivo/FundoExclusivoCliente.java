package br.com.vinicius.teste.dataprovider.fundoesxclusivo;

import br.com.vinicius.teste.models.fundoexclusivo.AtivosFundoExclusivoDto;
import br.com.vinicius.teste.models.fundoexclusivo.ProdutoFundoExclusivoDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FundoExclusivoCliente {

    public List<AtivosFundoExclusivoDto> buscarFundosExclusivos(List<String> codigosFundo){

        var produtosFundoExclusivo = List.of(
                ProdutoFundoExclusivoDto.builder()
                        .risco("1")
                        .quantidade(new BigDecimal("10"))
                        .classeAtivo("IPCA")
                        .codigoAtivo("VGIP11")
                        .veiculo("2")
                        .totalAlocado(new BigDecimal("50.000")).build(),
                ProdutoFundoExclusivoDto.builder()
                        .risco("1")
                        .quantidade(new BigDecimal("10"))
                        .classeAtivo("CDI")
                        .codigoAtivo("VGIR11")
                        .veiculo("2")
                        .totalAlocado(new BigDecimal("50.000")).build());

        var ativos = AtivosFundoExclusivoDto.builder()
                .nomeFundo("FUNDO-EXCLUSIVO-B12")
                .codigoProduto("145")
                .produtosFundoExclusivo(produtosFundoExclusivo)
                .build();

        return List.of(ativos);
    }
}
