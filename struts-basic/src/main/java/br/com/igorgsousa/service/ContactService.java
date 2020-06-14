package br.com.igorgsousa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.igorgsousa.model.entity.Contact;

public class ContactService extends AbstractJPAService {

	public ContactService(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Contact save(Contact contact) throws Exception {
		
		if(contact.getId()==null) {
			this.entityManager.persist(contact);
		}else {
			this.entityManager.merge(contact);
		}
		
		
		return contact;
	}

	public List<Contact> findByName(String name) throws Exception {
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Contact> criteria = builder.createQuery(Contact.class);
		
		Root<Contact> contactRoot = criteria.from(Contact.class);
		
		criteria.select(contactRoot);
		criteria.where(builder.equal(contactRoot.get("name"),name));
		
		return this.entityManager.createQuery(criteria).getResultList();
	}
}
