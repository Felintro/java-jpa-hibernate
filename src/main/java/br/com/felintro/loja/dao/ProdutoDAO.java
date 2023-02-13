package br.com.felintro.loja.dao;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class ProdutoDAO {

    private EntityManager entityManager;

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.entityManager.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.entityManager.merge(produto);
        this.entityManager.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.entityManager
            .createQuery(jpql, Produto.class)
            .getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return this.entityManager
            .createQuery(jpql, Produto.class)
            .setParameter("nome", nome)
            .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nomeCategoria) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCategoria";
        return this.entityManager
            .createQuery(jpql, Produto.class)
            .setParameter("nomeCategoria", nomeCategoria)
            .getResultList();
    }



}