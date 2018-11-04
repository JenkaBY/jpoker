package by.jenka.jpoker.hand.matcher.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinderByStringsGrouped;

import java.util.List;

public class FullHouseMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"2", "3"};

    public FullHouseMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 5;
        rankPositionFinder = new PositionFinderByStringsGrouped(getSumRankValues(), PATTERNS);
    }
}
