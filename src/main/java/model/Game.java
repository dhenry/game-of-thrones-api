package model;

import java.util.List;
import java.util.Random;

public class Game {
    private List<EventCard> availableRoundOneCards;
    private List<EventCard> availableRoundTwoCards;
    private List<EventCard> availableRoundThreeCards;

    private Integer wildlingsStrength = 0;

    public Game() {
        availableRoundOneCards = Cards.getDeck(1);
        availableRoundTwoCards = Cards.getDeck(2);
        availableRoundThreeCards = Cards.getDeck(3);
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
        EventCard card = cards.remove(new Random().nextInt(cards.size()-1));
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
}
