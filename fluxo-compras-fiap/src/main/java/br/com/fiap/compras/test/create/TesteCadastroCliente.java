package br.com.fiap.compras.test.create;

import br.com.fiap.compras.domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCadastroCliente {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setNomeCliente("Vitória");
        cliente.setTelefone(1178594131);
        cliente.setNumeroCartao(22556644);
        cliente.setLimiteCartao(10000.00);

        cliente.setNomeCliente("Tomas");
        cliente.setTelefone(1185976146);
        cliente.setNumeroCartao(11223344);
        cliente.setLimiteCartao(90000.00);

        try {
            entityManager.persist(cliente);
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        entityManager.close();
        factory.close();
    }
}
