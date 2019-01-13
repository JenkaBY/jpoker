package by.jenka.jpoker.rank.impl;

import by.jenka.jpoker.rank.FrenchRank;

public final class Two extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0032";
    }

    @Override
    public long getValue() {
        return 10L;
    }
}
