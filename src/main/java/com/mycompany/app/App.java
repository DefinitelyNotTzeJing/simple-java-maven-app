package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class App {
    private static final String MESSAGE = "Hello from Spark Web Server! Welcome to the world of Java!";

    public static void main(String[] args) {
        port(8082);

        get("/", (req, res) -> MESSAGE);

        // 🛠 Add this to handle GitHub webhook POSTs
        post("/github-webhook/", (req, res) -> {
            System.out.println("Webhook received!");
            System.out.println("Payload: " + req.body());
            res.status(200); // OK
            return "Webhook received!";
        });
    }
}
