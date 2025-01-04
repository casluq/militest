package com.mili.militest.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mili.militest.dto.ProdutoDTO;
import com.mili.militest.entities.Produto;
import com.mili.militest.enums.TipoProdutoEnum;
import com.mili.militest.repositories.ProdutoRepository;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produtos")
    public List<ProdutoDTO> listAll() {
        var produtos = this.repository.findAll();

        return produtos
            .stream()
            .map((produto) -> {
                var produtoDTO = new ProdutoDTO();

                produtoDTO.setId(produto.getId());
                produtoDTO.setPreco(produto.getPreco());
                produtoDTO.setPeso(produto.getPeso());
                produtoDTO.setTamanho(produto.getTamanho());
                produtoDTO.setTipo(produto.getTipo());
                produtoDTO.setUnidadePeso(produto.getUnidadePeso());
                produtoDTO.setUnidadeTamanho(produto.getUnidadeTamanho());

                if (produto.getTipo().equals(TipoProdutoEnum.FISICO)) {
                    produtoDTO.setValorFrete(produto.calcularFrete(10));
                    produtoDTO.setValorTotalComFrete(produtoDTO.getPreco() + produtoDTO.getValorFrete());
                }

                produtoDTO.setEmPromocao(produto.getPromocao() != null);

                if (produtoDTO.isEmPromocao()) {
                    var valorTotal = produtoDTO.getPreco() - produtoDTO.getPreco() * (produto.getPromocao().getPorcentagemDesconto() / 100) + produtoDTO.getValorFrete();
                    produtoDTO.setValorTotalComDesconto(valorTotal);
                } else {
                    produtoDTO.setValorTotalComDesconto(produtoDTO.getPreco());
                }

                return produtoDTO;
            }).collect(Collectors.toList());
    }

    @PostMapping("/produto")
    public Produto novo(@RequestBody Produto produto) {

        if (produto.getPromocao() != null) {
            produto.getPromocao().setProduto(produto);
        }

        return this.repository.save(produto);
    }

    @PutMapping("/produto/{id}")
    public Produto atualizar(@RequestBody Produto produtoAtualizado, @PathVariable Long id) {
        return this.repository
            .findById(id)
            .map(produto -> {
                produto.setPeso(produtoAtualizado.getPeso());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setTamanho(produtoAtualizado.getTamanho());
                produto.setTipo(produtoAtualizado.getTipo());
                
                this.repository.save(produto);

                return produto;
            })
            .orElseGet(() -> {
                if (produtoAtualizado.getPromocao() != null) {
                    produtoAtualizado.getPromocao().setProduto(produtoAtualizado);
                }
                return this.repository.save(produtoAtualizado);
            });
    }

    @DeleteMapping("/produto/{id}")
    public void deletar(@PathVariable Long id) {
        if (this.repository.findById(id).isPresent()) {
            this.repository.deleteById(id);
        }
    }

    @GetMapping("/produto/produto-mais-caro")
    public Produto buscarProdutoMaisCaro() {
        return this.repository.buscarProdutoMaisCaro();
    }

    @GetMapping("/produto/media-preco-sem-desconto")
    public Double mediaDosProdutosSemDesconto() {
        return this.repository.mediaDosProdutosSemDesconto();
    }
}