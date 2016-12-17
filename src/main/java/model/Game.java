package model;

import spark.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static final String SWORD = "1 :sword:";
    public static final String EUROPEAN_CASTLE = "1 :european_castle:";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String SKULL = ":skull";
    public static final String ZERO = "0";
    private List<EventCard> availableRoundOneCards;
    private List<EventCard> availableRoundTwoCards;
    private List<EventCard> availableRoundThreeCards;
    private List<String> tidesOfBattle;

    private Integer wildlingsStrength = 0;

    public Game() {
        availableRoundOneCards = Cards.getDeck(1);
        availableRoundTwoCards = Cards.getDeck(2);
        availableRoundThreeCards = Cards.getDeck(3);
        tidesOfBattle = new ArrayList<>();
        tidesOfBattle.add(SWORD);
        tidesOfBattle.add(SWORD);
        tidesOfBattle.add(SWORD);
        tidesOfBattle.add(SWORD);
        tidesOfBattle.add(EUROPEAN_CASTLE);
        tidesOfBattle.add(EUROPEAN_CASTLE);
        tidesOfBattle.add(EUROPEAN_CASTLE);
        tidesOfBattle.add(TWO);
        tidesOfBattle.add(TWO);
        tidesOfBattle.add(TWO);
        tidesOfBattle.add(TWO);
        tidesOfBattle.add(THREE);
        tidesOfBattle.add(THREE);
        tidesOfBattle.add(SKULL);
        tidesOfBattle.add(SKULL);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
        tidesOfBattle.add(ZERO);
    }

    public EventCard playRoundOneCard() {
        return playRandomCard(availableRoundOneCards, 1);
    }

    public EventCard playRoundTwoCard() {
        return playRandomCard(availableRoundTwoCards, 2);
    }

    public EventCard playRoundThreeCard() {
        return playRandomCard(availableRoundThreeCards, 3);
    }

    public Integer getWildlingsStrength() {
        return wildlingsStrength;
    }

    public List<EventCard> getAvailableRoundOneCards() {
        return availableRoundOneCards;
    }

    public List<EventCard> getAvailableRoundTwoCards() {
        return availableRoundTwoCards;
    }

    public List<EventCard> getAvailableRoundThreeCards() {
        return availableRoundThreeCards;
    }

    private EventCard playRandomCard(final List<EventCard> cards, int deckNumber) {
        // shuffle deck if no cards left
        if (cards.size() == 0) {
            shuffle(cards, deckNumber);
        }
        // grab a random card
        EventCard card = cards.remove(new Random().nextInt(cards.size()));
        // increment wildlingsStrength if required
        if (card.incrementsWildlings()) {
            wildlingsStrength += 2;
        }
        // shuffle deck if required
        if (card.shuffleDeck()) {
            cards.clear();
            shuffle(cards, deckNumber);
        }
        return card;
    }

    private void shuffle(List<EventCard> cards, int deckNumber) {
        cards.addAll(Cards.getDeck(deckNumber));
    }

    public Integer battleWildlings(boolean wonBattle) {
        if (wonBattle) {
            wildlingsStrength = 0;
        } else {
            wildlingsStrength /= 2;
        }
        return wildlingsStrength;
    }

    public boolean hasTidesOfBattle() {
        return !CollectionUtils.isEmpty(tidesOfBattle);
    }

    public String drawTidesOfBattleCard() {
        return tidesOfBattle.remove(new Random(tidesOfBattle.size() -1).nextInt());
    }
}
