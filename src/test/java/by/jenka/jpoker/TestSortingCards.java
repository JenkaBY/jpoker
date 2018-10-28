package by.jenka.jpoker;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.rank.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestSortingCards extends UtilsTest {

    @Test
    public void testDeckSortingByRank() {
        Object[] sorted = getDeck().getCards().stream()
                .sorted(CardComparator.ByRank)
                .map(Card::getRank)
                .distinct()
                .toArray();
        Assertions.assertArrayEquals(getSortedRanks().toArray(), sorted);
    }

    @Test
    public void deckMustBeShuffled() {
        final List<Rank> shuffled = getDeck().getCards().stream()
                .limit(8)
                .map(Card::getRank)
                .distinct()
                .collect(Collectors.toList());

        final List<Rank> immitated = getSortedRanks().subList(0, 2);
        final int first = 0;
        final int second = 0;
        Rank firstRank = immitated.get(first);
        Rank secondRank = immitated.get(second);

        if (firstRank.equals(shuffled.get(first)) && secondRank.equals(shuffled.get(second))) {
            Assertions.fail("Deck must be shuffled.");
        }
    }

    private List<Rank> immitateRanksOfDeck() {
        return getSortedRanks().stream()
                .flatMap(rank -> Collections.nCopies(4, rank).stream())
                .collect(Collectors.toList());
    }
}
