package br.com.igorgsousa.helpers;

public class TemperatureConverterHelper {
	
	
	
	public static double convetCelsiusToFahrenheit(double temperature) {
		
		return (temperature * (9.0/5.0))+32;
	}

	public static double convetCelsiusToKelvin(double temperature) {
		
		return temperature + 273.15;
	}
	
}
