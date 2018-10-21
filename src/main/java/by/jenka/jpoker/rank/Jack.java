package by.jenka.jpoker.rank;

public final class Jack extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u004A";
    }

    @Override
    public int getValue() {
        return 12;
    }
}
