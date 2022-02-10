package co.edu.escuelaing.arep.sparkapp;

import static spark.Spark.*;

public class Server {
	

        
    	public static void main(String[] args) {
            port(getPort());
            get("/", (req, res) -> {
            return "<!DOCTYPE html>"+
                     "<html>"+
                    "<head>" +
                    "<title> Celcius A Cahrenheit </title>"+
                    "<style>\n"+
                    "input[type=text] {\n"
                    + "width: 100%;\n"
                    + "  padding: 12px 20px;\n"
                    + "  margin: 8px 0;\n"
                    + "  box-sizing: border-box;\n"
                    + "  border: none;\n"
                    + "  background-color: #6E6D70;\n"
                    + "  color: white;"
                    + "}"
                    + ".button {\n"
                    +"display: flex;\n"
            		+ "  flex-direction: column;\n"
            		+ "  align-items: center;\n"
            		+ "  padding: 6px 14px;\n"
            		+ "  font-family: -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif;\n"
            		+ "  border-radius: 6px;\n"
            		+ "  border: none;\n"
            		+ "\n"
            		+ "  background: #6E6D70;\n"
            		+ "  box-shadow: 0px 0.5px 1px rgba(0, 0, 0, 0.1), inset 0px 0.5px 0.5px rgba(255, 255, 255, 0.5), 0px 0px 0px 0.5px rgba(0, 0, 0, 0.12);\n"
            		+ "  color: #DFDEDF;\n"
            		+ "  user-select: none;\n"
            		+ "  -webkit-user-select: none;\n"
            		+ "  touch-action: manipulation;\n"
                    + "}\n"
                    + "\n"
                    + "</style>"+
                    "<body>" +
                    "<div>" +
                    "<h2>Conversion celcius a fahrenheit</h2>" +
                    "</div>"+
                    "<form action=\"/respuestaCelciusFahrenheit\" method=\"get\">" +
                    "<div>" +
                    " <h4 for\"info\"> Celcius a Fahrenheit</h4>" +
                    " <input type=\"text\" required name=\"datos\" id=\"datos\" value=\"\">" +
                    "</div>" +
                    "</br>"+
                    "<button class=\"button button1\">Celcius a Fahrenheit</button>\n"+
                    "</form>"+
                    "<form action=\"/respuestaFahrenheitCelcius\" method=\"get\">" +
                            "<div>" +
                            " <h4 for\"info\"> Farenheit a Celcius</h4>" +
                            " <input type=\"text\" required name=\"datos2\" id=\"datos2\" value=\"\">" +
                            "</div>" +
                            "</br>"+
                            "<button class=\"button button1\">Fahrenheit a Celcius</button>\n"+
                            "</form>"+
                    "</body>";
            });

            get("/respuestaCelciusFahrenheit", (req, res) -> {
            	ServiceAPI calcular = new ServiceAPI();
                String numero = req.queryParams("datos");
                String respuesta = "" ;
                try {
                    
                	respuesta = calcular.celciusAFahrenheit(numero);
                    
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<title> Respuesta </title>"+
                            "</head>"+
                            "<style>\n"
                            + " {\n"
                    		+ "  background: #6E6D70;\n"
                    		+ "  color: white;"
                    		+ "}\n"
                            + ".button {\n"
                            +"display: flex;\n"
                    		+ "  flex-direction: column;\n"
                    		+ "  align-items: center;\n"
                    		+ "  padding: 6px 14px;\n"
                    		+ "  font-family: -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif;\n"
                    		+ "  border-radius: 6px;\n"
                    		+ "  border: none;\n"
                    		+ "\n"
                    		+ "  background: #6E6D70;\n"
                    		+ "  box-shadow: 0px 0.5px 1px rgba(0, 0, 0, 0.1), inset 0px 0.5px 0.5px rgba(255, 255, 255, 0.5), 0px 0px 0px 0.5px rgba(0, 0, 0, 0.12);\n"
                    		+ "  color: #DFDEDF;\n"
                    		+ "  user-select: none;\n"
                    		+ "  -webkit-user-select: none;\n"
                    		+ "  touch-action: manipulation;\n"
                            + "}\n"
                            + "\n"
                            + "</style>"+
                            "<body>" +
                            "<form action=\"/\" method=\"get\">" +
                            " <h4 for\"media\"> El valor que ingresaste al convertirlo de celcius a fahrenheit es: </h4>" +
                            "</br>" +
                            "<h4>" + respuesta + "<p> Grados fahrenheit</p>"+ "</h4>\n" +
                            "</br>" +
                            "<button class=\"button button1\"> Volver </button>" +
                            "</form>" +
                            "</body>";

                }
                
                catch (Exception e) {
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<body>" +
                            "<head>" +
                            "<title> Invalid Transaction</title>"+
                            "</head>"+
                            "<style>\n"
                            + ".button {\n"
                            +"display: flex;\n"
                    		+ "  flex-direction: column;\n"
                    		+ "  align-items: center;\n"
                    		+ "  padding: 6px 14px;\n"
                    		+ "  font-family: -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif;\n"
                    		+ "  border-radius: 6px;\n"
                    		+ "  border: none;\n"
                    		+ "\n"
                    		+ "  background: #6E6D70;\n"
                    		+ "  box-shadow: 0px 0.5px 1px rgba(0, 0, 0, 0.1), inset 0px 0.5px 0.5px rgba(255, 255, 255, 0.5), 0px 0px 0px 0.5px rgba(0, 0, 0, 0.12);\n"
                    		+ "  color: #DFDEDF;\n"
                    		+ "  user-select: none;\n"
                    		+ "  -webkit-user-select: none;\n"
                    		+ "  touch-action: manipulation;\n"
                            + "}\n"
                            + "\n"
                            + "</style>"+
                            "<form action=\"/\" method=\"get\">" +
                            "<h1>Invalid Transaction </h1>"+
                            "<button class=\"button button1\"> Volver </button>" +
                            "</form>" +
                            "" +
                            "" +
                            "" ;
                }

            });
            
            get("/respuestaFahrenheitCelcius", (req, res) -> {
            	ServiceAPI calcular = new ServiceAPI();
                String numero = req.queryParams("datos2");
                String respuesta = "" ;
                try {
                	respuesta = calcular.fahrenheitACelcius(numero);
                    return "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<title> Respuesta </title>"+
                    "</head>"+
                    "<style>\n"
                    + " #texto{\n"
            		+ "  background: #6E6D70;\n"
            		+ "  color: white;"
            		+ "}\n"
                    + ".button {\n"
                    +"display: flex;\n"
            		+ "  flex-direction: column;\n"
            		+ "  align-items: center;\n"
            		+ "  padding: 6px 14px;\n"
            		+ "  font-family: -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif;\n"
            		+ "  border-radius: 6px;\n"
            		+ "  border: none;\n"
            		+ "\n"
            		+ "  background: #6E6D70;\n"
            		+ "  box-shadow: 0px 0.5px 1px rgba(0, 0, 0, 0.1), inset 0px 0.5px 0.5px rgba(255, 255, 255, 0.5), 0px 0px 0px 0.5px rgba(0, 0, 0, 0.12);\n"
            		+ "  color: #DFDEDF;\n"
            		+ "  user-select: none;\n"
            		+ "  -webkit-user-select: none;\n"
            		+ "  touch-action: manipulation;\n"
                    + "}\n"
                    + "\n"
                    + "</style>"+
                    "<body>" +
                    "<form action=\"/\" method=\"get\">" +
                    " <h4 for\"media\"> El valor que ingresaste al convertirlo de fahrenheit a celcius es: </h4>" +
                    "</br>" +
                    "<label>" + respuesta + "<p> Grados Farenheit</p>"+ "</label>\n"+
                    "</br>" +
                    "<button class=\"button button1\"> Volver </button>" +
                    "</form>" +
                    "</body>";
                }
                
                catch (Exception e) {
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<body>" +
                            "<head>" +
                            "<title> Invalid Transaction</title>"+
                            "</head>"+
                            "<style>\n"
                            + ".button {\n"
                            +"display: flex;\n"
                    		+ "  flex-direction: column;\n"
                    		+ "  align-items: center;\n"
                    		+ "  padding: 6px 14px;\n"
                    		+ "  font-family: -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif;\n"
                    		+ "  border-radius: 6px;\n"
                    		+ "  border: none;\n"
                    		+ "\n"
                    		+ "  background: #6E6D70;\n"
                    		+ "  box-shadow: 0px 0.5px 1px rgba(0, 0, 0, 0.1), inset 0px 0.5px 0.5px rgba(255, 255, 255, 0.5), 0px 0px 0px 0.5px rgba(0, 0, 0, 0.12);\n"
                    		+ "  color: #DFDEDF;\n"
                    		+ "  user-select: none;\n"
                    		+ "  -webkit-user-select: none;\n"
                    		+ "  touch-action: manipulation;\n"
                            + "}\n"
                            + "\n"
                            + "</style>"+
                            "<form action=\"/\" method=\"get\">" +
                            "<h1>Invalid Transaction </h1>"+
                            "<button class=\"button button1\"> Volver </button>" +
                            "</form>" +
                            "" +
                            "" +
                            "" ;
                }

            });

        }
    
    static int getPort(){
        if(System.getenv("PORT")!= null){
            return  Integer.parseInt(System.getenv("PORT"));
        }
        return 8090;
    }

}
