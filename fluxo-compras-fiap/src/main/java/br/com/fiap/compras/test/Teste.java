package br.com.fiap.compras.test;

import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("fluxo-compras-fiap").createEntityManager();
	}
	
}