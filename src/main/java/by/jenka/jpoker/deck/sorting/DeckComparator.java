package by.jenka.jpoker.deck.sorting;

import by.jenka.jpoker.card.Card;

import java.util.Comparator;

public class DeckComparator {
    public static Comparator<Card> ByRank = Comparator.comparingInt(card -> card.getRank().getValue());
    public static Comparator<Card> BySuit = Comparator.comparing(card -> card.getSuit().getValue());
    public static Comparator<Card> ByRankAndSuit = ByRank.thenComparing(BySuit);
    public static Comparator<Card> BySuitAndRanks = BySuit.thenComparing(ByRank);

}
