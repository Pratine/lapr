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
public class RegistRegimeTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private RegistRegime registRegimeEx1;
    private RegistRegime registRegimeEx2;

    @Before
    public void setUp() {
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);

        registRegimeEx1 = new RegistRegime();
        registRegimeEx1.addRegime(reg251);
        registRegimeEx1.addRegime(reg252);
        registRegimeEx1.addRegime(reg253);
        registRegimeEx1.addRegime(reg254);
        registRegimeEx1.addRegime(reg255);
        
        Regime reg251v2 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252v2 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253v2 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254v2 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255v2 = new Regime(90, 80, 4500, 5500, 650);

        registRegimeEx2 = new RegistRegime();
        registRegimeEx2.addRegime(reg251v2);
        registRegimeEx2.addRegime(reg252v2);
        registRegimeEx2.addRegime(reg253v2);
        registRegimeEx2.addRegime(reg254v2);
        registRegimeEx2.addRegime(reg255v2);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegimeList method, of class RegistRegime.
     */
    @org.junit.Test
    public void testGetRegimeList() {
        System.out.println("getRegimeList");
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);

        RegistRegime instance = new RegistRegime();
        instance.addRegime(reg251);
        instance.addRegime(reg252);
        instance.addRegime(reg253);
        instance.addRegime(reg254);
        instance.addRegime(reg255);
        LinkedList<Regime> expResult = instance.getRegimeList();
        LinkedList<Regime> result = registRegimeEx1.getRegimeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRegime method, of class RegistRegime.
     */
    @org.junit.Test
    public void testAddRegime() {
        System.out.println("addRegime");
        Regime regime1 = new Regime(115, 125, 900, 1499, 500);
        Regime regime2 = new Regime(125, 120, 1500, 2499, 450);
        Regime regime3 = new Regime(120, 105, 2500, 3499, 520);
        Regime regime4 = new Regime(105, 90, 3500, 4499, 550);
        Regime regime5 = new Regime(90, 80, 4500, 5500, 650);
        RegistRegime instance = new RegistRegime();
        instance.addRegime(regime1);
        instance.addRegime(regime2);
        instance.addRegime(regime3);
        instance.addRegime(regime4);
        instance.addRegime(regime5);
        LinkedList<Regime> expResult = registRegimeEx1.getRegimeList();
        LinkedList<Regime> result = instance.getRegimeList();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class RegistRegime.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);
        
        Object obj = null;

        RegistRegime instance = new RegistRegime();
        instance.addRegime(reg251);
        instance.addRegime(reg252);
        instance.addRegime(reg253);
        instance.addRegime(reg254);
        instance.addRegime(reg255);
        boolean expResult = true;
        boolean expResult1 = false;
        boolean result = instance.equals(registRegimeEx1);
        boolean result1 = instance.equals(new RegistRegime());
        boolean result2 = instance.equals(new Regime());
        boolean result3 = registRegimeEx1.equals(registRegimeEx2);
        boolean result4 = registRegimeEx1.equals(obj);
        assertEquals(expResult, result);
        assertEquals(expResult, result3);
        assertEquals(expResult1, result4);
        assertFalse(result1);
        assertFalse(result2);
    }

    /**
     * Test of hashCode method, of class RegistRegime.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 313651910;
        int result = registRegimeEx1.hashCode();
        assertEquals(expResult, result);
    }

}
