package by.jenka.jpoker.hand;

import by.jenka.jpoker.BaseTest;
import by.jenka.jpoker.hand.texasholdem.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestHands extends BaseTest {
    @RepeatedTest(10)
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
}
