package br.edu.ifpr.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProducer {

private static EntityManagerFactory fabrica;
	
	public static EntityManager getConexao(){
		if(fabrica == null)
			fabrica = Persistence.createEntityManagerFactory
			("jokenpo");
		return fabrica.createEntityManager();
	}
}
