package br.com.vinicius.teste.strategy.produtos.Impl.priivate;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("validadorProdutosPrivate")
public class ValidadorProdutosPrivateStrategyImpl extends ProductRuleTemplateMethod {

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {
        // Lógica de validação específica para Private
        return produtos;
    }
}