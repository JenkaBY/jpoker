package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;

import java.util.List;
import java.util.regex.Pattern;

public class TwoPairMatcher extends HandMatcher {
    private static final Pattern PATTERN_RANKS = Pattern.compile("(.*)2(.*)2(.*)");
    private static final Pattern PATTERN_SUITS = null;

    public TwoPairMatcher(List<Card> hand) {
        super(hand);
    }

    @Override
    protected int minHandSize() {
        return 4;
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
