package by.jenka.jpoker.rank;

public final class Seven extends FrenchRank {
    @Override
    public String toUnicode() {
        return "\u0037";
    }

    @Override
    public long getValue() {
        return 1000000L;
    }
}
