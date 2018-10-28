package by.jenka.jpoker.hand;

import by.jenka.jpoker.UtilsTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.OnePairMatcher;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestOnePairMatcher extends UtilsTest {

    @Test
    public void testHandWithOneCard() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two())
        );
        HandMatcher handMatcher = new OnePairMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testOnePair() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Jack())
        );

        HandMatcher handMatcher = new OnePairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(2, handMatcher.getWinnerCards().size());
        Assertions.assertArrayEquals(
                Arrays.asList(new StandardCard(HEART, new Two()), new StandardCard(DIAMOND, new Two())).toArray(),
                handMatcher.getWinnerCards().toArray()
        );
    }

    @Test
    public void testThreePairs() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(CLUB, new Jack()),
                new StandardCard(CLUB, new Three())
        );

        HandMatcher handMatcher = new OnePairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(6, handMatcher.getWinnerCards().size());

        final Object[] expected = Stream.of(
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(CLUB, new Jack()))
                .sorted(CardComparator.ByRankAndSuit)
                .toArray();

        final Object[] actual = handMatcher.getWinnerCards().stream()
                .sorted(CardComparator.ByRankAndSuit)
                .toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    private List<Hand> getSortedHands() {
        return Arrays.asList(
                new StraightFlush(),    // 11111 suit 5
                new FourKind(),         // 4
                new FullHouse(),        // 32
                new Flush(),            // suit 5
                new Straight(),         // 11111
                new Set(),              // 3
                new TwoPair(),          // 22
                new OnePair(),          // 2
                new HighCard()          // 11
        );
    }

    private void store() {
        final List<Card> fiveCards = Arrays.asList(
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
