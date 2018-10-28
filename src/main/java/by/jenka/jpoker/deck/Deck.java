package by.jenka.jpoker.deck;

import by.jenka.jpoker.card.Card;

import java.util.List;

public interface Deck {
    List<Card> getCards();

    int getDeckSize();
}
