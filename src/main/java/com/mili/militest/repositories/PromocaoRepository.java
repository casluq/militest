package com.mili.militest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mili.militest.entities.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long>{
    
}
