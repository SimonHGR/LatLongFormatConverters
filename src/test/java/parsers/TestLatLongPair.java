package parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLatLongPair {
    @Test
    public void testAsDDMMNS() {
        double decimal = 55.1;
        String dmns = LatLongPair.asDDMMNS(decimal);
        Assertions.assertEquals("5506N", dmns);
    }
    @Test
    public void testAsDDDMMEW() {
        double decimal = -105.1;
        String dmns = LatLongPair.asDDDMMEW(decimal);
        Assertions.assertEquals("10506W", dmns);
    }
}
