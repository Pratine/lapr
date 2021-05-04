package lapr.project.utils;

/**
 * Represents a unit converter, that allows the conversion of units.
 *
 * @author salva
 */
public class UnitConverter {

    /**
     * Converts a distance from kilometers to meters.
     *
     * @param distance Distance that will be converted.
     * @return Distance in meters.
     */
    public static double kilometersToMeters(String distance) {
        double lengthKilometers = Double.parseDouble(distance.replaceAll("[^0-9.]", ""));

        return lengthKilometers * 1000;
    }

    /**
     * Converts a velocity from kilometers/hour to meters/second.
     *
     * @param velocity Velocity that will be converted.
     * @return Velocity in meters/second.
     */
    public static int kilometerPerHourToMetersPerSecond(String velocity) {
        int velocityKilometersPerHour = Integer.parseInt(velocity.replaceAll("[^0-9.]", ""));
        return velocityKilometersPerHour * 1000 / 3600;
    }
    
    /**
     * Converts a weight from kilograms to grams.
     *
     * @param weight Weight that will be converted.
     * @return Weight in grams.
     */
    public static double kilogramsToGrams(String weight){
        double grams = Double.parseDouble(weight.replaceAll("[^0-9.]", ""));
        return grams * 1000;
    }

    public static Double kilometerPerHourToMetersPerSecondDouble(String velocity) {
        Double velocityKilometersPerHour = Double.parseDouble(velocity.replaceAll("[^0-9.]", ""));
        return velocityKilometersPerHour * 1000 / 3600;
    }
}
