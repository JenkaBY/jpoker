package by.jenka.jpoker.suit;

public class Spide extends AbstractSuit {
    @Override
    public String toUnicode() {
        return "\u2660";
    }

    @Override
    public long getValue() {
        return 10L;
    }
}
