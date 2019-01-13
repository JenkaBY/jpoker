package by.jenka.jpoker.suit.impl;

import by.jenka.jpoker.suit.AbstractSuit;

public class Heart extends AbstractSuit {
    @Override
    public String toUnicode() {
        return "\u2665";
    }

    @Override
    public long getValue() {
        return 1L;
    }
}
