package by.jenka.jpoker.suit;

public class Spide implements Suit {
    @Override
    public String toUnicode() {
        return "\u2660";
    }

    @Override
    public int getValue() {
        return 3;
    }
}
