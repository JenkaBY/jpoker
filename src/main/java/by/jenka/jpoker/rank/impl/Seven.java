package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Seven extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0037";
    }

    @Override
    public long getValue() {
        return 1000000L;
    }
}
