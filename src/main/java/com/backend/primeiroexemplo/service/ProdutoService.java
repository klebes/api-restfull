package com.backend.primeiroexemplo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.primeiroexemplo.model.Produto;
import com.backend.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ArrayList<Produto> obterTodosProdutos() {
        return produtoRepository.obterTodosProdutos();
    }

    public Optional<Produto> obterProdutoPorId(Long id){
        return produtoRepository.obterProdutoPorId(id);
    }

    public Produto adicionaProduto(Produto produto){
        return produtoRepository.adicionarProduto(produto);

    }

    public void deletarProtudo(long id){
        produtoRepository.deletarProtudo(null);

    }

    public Produto atuaProduto(long id, Produto produto){
        produto.setIdProduto(id);
        return produtoRepository.atualizarProduto(produto);
    }
}
