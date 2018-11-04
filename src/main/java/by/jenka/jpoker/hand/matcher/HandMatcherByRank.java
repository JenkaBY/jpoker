package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.card.sorting.CardComparator;
import by.jenka.jpoker.factory.RankFactory;
import by.jenka.jpoker.hand.matcher.position_finder.PositionFinder;
import by.jenka.jpoker.rank.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class HandMatcherByRank extends AbstractHandMatcher {
    protected List<Integer> rankPositions;
    protected PositionFinder rankPositionFinder;

    public HandMatcherByRank(List<Card> hand) {
        super(hand);
        this.rankPositions = new ArrayList<>(MAX_CARDS_ON_TABLE);
    }

    @Override
    public boolean isMatch() {
        return super.isMatch() && isMatchSumRanks();
    }

    @Override
    public List<Card> getWinnerCards() {
        return getUnlimitedWinnerCards().stream()
                .limit(getMinHandSize())
                .collect(toList());
    }

    @Override
    public List<Card> getUnlimitedWinnerCards() {
        return getWinnerHands(getWinnerRankClasses())
                .collect(toList());
    }

    protected Stream<Card> getWinnerHands(List<Class<? extends Rank>> winnerRankClasses) {
        return hand.stream()
                .filter(card -> winnerRankClasses.contains(card.getRank().getClass()))
                .sorted(CardComparator.ByRankReversedAndSuit);
    }

    protected List<Class<? extends Rank>> getWinnerRankClasses() {
        return rankPositions.stream()
                .map(RankFactory::getRankFromPosition)
                .map(Rank::getClass)
                .collect(toList());
    }

    private boolean isMatchSumRanks() {
        rankPositionFinder.find();
        rankPositions.addAll(rankPositionFinder.getPositions());
        return rankPositionFinder.isMatch();
    }

    protected final String getSumRankValues() {
        return String.format("%14d", getSumRanks());
    }

    private long getSumRanks() {
        return hand.stream()
                .map(Card::getRank)
                .mapToLong(Rank::getValue)
                .sum();
    }
}
