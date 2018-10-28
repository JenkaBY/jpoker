package by.jenka.jpoker.rank;

public abstract class FrenchRank implements Rank {
    @Override
    public int hashCode() {
        return Long.hashCode(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Rank)) {
            return false;
        }
        return this.getValue() == ((Rank) obj).getValue();
    }

    @Override
    public String toString() {
        return toUnicode();
    }
}
