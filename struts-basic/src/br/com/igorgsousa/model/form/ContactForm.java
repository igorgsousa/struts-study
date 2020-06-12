package br.com.igorgsousa.model.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.igorgsousa.model.entity.Contact;

public class ContactForm extends ActionForm {

	private static final long serialVersionUID = -600033564873824653L;
	private Contact contact;

	public ContactForm() {
		super();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.contact = new Contact();
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		if(request.getMethod().contentEquals("POST")) {
			if(this.getContact().getName() == null || this.getContact().getName().isEmpty()) {
				errors.add("contact.name", new ActionMessage("form.validate.contact.name.required"));
			}

			if(this.getContact().getDesignation() == null || this.getContact().getDesignation().isEmpty()) {
				errors.add("contact.name", new ActionMessage("form.validate.contact.name.required"));
			}
		}
		
		return errors;
	}
}