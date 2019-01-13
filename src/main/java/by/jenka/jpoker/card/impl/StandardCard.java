package by.jenka.jpoker.card.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.suit.Suit;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class StandardCard implements Card {
    private final Suit suit;
    private final Rank rank;

    public StandardCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public String toUnicode() {
        return rank.toUnicode() + suit.toUnicode();
    }

    @Override
    public String toString() {
        return toUnicode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandardCard that = (StandardCard) o;

        if (!suit.equals(that.suit)) return false;
        return rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        int result = 12 * suit.hashCode() + rank.hashCode();
        return result;
    }
}
