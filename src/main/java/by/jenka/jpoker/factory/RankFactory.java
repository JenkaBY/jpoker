package by.jenka.jpoker.factory;

import by.jenka.jpoker.rank.*;

public class RankFactory {
    public static Rank getRankFromPosition(int position) {
        switch (position) {
            case 0:
            case 13:
                return new Ace();
            case 1:
                return new King();
            case 2:
                return new Queen();
            case 3:
                return new Jack();
            case 4:
                return new Ten();
            case 5:
                return new Nine();
            case 6:
                return new Eight();
            case 7:
                return new Seven();
            case 8:
                return new Six();
            case 9:
                return new Five();
            case 10:
                return new Four();
            case 11:
                return new Three();
            case 12:
                return new Two();
            default:
                throw new RuntimeException("Invalid value of position: " + position);
        }
    }
}
