package by.jenka.jpoker.rank;

public final class Eight extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0038";
    }

    @Override
    public long getValue() {
        return 10_000_000L;
    }
}
