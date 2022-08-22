package br.com.fiap.compras.test.create;

import br.com.fiap.compras.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCadastroProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fluxo-compras-fiap");
        EntityManager entityManager = factory.createEntityManager();

        Produto produto = new Produto();
        produto.setNomeProduto("Celular");
        produto.setQuantidadeDisponivel(16);
        produto.setDescricaoPeso(12.0);

        try {
            entityManager.persist(produto);
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
