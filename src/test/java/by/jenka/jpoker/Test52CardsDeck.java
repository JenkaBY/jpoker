package by.jenka.jpoker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test52CardsDeck extends UtilsTest {

    @Test
    public void testSizeDeck52Cards() {
        Assertions.assertEquals(52, getDeck().getCards().size());
    }
}
