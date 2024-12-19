package com.lunchpailff;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        // Default route
        app.get("/", ctx -> ctx.result("Welcome to LunchPailFF Backend!"));

        // Database test route
        app.get("/db-test", ctx -> {
            try (Connection connection = Database.connect()) { // Make sure Database.connect() is implemented
                ctx.result("Database connected successfully!");
            } catch (Exception e) {
                ctx.result("Database connection failed: " + e.getMessage());
            }
        });

        app.get("/draft", ctx -> {
            Map<String, String> draft = new HashMap<>();
            draft.put("round1", "Patrick Mahomes");
            draft.put("round2", "Justin Jefferson");

            ctx.json(draft);
        });

    }
}
