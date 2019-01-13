package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Five extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0035";
    }

    @Override
    public long getValue() {
        return 10_000L;
    }
}
