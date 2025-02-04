package br.com.vinicius.teste;

import br.com.vinicius.teste.usecase.PortfolioUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TesteApplication implements CommandLineRunner {

	@Autowired
	private PortfolioUsecase portfolioUsecase;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var portfolio = portfolioUsecase.criarPortfolio(123, "VAREJO");

		log.info("Portfolio: {}", portfolio);

	}
}
