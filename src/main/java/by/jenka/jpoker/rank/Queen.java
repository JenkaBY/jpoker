package by.jenka.jpoker.rank;

public final class Queen extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0051";
    }

    @Override
    public long getValue() {
        return 100_000_000_000L;
    }
}
