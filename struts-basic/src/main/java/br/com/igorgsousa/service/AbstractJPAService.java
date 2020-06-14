package br.com.igorgsousa.service;

import javax.persistence.EntityManager;

public abstract class AbstractJPAService {
	
	protected EntityManager entityManager;

	public AbstractJPAService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
