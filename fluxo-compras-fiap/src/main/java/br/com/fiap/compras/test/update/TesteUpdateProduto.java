package br.com.fiap.compras.test.update;

import br.com.fiap.compras.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteUpdateProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Produto produto = new Produto(1L, "Notebook", 3.000, 12345);

        entityManager.merge(produto);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
}