package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Six extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0036";
    }

    @Override
    public long getValue() {
        return 100000L;
    }
}
