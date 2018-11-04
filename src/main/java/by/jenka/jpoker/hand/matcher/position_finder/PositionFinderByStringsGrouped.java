package by.jenka.jpoker.hand.matcher.position_finder;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PositionFinderByStringsGrouped implements PositionFinder {
    private String[] patterns;
    private String input;
    private Map<String, List<Integer>> foundPositions;

    public PositionFinderByStringsGrouped(String input, String... patterns) {
        this.patterns = patterns;
        this.input = input;
        this.foundPositions = new HashMap<>(7);
    }

    @Override
    public void find() {
        Stream.of(patterns)
                .distinct()
                .forEach(pattern -> {
                    int currentPosition = 0;
                    List<Integer> positions = new ArrayList<>();
                    while (input.indexOf(pattern, currentPosition) != -1) {
                        currentPosition = input.indexOf(pattern, currentPosition);
                        positions.add(currentPosition++);
                    }
                    foundPositions.put(pattern, positions);
                });
    }

    @Override
    public boolean isMatch() {
        return getFlatPositions().size() >= patterns.length;
    }

    private List<Integer> getFlatPositions() {
        return foundPositions.values().stream()
                .filter(Objects::nonNull)
                .filter(positions -> positions.size() > 0)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    @Override
    public List<Integer> getPositions() {
        return getFlatPositions();
    }
}
