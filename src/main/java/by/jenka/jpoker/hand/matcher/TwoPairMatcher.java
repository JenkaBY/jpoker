package by.jenka.jpoker.hand.matcher;

import by.jenka.jpoker.card.Card;
import by.jenka.jpoker.hand.matcher.shared.HandMatcherByRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TwoPairMatcher extends HandMatcherByRank {
    private final static String[] PATTERNS = new String[]{"2", "2"};
    public TwoPairMatcher(List<Card> hand) {
        super(hand);
    }

    @Override
    protected int minHandSize() {
        return 4;
    }

    @Override
    protected Pattern getPatternForRanks() {
        return null;
    }

    @Override
    protected Pattern getPatternForSuits() {
        return null;
    }

    protected boolean isMatchSumRanks() {
        PositionFinder finder = new PositionFinderByStrings(getSumRankValues(), PATTERNS);
        finder.find();
        rankPositions = finder.getPositions();
        return finder.isMatch();
    }

    protected boolean isMatchSumSuits() {
        return false;
    }

    protected class PositionFinderByStrings implements PositionFinder {
        private String[] patterns;
        private String input;
        private final Set<Integer> foundPositions;

        public PositionFinderByStrings(String input, String... patterns) {
            this.patterns = patterns;
            this.input = input;
            this.foundPositions = new HashSet<>(4);
        }

        @Override
        public void find() {
            Stream.of(patterns)
                    .distinct()
                    .forEach(pattern -> {
                        int currentPosition = 0;
                        while (input.indexOf(pattern, currentPosition) != -1) {
                            currentPosition = input.indexOf(pattern, currentPosition);
                            foundPositions.add(currentPosition++);
                        }
                    });
        }

        @Override
        public boolean isMatch() {
            return foundPositions.size() >= patterns.length;
        }

        @Override
        public List<Integer> getPositions() {
            return new ArrayList<>(foundPositions);
        }
    }
}
