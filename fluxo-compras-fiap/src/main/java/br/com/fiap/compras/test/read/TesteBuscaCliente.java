package br.com.fiap.compras.test.read;

import br.com.fiap.compras.domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteBuscaCliente {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, 1L);

        System.out.println(cliente.getIdCliente() +" " + cliente.getNomeCliente());

        entityManager.close();
        factory.close();
    }
}