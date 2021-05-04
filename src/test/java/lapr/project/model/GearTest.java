package lapr.project.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author vdjol
 */
public class GearTest {

    private Gear gearEx1;

    @Before
    public void setUp() {
        gearEx1 = new Gear(4.5);
    }

    /**
     * Test of getRatio method, of class Gear.
     */
    @Test
    public void testGetRatio() {
        System.out.println("getRatio");
        double expResult = 4.5;
        double result = gearEx1.getRatio();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setRatio method, of class Gear.
     */
    @Test
    public void testSetRatio() {
        System.out.println("setRatio");
        Gear instance = new Gear();
        double expResult = 1.43;
        instance.setRatio(expResult);
        double result = instance.getRatio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class Gear.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Gear g1 = new Gear();
        Gear instance = new Gear(4.5);
        
        boolean expResult1 = false;
        boolean result1 = g1.equals(obj);
        boolean expResult = true;
        boolean result = instance.equals(gearEx1) && gearEx1.equals(instance);
        boolean result2 = instance.equals(new Gear());
        
        assertEquals(expResult, result);
        assertFalse(result2);
        assertEquals(expResult1, result1);
    }
     
    /**
     * Test of equals method, of class Gear.
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equalsFalse");

        Gear instance = new Gear();
        Gear obj = new Gear();

        instance.setRatio(1.33);
        obj.setRatio(1.01);

        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals true method, of class Gear.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("equalsTrue");

        Gear instance = new Gear();
        Gear obj = new Gear();
        instance.setRatio(1.33);
        obj.setRatio(1.33);

        Gear g = null;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        boolean result0 = instance.equals(instance);
        boolean result1 = instance.equals(new Regime());
        boolean result2 = instance.equals(new Gear());
        boolean result3 = instance.equals(g);
        assertEquals(expResult, result);
        assertEquals(expResult, result0);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);

    }

    /**
     * Test of hashCode method, of class Gear.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 1074921843;
        int result = gearEx1.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Gear.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tRatio: ").append("4.5").append("\n");
        String result = gearEx1.toString();
        String expResult = sb.toString();
        assertEquals(expResult, result);
    }
}
