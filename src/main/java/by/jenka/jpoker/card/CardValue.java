package by.jenka.jpoker.card;

public class CardValue {
    private long suitValue;
    private long rankValue;

    private CardValue() {
    }

    ;

    public CardValue(long suitValue, long rankValue) {
        this.suitValue = suitValue;
        this.rankValue = rankValue;
    }

    public static CardValueBuilder withSuitValue(long suitValue) {
        return new CardValueBuilder(suitValue);
    }

    public static class CardValueBuilder {
        private long suitValue;

        CardValueBuilder(long suitValue) {
            this.suitValue = suitValue;
        }

        public CardValue withRankValue(long rankValue) {
            return new CardValue(suitValue, rankValue);
        }
    }
}
