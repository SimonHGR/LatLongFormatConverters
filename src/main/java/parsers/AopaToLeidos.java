package parsers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class AopaToLeidos {
    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .flatMap(ParseAOPA::parseSpaceSeparatedTextWithSlashes)
                .map(LatLongPair::of)
                .map(LatLongPair::asLeidosFormat)
                .forEachOrdered(System.out::println);
    }
}
