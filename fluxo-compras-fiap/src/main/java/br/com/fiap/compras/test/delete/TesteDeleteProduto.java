package br.com.fiap.compras.test.delete;

import br.com.fiap.compras.domain.Cliente;
import br.com.fiap.compras.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDeleteProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Produto produto = entityManager.find(Produto.class, 1L);
        entityManager.remove(produto);

        try {
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }
}