package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Ace extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0041";
    }

    @Override
    public long getValue() {
        return 10_000_000_000_001L;
    }
}
