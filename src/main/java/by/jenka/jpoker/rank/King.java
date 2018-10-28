package by.jenka.jpoker.rank;

public final class King extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u004B";
    }

    @Override
    public long getValue() {
        return 1_000_000_000_000L;
    }
}
