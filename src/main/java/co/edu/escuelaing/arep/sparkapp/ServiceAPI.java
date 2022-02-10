package co.edu.escuelaing.arep.sparkapp;


public class ServiceAPI {
	public String celciusAFahrenheit(String value) {
		double respuesta;
		double convertido=Double.parseDouble(value);
		respuesta=(convertido*1.8) + 32;
		return respuesta+"";
	}

	public String fahrenheitACelcius(String value) {
		double respuesta;
		double convertido=Double.parseDouble(value);
		respuesta=((convertido - 32)*5)/9;
		System.out.println(respuesta);
		return respuesta+"";
	}

}