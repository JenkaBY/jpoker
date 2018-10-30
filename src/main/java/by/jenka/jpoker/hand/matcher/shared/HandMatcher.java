package by.jenka.jpoker.hand.matcher.shared;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.suit.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HandMatcher {
    protected List<Card> hand;
    protected List<Integer> rankPositions;
    protected List<Integer> suitPositions;

    public HandMatcher(List<Card> hand) {
        this.hand = hand;
    }

    public abstract List<Card> getWinnerCards();

    public final boolean isMatch() {
        if (!hasMinSize()) {
            suitPositions = Collections.EMPTY_LIST;
            rankPositions = Collections.EMPTY_LIST;
            return false;
        }
        boolean isMatch = isMatchSumRanks();
        if (isNeedCheckSuits()) {
            isMatch = isMatch && isMatchSumSuits();
        }
        return isMatch;
    }

    protected boolean isMatchSumRanks() {
        Matcher m = getPatternForRanks().matcher(getSumRankValues());
        PositionFinder finder = new FinderMatchedPosition(m);
        finder.find();
        rankPositions = finder.getPositions();
        return finder.isMatch();
    }

    protected boolean isMatchSumSuits() {
        Matcher m = getPatternForSuits().matcher(getSumSuitValues());
        PositionFinder finder = new FinderMatchedPosition(m);
        finder.find();
        suitPositions = finder.getPositions();
        return finder.isMatch();
    }

    protected boolean isNeedCheckSuits() {
        return false;
    }

    private boolean hasMinSize() {
        return hand.size() >= minHandSize();
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

    protected final String getSumSuitValues() {
        return String.format("%4d", getSumSuits());
    }

    private long getSumSuits() {
        return hand.stream()
                .map(Card::getSuit)
                .mapToLong(Suit::getValue)
                .sum();
    }

    protected abstract int minHandSize();

    protected abstract Pattern getPatternForRanks();

    protected abstract Pattern getPatternForSuits();

    protected interface PositionFinder {
        void find();

        boolean isMatch();

        List<Integer> getPositions();
    }

    private static class FinderMatchedPosition implements PositionFinder {
        private boolean isFoundOut;
        private Matcher m;
        private List<Integer> positions;

        FinderMatchedPosition(Matcher matcher) {
            this.m = matcher;
            positions = new ArrayList<>(4);
        }

        public void find() {
            while (m.find()) {
                positions.add(m.start());
            }
            isFoundOut = true;
        }

        public boolean isMatch() {
            if (!isFoundOut) {
                throw new RuntimeException("The 'find()' method must be called before.");
            }
            return !positions.isEmpty();
        }

        public List<Integer> getPositions() {
            return positions;
        }
    }
}
