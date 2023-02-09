package br.com.felintro.loja.utils;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("curso_alura");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

}
