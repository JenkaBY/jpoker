package by.jenka.jpoker.suit.impl;

import by.jenka.jpoker.suit.AbstractSuit;

public class Diamond extends AbstractSuit {
    @Override
    public String toUnicode() {
        return "\u2666";
    }

    @Override
    public long getValue() {
        return 100L;
    }
}
