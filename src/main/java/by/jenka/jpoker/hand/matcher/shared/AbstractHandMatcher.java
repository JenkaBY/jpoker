package by.jenka.jpoker.hand.matcher.shared;

import by.jenka.jpoker.card.Card;

import java.util.List;

public abstract class AbstractHandMatcher implements HandMatcher {
    protected static short MAX_CARDS_IN_HAND = 7;
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

    ;
//    public final boolean isMatch() {
//        if (!hasMinSize()) {
//            suitPositions = Collections.EMPTY_LIST;
//            rankPositions = Collections.EMPTY_LIST;
//            return false;
//        }
//        boolean isMatch = isMatchSumRanks();
//        if (isNeedCheckSuits()) {
//            isMatch = isMatch && isMatchSumSuits();
//        }
//        return isMatch;

//    }
//    protected boolean isMatchSumRanks() {
//        Matcher m = getPatternForRanks().matcher(getSumRankValues());
//        PositionFinder finder = new PositionFinderByMatcher(m);
//        finder.find();
//        rankPositions = finder.getPositions();
//        return finder.isMatch();

//    }
//    protected boolean isMatchSumSuits() {
//        Matcher m = getPatternForSuits().matcher(getSumSuitValues());
//        PositionFinder finder = new PositionFinderByMatcher(m);
//        finder.find();
//        suitPositions = finder.getPositions();
//        return finder.isMatch();

//    }

//    protected final String getSumSuitValues() {
//        return String.format("%4d", getSumSuits());
//    }
//
//    private long getSumSuits() {
//        return hand.stream()
//                .map(Card::getSuit)
//                .mapToLong(Suit::getValue)
//                .sum();
//    }


//    protected abstract Pattern getPatternForRanks();

//    protected abstract Pattern getPatternForSuits();
}
