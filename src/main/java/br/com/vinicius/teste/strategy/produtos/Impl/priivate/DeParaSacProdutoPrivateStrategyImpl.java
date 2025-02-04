package br.com.vinicius.teste.strategy.produtos.Impl.priivate;

import br.com.vinicius.teste.dataprovider.produtos.ProdutoCliente;
import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("strategySacPrivate")
public class DeParaSacProdutoPrivateStrategyImpl extends ProductRuleTemplateMethod {

    private ProdutoCliente produtoCliente;

    public DeParaSacProdutoPrivateStrategyImpl(ProdutoCliente produtoCliente){

        this.produtoCliente = produtoCliente;
    }

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {

        produtos.parallelStream().forEach(produto->{

            log.info("Buscando dados SAC para compor produtos");

            var produtoDto = produtoCliente.buscarProdutoSac(produto.getCodigoProduto());

            produto.setNomeProduto(produtoDto.nomeProduto());

        });

        //aplicar regra de agrupamento

        return produtos;
    }
}
