package br.com.vinicius.teste.usecase;

import br.com.vinicius.teste.dataprovider.rentabilidade.RentabilidadeCliente;
import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.models.rentabilidade.PosicaoClienteDto;
import br.com.vinicius.teste.models.rentabilidade.ProdutoRentabilidadeDto;
import br.com.vinicius.teste.strategy.cliente.ClienteStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PortfolioUsecase {

    private final RentabilidadeCliente rentabilidadeCliente;
    private List<ClienteStrategy> clienteStrategyList;

    public PortfolioUsecase(RentabilidadeCliente rentabilidadeCliente, List<ClienteStrategy> clienteStrategyList){
        this.rentabilidadeCliente = rentabilidadeCliente;
        this.clienteStrategyList = clienteStrategyList;
    }

    public PortfolioDto criarPortfolio(Integer idCliente, String segmento){

        PosicaoClienteDto posicaoCliente =
                rentabilidadeCliente.buscaPosicaoCliente(idCliente);

        PortfolioDto portfolioDto = converterPosicaoClienteParaPortfolioDto(posicaoCliente);

        var strategySegmento = clienteStrategyList.stream()
                .filter(strategy -> strategy.getTipoCliente().equals(segmento))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Estratégia não encontrada para o segmento: " + segmento));

        portfolioDto = strategySegmento.processarProdutosPortfolio(portfolioDto.getPortfolioProduto());

        // aplicar outras estrategias. EX: calculo de percentuais

        return portfolioDto;
    }

    //Metodos abaixo sera trocado pelo mapperStruct
    private PortfolioDto converterPosicaoClienteParaPortfolioDto(PosicaoClienteDto posicaoClienteDto) {
        List<PortfolioProdutoDto> portfolioProdutos = posicaoClienteDto.produtos().stream()
                .map(this::converterProdutoRentabilidadeParaPortfolioProdutoDto)
                .collect(Collectors.toList());

        // Calcula o valor total do portfólio
        BigDecimal valorTotal = portfolioProdutos.stream()
                .map(PortfolioProdutoDto::getTotalAlocado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return PortfolioDto.builder()
                .valorTotal(valorTotal)
                .portfolioProduto(portfolioProdutos)
                .dataReferencia(posicaoClienteDto.dataBase())
                .build();
    }

    private PortfolioProdutoDto converterProdutoRentabilidadeParaPortfolioProdutoDto(ProdutoRentabilidadeDto produtoRentabilidade) {

        return PortfolioProdutoDto.builder()
                .codigoProduto(produtoRentabilidade.codigoProduto())
                .nomeProduto(produtoRentabilidade.nomeProduto())
                .taxa(produtoRentabilidade.taxa())
                .quantidade(produtoRentabilidade.quantidade())
                .totalAlocado(BigDecimal.TEN)
                .dataPosicao(produtoRentabilidade.dataPosicao())
                .tipoProduto(produtoRentabilidade.tipoProduto())
                .build();
    }
}
