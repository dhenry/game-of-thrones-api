import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.GameState;
import model.TidesOfBattleResponse;
import spark.ModelAndView;
import spark.ResponseTransformer;
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

        get("/tides", "application/json", (request1, response1) -> {
            String tides1 = getTidesOfBattleCard();
            String tides2 = getTidesOfBattleCard();

            String body = request1.body().toString();
            return new TidesOfBattleResponse(body, body, tides1, tides2);
        }, JsonUtil.json());

        get("/battleWildlings", "application/json", (request1, response1) -> {
            boolean wonBattle = Boolean.parseBoolean(request1.queryParams("won"));
            return new ObjectMapper().writeValueAsString(gameState.getCurrentGame().battleWildlings(wonBattle));
        });

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        after((req, res) -> {
            res.type("application/json");
        });
    }

    private static class JsonUtil {

        public static String toJson(Object object) {
            return new Gson().toJson(object);
        }

        public static ResponseTransformer json() {
            return JsonUtil::toJson;
        }
    }

    private static String getTidesOfBattleCard() {
        if (gameState.getCurrentGame() != null && gameState.getCurrentGame().hasTidesOfBattle()) {
            return gameState.getCurrentGame().drawTidesOfBattleCard();
        } else {
            gameState.newGame();
            return gameState.getCurrentGame().drawTidesOfBattleCard();
        }
    }
}
