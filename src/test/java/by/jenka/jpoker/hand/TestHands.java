package by.jenka.jpoker.hand;

import by.jenka.jpoker.UtilsTest;
import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.StandardCard;
import by.jenka.jpoker.hand.texasholdem.*;
import by.jenka.jpoker.rank.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestHands extends UtilsTest {
    @Test
    public void testRankValues() {
        final List<Hand> sortedHands = getSortedHands();
        List<Hand> unsorted = new ArrayList<>(Collections.nCopies(sortedHands.size(), null));
        Collections.copy(unsorted, sortedHands);
        Collections.shuffle(unsorted);

        Assertions.assertArrayEquals(
                sortedHands.toArray(),
                unsorted.stream()
                        .sorted()
                        .toArray());
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
