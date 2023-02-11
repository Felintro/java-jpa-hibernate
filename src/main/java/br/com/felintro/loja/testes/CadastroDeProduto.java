package br.com.felintro.loja.testes;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.dao.ProdutoDAO;
import br.com.felintro.loja.model.Produto;
import br.com.felintro.loja.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Xiaomi Pocophone F1");
        produto.setDescricao("6GB RAM + 128GB armazenamento");
        produto.setPreco(new BigDecimal("1250"));

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        entityManager.getTransaction().begin();
        produtoDAO.cadastrar(produto);
        entityManager.getTransaction().commit();
        entityManager.close();


    }


}
