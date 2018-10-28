package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.factory.RankFactory;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.suit.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class HandMatcher {
    protected List<Card> hand;
    protected List<Integer> positionRankMatcher;
    protected List<Integer> positionSuitMatcher;

    public HandMatcher(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getWinnerCards() {
//        TODO what happens if length of ranks will not equal 14??
        List<Class<? extends Rank>> pairCardClasses = positionRankMatcher.stream()
                .map(RankFactory::getRankFromPosition)
                .map(Rank::getClass)
                .collect(Collectors.toList());

        return hand.stream()
                .filter(card -> pairCardClasses.contains(card.getRank().getClass()))
                .collect(Collectors.toList());
    }

    public final boolean isMatch() {
        if (!hasMinSize()) {
            positionSuitMatcher = Collections.EMPTY_LIST;
            positionRankMatcher = Collections.EMPTY_LIST;
            return false;
        }
        boolean isMatch = isMatchSumRanks();
        if (isNeedCheckSuits()) {
            isMatch = isMatch && isMatchSumSuits();
        }
        return isMatch;
    }

    private boolean isMatchSumRanks() {
        Matcher m = getPatternForRanks().matcher(getSumRankValues());
        FinderMatchedPosition finder = new FinderMatchedPosition(m);
        finder.find();
        positionRankMatcher = finder.getPositions();
        return finder.isMatch();
    }

    private boolean isMatchSumSuits() {
        Matcher m = getPatternForSuits().matcher(getSumSuitValues());
        FinderMatchedPosition finder = new FinderMatchedPosition(m);
        finder.find();
        positionSuitMatcher = finder.getPositions();
        return finder.isMatch();
    }

    protected boolean isNeedCheckSuits() {
        return false;
    }

    private boolean hasMinSize() {
        return hand.size() >= minHandSize();
    }

    private String getSumRankValues() {
        return String.valueOf(getSumRanks());
    }

    private long getSumRanks() {
        return hand.stream()
                .map(Card::getRank)
                .mapToLong(Rank::getValue)
                .sum();
    }

    private String getSumSuitValues() {
        return String.valueOf(getSumSuits());
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

    private static class FinderMatchedPosition {
        private boolean isFoundOut;
        private Matcher m;
        private List<Integer> positions;

        FinderMatchedPosition(Matcher matcher) {
            this.m = matcher;
            positions = new ArrayList<>(4);
        }

        void find() {
            if (m.find()) {
                positions.add(m.start());
                while (m.find()) {
                    positions.add(m.start());
                }
            }
            isFoundOut = true;
        }

        boolean isMatch() {
            if (!isFoundOut) {
                throw new RuntimeException("The 'find()' method must be called before.");
            }
            return !positions.isEmpty();
        }

        List<Integer> getPositions() {
            return positions;
        }
    }
}
