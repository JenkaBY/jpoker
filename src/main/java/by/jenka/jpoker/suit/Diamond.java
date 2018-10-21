package by.jenka.jpoker.suit;

public class Diamond implements Suit {
    @Override
    public String toUnicode() {
        return "\u2666";
    }

    @Override
    public int getValue() {
        return 2;
    }
}
