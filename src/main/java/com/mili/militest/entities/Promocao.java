package com.mili.militest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Promocao {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "porcentagem_desconto")
    private double porcentagemDesconto;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Promocao(){}
    
    public Promocao(double porcentagemDesconto){
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
