package br.com.fiap.compras.test.read;

import br.com.fiap.compras.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteBuscaProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Produto produto = entityManager.find(Produto.class, 1L);

        System.out.println(produto.getIdProduto() + " " + produto.getNomeProduto());

        entityManager.close();
        factory.close();
    }
}