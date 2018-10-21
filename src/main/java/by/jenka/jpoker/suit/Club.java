package by.jenka.jpoker.suit;

public class Club implements Suit {
    @Override
    public String toUnicode() {
        return "\u2663";
    }

    @Override
    public int getValue() {
        return 4;
    }
}
