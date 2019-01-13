package by.jenka.jpoker.suit.impl;

import by.jenka.jpoker.suit.AbstractSuit;

public class Club extends AbstractSuit {
    @Override
    public String toUnicode() {
        return "\u2663";
    }

    @Override
    public long getValue() {
        return 1_000L;
    }
}
