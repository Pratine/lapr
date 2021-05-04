package lapr.project.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author vdjol
 */
public class MotorizationTest {

    public MotorizationTest() {
    }

    /**
     * Test of getById method, of class Motorization.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 1;
        String expResult = "combustion";
        String expResult1 = null;
        String result = Motorization.getById(id);
        String result1 = Motorization.getById(-1);
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
}
