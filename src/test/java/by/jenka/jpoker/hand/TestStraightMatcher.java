package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.impl.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.StraightMatcher;
import by.jenka.jpoker.rank.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestStraightMatcher extends BaseTest {

    @Test
    public void testHandWithFourCards() {
        final List<Card> cards = toList(
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(HEART, new Four()),
                new StandardCard(CLUB, new Five())
        );
        HandMatcher handMatcher = new StraightMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testSet() {
        final List<Card> fiveCards = toList(
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(HEART, new Four()),
                new StandardCard(CLUB, new Five()),
                new StandardCard(DIAMOND, new Six())
        );

        HandMatcher handMatcher = new StraightMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                sort(
                        new StandardCard(HEART, new Two()),
                        new StandardCard(CLUB, new Three()),
                        new StandardCard(HEART, new Four()),
                        new StandardCard(CLUB, new Five()),
                        new StandardCard(DIAMOND, new Six())
                ).collect(Collectors.toList())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStraightEdgeCaseAceIsMin() {
        final List<Card> sevenCards = toList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(DIAMOND, new Four()),
                new StandardCard(DIAMOND, new Five()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new King())
        );

        HandMatcher handMatcher = new StraightMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(DIAMOND, new Five()),
                new StandardCard(DIAMOND, new Four()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Ace())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStraightEdgeCaseMax() {
        final List<Card> sevenCards = toList(
                new StandardCard(HEART, new King()),
                new StandardCard(DIAMOND, new Ten()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Ten()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new Four())
        );

        HandMatcher handMatcher = new StraightMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(HEART, new King()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new Ten())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }
}
