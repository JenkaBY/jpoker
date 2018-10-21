package by.jenka.jpoker.suit;

public class Heart implements Suit {
    @Override
    public String toUnicode() {
        return "\u2665";
    }

    @Override
    public int getValue() {
        return 1;
    }
}
