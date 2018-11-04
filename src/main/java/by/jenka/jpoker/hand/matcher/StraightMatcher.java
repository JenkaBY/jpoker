package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.common.StreamUtil;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;
import by.jenka.jpoker.hand.matcher.shared.PositionFinderByMatcherRange;
import by.jenka.jpoker.rank.Ace;
import by.jenka.jpoker.rank.Rank;
import by.jenka.jpoker.rank.Two;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StraightMatcher extends HandMatcherByRank {
    private static final Pattern PATTERN_RANKS = Pattern.compile("[123]{5,}");

    public StraightMatcher(List<Card> hand) {
        super(hand);
        this.minHandSize = 5;
        Matcher m = PATTERN_RANKS.matcher(getSumRankValues());
        rankPositionFinder = new PositionFinderByMatcherRange(m);
    }

    @Override
    public List<Card> getWinnerCards() {
        List<Class<? extends Rank>> winnerRankClasses = getWinnerRankClasses();

        if (winnerRankClasses.isEmpty()) {
            return new ArrayList<>(0);
        }
        final List<Card> winnerCards = super.getWinnerHands(winnerRankClasses)
                .filter(StreamUtil.distinctByKey(Card::getRank))
                .limit(getMinHandSize())
                .collect(toList());

        final Card highCard = winnerCards.get(0);
        final boolean isHighCardAce = highCard.getRank().getClass().equals(Ace.class);

        final Card lowCard = winnerCards.get(winnerCards.size() - 1);
        final boolean isLowCardTwo = lowCard.getRank().getClass().equals(Two.class);

        if (isHighCardAce && isLowCardTwo) {
            winnerCards.remove(0);
            winnerCards.add(highCard);
            return winnerCards;
        }
        return winnerCards;
    }
}
