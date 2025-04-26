import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class App {

    private static final String MESSAGE = "Hello from Spark Web Server! Welcome to the world of Java!";

    public App() {}

    public static void main(String[] args) {
        port(8082);  // Ensures the app is listening on port 8082

        // Handle GitHub Webhook POST
        post("/github-webhook/", (req, res) -> {
            System.out.println("Webhook received: " + req.body());
            res.status(200); // Reply 200 OK
            return "Webhook received!";
        });

        // Optional: still allow GET /
        get("/", (req, res) -> MESSAGE);
    }

    public String getMessage() {
        return MESSAGE;
    }
}
