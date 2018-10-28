package by.jenka.jpoker.hand;

public interface Hand extends Comparable<Hand> {
    int getRankValue();

    @Override
    default int compareTo(Hand o) {
        return Integer.compare(getRankValue(), o.getRankValue());
    }
}
