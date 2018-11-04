package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.shared.PositionFinderByMatcher;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnePairMatcher extends HandMatcherByRank {
    private static final Pattern PATTERN_RANKS = Pattern.compile("2");

    public OnePairMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 2;
        final Matcher rankMatcher = PATTERN_RANKS.matcher(getSumRankValues());
        this.rankPositionFinder = new PositionFinderByMatcher(rankMatcher);
    }
}
