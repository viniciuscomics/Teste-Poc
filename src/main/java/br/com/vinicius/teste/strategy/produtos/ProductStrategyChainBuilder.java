package br.com.vinicius.teste.strategy.produtos;

import br.com.vinicius.teste.strategy.produtos.Impl.FYProdutoStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.LSProdutoStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.MergeApiProdutosStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.NSProdutoStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.priivate.DeParaSacProdutoPrivateStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.priivate.ValidadorProdutosPrivateStrategyImpl;
import br.com.vinicius.teste.strategy.produtos.Impl.varejo.ValidadorProdutosVarejoStrategyImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductStrategyChainBuilder {

    private final List<ProdutoStrategy> implStrategyList;

    public ProductStrategyChainBuilder(List<ProdutoStrategy> strategyList){
        this.implStrategyList = strategyList;
    }

    public ProdutoStrategy buildChainPortfolioVarejo() {

        return builderChainOfResponsability(ValidadorProdutosVarejoStrategyImpl.class,
                FYProdutoStrategyImpl.class,
                LSProdutoStrategyImpl.class,
                MergeApiProdutosStrategyImpl.class,
                NSProdutoStrategyImpl.class);
    }

    public ProdutoStrategy buildChainPortfolioPrivate() {

        return builderChainOfResponsability(ValidadorProdutosPrivateStrategyImpl.class,
                DeParaSacProdutoPrivateStrategyImpl.class,
                FYProdutoStrategyImpl.class,
                LSProdutoStrategyImpl.class,
                MergeApiProdutosStrategyImpl.class,
                NSProdutoStrategyImpl.class);
    }


    @SafeVarargs
    private ProdutoStrategy builderChainOfResponsability(Class<? extends ProdutoStrategy>... produtoStrategiesClassImpl){

        ProdutoStrategy chainOfResponsabilityStrategy = null;
        ProdutoStrategy current = null;

        for(var produtoStrategyClass : produtoStrategiesClassImpl){

            for(ProdutoStrategy strategy: implStrategyList){

                if(produtoStrategyClass.isInstance(strategy)){

                    if(chainOfResponsabilityStrategy == null){
                        chainOfResponsabilityStrategy = strategy;
                    }
                    else{
                        current.setNextProductStrategy(strategy);
                    }

                    current = strategy;
                    break;
                }
            }

            if(current == null)
                throw new RuntimeException("Strategy não encontrada.");

        }

        return chainOfResponsabilityStrategy;
    }
}
