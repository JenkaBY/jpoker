package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Four extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0034";
    }

    @Override
    public long getValue() {
        return 1_000L;
    }
}
