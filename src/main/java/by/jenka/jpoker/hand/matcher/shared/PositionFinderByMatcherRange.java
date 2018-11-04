package by.jenka.jpoker.hand.matcher.shared;

import java.util.regex.Matcher;
import java.util.stream.IntStream;

public class PositionFinderByMatcherRange extends PositionFinderByMatcher {
    public PositionFinderByMatcherRange(Matcher matcher) {
        super(matcher);
    }

    public void find() {
        while (m.find()) {
            IntStream.range(m.start(), m.end()).forEach(positions::add);
        }
        isFoundOut = true;
    }
}
