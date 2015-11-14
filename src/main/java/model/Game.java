package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<EventCard> revealedCardsRoundOne = new ArrayList<>();
    private List<EventCard> revealedCardsRoundTwo = new ArrayList<>();
    private List<EventCard> revealedCardsRoundThree = new ArrayList<>();

    private List<EventCard> hiddenCardsRoundOne;
    private List<EventCard> hiddenCardsRoundTwo;
    private List<EventCard> hiddenCardsRoundThree;

    private Integer wildlings = 0;

    public Game() {
        hiddenCardsRoundOne = Cards.getRoundOneDeck();
        hiddenCardsRoundTwo = Cards.getRoundTwoDeck();
        hiddenCardsRoundThree = Cards.getRoundThreeDeck();
    }
}
