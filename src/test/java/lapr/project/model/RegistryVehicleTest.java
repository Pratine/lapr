/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.utils.UnitConverter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Bruno Fonseca
 */
public class RegistryVehicleTest {

    private Vehicle vehicleEx1;
    private RegistryVehicle registryVehicleEx1;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        //Vehicle
        Regime reg251 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255 = new Regime(90, 80, 4500, 5500, 650);

        Throttle throttle25 = new Throttle(25);
        throttle25.addRegime(reg251);
        throttle25.addRegime(reg252);
        throttle25.addRegime(reg253);
        throttle25.addRegime(reg254);
        throttle25.addRegime(reg255);

        Regime reg501 = new Regime(185, 195, 900, 1499, 380);
        Regime reg502 = new Regime(195, 190, 1500, 2499, 350);
        Regime reg503 = new Regime(190, 180, 2500, 3999, 360);
        Regime reg504 = new Regime(180, 150, 3500, 4499, 400);
        Regime reg505 = new Regime(150, 135, 4500, 5500, 520);

        Throttle throttle50 = new Throttle(50);
        throttle50.addRegime(reg501);
        throttle50.addRegime(reg502);
        throttle50.addRegime(reg503);
        throttle50.addRegime(reg504);
        throttle50.addRegime(reg505);

        Regime reg1001 = new Regime(305, 325, 900, 1499, 380);
        Regime reg1002 = new Regime(325, 315, 1500, 2499, 350);
        Regime reg1003 = new Regime(315, 290, 2500, 3999, 360);
        Regime reg1004 = new Regime(290, 220, 3500, 4499, 400);
        Regime reg1005 = new Regime(220, 205, 4500, 5500, 520);

        Throttle throttle100 = new Throttle(100);
        throttle100.addRegime(reg1001);
        throttle100.addRegime(reg1002);
        throttle100.addRegime(reg1003);
        throttle100.addRegime(reg1004);
        throttle100.addRegime(reg1005);

        RegistThrottle registerThrottle1 = new RegistThrottle();
        registerThrottle1.addThrottle(throttle25);
        registerThrottle1.addThrottle(throttle50);
        registerThrottle1.addThrottle(throttle100);

        LinkedList<Gear> gearList = new LinkedList<>();

        gearList.add(new Gear(4.5));
        gearList.add(new Gear(3.5));
        gearList.add(new Gear(2.7));
        gearList.add(new Gear(1.6));
        gearList.add(new Gear(1.2));
        gearList.add(new Gear(0.9));

        Map<String, Double> velocityLimitPerRoad = new HashMap<>();
        velocityLimitPerRoad.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        vehicleEx1 = new Vehicle(Type.CAR, 2, Fuel.DIESEL, 2.4, 2400000, 1200000, 0.39, 0.015,
                0.8, 900, 5500, Motorization.COMBUSTION, registerThrottle1, 4, gearList);
        vehicleEx1.setName("Pick_up");
        vehicleEx1.setDescription("Pick-up test vehicle");
        vehicleEx1.setVelocityLimitPerRoad(velocityLimitPerRoad);

        //RegistryVehicle
        registryVehicleEx1 = new RegistryVehicle();
        registryVehicleEx1.addVehicle(vehicleEx1);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getVehicleList method, of class RegistryVehicle.
     */
    @Test
    public void testGetVehicleList() {
        System.out.println("getVehicleList");
        LinkedList<Vehicle> vehicleList = new LinkedList<>();
        vehicleList.add(vehicleEx1);
        LinkedList<Vehicle> expResult = vehicleList;
        LinkedList<Vehicle> result = registryVehicleEx1.getVehicleList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addVehicle method, of class RegistryVehicle.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        RegistryVehicle instance = new RegistryVehicle();
        boolean expResult = true;
        boolean result = instance.addVehicle(vehicleEx1);
        assertEquals(expResult, result);
        boolean result1 = instance.addVehicle(vehicleEx1);
        assertFalse(result1);
    }

    /**
     * Test of contains method, of class RegistryVehicle.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Vehicle vehicle = new Vehicle();
        boolean expResult = true;
        boolean result = registryVehicleEx1.contains(vehicleEx1);
        boolean result1 = registryVehicleEx1.contains(vehicle);
        assertEquals(expResult, result);
        assertFalse(result1);
    }

    /**
     * Test of getVehicleNamesList method, of class RegistryVehicle.
     */
    @Test
    public void testGetVehicleNamesList() {
        System.out.println("getVehicleNamesList");
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Pick_up");
        ArrayList<String> expResult = nameList;
        ArrayList<String> result = registryVehicleEx1.getVehicleNamesList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVehicleByName method, of class RegistryVehicle.
     */
    @Test
    public void testGetVehicleByName() {
        System.out.println("getVehicleByName");
        String name = "Pick_up";
        Vehicle expResult = vehicleEx1;
        Vehicle expResult1 = null;
        Vehicle result = registryVehicleEx1.getVehicleByName(name);
        Vehicle result1 = registryVehicleEx1.getVehicleByName("");
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }

    /**
     * Test of newVehicle method, of class RegistryVehicle.
     */
    @Test
    public void testNewVehicle() {
        System.out.println("newVehicle");
        Vehicle expResult = new Vehicle();
        Vehicle result = registryVehicleEx1.newVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class RegistryVehicle.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = 2;
        registryVehicleEx1.addVehicle(new Vehicle());
        int result = registryVehicleEx1.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class RegistryVehicle.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        boolean expResult = true;
        boolean result = registryVehicleEx1.validate();
        boolean result1 = new RegistryVehicle().validate();

        assertEquals(expResult, result);
        assertFalse(result1);
    }

}
