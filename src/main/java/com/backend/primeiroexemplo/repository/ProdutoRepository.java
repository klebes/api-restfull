package com.backend.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.backend.primeiroexemplo.model.Produto;

public class ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    private Long ultimoIdProduto = 0L;

    /**
     * metodo para retornar uma lista de produtos
     * @return lista de produtos
     */
    public ArrayList<Produto> obterTodosProdutos(){
        return produtos;
    }

    public Optional obterProdutoPorId(Long id){
        return produtos.stream().filter(produtos ->produtos.getIdProduto() == id).findFirst();
    }

    public Produto adicionarProduto(Produto produto){
        ultimoIdProduto++;
        produto.setIdProduto(ultimoIdProduto);
        produtos.add(produto);
        return produto;

    }

    public void deletarProtudo(Long id){
        produtos.removeIf(produto -> produto.getIdProduto() == id);

    }

    public Produto atualizarProduto(Produto produto){
        Optional<Produto> produtoEncontrado = obterProdutoPorId(produto.getIdProduto());

        if(produtoEncontrado.isEmpty()){
            throw new Exception("Produto não econtrado! ");

        }
        deletarProtudo(produto.getIdProduto());

        produtos.add(produto);
        
        return produto;

    }
}
