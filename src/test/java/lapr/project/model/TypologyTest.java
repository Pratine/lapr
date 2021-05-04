/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vdjol
 */
public class TypologyTest {
    
    public TypologyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of getById method, of class Typology.
     */
    @Test
    public void testGetById() {
        System.out.println("getTypologyById");
        int id = 1;
        String expResult = "regular road";
        String result = Typology.getById(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getJunctionByName method, of class Project.
     */
    @Test
    public void testGetByName() {
        System.out.println("getTyologyByName");
        String typologyName = "regular road";
        Typology expResult = Typology.ROAD;
        Typology result = Typology.getByName(typologyName);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of values method, of class Typology.
//     */
//    @Test
//    public void testValues() {
//        System.out.println("values");
//        Typology[] expResult = null;
//        Typology[] result = Typology.values();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of valueOf method, of class Typology.
//     */
//    @Test
//    public void testValueOf() {
//        System.out.println("valueOf");
//        String name = "";
//        Typology expResult = null;
//        Typology result = Typology.valueOf(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
