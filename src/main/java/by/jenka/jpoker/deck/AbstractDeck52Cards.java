package by.jenka.jpoker.deck;

import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.rank.impl.*;
import by.jenka.jpoker.suit.Suit;
import by.jenka.jpoker.suit.impl.Club;
import by.jenka.jpoker.suit.impl.Diamond;
import by.jenka.jpoker.suit.impl.Heart;
import by.jenka.jpoker.suit.impl.Spide;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeck52Cards implements Deck {
    private static final int SUIT_SIZE = 4;
    private static final int RANK_SIZE = 13;

    protected Set<Suit> getAllSuits() {
        final Set<Suit> suits = new HashSet<>(SUIT_SIZE);
        suits.addAll(Arrays.asList(new Heart(), new Diamond(), new Club(), new Spide()));
        return Collections.unmodifiableSet(suits);
    }

    protected Set<Rank> getAllRanks() {
        final Set<Rank> ranks = new HashSet<>(RANK_SIZE);
        ranks.addAll(Arrays.asList(
                new Two(), new Three(), new Four(), new Five(),
                new Six(), new Seven(), new Eight(), new Nine(),
                new Ten(), new Jack(), new Queen(), new King(),
                new Ace()
                )
        );

        return Collections.unmodifiableSet(ranks);
    }

    protected abstract void fillDeck();

    @Override
    public int getDeckSize() {
        return getCards().size();
    }
}
