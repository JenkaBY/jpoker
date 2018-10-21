package by.jenka.jpoker.deck;

import by.jenka.jpoker.rank.*;
import by.jenka.jpoker.suit.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeck52Cards implements Deck {
    protected final int size;

    public AbstractDeck52Cards() {
        this.size = 52;
    }

    protected Set<Suit> getAllSuits() {
        final Set<Suit> suits = new HashSet<>(4);
        suits.addAll(Arrays.asList(new Heart(), new Diamond(), new Club(), new Spide()));
        return Collections.unmodifiableSet(suits);
    }

    protected Set<Rank> getAllRanks() {
        final Set<Rank> ranks = new HashSet<>();
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
}
