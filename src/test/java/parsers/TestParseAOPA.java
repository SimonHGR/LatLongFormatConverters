package parsers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestParseAOPA {
    @Test
    public void testParseSlashPair() {
        String source = "39.9534/-105.5286";
        double [] res = ParseAOPA.parseOnePairWithSlashes(source);
        Assertions.assertArrayEquals(new double[]{39.9534, -105.5286}, res, 0.0001);
    }

/*
39.9534/-105.5286 39.9426/-105.676 40.0573/-106.3709
*/
    @Test
    public void testSpaceSeparatedStream() {
        String source = "39.9534/-105.5286 39.9426/-105.676 40.0573/-106.3709";
        double [][] expected = {{39.9534, -105.5286}, {39.9426, -105.676}, {40.0573, -106.3709}};
        Object[] actual = ParseAOPA.parseSpaceSeparatedTextWithSlashes(source).toArray();
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], (double[])actual[i], 0.0001);
        }
    }

}
