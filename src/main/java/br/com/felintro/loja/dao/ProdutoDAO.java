package br.com.felintro.loja.dao;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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
        String queryJPQL = "SELECT p FROM Produto p";
        return this.entityManager
            .createQuery(queryJPQL, Produto.class)
            .getResultList();
    }

    public List<Produto> buscarPorNome(String nomeProduto) {
        String queryJPQL = "SELECT p FROM Produto p WHERE p.nome = :nomeProduto";
        return this.entityManager
            .createQuery(queryJPQL, Produto.class)
            .setParameter("nomeProduto", nomeProduto)
            .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nomeCategoria) {
        String queryJPQL = "SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCategoria";
        return this.entityManager
            .createQuery(queryJPQL, Produto.class)
            .setParameter("nomeCategoria", nomeCategoria)
            .getResultList();
    }

    public BigDecimal retornaPrecoPorNomeProduto(String nomeProduto) {
        String queryJPQL = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return this.entityManager
            .createQuery(queryJPQL, BigDecimal.class)
            .setParameter("nome", nomeProduto)
            .getSingleResult();

    }

    public BigDecimal retornaPrecoPorIdProduto(Long idProduto) {
        String queryJPQL = "SELECT p.preco FROM Produto p WHERE p.id = :idProduto";
        return this.entityManager
            .createQuery(queryJPQL, BigDecimal.class)
            .setParameter("idProduto", idProduto)
            .getSingleResult();
    }

}