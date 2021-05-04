package lapr.project.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author vdjol
 */
public class FuelTest {
    
    public FuelTest() {
    }
    /**
     * Test of getEnergyById method, of class Fuel.
     */
    @Test
    public void testGetEnergyById() {
        System.out.println("getEnergyById");
        int id = 1;
        
        double expResult = 48.0;
        double expResult2 = 0.0;
        double result = Fuel.getEnergyById(id);
        double result2 = Fuel.getEnergyById(-1);
        assertEquals(expResult, result, 0.0);
        assertEquals(expResult2, result2, 0.0);
    }
}
