package by.jenka.jpoker.deck;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck52Cards extends AbstractDeck52Cards {
    private List<Card> cards;
    private static Deck DECK;

    private Deck52Cards() {
        super();
        cards = new ArrayList<>();
        fillDeck();
    }

    public static Deck getInstance() {
        if (DECK == null) {
            DECK = new Deck52Cards();
        }
        return DECK;
    }

    @Override
    protected void fillDeck() {
        if (!cards.isEmpty()) {
            return;
        }
        this.getAllRanks().forEach(rank -> {
            getAllSuits().forEach(suit -> {
                cards.add(new StandardCard(suit, rank));
            });
        });
        Collections.shuffle(this.getCards());
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

}
