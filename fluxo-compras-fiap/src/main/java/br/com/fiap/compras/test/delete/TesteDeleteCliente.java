package br.com.fiap.compras.test.delete;

import br.com.fiap.compras.domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDeleteCliente {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, 1L);
        entityManager.remove(cliente);

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