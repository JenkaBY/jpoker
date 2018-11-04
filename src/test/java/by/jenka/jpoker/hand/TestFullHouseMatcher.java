package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.FullHouseMatcher;
import by.jenka.jpoker.rank.Ace;
import by.jenka.jpoker.rank.Three;
import by.jenka.jpoker.rank.Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestFullHouseMatcher extends BaseTest {

    @Test
    public void testHandWithFourCards() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(DIAMOND, new Three())
        );
        HandMatcher handMatcher = new FullHouseMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testFullHouse() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Two()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three())
        );

        HandMatcher handMatcher = new FullHouseMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(SPIDE, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(HEART, new Two()),
                new StandardCard(CLUB, new Two())
        );
        String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSevenCards() {
        final List<Card> sevenCards = Arrays.asList(
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Two())
        );

        HandMatcher handMatcher = new FullHouseMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");

        final List<Card> winnerCards = handMatcher.getWinnerCards();
        Assertions.assertEquals(5, winnerCards.size());

        String expected = toString(
                new StandardCard(SPIDE, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two())
        );
        String actual = toString(winnerCards);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSevenCards2() {
        final List<Card> sevenCards = Arrays.asList(
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Ace())
        );

        HandMatcher handMatcher = new FullHouseMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");

        final List<Card> winnerCards = handMatcher.getWinnerCards();
        Assertions.assertEquals(5, winnerCards.size());

        String expected = toString(
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(CLUB, new Ace()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three())
        );
        String actual = toString(winnerCards);

        Assertions.assertEquals(expected, actual);
    }
}
