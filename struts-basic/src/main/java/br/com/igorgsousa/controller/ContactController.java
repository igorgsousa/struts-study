package br.com.igorgsousa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.igorgsousa.config.plugins.HibernatePlugin;
import br.com.igorgsousa.model.entity.Contact;
import br.com.igorgsousa.model.form.ContactForm;
import br.com.igorgsousa.service.ContactService;

public class ContactController extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionErrors errors = form.validate(mapping, request);
		ActionForward ret = mapping.findForward("contact");
		
		ContactForm contactForm = (ContactForm) form;
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			if(errors.isEmpty()) {
				EntityManager entityManager = (EntityManager) this.servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME);
				ContactService contactService = new ContactService(entityManager);
				try {
					entityManager.getTransaction().begin();
					
					List<Contact> contacts = contactService.findByName(contactForm.getContact().getName());
					
					if(contacts != null && contacts.size() > 0) {
						 errors.add("contact.name", new ActionMessage("form.validate.contact.name.taken"));		
						 saveErrors(request, errors);
						 return mapping.getInputForward();
					}
					
					entityManager.persist(contactForm.getContact());
					
					entityManager.getTransaction().commit();
					ret = mapping.findForward("success");
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		return ret;
		
	}

}