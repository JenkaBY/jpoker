package by.jenka.jpoker.hand.matcher.shared;

import by.jenka.jpoker.card.Card;

import java.util.List;

public interface HandMatcher {
    List<Card> getWinnerCards();

    boolean isMatch();

    int getMinHandSize();
}
