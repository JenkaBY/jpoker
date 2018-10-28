package by.jenka.jpoker.card.sorting;

import by.jenka.jpoker.card.Card;

import java.util.Comparator;

public class CardComparator {
    public static Comparator<Card> ByRank = Comparator.comparingLong(card -> card.getRank().getValue());
    public static Comparator<Card> BySuit = Comparator.comparing(card -> card.getSuit().getValue());
    public static Comparator<Card> ByRankAndSuit = ByRank.thenComparing(BySuit);
    public static Comparator<Card> BySuitAndRanks = BySuit.thenComparing(ByRank);

}
