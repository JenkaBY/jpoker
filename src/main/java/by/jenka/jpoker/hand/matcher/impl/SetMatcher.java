package by.jenka.jpoker.hand.matcher.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinderByStrings;

import java.util.List;

public class SetMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"3"};

    public SetMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 3;
        this.rankPositionFinder = new PositionFinderByStrings(getSumRankValues(), PATTERNS);
    }
}
