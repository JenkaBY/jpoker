package by.jenka.jpoker.deck.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.impl.StandardCard;
import by.jenka.jpoker.deck.AbstractDeck52Cards;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.suit.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck52Cards extends AbstractDeck52Cards {
    private List<Card> cards;

    public Deck52Cards() {
        super();
        cards = new ArrayList<>();
        fillDeck();
    }

    @Override
    protected void fillDeck() {
        if (!cards.isEmpty()) {
            return;
        }
        this.getAllRanks().forEach(rank -> {
            getAllSuits().forEach(suit -> {
                cards.add(initCard(suit, rank));
            });
        });
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(this.getCards());
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    private Card initCard(Suit suit, Rank rank) {
        return new StandardCard(suit, rank);
    }

}
