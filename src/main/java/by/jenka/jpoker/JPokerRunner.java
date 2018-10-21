package by.jenka.jpoker;

import by.jenka.jpoker.common.Unicodable;
import by.jenka.jpoker.deck.Deck;
import by.jenka.jpoker.deck.Deck52Cards;
import by.jenka.jpoker.deck.sorting.DeckComparator;

import java.util.Collection;
import java.util.stream.Collectors;

public class JPokerRunner {
    public static void main(String[] args) {
        JPokerRunner runner = new JPokerRunner();
        Deck pokerDeck = Deck52Cards.getInstance();

        printUnicodes(
                pokerDeck.getCards().stream()
                        .sorted(DeckComparator.BySuitAndRanks)
                        .collect(Collectors.toList())
        );
    }

    private static void printUnicodes(Collection<? extends Unicodable> codes) {
        Integer count = 1;
        for (Unicodable code : codes) {
            String x = code.toUnicode();
            System.out.println(count + ": " + x);
            count = 1 + count;
        }
    }
}
