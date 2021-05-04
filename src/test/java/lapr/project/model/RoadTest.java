/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Sousa
 */
public class RoadTest {

    private Road roadEx2;
    private Road roadEx1;
    private Road roadEx1Copy;

    public RoadTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        roadEx1 = new Road("Road ex1");
        roadEx1Copy = new Road("Road ex1");
        roadEx2 = new Road("Road ex2");
        roadEx1.setTypology(Typology.HIGHWAY);
        roadEx1Copy.setTypology(Typology.HIGHWAY);
        roadEx2.setTypology(Typology.ROAD);
        
        roadEx2.setToll(1, 1.26);
        roadEx2.setToll(2, 3.23);
        roadEx2.setToll(3, 5.43);
        
        roadEx1.setToll(1, 1.25);
        roadEx1.setToll(2, 3.00);
        roadEx1.setToll(3, 5.00);

        roadEx1Copy.setToll(1, 1.25);
        roadEx1Copy.setToll(2, 3.00);
        roadEx1Copy.setToll(3, 5.00);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Road.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Road ex1";
        String result = roadEx1.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Road.
     */
    @org.junit.Test
    public void testSetName() {
        System.out.println("setName");
        String name = "test";
        String expected = "test";
        Road instance = new Road();
        instance.setName(name);
        String result = instance.getName();
        assertEquals(expected, result);

    }

    /**
     * Test of setTypology method, of class Road.
     */
    @org.junit.Test
    public void testSetTypology() {
        System.out.println("setTypology");
        Typology typology = Typology.HIGHWAY;
        Road instance = new Road();
        instance.setTypology(typology);
        Typology expected = Typology.HIGHWAY;
        Typology result = instance.getTypology();
        assertEquals(expected, result
        );

    }

    /**
     * Test of getTollFare method, of class Road.
     */
    @org.junit.Test
    public void testGetTollFare() {
        System.out.println("getTollFare");
        Map<Integer, Double> expResult = new HashMap<>();
        expResult.put(1, 1.25);
        expResult.put(2, 3.00);
        expResult.put(3, 5.00);
        Map<Integer, Double> result = roadEx1.getTollFare();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Road.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Road r = new Road();
        boolean expResult = true;
        boolean expResult1 = false;
        boolean result = roadEx1.equals(roadEx1Copy);
        boolean result1 = r.equals(obj);
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
        
    }
    
    /**
     * Test of equals method, of class Gear.
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equalsFalse");
        
        Road instance = roadEx1;
        Road obj = roadEx2;
        
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
        
        Road instance = roadEx1;
        Road obj = roadEx1Copy;
        
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Road.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertTrue(roadEx1.hashCode() == roadEx1.hashCode());
    }
    /**
     * Test of compareTo method, of class Road.
     */
    @org.junit.Test
    public void testCompareTo() {
        System.out.println("compareTo");
        int expResult = 0;
        int result = roadEx1.compareTo(roadEx1Copy);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of toString method, of class Road.
//     */
//    @org.junit.Test
//    public void testToString() {
//        System.out.println("toString");
//        Road instance = new Road();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }
    /**
     * Test of validate method, of class Road.
     */
    @org.junit.Test
    public void testValidate() {
        System.out.println("validate");
        boolean expResult = true;
        boolean result = roadEx1.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypology method, of class Road.
     */
    @org.junit.Test
    public void testGetTypology() {
        System.out.println("getTypology");
        Typology expResult = Typology.HIGHWAY;
        Typology result = roadEx1.getTypology();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypologyName method, of class Road.
     */
    @org.junit.Test
    public void testGetTypologyName() {
        System.out.println("getTypologyName");
        String expResult = Typology.HIGHWAY.name();
        String result = roadEx1.getTypologyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setToll method, of class Road.
     */
    @org.junit.Test
    public void testSetToll() {
        System.out.println("setToll");
        Integer id = 1;
        Double fare = 1.25;
        Road instance = new Road();
        instance.setToll(id, fare);
        Map<Integer, Double> expResult = new HashMap<>();
        expResult.put(1, 1.25);
        Map<Integer, Double> result = instance.getTollFare();
        assertEquals(expResult, result);

    }

}
