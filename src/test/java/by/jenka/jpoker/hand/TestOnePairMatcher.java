package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.OnePairMatcher;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.Jack;
import by.jenka.jpoker.rank.Queen;
import by.jenka.jpoker.rank.Three;
import by.jenka.jpoker.rank.Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOnePairMatcher extends BaseTest {

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
                new StandardCard(CLUB, new Queen()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Jack())
        );

        HandMatcher handMatcher = new OnePairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        final List<Card> winnerCards = handMatcher.getWinnerCards();
        final String actual = toString(winnerCards);
        final String expected = toString(
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two())
        );
        Assertions.assertEquals(2, winnerCards.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThreePairs() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Queen()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(CLUB, new Jack()),
                new StandardCard(CLUB, new Three())
        );

        HandMatcher handMatcher = new OnePairMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(2, handMatcher.getWinnerCards().size());

        final String expected = toString(
                sort(
                        toList(
                                new StandardCard(DIAMOND, new Jack()),
                                new StandardCard(CLUB, new Jack())
                        )
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
