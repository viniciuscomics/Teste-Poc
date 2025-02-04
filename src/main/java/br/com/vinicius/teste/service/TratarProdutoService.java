package br.com.vinicius.teste.service;

import br.com.vinicius.teste.dataprovider.fundoesxclusivo.FundoExclusivoCliente;
import br.com.vinicius.teste.dataprovider.produtos.ProdutoCliente;
import br.com.vinicius.teste.models.dto.PortfolioDto;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.models.rentabilidade.PosicaoClienteDto;
import br.com.vinicius.teste.models.rentabilidade.ProdutoRentabilidadeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TratarProdutoService {

    private final FundoExclusivoCliente fundoExclusivoCliente;
    private final ProdutoCliente produtoCliente;

    public TratarProdutoService(FundoExclusivoCliente fundoExclusivoCliente, ProdutoCliente produtoCliente){
        this.fundoExclusivoCliente = fundoExclusivoCliente;
        this.produtoCliente = produtoCliente;
    }

    public void tratarProdutos(PosicaoClienteDto posicaoClienteDto){

        List<PortfolioProdutoDto> produtos = converterProdutos(posicaoClienteDto.produtos());

        var produtosFy =
                produtos.stream().filter(
                        produto -> produto.getTipoProduto().equals("FY")).toList();

        //Pensar em como chamar api de produtos e fundos exclusivos

        //Aplicar regras nos produtos.

    }

    private List<PortfolioProdutoDto> converterProdutos(List<ProdutoRentabilidadeDto> produtosRentabilidade) {
        return produtosRentabilidade.stream()
                .map(produto -> converterProduto(produto))
                .collect(Collectors.toList());
    }

    private PortfolioProdutoDto converterProduto(ProdutoRentabilidadeDto produtoRentabilidade) {
       /* return new PortfolioProdutoDto(
                null, // id (assumindo que é gerado posteriormente)
                produtoRentabilidade.codigoProduto(),
                produtoRentabilidade.nomeProduto(),
                null, // risco (não está presente no ProdutoRentabilidadeDto)
                null,  // totalAlocado (não está presente no ProdutoRentabilidadeDto)
                produtoRentabilidade.quantidade(),
                produtoRentabilidade.taxa(),
                produtoRentabilidade.dataPosicao(),
                produtoRentabilidade.tipoProduto(),
                null, // classeAtivo (não está presente no ProdutoRentabilidadeDto)
                null, // veiculo (não está presente no ProdutoRentabilidadeDto)
                false, // isUpdate (assumindo que é falso por padrão)
                null // Passando o portfolioFundoExclusivo
        );*/
        return PortfolioProdutoDto.builder()
                .codigoProduto(produtoRentabilidade.codigoProduto())
                .nomeProduto(produtoRentabilidade.nomeProduto())
                .quantidade(produtoRentabilidade.quantidade())
                .taxa(produtoRentabilidade.taxa())
                .dataPosicao(produtoRentabilidade.dataPosicao())
                .tipoProduto(produtoRentabilidade.tipoProduto())
                .isUpdate(false) // Valor padrão
                .build();
    }

}
