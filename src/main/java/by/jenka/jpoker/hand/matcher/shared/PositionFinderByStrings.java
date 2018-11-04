package by.jenka.jpoker.hand.matcher.shared;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class PositionFinderByStrings implements PositionFinder {
    protected String[] patterns;
    protected String input;
    protected final Set<Integer> foundPositions;

    public PositionFinderByStrings(String input, String... patterns) {
        this.patterns = patterns;
        this.input = input;
        this.foundPositions = new HashSet<>(7);
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
