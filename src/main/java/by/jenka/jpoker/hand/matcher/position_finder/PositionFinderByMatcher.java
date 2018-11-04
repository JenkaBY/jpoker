package by.jenka.jpoker.hand.matcher.position_finder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class PositionFinderByMatcher implements PositionFinder {
    protected boolean isFoundOut;
    protected Matcher m;
    protected List<Integer> positions;

    public PositionFinderByMatcher(Matcher matcher) {
        this.m = matcher;
        positions = new ArrayList<>(7);
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
