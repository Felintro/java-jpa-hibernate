package br.com.felintro.loja.dao;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Categoria;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class CategoriaDAO {

    private EntityManager entityManager;

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

}