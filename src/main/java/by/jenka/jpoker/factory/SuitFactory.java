package by.jenka.jpoker.factory;

import by.jenka.jpoker.suit.*;

public class SuitFactory {
    public static Suit getSuitFromPosition(int position) {
        switch (position) {
            case 0:
                return new Club();
            case 1:
                return new Diamond();
            case 2:
                return new Spide();
            case 3:
                return new Heart();
            default:
                throw new RuntimeException("Invalid value of position: " + position);
        }
    }
}
