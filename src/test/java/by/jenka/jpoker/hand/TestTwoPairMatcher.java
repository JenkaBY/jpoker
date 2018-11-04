package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.matcher.TwoPairMatcher;
import by.jenka.jpoker.hand.matcher.shared.HandMatcher;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.Ace;
import by.jenka.jpoker.rank.Jack;
import by.jenka.jpoker.rank.Three;
import by.jenka.jpoker.rank.Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestTwoPairMatcher extends BaseTest {

    @Test
    public void testHandWithTwoCards() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Two()),
                new StandardCard(SPIDE, new Three())
        );
        HandMatcher handMatcher = new TwoPairMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testTwoPairs() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Two()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Jack())
        );

        HandMatcher handMatcher = new TwoPairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(4, handMatcher.getWinnerCards().size());
        String expected = toString(
                sort(
                        new StandardCard(HEART, new Two()),
                        new StandardCard(CLUB, new Two()),
                        new StandardCard(SPIDE, new Three()),
                        new StandardCard(DIAMOND, new Three())
                ).collect(Collectors.toList())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
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

        HandMatcher handMatcher = new TwoPairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        final List<Card> winnerCards = handMatcher.getWinnerCards();
        String expected = toString(
                sort(
                        new StandardCard(SPIDE, new Three()),
                        new StandardCard(CLUB, new Three()),
                        new StandardCard(DIAMOND, new Jack()),
                        new StandardCard(CLUB, new Jack())
                ).collect(Collectors.toList())
        );
        String actual = toString(winnerCards);

        Assertions.assertEquals(4, winnerCards.size());
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
