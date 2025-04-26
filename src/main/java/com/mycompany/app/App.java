package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class App {
    private static final String MESSAGE = "Hello from Spark Server!";

    public App() {}

    public static void main(String[] args) {
        port(8082);

        get("/", (req, res) -> MESSAGE);

        post("/github-webhook/", (req, res) -> {
            System.out.println("Webhook received!");
            System.out.println("Payload: " + req.body());
            res.status(200);
            return "Webhook received!";
        });
    }

    // ADD THIS BACK
    public String getMessage() {
        return MESSAGE;
    }
}
