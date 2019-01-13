package by.jenka.jpoker;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.impl.StandardCard;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.deck.Deck;
import by.jenka.jpoker.deck.impl.Deck52Cards;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.rank.impl.*;
import by.jenka.jpoker.suit.Suit;
import by.jenka.jpoker.suit.impl.Club;
import by.jenka.jpoker.suit.impl.Diamond;
import by.jenka.jpoker.suit.impl.Heart;
import by.jenka.jpoker.suit.impl.Spide;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseTest {
    private Deck deck;
    protected static final Suit HEART = new Heart();
    protected static final Suit CLUB = new Club();
    protected static final Suit DIAMOND = new Diamond();
    protected static final Suit SPIDE = new Spide();

    @BeforeEach
    public void initDecks() {
        deck = new Deck52Cards();
    }

    protected Deck getDeck() {
        return this.deck;
    }

    protected Stream<Card> sort(Card... cards) {
        return Stream.of(cards)
                .sorted(CardComparator.ByRankReversedAndSuit);
    }

    protected Stream<Card> sort(List<Card> cards) {
        Card[] cardsAr = new Card[cards.size()];
        return sort(cards.toArray(cardsAr));
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

    protected List<Card> toList(Card... cards) {
        return Arrays.asList(cards);
    }

    protected String toString(Card... cards) {
        return toString(toList(cards));
    }

    protected String toString(List<Card> cards) {
        return cards.stream()
                .map(Card::toUnicode)
                .collect(Collectors.joining());
    }


    protected void store() {
        final List<Card> cards = toList(
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(HEART, new Ace()),
                new StandardCard(HEART, new Five()),
                new StandardCard(HEART, new Six()),
                new StandardCard(HEART, new Seven()),
                new StandardCard(HEART, new Eight()),
                new StandardCard(HEART, new Nine()),
                new StandardCard(HEART, new Ten()),
                new StandardCard(HEART, new Queen()),
                new StandardCard(HEART, new King())
        );
    }
}
