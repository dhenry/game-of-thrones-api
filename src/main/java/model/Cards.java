package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cards {

    private static final List<EventCard> roundOneDeck;
    private static final List<EventCard> roundTwoDeck;
    private static final List<EventCard> roundThreeDeck;

    static {
        roundOneDeck = new ArrayList<>();
        roundOneDeck.add(new EventCard(0, "A Throne of Blades", true));
        roundOneDeck.add(new EventCard(1, "Winter is Coming", false, true));
        roundOneDeck.add(new EventCard(2, "A Throne of Blades", true));
        roundOneDeck.add(new EventCard(3, "Mustering", false));
        roundOneDeck.add(new EventCard(4, "Last Days of Summer", true));
        roundOneDeck.add(new EventCard(5, "Supply", false));
        roundOneDeck.add(new EventCard(6, "Mustering", false));
        roundOneDeck.add(new EventCard(7, "Mustering", false));
        roundOneDeck.add(new EventCard(8, "Supply", false));
        roundOneDeck.add(new EventCard(9, "Supply", false));

        roundTwoDeck = new ArrayList<>();
        roundTwoDeck.add(new EventCard(0, "Dark Wings, Dark Words", true));
        roundTwoDeck.add(new EventCard(1, "Dark Wings, Dark Words", true));
        roundTwoDeck.add(new EventCard(2, "Game of Thrones", false));
        roundTwoDeck.add(new EventCard(3, "Winter is Coming", false, true));
        roundTwoDeck.add(new EventCard(4, "Clash of Kings", false));
        roundTwoDeck.add(new EventCard(5, "Last Days of Summer", true));
        roundTwoDeck.add(new EventCard(6, "Game of Thrones", false));
        roundTwoDeck.add(new EventCard(7, "Game of Thrones", false));
        roundTwoDeck.add(new EventCard(8, "Clash of Kings", false));
        roundTwoDeck.add(new EventCard(9, "Clash of Kings", false));

        roundThreeDeck = new ArrayList<>();
        roundThreeDeck.add(new EventCard(0, "Put to the Sword", false));
        roundThreeDeck.add(new EventCard(1, "Sea of Storms", true));
        roundThreeDeck.add(new EventCard(2, "Web of Lies", true));
        roundThreeDeck.add(new EventCard(3, "Storm of Swords", true));
        roundThreeDeck.add(new EventCard(4, "Rains of Autumn", true));
        roundThreeDeck.add(new EventCard(5, "Feast for Crows", true));
        roundThreeDeck.add(new EventCard(6, "Wildlings Attack", false));
        roundThreeDeck.add(new EventCard(7, "Put to the Sword", false));
        roundThreeDeck.add(new EventCard(8, "Wildlings Attack", false));
        roundThreeDeck.add(new EventCard(9, "Wildlings Attack", false));
    }

    public static List<EventCard> getDeck(int deckNumber) {
        switch (deckNumber) {
            case 1:
                return new ArrayList<>(roundOneDeck);
            case 2:
                return new ArrayList<>(roundTwoDeck);
            case 3:
                return  new ArrayList<>(roundThreeDeck);
            default:
                throw new RuntimeException("Invalid deck number:" + deckNumber);
        }
    }
}
