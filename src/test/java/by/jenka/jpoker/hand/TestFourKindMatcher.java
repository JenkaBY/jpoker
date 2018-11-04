package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.FourKindMatcher;
import by.jenka.jpoker.rank.Ace;
import by.jenka.jpoker.rank.Jack;
import by.jenka.jpoker.rank.Three;
import by.jenka.jpoker.rank.Two;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestFourKindMatcher extends BaseTest {

    @Test
    public void testHandWithMinHandSize() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(CLUB, new Two())
        );
        HandMatcher handMatcher = new FourKindMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testForKind() {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(HEART, new Three()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(CLUB, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Ace())
        );

        HandMatcher handMatcher = new FourKindMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(4, handMatcher.getWinnerCards().size());
        String expected = toString(
                new StandardCard(HEART, new Three()),
                new StandardCard(SPIDE, new Three()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Three())
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
                new StandardCard(DIAMOND, new Jack()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(CLUB, new Jack()),
                new StandardCard(CLUB, new Three())
        );

        HandMatcher handMatcher = new FourKindMatcher(sevenCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(4, handMatcher.getWinnerCards().size());

        String expected = toString(
                sort(
                        new StandardCard(HEART, new Three()),
                        new StandardCard(DIAMOND, new Three()),
                        new StandardCard(SPIDE, new Three()),
                        new StandardCard(CLUB, new Three())
                ).collect(Collectors.toList())
        );

        final String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }
}
