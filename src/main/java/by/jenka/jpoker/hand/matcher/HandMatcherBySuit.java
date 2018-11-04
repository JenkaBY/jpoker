package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.factory.SuitFactory;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinder;
import by.jenka.jpoker.suit.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class HandMatcherBySuit extends AbstractHandMatcher {
    protected List<Integer> suitPositions;
    protected PositionFinder suitPositionFinder;

    public HandMatcherBySuit(List<Card> hand) {
        super(hand);
        this.suitPositions = new ArrayList<>(MAX_CARDS_ON_TABLE);
    }

    @Override
    public boolean isMatch() {
        return super.isMatch() && isMatchSumSuits();
    }

    @Override
    public List<Card> getWinnerCards() {
        return getUnlimitedWinnerCards().stream()
                .limit(getMinHandSize())
                .collect(toList());
    }

    @Override
    public List<Card> getUnlimitedWinnerCards() {
        return getWinnerHands(getWinnerSuitClasses())
                .collect(toList());
    }

    protected Stream<Card> getWinnerHands(List<Class<? extends Suit>> winnerSuitClasses) {
        return hand.stream()
                .filter(card -> winnerSuitClasses.contains(card.getSuit().getClass()))
                .sorted(CardComparator.ByRankReversedAndSuit);
    }

    protected List<Class<? extends Suit>> getWinnerSuitClasses() {
        return suitPositions.stream()
                .map(SuitFactory::getSuitFromPosition)
                .map(Suit::getClass)
                .collect(toList());
    }

    private boolean isMatchSumSuits() {
        suitPositionFinder.find();
        suitPositions.addAll(suitPositionFinder.getPositions());
        return suitPositionFinder.isMatch();
    }

    protected final String getSumSuitValues() {
        return String.format("%4d", getSumSuits());
    }

    private long getSumSuits() {
        return hand.stream()
                .map(Card::getSuit)
                .mapToLong(Suit::getValue)
                .sum();
    }
}
