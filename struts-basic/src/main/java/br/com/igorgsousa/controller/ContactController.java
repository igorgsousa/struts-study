package br.com.igorgsousa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ContactController extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionErrors errors = form.validate(mapping, request);
		ActionForward ret = mapping.findForward("contact");
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			if(errors.isEmpty()) {
				ret = mapping.findForward("success");
			}
		}
		
		return ret;
		
	}

}