package br.com.igorgsousa.enums;

public enum TemperatureScale {
	
	CELSIUS("C", "CELSIUS"),
	FAHRENHEIT("F", "FAHRENHEIT"),
	KELVIN("K", "KELVIN");

	private final String symbol;
	private final String name;

	private TemperatureScale(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}
	
	
	public static TemperatureScale from(String scale) {
		
		TemperatureScale ret = null;
		for(TemperatureScale temperatureScale : TemperatureScale.values()) {
			if(temperatureScale.name.equalsIgnoreCase(scale) || temperatureScale.symbol.equalsIgnoreCase(scale)) {
				ret  = temperatureScale;
				break;
			}
		}
		return ret;
	}
}
