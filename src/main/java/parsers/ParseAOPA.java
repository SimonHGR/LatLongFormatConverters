package parsers;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
Sample:

39.9534/-105.5286 39.9426/-105.676 40.0573/-106.3709
 */
public class ParseAOPA {
    public static double[] parseOnePairWithSlashes(String input) {
        String [] pair = input.split("/");
        assert pair.length == 2;
        double [] rv = new double[2];
        rv[0] = Double.parseDouble(pair[0]);
        rv[1] = Double.parseDouble(pair[1]);
        return rv;
    }

    public static final Pattern SPACE_SEPARATED = Pattern.compile("\\s+");
    public static Stream<double[]> parseSpaceSeparatedTextWithSlashes(String input) {
        return SPACE_SEPARATED.splitAsStream(input)
                .map(ParseAOPA::parseOnePairWithSlashes);
    }
}
