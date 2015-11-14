package model;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final List<EventCard> roundOneDeck;
    private static final List<EventCard> roundTwoDeck;
    private static final List<EventCard> roundThreeDeck;

    static {
        roundOneDeck = new ArrayList<>();
        roundOneDeck.add(new EventCard(0, "A Throne of Blades"));
        roundOneDeck.add(new EventCard(1, "Winter is Coming"));
        roundOneDeck.add(new EventCard(2, "A Throne of Blades"));
        roundOneDeck.add(new EventCard(3, "Mustering"));
        roundOneDeck.add(new EventCard(4, "Last Days of Summer"));
        roundOneDeck.add(new EventCard(5, "Supply"));
        roundOneDeck.add(new EventCard(6, "Mustering"));
        roundOneDeck.add(new EventCard(7, "Mustering"));
        roundOneDeck.add(new EventCard(8, "Supply"));
        roundOneDeck.add(new EventCard(9, "Supply"));

        roundTwoDeck = new ArrayList<>();
        roundTwoDeck.add(new EventCard(0, "Dark Wings, Dark Words"));
        roundTwoDeck.add(new EventCard(1, "Dark Wings, Dark Words"));
        roundTwoDeck.add(new EventCard(2, "Game of Thrones"));
        roundTwoDeck.add(new EventCard(3, "Winter is Coming"));
        roundTwoDeck.add(new EventCard(4, "Clash of Kings"));
        roundTwoDeck.add(new EventCard(5, "Last Days of Summer"));
        roundTwoDeck.add(new EventCard(6, "Game of Thrones"));
        roundTwoDeck.add(new EventCard(7, "Game of Thrones"));
        roundTwoDeck.add(new EventCard(8, "Clash of Kings"));
        roundTwoDeck.add(new EventCard(9, "Clash of Kings"));

        roundThreeDeck = new ArrayList<>();
        roundThreeDeck.add(new EventCard(0, "Put to the Sword"));
        roundThreeDeck.add(new EventCard(1, "Sea of Storms"));
        roundThreeDeck.add(new EventCard(2, "Web of Lies"));
        roundThreeDeck.add(new EventCard(3, "Storm of Swords"));
        roundThreeDeck.add(new EventCard(4, "Rains of Autumn"));
        roundThreeDeck.add(new EventCard(5, "Feast for Crows"));
        roundThreeDeck.add(new EventCard(6, "Wildlings Attack"));
        roundThreeDeck.add(new EventCard(7, "Put to the Sword"));
        roundThreeDeck.add(new EventCard(8, "Wildlings Attack"));
        roundThreeDeck.add(new EventCard(9, "Wildlings Attack"));
    }


    public static List<EventCard> getRoundOneDeck() {
        return roundOneDeck;
    }

    public static List<EventCard> getRoundTwoDeck() {
        return roundTwoDeck;
    }

    public static List<EventCard> getRoundThreeDeck() {
        return roundThreeDeck;
    }
}
