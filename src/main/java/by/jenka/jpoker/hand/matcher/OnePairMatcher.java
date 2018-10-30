package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;

import java.util.List;
import java.util.regex.Pattern;

public class OnePairMatcher extends HandMatcherByRank {
    private static final Pattern PATTERN_RANKS = Pattern.compile("2");
    private static final Pattern PATTERN_SUITS = null;

    public OnePairMatcher(List<Card> hand) {
        super(hand);
    }

    @Override
    protected int minHandSize() {
        return 2;
    }

    @Override
    protected Pattern getPatternForRanks() {
        return PATTERN_RANKS;
    }

    @Override
    protected Pattern getPatternForSuits() {
        return PATTERN_SUITS;
    }
}
