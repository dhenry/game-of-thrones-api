import com.fasterxml.jackson.databind.ObjectMapper;
import model.GameState;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

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
    }
}
