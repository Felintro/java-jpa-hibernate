package br.com.felintro.loja.dao;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class ProdutoDAO {

    private EntityManager entityManager;

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }

}