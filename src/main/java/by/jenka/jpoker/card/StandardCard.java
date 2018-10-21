package by.jenka.jpoker.card;

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
}
