package model;

public class EventCard {
    private Integer id;
    private String title;
    private boolean incrementsWildlings;
    private boolean shuffleDeck;

    public EventCard(int id, String title, boolean incrementsWildlings, boolean shuffleDeck) {
        this.id = id;
        this.title = title;
        this.incrementsWildlings = incrementsWildlings;
        this.shuffleDeck = shuffleDeck;
    }

    public EventCard(int id, String title, boolean incrementsWildlings) {
        this(id, title, incrementsWildlings, false);
    }

    public EventCard() {
    }

    public boolean incrementsWildlings() {
        return incrementsWildlings;
    }

    public boolean shuffleDeck() {
        return shuffleDeck;
    }
}
