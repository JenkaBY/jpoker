package by.jenka.jpoker.hand.matcher.shared;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.factory.RankFactory;
import by.jenka.jpoker.rank.Rank;

import java.util.List;
import java.util.stream.Collectors;

public abstract class HandMatcherByRank extends HandMatcher {
    public HandMatcherByRank(List<Card> hand) {
        super(hand);
    }

    public List<Card> getWinnerCards() {
        List<Class<? extends Rank>> pairCardClasses = rankPositions.stream()
                .map(RankFactory::getRankFromPosition)
                .map(Rank::getClass)
                .collect(Collectors.toList());

        return hand.stream()
                .filter(card -> pairCardClasses.contains(card.getRank().getClass()))
                .collect(Collectors.toList());
    }
}
