package br.com.vinicius.teste.strategy.produtos.Impl.varejo;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("validadorProdutoVarejo")
public class ValidadorProdutosVarejoStrategyImpl extends ProductRuleTemplateMethod {

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {
        // Lógica de validação específica para varejo
        return produtos;
    }
}
