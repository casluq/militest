package com.mili.militest.dto;

import com.mili.militest.enums.TipoProdutoEnum;

public class ProdutoDTO {

    private int id;
    private Double preco;
    private Double peso;
    private String unidadePeso;
    private Integer tamanho;
    private String unidadeTamanho;
    private boolean emPromocao;
    private double valorFrete;
    private double valorTotalComFrete;
    private double valorTotalComDesconto;
   
    private TipoProdutoEnum tipo;

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

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public TipoProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoEnum tipo) {
        this.tipo = tipo;
    }
    
    public double getValorTotalComFrete() {
        return valorTotalComFrete;
    }

    public void setValorTotalComFrete(double valorTotalComFrete) {
        this.valorTotalComFrete = valorTotalComFrete;
    }

    public double getValorTotalComDesconto() {
        return valorTotalComDesconto;
    }

    public void setValorTotalComDesconto(double valorTotalComDesconto) {
        this.valorTotalComDesconto = valorTotalComDesconto;
    }
}
