package br.com.felintro.loja.testes;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import br.com.felintro.loja.dao.CategoriaDAO;
import br.com.felintro.loja.dao.ProdutoDAO;
import br.com.felintro.loja.model.Categoria;
import br.com.felintro.loja.model.Produto;
import br.com.felintro.loja.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProdutos();
        Long id = 1L;

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        Produto produto = produtoDAO.buscarPorId(1L);
        System.out.println(produto);
        produtoDAO.buscarTodos().forEach(System.out::println);

        System.out.println("===================================");

        System.out.println(produtoDAO.buscarPorNome("Xiaomi Pocophone F1").toString());
    }

    private static void cadastrarProdutos() {
        Categoria categoria = new Categoria();
        categoria.setNome("Informatica");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Eletronicos");

        Produto produto = new Produto();
        produto.setCategoria(categoria);
        produto.setPreco(new BigDecimal("2500"));
        produto.setNome("Placa de video GALAX RTX 2060");
        produto.setDescricao("12GB VRAM GDDR6");

        Produto produto2 = new Produto();
        produto2.setCategoria(categoria2);
        produto2.setPreco(new BigDecimal("1400"));
        produto2.setNome("Xiaomi Pocophone F1");
        produto2.setDescricao("Preto 6GB RAM + 128GB Armazenamento");

        Produto produto3 = new Produto();
        produto3.setCategoria(categoria2);
        produto3.setPreco(new BigDecimal("10000"));
        produto3.setNome("Iphone 14 Pro Max");
        produto3.setDescricao("Branco 6GB RAM + 256GB Armazenamento");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        categoriaDAO.cadastrar(categoria);
        categoriaDAO.cadastrar(categoria2);
        produtoDAO.cadastrar(produto);
        produtoDAO.cadastrar(produto2);
        produtoDAO.cadastrar(produto3);

        entityManager.getTransaction().commit();
    }

}