package by.jenka.jpoker.hand.matcher.impl;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.AbstractHandMatcher;
import by.jenka.jpoker.hand.matcher.HandMatcher;

import java.util.List;

public class StraightFlushMatcher extends AbstractHandMatcher {
    private HandMatcher straightMatcher;

    public StraightFlushMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 5;
        HandMatcher flushMatcher = new FlushMatcher(hand);
        flushMatcher.isMatch();
        straightMatcher = new StraightMatcher(flushMatcher.getUnlimitedWinnerCards());
    }

    @Override
    public boolean isMatch() {
        return straightMatcher.isMatch();
    }

    @Override
    public List<Card> getWinnerCards() {
        return straightMatcher.getWinnerCards();
    }

    @Override
    public List<Card> getUnlimitedWinnerCards() {
        return straightMatcher.getUnlimitedWinnerCards();
    }
}
