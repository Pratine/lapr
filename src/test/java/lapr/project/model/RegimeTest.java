/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rgcar
 */
public class RegimeTest {
    

    public RegimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTorqueLow method, of class Regime.
     */
    @Test
    public void testGetTorqueLow() {
        System.out.println("getTorqueLow");
        Regime instance = new Regime();
        int expResult = 0;
        int result = instance.getTorqueLow();
        assertEquals(expResult, result);
        
        instance.setTorqueLow(-1);
        int expResult1 = 0;
        int result1 = instance.getTorqueLow();
        assertEquals(expResult1, result1);
        
        instance.setTorqueLow(1);
        int expResult2 = 1;
        int result2 = instance.getTorqueLow();
        assertEquals(expResult2, result2);
        
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        int expResult3 = 115;
        int result3 = reg251.getTorqueLow();
        assertEquals(expResult3, result3);
        
        Regime reg257 = new Regime(175, 166, 3500, 4499);
        int expResult4 = 175;
        int result4 = reg257.getTorqueLow();
        assertEquals(expResult4, result4);
       
    }

//    /**
//     * Test of getTorqueHigh method, of class Regime.
//     */
    @Test
    public void testGetTorqueHigh() {
        Regime instance = new Regime();
        int expResult = 0;
        int result = instance.getTorqueHigh();
        assertEquals(expResult, result);
        
        instance.setTorqueHigh(-1);
        int expResult1 = 0;
        int result1 = instance.getTorqueHigh();
        assertEquals(expResult1, result1);
        
        instance.setTorqueHigh(1);
        int expResult2 = 1;
        int result2 = instance.getTorqueHigh();
        assertEquals(expResult2, result2);
        
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        int expResult3 = 125;
        int result3 = reg251.getTorqueHigh();
        assertEquals(expResult3, result3);
        
        Regime reg257 = new Regime(175, 166, 3500, 4499);
        int expResult4 = 166;
        int result4 = reg257.getTorqueHigh();
        assertEquals(expResult4, result4);
       
    }
//
//    /**
//     * Test of getRpmLow method, of class Regime.
//     */
    @Test
    public void testGetRpmLow() {
        System.out.println("getRpmLow");
        Regime instance = new Regime();
        int expResult = 0;
        int result = instance.getRpmLow();
        assertEquals(expResult, result);
        
        instance.setRpmLow(-1); 
        int expResult1 = 0;
        int result1 = instance.getRpmLow();
        assertEquals(expResult1, result1);
        
        instance.setRpmLow(1);
        int expResult2 = 1;
        int result2 = instance.getRpmLow();
        assertEquals(expResult2, result2);
        
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        int expResult3 = 900;
        int result3 = reg251.getRpmLow();
        assertEquals(expResult3, result3);
        
        Regime reg257 = new Regime(175, 166, 3500, 4499);
        int expResult4 = 3500;
        int result4 = reg257.getRpmLow();
        assertEquals(expResult4, result4);
        
    }

    /**
     * Test of getRpmHigh method, of class Regime.
     */
//    @Test
    public void testGetRpmHigh() {
        System.out.println("getRpmHigh");
        Regime instance = new Regime();
        int expResult = 0;
        int result = instance.getRpmHigh();
        assertEquals(expResult, result);
        
        instance.setRpmHigh(-1); 
        int expResult1 = 0;
        int result1 = instance.getRpmHigh();
        assertEquals(expResult1, result1);
        
        instance.setRpmHigh(1);
        int expResult2 = 1;
        int result2 = instance.getRpmHigh();
        assertEquals(expResult2, result2);
        
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        int expResult3 = 1499;
        int result3 = reg251.getRpmHigh();
        assertEquals(expResult3, result3);
        
        Regime reg257 = new Regime(175, 166, 3500, 4499);
        int expResult4 = 4499;
        int result4 = reg257.getRpmHigh();
        assertEquals(expResult4, result4);
  
    }

    /**
     * Test of getSfc method, of class Regime.
     */
    @Test
    public void testGetSfc() {
        System.out.println("getSfc");
        Regime instance = new Regime();
        double expResult = 0.0;
        double result = instance.getSfc();
        assertEquals(expResult, result, 0.0);
        
        instance.setSfc(-1.0); 
        double expResult1 = 0;
        double result1 = instance.getSfc();
        assertEquals(expResult1, result1, 0.0);
        
        instance.setSfc(1.0);
        double expResult2 = 1.0;
        double result2 = instance.getSfc();
        assertEquals(expResult2, result2, 0.0);
        
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        double expResult3 = 500;
        double result3 = reg251.getSfc();
        assertEquals(expResult3, result3, 0.0);
        
        
        
    }

    /**
     * Test of setTorqueLow method, of class Regime.
     */
    @Test
    public void testSetTorqueLow() {
        System.out.println("setTorqueLow");
        int torqueLow = 0;
        Regime instance = new Regime();
        instance.setTorqueLow(torqueLow);
        int result = instance.getTorqueLow();
        assertEquals(torqueLow, result);
        
        int torqueLow1 = -1;
        int expected = 0;
        instance.setTorqueLow(torqueLow);
        int result1 = instance.getTorqueLow();
        assertEquals(expected, result1);
        
        int torqueLow2 = 2;
        instance.setTorqueLow(torqueLow2);
        int result2 = instance.getTorqueLow();
        assertEquals(torqueLow2, result2);
        
    }

