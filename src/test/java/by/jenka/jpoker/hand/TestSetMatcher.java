package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.impl.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.SetMatcher;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.impl.Ace;
import by.jenka.jpoker.rank.impl.Jack;
import by.jenka.jpoker.rank.impl.Three;
import by.jenka.jpoker.rank.impl.Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSetMatcher extends BaseTest {

    @Test
    public void testHandWithTwoCards() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Two())
        );
        HandMatcher handMatcher = new SetMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testSet() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Jack())
        );

        HandMatcher handMatcher = new SetMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(3, handMatcher.getWinnerCards().size());
        String expected = toString(
                sort(
                        new StandardCard(CLUB, new Three()),
                        new StandardCard(SPIDE, new Three()),
                        new StandardCard(DIAMOND, new Three())
                ).collect(Collectors.toList())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetEdgeCase() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(DIAMOND, new Ace()),
                new StandardCard(DIAMOND, new Jack())
        );

        HandMatcher handMatcher = new SetMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(3, handMatcher.getWinnerCards().size());
        String expected = toString(
                sort(
                        new StandardCard(CLUB, new Ace()),
                        new StandardCard(SPIDE, new Ace()),
                        new StandardCard(DIAMOND, new Ace())
                ).collect(Collectors.toList())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThreePairs() {
        final List<Card> sevenCards = Arrays.asList(
                new StandardCard(HEART, new Three()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(HEART, new Jack()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(CLUB, new Jack()),
                new StandardCard(CLUB, new Three())
        );

        HandMatcher handMatcher = new SetMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(3, handMatcher.getWinnerCards().size());

        String expected = toString(
                sort(
                        new StandardCard(HEART, new Jack()),
                        new StandardCard(DIAMOND, new Jack()),
                        new StandardCard(CLUB, new Jack())
                ).collect(Collectors.toList())
        );

        final String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
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
}
