package by.jenka.jpoker.hand.matcher.shared;

import java.util.List;

public interface PositionFinder {
    void find();

    boolean isMatch();

    List<Integer> getPositions();
}
