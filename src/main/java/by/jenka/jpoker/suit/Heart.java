package by.jenka.jpoker.suit;

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
