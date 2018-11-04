package by.jenka.jpoker.hand.matcher.position_finder;

import java.util.List;

public interface PositionFinder {
    void find();

    boolean isMatch();

    List<Integer> getPositions();
}
