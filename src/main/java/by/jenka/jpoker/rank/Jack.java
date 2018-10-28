package by.jenka.jpoker.rank;

public final class Jack extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u004A";
    }

    @Override
    public long getValue() {
        return 10_000_000_000L;
    }
}
