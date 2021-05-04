/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salva
 */
public class JunctionTest {

    private Junction junctionEx1;
    private Junction junctionEx1Copy;
    private Junction junctionEx2;

    @Before

    public void setUp() {
        junctionEx1 = new Junction("n0");
        junctionEx1Copy = new Junction("n0");
        junctionEx2 = new Junction("n3");
    }

    /**
     * Test of getId method, of class Junction.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = "n0";
        String result = junctionEx1.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Junction.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String expected = "n2";
        Junction instance = new Junction();
        instance.setId("n2");
        String result = instance.getId();
        assertEquals(expected, result);
    }

    /**
     * Test of toString method, of class Junction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "n0";
        String result = junctionEx1.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Junction.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Segment s1 = new Segment();
        Project p1 = new Project();
        Junction j = new Junction();
        boolean expResult = true;
        boolean expResult2 = false;
        boolean result = junctionEx1.equals(junctionEx1Copy);
        boolean result1 = junctionEx1.equals(junctionEx1);
        boolean result2 = junctionEx1.equals(junctionEx2);
        boolean result4 = junctionEx1.equals(p1);
        boolean result3 = junctionEx1.equals(s1);
        boolean result5 = j.equals(obj);
        assertEquals(expResult, result);
        assertEquals(expResult, result1);
        assertEquals(expResult2, result3);
        assertEquals(expResult2, result2);
        assertEquals(expResult2, result4);
        assertEquals(expResult2, result5);
    }
    
    /**
     * Test of hashCode method, of class Junction.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 3723;
        int result = junctionEx1.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Junction.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Junction j1 = new Junction();
        j1.setId(null);
        boolean expResult = true;
        boolean expResult1 = false;
        boolean result = junctionEx1.validate();
        boolean result1 = new Junction().validate();
        boolean result2 = j1.validate();
        assertEquals(expResult, result);
        assertFalse(result1);
        assertEquals(expResult1, result2);
    }

}
