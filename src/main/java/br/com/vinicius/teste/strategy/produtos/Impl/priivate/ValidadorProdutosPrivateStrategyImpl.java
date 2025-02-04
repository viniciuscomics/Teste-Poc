package br.com.vinicius.teste.strategy.produtos.Impl.priivate;

import br.com.vinicius.teste.models.dto.PortfolioProdutoDto;
import br.com.vinicius.teste.strategy.produtos.ProductRuleTemplateMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ValidadorProdutosPrivateStrategyImpl extends ProductRuleTemplateMethod {

    @Override
    protected List<PortfolioProdutoDto> aplicarEstrategia(List<PortfolioProdutoDto> produtos) {
        // Lógica de validação específica para Private
        log.info("Aplicando regras de produtos valido cliente Private.");
        return produtos;
    }
}