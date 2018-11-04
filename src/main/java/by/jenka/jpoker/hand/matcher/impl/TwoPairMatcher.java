package by.jenka.jpoker.hand.matcher.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinderByStrings;

import java.util.List;

public class TwoPairMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"2", "2"};

    public TwoPairMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 4;
        rankPositionFinder = new PositionFinderByStrings(getSumRankValues(), PATTERNS);
    }
}
