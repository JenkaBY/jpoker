package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.shared.PositionFinderByStrings;

import java.util.List;

public class TwoPairMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"2", "2"};

    public TwoPairMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 4;
        rankPositionFinder = new PositionFinderByStrings(getSumRankValues(), PATTERNS);
    }
}
