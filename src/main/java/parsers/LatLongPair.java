package parsers;

public class LatLongPair {
    private double latitude;
    private double longitude;

    private LatLongPair(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static LatLongPair of(double[] latlong) {
        return new LatLongPair(latlong[0], latlong[1]);
    }

    public static LatLongPair of(double latitude, double longitude) {
        return new LatLongPair(latitude, longitude);
    }

/*
Leidos format
8-12 character latitude/longitude in the format aabb(A)(/)(c)ccdd(B), where parentheses denote optional characters
aa is degrees latitude in the range 00-90
bb is minutes latitude in the range 00-59
(c)cc is degrees longitude in the range 00-180
dd is minutes longitude in the range 00-59
(A) is either N or S (North or South, default to N if unspecified)
(B) is either W or E (West or East, default to W if unspecified)
Valid formats are aabb/ccdd, aabbA/ccddB, aabb/cccdd, aabbAcccddB and aabbA/cccddB
     */

//    public String asDDMMSS() {
//    }
    public static String asDDMMNS(double decimal) {
        int degrees = (int)decimal;
        double fraction = decimal - degrees;
        int mins = (int)(fraction * 60);
        return String.format("%02d%02d%1s", degrees, mins, (decimal >= 0 ? "N" : "S"));
    }

    public static final double HALF_MINUTE = 0.5 / 60.0;
    public static String asDDDMMEW(double decimal) {
        boolean positive = decimal >= 0;
        decimal = Math.abs(decimal);
        int degrees = (int)decimal;
        double fraction = decimal - degrees;
        int mins = (int)((fraction + HALF_MINUTE) * 60);
        return String.format("%03d%02d%1s", degrees, mins, (positive ? "E" : "W"));
    }

    public String asLeidosFormat() {
        return asDDMMNS(latitude) + "/" + asDDDMMEW(longitude);
    }
}
