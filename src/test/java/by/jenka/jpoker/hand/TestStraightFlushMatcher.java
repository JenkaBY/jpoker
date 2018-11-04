package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.StraightFlushMatcher;
import by.jenka.jpoker.rank.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestStraightFlushMatcher extends BaseTest {

    @Test
    public void testHandWithFourCards() {
        final List<Card> cards = toList(
                new StandardCard(HEART, new Two()),
                new StandardCard(HEART, new Three()),
                new StandardCard(HEART, new Four()),
                new StandardCard(HEART, new Five())
        );
        HandMatcher handMatcher = new StraightFlushMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testStraightFlush() {
        final List<Card> fiveCards = toList(
                new StandardCard(HEART, new Five()),
                new StandardCard(HEART, new Two()),
                new StandardCard(HEART, new Four()),
                new StandardCard(HEART, new Three()),
                new StandardCard(HEART, new Six())
        );

        HandMatcher handMatcher = new StraightFlushMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(HEART, new Six()),
                new StandardCard(HEART, new Five()),
                new StandardCard(HEART, new Four()),
                new StandardCard(HEART, new Three()),
                new StandardCard(HEART, new Two())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStraightFlushEdgeCaseAceIsMin() {
        final List<Card> sevenCards = toList(
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Ace()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Four()),
                new StandardCard(DIAMOND, new Five()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new King())
        );

        HandMatcher handMatcher = new StraightFlushMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(DIAMOND, new Five()),
                new StandardCard(DIAMOND, new Four()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Ace())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStraightFlushEdgeCaseMax() {
        final List<Card> sevenCards = toList(
                new StandardCard(DIAMOND, new King()),
                new StandardCard(DIAMOND, new Ten()),
                new StandardCard(DIAMOND, new Ace()),
                new StandardCard(HEART, new Ace()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new Four())
        );

        HandMatcher handMatcher = new StraightFlushMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(DIAMOND, new Ace()),
                new StandardCard(DIAMOND, new King()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new Ten())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }
}
