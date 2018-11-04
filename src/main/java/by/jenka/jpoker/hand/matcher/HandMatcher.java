package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;

import java.util.List;

public interface HandMatcher {
    List<Card> getWinnerCards();

    List<Card> getUnlimitedWinnerCards();

    boolean isMatch();

    int getMinHandSize();
}
