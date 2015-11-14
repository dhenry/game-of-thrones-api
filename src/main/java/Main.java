import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroku.sdk.jdbc.DatabaseUrl;
import model.GameState;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    private static final GameState gameState = new GameState();

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        get("/state", "application/json", (request1, response1) ->
                new ObjectMapper().writeValueAsString(gameState.getCurrentGame()));

        get("/roundOneCard", "application/json", (request1, response1) ->
                new ObjectMapper().writeValueAsString(gameState.getCurrentGame().playRoundOneCard()));

        get("/roundTwoCard", "application/json", (request1, response1) ->
                new ObjectMapper().writeValueAsString(gameState.getCurrentGame().playRoundTwoCard()));

        get("/roundThreeCard", "application/json", (request1, response1) ->
                new ObjectMapper().writeValueAsString(gameState.getCurrentGame().playRoundThreeCard()));

        get("/wildlings", "application/json", (request1, response1) ->
                new ObjectMapper().writeValueAsString(gameState.getCurrentGame().getWildlingsStrength()));

        get("/newGame", "application/json", (request1, response1) -> {
            gameState.newGame();
            return new ObjectMapper().writeValueAsString(gameState.getCurrentGame());
        });

        get("/battleWildlings", "application/json", (request1, response1) -> {
            boolean wonBattle = Boolean.parseBoolean(request1.queryParams("won"));
            return new ObjectMapper().writeValueAsString(gameState.getCurrentGame().battleWildlings(wonBattle));
        });

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/db", (req, res) -> {
            Connection connection = null;
            Map<String, Object> attributes = new HashMap<>();
            try {
                connection = DatabaseUrl.extract().getConnection();

                Statement stmt = connection.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
                stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
                ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

                ArrayList<String> output = new ArrayList<String>();
                while (rs.next()) {
                    output.add("Read from DB: " + rs.getTimestamp("tick"));
                }

                attributes.put("results", output);
                return new ModelAndView(attributes, "db.ftl");
            } catch (Exception e) {
                attributes.put("message", "There was an error: " + e);
                return new ModelAndView(attributes, "error.ftl");
            } finally {
                if (connection != null) try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }, new FreeMarkerEngine());

    }

}
