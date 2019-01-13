package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.impl.StandardCard;
import by.jenka.jpoker.hand.matcher.HandMatcher;
import by.jenka.jpoker.hand.matcher.impl.FlushMatcher;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.impl.*;
import by.jenka.jpoker.suit.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestFlushMatcher extends BaseTest {

    @Test
    public void testHandWithFourCards() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(HEART, new Three()),
                new StandardCard(HEART, new Ace()),
                new StandardCard(HEART, new Jack())

        );
        HandMatcher handMatcher = new FlushMatcher(cards);

        Assertions.assertFalse(handMatcher.isMatch(), "Too low cards in hand.");
        Assertions.assertEquals(0, handMatcher.getWinnerCards().size());
    }

    @Test
    public void testFlush() {
        OneSuitFlushTest(HEART);
    }

    @Test
    public void testFlushSpide() {
        OneSuitFlushTest(SPIDE);
    }

    @Test
    public void testFlushClub() {
        OneSuitFlushTest(CLUB);
    }

    @Test
    public void testFlushDiamonds() {
        OneSuitFlushTest(DIAMOND);
    }

    private void OneSuitFlushTest(Suit suit) {
        final List<Card> fiveCards = Arrays.asList(
                new StandardCard(suit, new Two()),
                new StandardCard(suit, new Three()),
                new StandardCard(suit, new Queen()),
                new StandardCard(suit, new Ten()),
                new StandardCard(suit, new Jack())
        );

        HandMatcher handMatcher = new FlushMatcher(fiveCards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        final List<Card> winnerCards = handMatcher.getWinnerCards();
        final String actual = toString(winnerCards);
        final String expected = toString(
                new StandardCard(suit, new Queen()),
                new StandardCard(suit, new Jack()),
                new StandardCard(suit, new Ten()),
                new StandardCard(suit, new Three()),
                new StandardCard(suit, new Two())
        );
        Assertions.assertEquals(5, winnerCards.size());
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testAllCardsOneSuits() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(HEART, new Two()),
                new StandardCard(HEART, new Three()),
                new StandardCard(HEART, new Queen()),
                new StandardCard(HEART, new Ten()),
                new StandardCard(HEART, new Jack()),
                new StandardCard(HEART, new Ace()),
                new StandardCard(HEART, new Six())
        );

        HandMatcher handMatcher = new FlushMatcher(cards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());

        final String expected = toString(
                new StandardCard(HEART, new Ace()),
                new StandardCard(HEART, new Queen()),
                new StandardCard(HEART, new Jack()),
                new StandardCard(HEART, new Ten()),
                new StandardCard(HEART, new Six())
        );

        final String actual = toString(handMatcher.getWinnerCards());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAndFlush() {
        final List<Card> cards = Arrays.asList(
                new StandardCard(DIAMOND, new Two()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Ten()),
                new StandardCard(SPIDE, new Ace()),
                new StandardCard(HEART, new Ace()),
                new StandardCard(DIAMOND, new Ace())
        );

        HandMatcher handMatcher = new FlushMatcher(cards);

        Assertions.assertTrue(handMatcher.isMatch(), "Should be matched");
        Assertions.assertEquals(5, handMatcher.getWinnerCards().size());

        final String expected = toString(
                new StandardCard(DIAMOND, new Ace()),
                new StandardCard(DIAMOND, new Queen()),
                new StandardCard(DIAMOND, new Ten()),
                new StandardCard(DIAMOND, new Three()),
                new StandardCard(DIAMOND, new Two())
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
