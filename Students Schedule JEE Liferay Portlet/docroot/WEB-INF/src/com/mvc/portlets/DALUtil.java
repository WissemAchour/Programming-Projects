package com.mvc.portlets;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DALUtil {
	private DALUtil() {
	}
	
	private static EntityManager em;
	public static EntityManager getEntityManager(){
		if(em==null){
			em=Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
		}
		return em;
	}
}
