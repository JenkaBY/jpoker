package by.jenka.jpoker.rank;

public final class Three extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0033";
    }

    @Override
    public int getValue() {
        return 3;
    }
}
