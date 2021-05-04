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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Sousa
 */
public class RegistThrottleTest {
    
    private RegistThrottle registThottle;
    private RegistThrottle registThottleCopy;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        registThottle = new RegistThrottle();
        registThottleCopy = new RegistThrottle();
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
        
        registThottle.addThrottle(throttle);
        registThottleCopy.addThrottle(throttle);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getThrottleList method, of class RegistThrottle.
     */
    @org.junit.Test
    public void testGetThrottleList() {
        System.out.println("getThrottleList");
        LinkedList<Throttle> instance = new LinkedList<>();
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
        
        instance.add(throttle);
        
        LinkedList<Throttle> expResult = instance;
        LinkedList<Throttle> result = registThottle.getThrottleList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addThrottle method, of class RegistThrottle.
     */
    @org.junit.Test
    public void testAddThrottle() {
        System.out.println("addThrottle");
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
        
        RegistThrottle instance = new RegistThrottle();
        instance.addThrottle(throttle);
        LinkedList<Throttle> result = instance.getThrottleList();
        LinkedList<Throttle> expected = registThottle.getThrottleList();
        assertEquals(expected, result);
    }

    /**
     * Test of equals method, of class RegistThrottle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = registThottle.equals(registThottleCopy);
        boolean result1 = registThottle.equals(registThottle);
        boolean result2 = registThottle.equals(new RegistThrottle());
        RegistThrottle regist = null;
        boolean result3 = registThottle.equals(regist);
        assertEquals(expResult, result);
        assertEquals(expResult, result1);
        assertFalse(result2);
        assertFalse(result2);
        assertFalse(result3);
    }

    /**
     * Test of hashCode method, of class RegistThrottle.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        RegistThrottle instance = new RegistThrottle();
        int expResult = 486;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
}
