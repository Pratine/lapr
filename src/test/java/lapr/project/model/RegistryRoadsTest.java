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
 * @author Bruno Fonseca
 */
public class RegistryRoadsTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private RegistryRoads registRoadsEx1;
    private Road roadEx1;
    private Road roadEx2;

    @Before
    public void setUp() {
        roadEx1 = new Road("Road ex1");
        roadEx2 = new Road("Road ex2");
        roadEx1.setTypology(Typology.HIGHWAY);
        roadEx2.setTypology(Typology.ROAD);

        roadEx1.setToll(1, 1.25);
        roadEx1.setToll(2, 3.00);
        roadEx1.setToll(3, 5.00);

        roadEx2.setToll(1, 2.25);
        roadEx2.setToll(2, 6.00);
        roadEx2.setToll(3, 10.00);
        registRoadsEx1 = new RegistryRoads();
        registRoadsEx1.addRoad(roadEx1);
        registRoadsEx1.addRoad(roadEx2);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRoadsList method, of class RegistryRoads.
     */
    @Test
    public void testGetRoadsList() {
        System.out.println("getRoadsList");
        LinkedList<Road> expected = new LinkedList<>();
        expected.add(roadEx1);
        expected.add(roadEx2);
        LinkedList<Road> result = registRoadsEx1.getRoadsList();
        assertEquals(expected, result);
    }

    /**
     * Test of addRoad method, of class RegistryRoads.
     */
    @Test
    public void testAddRoad() {
        System.out.println("addRoad");
        RegistryRoads instance = new RegistryRoads();
        instance.addRoad(new Road("Road ex1"));
        LinkedList<Road> expected = new LinkedList<>();
        expected.add(new Road("Road ex1"));
        LinkedList<Road> result = instance.getRoadsList();
        assertEquals(expected, result);
    }

    /**
     * Test of getRoadByName method, of class RegistryRoads.
     */
    @Test
    public void testGetRoadByName() {
        System.out.println("getRoadByName");
        String name = "Road ex1";
        Road expResult = roadEx1;
        Road expResult1 = null;
        Road result = registRoadsEx1.getRoadByName(name);
        Road result1 = registRoadsEx1.getRoadByName("");
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }

    /**
     * Test of size method, of class RegistryRoads.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = 2;
        int result = registRoadsEx1.size();
        assertEquals(expResult, result);
    }

}
