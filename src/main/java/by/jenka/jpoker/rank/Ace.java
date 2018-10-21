package by.jenka.jpoker.rank;

public final class Ace extends FrenchRank {
    private int value = 15;

    @Override
    public String toUnicode() {
        return "\u0041";
    }

    @Override
    public int getValue() {
        return value;
    }

}
