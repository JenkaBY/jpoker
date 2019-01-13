package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Nine extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0039";
    }

    @Override
    public long getValue() {
        return 100000000L;
    }
}
