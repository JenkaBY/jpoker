package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;

import java.util.List;

public abstract class AbstractHandMatcher implements HandMatcher {
    protected static short MAX_CARDS_ON_TABLE = 7;
    protected List<Card> hand;
    protected int minHandSize;

    public AbstractHandMatcher(List<Card> hand) {
        this.hand = hand;
    }

    protected boolean hasMinSize() {
        return hand.size() >= getMinHandSize();
    }

    @Override
    public boolean isMatch() {
        return hasMinSize();
    }

    @Override
    public final int getMinHandSize() {
        return this.minHandSize;
    }

    public abstract List<Card> getUnlimitedWinnerCards();
}
