package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.shared.PositionFinderByStrings;

import java.util.List;

public class SetMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"3"};

    public SetMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 3;
        this.rankPositionFinder = new PositionFinderByStrings(getSumRankValues(), PATTERNS);
    }
}
