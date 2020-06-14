package br.com.igorgsousa.components;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import br.com.igorgsousa.enums.TemperatureScale;
import br.com.igorgsousa.helpers.TemperatureConverterHelper;

public class TemperatureConverter extends BodyTagSupport{
	
	private static final long serialVersionUID = 7584602087065461023L;
	
	private String to;

	public TemperatureConverter() {
		this.to = TemperatureScale.FAHRENHEIT.getSymbol();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	@Override
	 public int doAfterBody(){
		 try{
			 BodyContent bc = getBodyContent();
			 JspWriter out = bc.getEnclosingWriter();
			 out.write("<div>");
			 out.write(this.getResultText((bc.getString())));
			 out.write("</div>");
		 }catch(Exception ignore){}

		 return EVAL_PAGE;
	 }

	private String getResultText(String valueToConvert) {
		
		TemperatureScale scale = TemperatureScale.from(this.to);
		
		String ret = "Tipo para conversao invalido";
		
		if(scale!= null) {
			if(scale.equals(TemperatureScale.FAHRENHEIT)) {
				ret = String.valueOf(TemperatureConverterHelper.convetCelsiusToFahrenheit(new Double(valueToConvert)));
			}else if(scale.equals(TemperatureScale.KELVIN)) {
				ret = String.valueOf(TemperatureConverterHelper.convetCelsiusToKelvin(new Double(valueToConvert)));
			}else {
				ret = valueToConvert;
			}
		}
		
		return ret;
	}
}
