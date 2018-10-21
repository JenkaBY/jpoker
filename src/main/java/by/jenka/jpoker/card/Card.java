package by.jenka.jpoker.card;

import by.jenka.jpoker.common.Unicodable;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.suit.Suit;

public interface Card extends Unicodable {
    Suit getSuit();

    Rank getRank();
}
