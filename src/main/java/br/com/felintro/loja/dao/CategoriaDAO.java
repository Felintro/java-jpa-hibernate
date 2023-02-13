package br.com.felintro.loja.dao;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Categoria;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class CategoriaDAO {

    private EntityManager entityManager;

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria buscarPorId(Long idCategoria) {
        String queryJPQL = "SELECT c FROM Categoria c WHERE c.id = :idCategoria";
        return this.entityManager
            .createQuery(queryJPQL, Categoria.class)
            .setParameter("idCategoria", idCategoria)
            .getSingleResult();
    }

    /* Nesta aplicação, cada categoria possui um nome único! */
    public Categoria buscarPorNome(String nomeCategoria) {
        String queryJPQL = "SELECT c FROM Categoria c WHERE c.nome = :nomeCategoria";
        return this.entityManager
            .createQuery(queryJPQL, Categoria.class)
            .setParameter("nomeCategoria", nomeCategoria)
            .getSingleResult();
    }

    public List<Categoria> buscarTodos() {
        String queryJPQL = "SELECT c FROM Categoria c";
        return this.entityManager
            .createQuery(queryJPQL, Categoria.class)
            .getResultList();
    }

}