package br.com.vinicius.teste.strategy.produtos.Impl;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class LSProdutoStrategyImpl extends ProductRuleTemplateMethod {

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {

        log.info("Aplicando regras para produtos do tipo LS.");
        produtos.parallelStream()
                .filter(produto-> "LS".equals(produto.getTipoProduto()))
                .forEach(produto->{

                    //aplicar regra.
                });

        return produtos;
    }
}