    /**
     * Test of setTorqueHigh method, of class Regime.
     */
    @Test
    public void testSetTorqueHigh() {
        System.out.println("setTorqueHigh");
        int torqueHigh = 0;
        Regime instance = new Regime();
        int result = instance.getTorqueHigh();
        assertEquals(torqueHigh, result);
        
        int torqueHigh1 = -1;
        int expected = 0;
        instance.setTorqueHigh(torqueHigh1);
        int result1 = instance.getTorqueHigh();
        assertEquals(expected, result1);
        
        int torqueHigh2 = 2;
        instance.setTorqueHigh(torqueHigh2);
        int result2 = instance.getTorqueHigh();
        assertEquals(torqueHigh2, result2);
    }

    /**
     * Test of setRpmLow method, of class Regime.
     */
    @Test
    public void testSetRpmLow() {
        System.out.println("setRpmLow");
        int rpmLow = 0;
        Regime instance = new Regime();
        instance.setRpmLow(rpmLow);
        int result = instance.getRpmLow();
        assertEquals(rpmLow, result);
        
        int torqueLow1 = -1;
        int expected = 0;
        instance.setRpmLow(torqueLow1);
        int result1 = instance.getRpmLow();
        assertEquals(expected, result1);
        
        int torqueLow2 = 2;
        instance.setRpmLow(torqueLow2);
        int result2 = instance.getRpmLow();
        assertEquals(torqueLow2, result2);
        
    }

    /**
     * Test of setRpmHigh method, of class Regime.
     */
    @Test
    public void testSetRpmHigh() {
        System.out.println("setRpmHigh");
        int rpmHigh = 0;
        Regime instance = new Regime();
        instance.setRpmHigh(rpmHigh);
        int result = instance.getRpmHigh();
        assertEquals(rpmHigh, result);
        
        int RpmHigh1 = -1;
        int expected = 0;
        instance.setRpmHigh(RpmHigh1);
        int result1 = instance.getRpmHigh();
        assertEquals(expected, result1);
        
        int RpmHigh2 = 2;
        instance.setRpmHigh(RpmHigh2);
        int result2 = instance.getRpmHigh();
        assertEquals(RpmHigh2, result2);
    }

    /**
     * Test of setSfc method, of class Regime.
     */
    @Test
    public void testSetSfc() {
        System.out.println("setSfc");
        Double sfc = 0.0;
        Regime instance = new Regime();
        instance.setSfc(sfc);
        Double result = instance.getSfc();
        assertEquals(sfc, result);
        
        Double sfc1 = -1.0;
        Double expected = 0.0;
        instance.setSfc(sfc1);
        Double result1 = instance.getSfc();
        assertEquals(expected, result1);
        
        Double sfc2 = 2.0;
        instance.setSfc(sfc2);
        Double result2 = instance.getSfc();
        assertEquals(sfc2, result2);
    }

    /**
     * Test of validate method, of class Regime.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Regime instance = new Regime();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        instance = new Regime(115, 125, 900, 1499, 500);
        expResult = true;
        result = instance.validate();
        assertEquals(expResult, result);
        
        instance = new Regime(-115, 125, -900, 1499, 500);
        expResult = false;
        result = instance.validate();
        assertEquals(expResult, result);
        
        instance = new Regime(115, 125, 1900, 1499, 500);
        expResult = false;
        result = instance.validate();
        assertEquals(expResult, result);
        
        
        
    }

    /**
     * Test of hashCode method, of class Regime.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Regime instance = new Regime();
        int expResult = 1029059101;
        int result = instance.hashCode();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of equals method, of class Regime.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Regime instance = new Regime();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
//        Regime reg513 = new Regime(140, 112, 9500, 12500);
//        Regime reg512 = new Regime(156, 140, 8500, 9499);
//        boolean result1 = reg513.equals(reg512);
//        assertFalse(result1);
//        
//        Regime reg1012 = new Regime(222, 200, 8500, 9499);
//        Regime reg1013 = new Regime(200, 160, 9500, 12500);
//        boolean result2 = reg1012.equals(reg1013);
//        assertFalse(result2);

        Regime reg1008 = new Regime(315, 299, 4500, 5499);
        Regime reg1009 = new Regime(315, 299, 4500, 5499);
        expResult = true;
        boolean result3 = reg1008.equals(reg1009);
        assertEquals(expResult, result3);
        
    }

    /**
     * Test of toString method, of class Regime.
     */
    @Test
    public void testToString() {
//        System.out.println("toString");
//        Regime instance = new Regime();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
        
//        StringBuilder expectedString = new StringBuilder();
//        expectedString.append("\n\t\t\tTorqueLow: ").append(115).append("\n");
//        expectedString.append("\t\t\tTorqueHigh: ").append(125).append("\n");
//        expectedString.append("\t\t\tRpmLow: ").append(1499).append("\n");
//        expectedString.append("\t\t\tRpmHigh: ").append(1900).append("\n");
//        expectedString.append("\t\t\tSFC: ").append(500).append("\n");
//        
//        Regime instance = new Regime(115, 125, 1499, 1900, 500);
//        String result = instance.toString();
//        String expected = expectedString.toString();
//        assertEquals(expected, result);
    }
    
}
