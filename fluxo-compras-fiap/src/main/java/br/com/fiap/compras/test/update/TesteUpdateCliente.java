package br.com.fiap.compras.test.update;

import br.com.fiap.compras.domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteUpdateCliente {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Cliente cliente = new Cliente(1L, "Thiago", 3.000, 12345, 67890);

        entityManager.merge(cliente);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
}