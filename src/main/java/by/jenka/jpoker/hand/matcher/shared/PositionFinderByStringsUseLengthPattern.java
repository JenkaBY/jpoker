package by.jenka.jpoker.hand.matcher.shared;

import java.util.stream.Stream;

public class PositionFinderByStringsUseLengthPattern extends PositionFinderByStrings {
    public PositionFinderByStringsUseLengthPattern(String input, String... patterns) {
        super(input, patterns);
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
        return foundPositions.size() >= 5;
    }
}
