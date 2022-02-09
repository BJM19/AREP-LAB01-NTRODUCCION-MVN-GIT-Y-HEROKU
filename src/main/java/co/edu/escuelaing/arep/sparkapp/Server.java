package co.edu.escuelaing.sparksimpleexample;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {
        port(Integer.valueOf(System.getenv("PORT")));

        get("/hello", (req, res) -> "Hello World");

        get("/hello/:nombre", (req, res) -> "Hello World" + req.params(":nombre"));
    }

}
