/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Tiago Sousa
 */
public class ThrottleTest {

    private Throttle throttleEx1;
    private Throttle throttleEx1Copy;

    @Before
    public void setUp() {
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);

        throttleEx1 = new Throttle(25);
        throttleEx1.addRegime(reg251);
        throttleEx1.addRegime(reg252);
        throttleEx1.addRegime(reg253);
        throttleEx1.addRegime(reg254);
        throttleEx1.addRegime(reg255);

        throttleEx1Copy = new Throttle(25);
        throttleEx1Copy.addRegime(reg251);
        throttleEx1Copy.addRegime(reg252);
        throttleEx1Copy.addRegime(reg253);
        throttleEx1Copy.addRegime(reg254);
        throttleEx1Copy.addRegime(reg255);
    }

    /**
     * Test of getRegimeList method, of class Throttle.
     */
    @org.junit.Test
    public void testGetRegimeList() {
        System.out.println("getRegimeList");
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);

        Throttle throttle = new Throttle(25);
        throttle.addRegime(reg251);
        throttle.addRegime(reg252);
        throttle.addRegime(reg253);
        throttle.addRegime(reg254);
        throttle.addRegime(reg255);
        LinkedList<Regime> expected = throttle.getRegimeList();
        LinkedList<Regime> result = throttleEx1.getRegimeList();
        assertEquals(expected, result);
    }

    /**
     * Test of addRegime method, of class Throttle.
     */
    @org.junit.Test
    public void testAddRegime() {
        System.out.println("addRegime");
        Regime reg = new Regime(115, 900, 1499, 500);
        Throttle instance = new Throttle(25);
        instance.addRegime(reg);
        LinkedList<Regime> expected = new LinkedList<>();
        expected.add(new Regime(115, 900, 1499, 500));
        LinkedList<Regime> result = instance.getRegimeList();
        assertEquals(expected, result);
    }

    /**
     * Test of equals method, of class Throttle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = throttleEx1.equals(throttleEx1Copy);
        boolean result1 = throttleEx1.equals(throttleEx1);
        boolean result2 = throttleEx1.equals(new Regime());
        boolean result3 = throttleEx1.equals(new Throttle(50));
        Throttle t = null;
        boolean result4 = throttleEx1.equals(t);

        assertEquals(expResult, result);
        assertEquals(expResult, result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

    /**
     * Test of hashCode method, of class Throttle.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 578;
        int result = throttleEx1.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Throttle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tIdThrottle: ").append("25").append("\n");
        sb.append("\t\tRegistRegime: ").append(throttleEx1.getRegimeList().toString()).append("\n");
        String expected = sb.toString();
        String result = throttleEx1.toString();
        assertEquals(expected, result);
    }

}
