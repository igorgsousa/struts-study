package br.com.igorgsousa.model.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm {

	private static final long serialVersionUID = -4120544347944843464L;
	private String hello = null;

	public HelloWorldForm() {
		super();
		hello = "Hello World";
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
}