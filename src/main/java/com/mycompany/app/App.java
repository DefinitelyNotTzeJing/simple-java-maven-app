import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class App {

    private static final String MESSAGE = "Hello from Spark Web Server! Welcome to the world of Java!";

    public App() {}

    public static void main(String[] args) {
<<<<<<< HEAD
        port(8082);  // Ensures the app is listening on port 8082

        // Handle GitHub Webhook POST
        post("/github-webhook/", (req, res) -> {
            System.out.println("Webhook received: " + req.body());
            res.status(200); // Reply 200 OK
            return "Webhook received!";
        });

        // Optional: still allow GET /
=======
        port(8082);  // Listen on port 8082

        // Handle GET request on "/"
>>>>>>> b99fb356d9d0a98a4338039038509562d45beb16
        get("/", (req, res) -> MESSAGE);

        // Handle POST request for GitHub webhook
        post("/github-webhook/", (req, res) -> {
            System.out.println("Webhook received:");
            System.out.println(req.body()); // Print the JSON payload from GitHub
            res.status(200);  // Respond with OK
            return "Webhook received!";
        });
    }

    public String getMessage() {
        return MESSAGE;
    }
}
