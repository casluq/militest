package com.mili.militest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mili.militest.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    @Query(value = "SELECT p FROM Produto p WHERE p.preco = (SELECT MAX(p2.preco) FROM Produto p2)")
    Produto buscarProdutoMaisCaro();

    @Query(value = "SELECT AVG(p.preco) FROM Produto p")
    Double mediaDosProdutosSemDesconto();
}
