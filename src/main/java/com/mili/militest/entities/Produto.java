package com.mili.militest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mili.militest.enums.TipoProdutoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private int id;

    private Double preco;
    private Double peso;
    private String unidadePeso;
    private Integer tamanho;
    private String unidadeTamanho;

    @Enumerated(EnumType.STRING)
    private TipoProdutoEnum tipo;

    // @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.LAZY)
    private Promocao promocao;

    public Produto() {}


    public Produto(
        Double preco,
        Double peso,
        String unidadePeso,
        Integer tamanho,
        String unidadeTamanho,
        TipoProdutoEnum tipo,
        Promocao promocao) {
            this.preco = preco;
            this.peso = peso;
            this.unidadePeso = unidadePeso;
            this.tamanho = tamanho;
            this.unidadeTamanho = unidadeTamanho;
            this.tipo = tipo;

            if (promocao != null) {
                promocao.setProduto(this);
            }

            this.promocao = promocao;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getUnidadePeso() {
        return unidadePeso;
    }

    public void setUnidadePeso(String unidadePeso) {
        this.unidadePeso = unidadePeso;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getUnidadeTamanho() {
        return unidadeTamanho;
    }

    public void setUnidadeTamanho(String unidadeTamanho) {
        this.unidadeTamanho = unidadeTamanho;
    }

    public TipoProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoEnum tipo) {
        this.tipo = tipo;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Double calcularFrete(double valorPorKilo) {
        return peso * valorPorKilo;
    }
}
