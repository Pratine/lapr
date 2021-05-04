package lapr.project.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author vdjol
 */
public class UnitConverterTest {

    /**
     *
     */
    public UnitConverterTest() {
    }

    /**
     * Test of KilometersToMeters method, of class UnitConverter.
     */
    @Test
    public void testKilometersToMeters() {
        System.out.println("KilometersToMeters");
        String length = "1.3 KM";
        Double expResult = 1300.0;

        Double result = UnitConverter.kilometersToMeters(length);

        assertEquals(expResult, result, 0.0000001f);
    }

    /**
     * Test of KilometersPerHourToMetersPerSecond method, of class
     * UnitConverter.
     */
    @Test
    public void testKilometersPerHourToMetersPerSecond() {
        System.out.println("KilometersPerHourToMetersPerSecond");
        String velocity = "120 KM/H";
        String expResult = "33";

        String result = String.format("%02d", UnitConverter.kilometerPerHourToMetersPerSecond(velocity));

        assertTrue("Expected 33", result.equals(expResult));
    }

    /**
     * Test of KilometersToGrams method, of class UnitConverter.
     */
    @Test
    public void testKilogramsToGrams() {
        System.out.println("KilogramsToGrams");
        String weight = "1.8 KG";
        Double expResult = 1800.0;

        Double result = UnitConverter.kilogramsToGrams(weight);

        assertEquals(expResult, result, 0.0000001f);
    }
}
