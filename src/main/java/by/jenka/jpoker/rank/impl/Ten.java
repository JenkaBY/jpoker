package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Ten extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0054";
    }

    @Override
    public long getValue() {
        return 1_000_000_000L;
    }
}
