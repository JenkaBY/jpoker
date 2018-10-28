package by.jenka.jpoker.rank;

public final class Six extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0036";
    }

    @Override
    public long getValue() {
        return 100000L;
    }
}
