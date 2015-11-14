package model;

public class GameState {
    private Game currentGame;

    public GameState() {
        newGame();
    }

    public void newGame() {
        currentGame = new Game();
    }

    public Game getCurrentGame() {
        return currentGame;
    }
}
