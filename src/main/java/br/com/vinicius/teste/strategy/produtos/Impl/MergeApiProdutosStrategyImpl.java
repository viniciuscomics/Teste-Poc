package br.com.vinicius.teste.strategy.produtos.Impl;

import br.com.vinicius.teste.dataprovider.produtos.ProdutoCliente;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("strategyMergeAPIProduto")
public class MergeApiProdutosStrategyImpl extends ProductRuleTemplateMethod {

    private ProdutoCliente produtoCliente;

    public MergeApiProdutosStrategyImpl(ProdutoCliente produtoCliente){
        this.produtoCliente = produtoCliente;
    }

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {

        produtos.parallelStream().forEach(produto->{

            log.info("Buscando dados para compor produtos");

            var produtoDto = produtoCliente.buscarProdutoFake(produto.getCodigoProduto());

            produto.setClasseAtivo(produtoDto.classeAtivo());
            produto.setIdClasseAtivo(produtoDto.idClasse());
            //outros atributos relevantes...

        });

        return produtos;
    }
}
