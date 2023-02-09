package br.com.felintro.loja.testes;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Xiaomi Pocophone F1");
        produto.setDescricao("6GB RAM + 128GB armazenamento");
        produto.setPreco(new BigDecimal("1250"));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("curso_alura");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();



    }


}
