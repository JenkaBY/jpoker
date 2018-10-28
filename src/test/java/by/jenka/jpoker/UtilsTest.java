package by.jenka.jpoker;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.deck.Deck;
import by.jenka.jpoker.deck.Deck52Cards;
import by.jenka.jpoker.rank.*;
import by.jenka.jpoker.suit.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UtilsTest {
    private Deck deck;
    protected static final Suit HEART = new Heart();
    protected static final Suit CLUB = new Club();
    protected static final Suit DIAMOND = new Diamond();
    protected static final Suit SPIDE = new Spide();

    @BeforeEach
    public void initDecks() {
        deck = Deck52Cards.getInstance();
    }

    protected Deck getDeck() {
        return this.deck;
    }

    protected Stream<Card> sort(Card... cards) {
        return Stream.of(cards)
                .sorted(CardComparator.ByRankAndSuit);
    }

    protected Stream<Card> sort(List<Card> cards) {
        return sort((Card[]) cards.toArray());
    }

    protected List<Rank> getSortedRanks() {
        return Arrays.asList(
                new Two(),
                new Three(),
                new Four(),
                new Five(),
                new Six(),
                new Seven(),
                new Eight(),
                new Nine(),
                new Ten(),
                new Jack(),
                new Queen(),
                new King(),
                new Ace()
        );
    }
}
