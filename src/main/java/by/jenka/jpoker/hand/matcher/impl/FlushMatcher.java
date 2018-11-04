package by.jenka.jpoker.hand.matcher.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.HandMatcherBySuit;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinderByMatcher;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlushMatcher extends HandMatcherBySuit {
    private static final Pattern PATTERN_RANKS = Pattern.compile("[567]");

    public FlushMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 5;
        Matcher m = PATTERN_RANKS.matcher(getSumSuitValues());
        suitPositionFinder = new PositionFinderByMatcher(m);
    }
}
