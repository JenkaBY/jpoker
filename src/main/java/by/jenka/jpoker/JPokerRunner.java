package by.jenka.jpoker;

import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.common.Unicodable;
import by.jenka.jpoker.deck.Deck;
import by.jenka.jpoker.deck.impl.Deck52Cards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JPokerRunner {
    public static void main(String[] args) {
        JPokerRunner runner = new JPokerRunner();
        Deck pokerDeck = new Deck52Cards();

        printUnicodes(
                pokerDeck.getCards().stream()
                        .sorted(CardComparator.BySuitAndRanks)
                        .collect(Collectors.toList())
        );
    }

    private static void printUnicodes(List<? extends Unicodable> codes) {
        int count = 1;
        IntStream.rangeClosed(1, codes.size())
                .mapToObj(num -> num + ": " + codes.get(num).toUnicode())
                .forEach(System.out::println);
    }
}
