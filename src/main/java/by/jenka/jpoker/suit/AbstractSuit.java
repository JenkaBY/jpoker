package by.jenka.jpoker.suit;

public abstract class AbstractSuit implements Suit {
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

        if (!(obj instanceof Suit)) {
            return false;
        }
        return getValue() == ((Suit) obj).getValue();
    }
}
