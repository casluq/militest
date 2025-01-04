package com.mili.militest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mili.militest.entities.Produto;
import com.mili.militest.entities.Promocao;
import com.mili.militest.enums.TipoProdutoEnum;
import com.mili.militest.repositories.ProdutoRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ProdutoRepository repository) {

    var promocao = new Promocao(10.0);
    var promocao2 = new Promocao(10.0);
    var promocao3 = new Promocao(10.0);
    var promocao4 = new Promocao(10.0);

    var produto = new Produto(17.0, 0.732, "KG", 0 , "", TipoProdutoEnum.FISICO, promocao);
    promocao.setProduto(produto);

    var produto2 = new Produto(52.0, 3.0, "KG", 0 , "", TipoProdutoEnum.FISICO, promocao2);
    promocao2.setProduto(produto2);

    var produto3 = new Produto(21.0, 0.487, "KG", 0 , "", TipoProdutoEnum.FISICO, null);

    var produto4 = new Produto(34.0, 0.0, "", 20 , "MB", TipoProdutoEnum.DIGITAL, promocao3);
    promocao3.setProduto(produto4);

    var produto5 = new Produto(58.0, 0.0, "", 47 , "MB", TipoProdutoEnum.DIGITAL, promocao4);
    promocao4.setProduto(produto5);

    var produto6 = new Produto(27.0, 0.0, "", 72 , "MB", TipoProdutoEnum.DIGITAL, null);

    return args -> {
      log.info("Preloading " + repository.save(produto));
      log.info("Preloading " + repository.save(produto2));
      log.info("Preloading " + repository.save(produto3));
      log.info("Preloading " + repository.save(produto4));
      log.info("Preloading " + repository.save(produto5));
      log.info("Preloading " + repository.save(produto6));
    };
  }
}