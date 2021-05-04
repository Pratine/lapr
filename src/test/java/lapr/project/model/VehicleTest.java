/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.utils.UnitConverter;
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
public class VehicleTest {

    private Vehicle vehicleEx1;
    private Vehicle vehicleEx1Copy;
    private Vehicle vehicleEx2;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        // Vehicle
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

        //Vehicle1 (copy)
        Throttle throttle25c = new Throttle(25);
        throttle25c.addRegime(reg251);
        throttle25c.addRegime(reg252);
        throttle25c.addRegime(reg253);
        throttle25c.addRegime(reg254);
        throttle25c.addRegime(reg255);

        Throttle throttle50c = new Throttle(50);
        throttle50c.addRegime(reg501);
        throttle50c.addRegime(reg502);
        throttle50c.addRegime(reg503);
        throttle50c.addRegime(reg504);
        throttle50c.addRegime(reg505);

        Throttle throttle100c = new Throttle(100);
        throttle100c.addRegime(reg1001);
        throttle100c.addRegime(reg1002);
        throttle100c.addRegime(reg1003);
        throttle100c.addRegime(reg1004);
        throttle100c.addRegime(reg1005);

        LinkedList<Gear> gearListc = new LinkedList<>();

        gearListc.add(new Gear(4.5));
        gearListc.add(new Gear(3.5));
        gearListc.add(new Gear(2.7));
        gearListc.add(new Gear(1.6));
        gearListc.add(new Gear(1.2));
        gearListc.add(new Gear(0.9));

        Map<String, Double> velocityLimitPerRoadc = new HashMap<>();
        velocityLimitPerRoadc.put("Highway", UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoadc.put("Road", UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        vehicleEx1Copy = new Vehicle(Type.CAR, 2, Fuel.DIESEL, 2.4, 2400000, 1200000, 0.39, 0.015,
                0.8, 900, 5500, Motorization.COMBUSTION, registerThrottle1, 4, gearListc);
        vehicleEx1Copy.setName("Pick_up");
        vehicleEx1Copy.setDescription("Pick-up test vehicle");
        vehicleEx1Copy.setVelocityLimitPerRoad(velocityLimitPerRoad);

        //Vehicle2
        Regime reg251v2 = new Regime(115, 125, 900, 1499, 500);
        Regime reg252v2 = new Regime(125, 120, 1500, 2499, 450);
        Regime reg253v2 = new Regime(120, 105, 2500, 3499, 520);
        Regime reg254v2 = new Regime(105, 90, 3500, 4499, 550);
        Regime reg255v2 = new Regime(90, 80, 4500, 5500, 650);

        Throttle throttle25v2 = new Throttle(25);
        throttle25v2.addRegime(reg251v2);
        throttle25v2.addRegime(reg252v2);
        throttle25v2.addRegime(reg253v2);
        throttle25v2.addRegime(reg254v2);
        throttle25v2.addRegime(reg255v2);

        Regime reg501v2 = new Regime(185, 195, 900, 1499, 380);
        Regime reg502v2 = new Regime(195, 190, 1500, 2499, 350);
        Regime reg503v2 = new Regime(190, 180, 2500, 3999, 360);
        Regime reg504v2 = new Regime(180, 150, 3500, 4499, 400);
        Regime reg505v2 = new Regime(150, 135, 4500, 5500, 520);

        Throttle throttle50v2 = new Throttle(50);
        throttle50v2.addRegime(reg501v2);
        throttle50v2.addRegime(reg502v2);
        throttle50v2.addRegime(reg503v2);
        throttle50v2.addRegime(reg504v2);
        throttle50v2.addRegime(reg505v2);

        Regime reg1001v2 = new Regime(305, 325, 900, 1499, 380);
        Regime reg1002v2 = new Regime(325, 315, 1500, 2499, 350);
        Regime reg1003v2 = new Regime(315, 290, 2500, 3999, 360);
        Regime reg1004v2 = new Regime(290, 220, 3500, 4499, 400);
        Regime reg1005v2 = new Regime(220, 205, 4500, 5500, 520);

        Throttle throttle100v2 = new Throttle(100);
        throttle100v2.addRegime(reg1001v2);
        throttle100v2.addRegime(reg1002v2);
        throttle100v2.addRegime(reg1003v2);
        throttle100v2.addRegime(reg1004v2);
        throttle100v2.addRegime(reg1005v2);

        RegistThrottle registerThrottle2 = new RegistThrottle();
        registerThrottle2.addThrottle(throttle25);
        registerThrottle2.addThrottle(throttle50);
        registerThrottle2.addThrottle(throttle100);

        LinkedList<Gear> gearListv2 = new LinkedList<>();

        gearListv2.add(new Gear(3.5));
        gearListv2.add(new Gear(4.5));
        gearListv2.add(new Gear(1.6));
        gearListv2.add(new Gear(2.7));
        gearListv2.add(new Gear(0.9));
        gearListv2.add(new Gear(1.2));

        Map<String, Double> velocityLimitPerRoadv2 = new HashMap<>();
        velocityLimitPerRoadv2.put("Highway", UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoadv2.put("Road", UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        vehicleEx2 = new Vehicle(Type.CAR, 1, Fuel.GASOLINE, 1.9, 1600.0, 420.0, 0.32, 0.013,
                0.6, 1000, 6500, Motorization.COMBUSTION, registerThrottle2, 3.6, gearListv2);
        vehicleEx2.setName("Buggatti");
        vehicleEx2.setDescription("Sports Car");
        vehicleEx2.setVelocityLimitPerRoad(velocityLimitPerRoadv2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getType method, of class Vehicle.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Type expResult = Type.CAR;
        Type result = vehicleEx1.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Vehicle.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Pick_up";
        String result = vehicleEx1.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "Pick-up test vehicle";
        String result = vehicleEx1.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMotorization method, of class Vehicle.
     */
    @Test
    public void testGetMotorization() {
        System.out.println("getMotorization");
        Motorization expResult = Motorization.COMBUSTION;
        Motorization result = vehicleEx1.getMotorization();
        assertEquals(expResult, result);
    }

    /**
     * Test of getToll_class method, of class Vehicle.
     */
    @Test
    public void testGetToll_class() {
        System.out.println("getToll_class");
        int expResult = 2;
        int result = vehicleEx1.getTollClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMass method, of class Vehicle.
     */
    @Test
    public void testGetMass() {
        System.out.println("getMass");
        double expResult = 2400000;
        double result = vehicleEx1.getMass();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLoad method, of class Vehicle.
     */
    @Test
    public void testGetLoad() {
        System.out.println("getLoad");
        double expResult = 1200000;
        double result = vehicleEx1.getLoad();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDragCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetDragCoefficient() {
        System.out.println("getDragCoefficient");
        double expResult = 0.39;
        double result = vehicleEx1.getDragCoefficient();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResistanceCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetResistanceCoefficient() {
        System.out.println("getResistanceCoefficient");
        double expResult = 0.015;
        double result = vehicleEx1.getResistanceCoefficient();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getWheelSize method, of class Vehicle.
     */
    @Test
    public void testGetWheelSize() {
        System.out.println("getWheelSize");
        double expResult = 0.8;
        double result = vehicleEx1.getWheelSize();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getEnergy_function method, of class Vehicle.
     */
    @Test
    public void testGetEnergyFunction() {
        System.out.println("getEnergyFunction");
        double expResult = 0.0;
        double result = vehicleEx1.getEnergyRatio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setType method, of class Vehicle.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        Type expected = Type.MOTORCYCLE;
        Vehicle instance = new Vehicle();
        instance.setType(expected);
        Type result = instance.getType();
        assertEquals(expected, result);
    }

    /**
     * Test of setToll_class method, of class Vehicle.
     */
    @Test
    public void testSetTollClass() {
        System.out.println("setTollClass");
        int expected = 2;
        Vehicle instance = new Vehicle();
        instance.setTollClass(expected);
        int result = instance.getTollClass();
        assertEquals(expected, result);

    }

    /**
     * Test of setMass method, of class Vehicle.
     */
    @Test
    public void testSetMass() {
        System.out.println("setMass");
        double expected = 1500;
        Vehicle instance = new Vehicle();
        instance.setMass(expected);
        double result = instance.getMass();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setLoad method, of class Vehicle.
     */
    @Test
    public void testSetLoad() {
        System.out.println("setLoad");
        double expected = 500;
        Vehicle instance = new Vehicle();
        instance.setLoad(expected);
        double result = instance.getLoad();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setDrag_coefficient method, of class Vehicle.
     */
    @Test
    public void testSetDragCoefficient() {
        System.out.println("setDragCoefficient");
        double expected = 0.3;
        Vehicle instance = new Vehicle();
        instance.setDragCoefficient(expected);
        double result = instance.getDragCoefficient();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setResistance_coefficient method, of class Vehicle.
     */
    @Test
    public void testSetResistanceCoefficient() {
        System.out.println("setResistanceCoefficient");
        double expected = 0.0024;
        Vehicle instance = new Vehicle();
        instance.setResistanceCoefficient(expected);
        double result = instance.getResistanceCoefficient();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setWheel_size method, of class Vehicle.
     */
    @Test
    public void testSetWheelSize() {
        System.out.println("setWheelSize");
        double expected = 0.78;
        Vehicle instance = new Vehicle();
        instance.setWheelSize(expected);
        double result = instance.getWheelSize();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setEnergy_function method, of class Vehicle.
     */
    @Test
    public void testSetEnergyFunction() {
        System.out.println("setEnergyFunction");
        double expected = 0.56;
        Vehicle instance = new Vehicle();
        instance.setEnergyRatio(expected);
        double result = instance.getEnergyRatio();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of getFuel method, of class Vehicle.
     */
    @Test
    public void testGetFuel() {
        System.out.println("getFuel");
        Fuel expResult = Fuel.DIESEL;
        Fuel result = vehicleEx1.getFuel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFrontal_area method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea() {
        System.out.println("getFrontalArea");
        double expResult = 2.4;
        double result = vehicleEx1.getFrontalArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getGear_list method, of class Vehicle.
     */
    @Test
    public void testGetGearList() {
        System.out.println("getGearList");
        LinkedList<Gear> expected = new LinkedList<>();

        expected.add(new Gear(4.5));
        expected.add(new Gear(3.5));
        expected.add(new Gear(2.7));
        expected.add(new Gear(1.6));
        expected.add(new Gear(1.2));
        expected.add(new Gear(0.9));
        LinkedList<Gear> result = vehicleEx1.getGearList();
        assertEquals(expected, result);
    }

    /**
     * Test of getMin_rpm method, of class Vehicle.
     */
    @Test
    public void testGetMin_rpm() {
        System.out.println("getMin_rpm");
        int expResult = 900;
        int result = vehicleEx1.getMin_rpm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMax_rpm method, of class Vehicle.
     */
    @Test
    public void testGetMax_rpm() {
        System.out.println("getMax_rpm");
        int expResult = 5500;
        int result = vehicleEx1.getMax_rpm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFinalDriveRatio method, of class Vehicle.
     */
    @Test
    public void testGetFinalDriveRatio() {
        System.out.println("getFinalDriveRatio");
        double expResult = 4.0;
        double result = vehicleEx1.getFinalDriveRatio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setName method, of class Vehicle.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String expected = "Name";
        Vehicle instance = new Vehicle();
        instance.setName(expected);
        String result = instance.getName();
        assertEquals(expected, result);
    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String expected = "Description";
        Vehicle instance = new Vehicle();
        instance.setDescription(expected);
        String result = instance.getDescription();
        assertEquals(expected, result);
    }

    /**
     * Test of setMotorization method, of class Vehicle.
     */
    @Test
    public void testSetMotorization() {
        System.out.println("setMotorization");
        Motorization expected = Motorization.ELECTRIC;
        Vehicle instance = new Vehicle();
        instance.setMotorization(expected);
        Motorization result = instance.getMotorization();
        assertEquals(expected, result);
    }

    /**
     * Test of setFuel method, of class Vehicle.
     */
    @Test
    public void testSetFuel() {
        System.out.println("setFuel");
        Fuel expected = Fuel.DIESEL;
        Vehicle instance = new Vehicle();
        instance.setFuel(expected);
        Fuel result = instance.getFuel();
        assertEquals(expected, result);
    }

    /**
     * Test of setFrontal_area method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea() {
        System.out.println("setFrontalArea");
        double expected = 3.7;
        Vehicle instance = new Vehicle();
        instance.setFrontalArea(expected);
        double result = instance.getFrontalArea();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setGear_list method, of class Vehicle.
     */
    @Test
    public void testSetGearList() {
        System.out.println("setGearList");
        LinkedList<Gear> gearList = new LinkedList<>();

        gearList.add(new Gear(4.5));
        gearList.add(new Gear(3.5));
        gearList.add(new Gear(2.7));
        gearList.add(new Gear(1.6));
        gearList.add(new Gear(1.2));
        gearList.add(new Gear(0.9));
        Vehicle instance = new Vehicle();
        instance.setGearList(gearList);
        LinkedList<Gear> result = instance.getGearList();
        LinkedList<Gear> expected = vehicleEx1.getGearList();
        assertEquals(expected, result);
    }

    /**
     * Test of setMin_rpm method, of class Vehicle.
     */
    @Test
    public void testSetMin_rpm() {
        System.out.println("setMin_rpm");
        int expected = 750;
        Vehicle instance = new Vehicle();
        instance.setMin_rpm(expected);
        int result = instance.getMin_rpm();
        assertEquals(expected, result);
    }

    /**
     * Test of setMax_rpm method, of class Vehicle.
     */
    @Test
    public void testSetMax_rpm() {
        System.out.println("setMax_rpm");
        int expected = 6500;
        Vehicle instance = new Vehicle();
        instance.setMax_rpm(expected);
        int result = instance.getMax_rpm();
        assertEquals(expected, result);
    }

    /**
     * Test of setFinalDriveRatio method, of class Vehicle.
     */
    @Test
    public void testSetFinalDriveRatio() {
        System.out.println("setFinalDriveRatio");
        double expected = 2.3;
        Vehicle instance = new Vehicle();
        instance.setFinalDriveRatio(expected);
        double result = instance.getFinalDriveRatio();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Vehicle v = null;
        Segment g = new Segment();
        assertTrue(vehicleEx1.equals(vehicleEx1Copy) && vehicleEx1Copy.equals(vehicleEx1));
        assertTrue(vehicleEx1.hashCode() == vehicleEx1Copy.hashCode());
        assertFalse(vehicleEx1.equals(vehicleEx2) && vehicleEx2.equals(vehicleEx1));
        assertFalse(vehicleEx1.equals(v));
        assertFalse(vehicleEx1.equals(g));

        Vehicle v1 = new Vehicle();
        v1.setName("Pick_up");
        v1.setDescription("Pick-up vehicle");
        assertFalse(vehicleEx1.equals(v1));
        v1.setDescription("Pick-up test vehicle");
        v1.setType(Type.TRUCK);
        assertFalse(vehicleEx1.equals(v1));
        v1.setType(Type.CAR);
        v1.setMotorization(Motorization.ELECTRIC);
        assertFalse(vehicleEx1.equals(v1));
        v1.setMotorization(Motorization.COMBUSTION);
        v1.setTollClass(1);
        assertFalse(vehicleEx1.equals(v1));
        v1.setTollClass(2);
        v1.setFuel(Fuel.GASOLINE);
        assertFalse(vehicleEx1.equals(v1));
        v1.setFuel(Fuel.DIESEL);
        v1.setMass(1200);
        assertFalse(vehicleEx1.equals(v1));
        v1.setMass(2400000);
        v1.setLoad(1200);
        assertFalse(vehicleEx1.equals(v1));
        v1.setLoad(1200000);
        v1.setDragCoefficient(0.38);
        assertFalse(vehicleEx1.equals(v1));
        v1.setDragCoefficient(0.39);
        v1.setFrontalArea(2.5);
        assertFalse(vehicleEx1.equals(v1));
        v1.setFrontalArea(2.4);
        v1.setResistanceCoefficient(0.016);
        assertFalse(vehicleEx1.equals(v1));
        v1.setResistanceCoefficient(0.015);
        v1.setWheelSize(0.9);
        assertFalse(vehicleEx1.equals(v1));
        v1.setWheelSize(0.8);
        v1.setFinalDriveRatio(7);
        assertFalse(vehicleEx1.equals(v1));
        v1.setFinalDriveRatio(4);
        v1.setMin_rpm(800);
        assertFalse(vehicleEx1.equals(v1));
        v1.setMin_rpm(900);
        v1.setMax_rpm(5600);
        assertFalse(vehicleEx1.equals(v1));
        v1.setMax_rpm(5500);
        Map<String, Double> velocityLimitPerRoad1 = new HashMap<>();
        velocityLimitPerRoad1.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("100"));
        velocityLimitPerRoad1.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("700"));
        v1.setVelocityLimitPerRoad(velocityLimitPerRoad1);
        assertFalse(vehicleEx1.equals(v1));
        Map<String, Double> velocityLimitPerRoad = new HashMap<>();
        velocityLimitPerRoad.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));
        v1.setVelocityLimitPerRoad(velocityLimitPerRoad);

        LinkedList<Gear> gearListc = new LinkedList<>();

        gearListc.add(new Gear(4.6));
        gearListc.add(new Gear(3.1));
        gearListc.add(new Gear(2.8));
        gearListc.add(new Gear(1.9));
        gearListc.add(new Gear(1.1));
        gearListc.add(new Gear(0.7));
        
        v1.setGearList(gearListc);
        
        assertFalse(vehicleEx1.equals(v1));

    }

    /**
     * Test of hashCode method, of class Vehicle.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = -1781564407;
        int result = vehicleEx1.hashCode();
        assertEquals(expResult, result);
    }
//    /**
//     * Test of maxSpeed method, of class Vehicle.
//     */
//    @Test
//    public void testMaxSpeed() {
//        System.out.println("maxSpeed");
//        Vehicle instance = new Vehicle();
//        double expResult = 0.0;
//        double result = instance.maxSpeed();
//        assertEquals(expResult, result, 0.0);
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addGear method, of class Vehicle.
     */
    @Test
    public void testAddGear() {
        System.out.println("addGear");
        Vehicle instance = new Vehicle();

        instance.addGear(new Gear(4.5));
        instance.addGear(new Gear(3.5));
        instance.addGear(new Gear(2.7));
        instance.addGear(new Gear(1.6));
        instance.addGear(new Gear(1.2));
        instance.addGear(new Gear(0.9));

        LinkedList<Gear> result = instance.getGearList();
        LinkedList<Gear> expected = vehicleEx1.getGearList();
        assertEquals(expected, result);
    }

    /**
     * Test of validate method, of class Vehicle.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        boolean expResult = true;
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        Vehicle v3 = new Vehicle();
        Vehicle v4 = new Vehicle();
        Vehicle v5 = new Vehicle();
        Vehicle v6 = new Vehicle();
        Vehicle v7 = new Vehicle();
        Vehicle v8 = new Vehicle();
        v1.setName("fail");
        v2.setName("fail");
        v2.setDescription("fail");
        v3.setName("fail");
        v3.setDescription("fail");
        v3.setType(Type.CAR);
        v4.setName("fail");
        v4.setDescription("fail");
        v4.setType(Type.CAR);
        v4.setFuel(Fuel.DIESEL);
        v5.setName("fail");
        v5.setDescription("fail");
        v5.setType(Type.CAR);
        v5.setFuel(Fuel.DIESEL);
        v5.setMass(1231);

        v6.setName("fail");
        v6.setDescription("fail");
        v6.setType(Type.CAR);
        v6.setFuel(Fuel.DIESEL);
        v6.setMass(1231);
        v6.setLoad(14);

        v7.setName("fail");
        v7.setDescription("fail");
        v7.setType(Type.CAR);
        v7.setFuel(Fuel.DIESEL);
        v7.setMass(1231);
        v7.setLoad(14);
        v7.setDragCoefficient(24);

        v8.setName("fail");
        v8.setDescription("fail");
        v8.setType(Type.CAR);
        v8.setFuel(Fuel.DIESEL);
        v8.setMass(1231);
        v8.setLoad(14);
        v8.setDragCoefficient(24);
        v8.setFrontalArea(2.0);

        boolean result = vehicleEx1.validate();
        boolean result1 = new Vehicle().validate();
        boolean result2 = v1.validate();
        boolean result3 = v2.validate();
        boolean result4 = v3.validate();
        boolean result5 = v4.validate();
        boolean result6 = v5.validate();
        boolean result7 = v6.validate();
        boolean result8 = v7.validate();
        boolean result9 = v8.validate();
        assertEquals(expResult, result);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertFalse(result6);
        assertFalse(result7);
        assertFalse(result8);
        assertFalse(result9);
    }

    /**
     * Test of getVelocityLimitPerRoad method, of class Vehicle.
     */
    @Test
    public void testGetVelocityLimitPerRoad() {
        System.out.println("getVelocityLimitPerRoad");
        Map<String, Double> expected = new HashMap<>();
        expected.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        expected.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));
        Map<String, Double> result = vehicleEx1.getVelocityLimitPerRoad();
        assertEquals(expected, result);
    }

    /**
     * Test of setVelocityLimitPerRoad method, of class Vehicle.
     */
    @Test
    public void testSetVelocityLimitPerRoad() {
        System.out.println("setVelocityLimitPerRoad");
        Map<String, Double> velocityLimitPerRoad = new HashMap<>();
        velocityLimitPerRoad.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));
        Vehicle instance = new Vehicle();
        instance.setVelocityLimitPerRoad(velocityLimitPerRoad);
        Map<String, Double> expected = vehicleEx1.getVelocityLimitPerRoad();
        Map<String, Double> result = instance.getVelocityLimitPerRoad();
        assertEquals(result, expected);
    }

    /**
     * Test of getVelocityLimitOfRoad method, of class Vehicle.
     */
    @Test
    public void testGetVelocityLimitOfRoad() {
        System.out.println("getVelocityLimitOfRoad");
        String roadTypology = "ROAD";
        double expResult = 22.22;
        double result = vehicleEx1.getVelocityLimitOfRoad(roadTypology);
        assertEquals(expResult, result, 0.0);

        double expResult2 = 0.0f;
        Vehicle v = new Vehicle();
        double result2 = v.getVelocityLimitOfRoad(roadTypology);
        assertEquals(expResult2, result2, 0.0);

        assertEquals(expResult2, vehicleEx1.getVelocityLimitOfRoad("REGULAR"), 0.0);
    }

    /**
     * Test of toString method, of class Vehicle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringBuilder sb = new StringBuilder();

        sb.append("\n\tName: ").append(vehicleEx1.getName()).append("\n");
        sb.append("\tDescription: ").append(vehicleEx1.getDescription()).append("\n");
        sb.append("\tType: ").append(vehicleEx1.getType().toString()).append("\n");
        sb.append("\tToll Classe: ").append(vehicleEx1.getTollClass()).append("\n");
        sb.append("\tMotorization: ").append(vehicleEx1.getMotorization().toString()).append("\n");
        sb.append("\tFuel: ").append(vehicleEx1.getFuel().toString()).append("\n");
        sb.append("\tMass: ").append(vehicleEx1.getMass()).append("\n");
        sb.append("\tLoad: ").append(vehicleEx1.getLoad()).append("\n");
        sb.append("\tDrag: ").append(vehicleEx1.getDragCoefficient()).append("\n");
        sb.append("\tFrontal Area: ").append(vehicleEx1.getFrontalArea()).append("\n");
        sb.append("\tRRC: ").append(vehicleEx1.getResistanceCoefficient()).append("\n");
        sb.append("\tWheelSize: ").append(vehicleEx1.getWheelSize()).append("\n");
        sb.append("\tMinRpm: ").append(vehicleEx1.getMin_rpm()).append("\n");
        sb.append("\tMaxRpm: ").append(vehicleEx1.getMax_rpm()).append("\n");
        sb.append("\tFinal Drive ratio: ").append(vehicleEx1.getFinalDriveRatio()).append("\n");
        sb.append("\tVelocity limit: ").append(vehicleEx1.getVelocityLimitPerRoad().toString()).append("\n");
        sb.append("\tGearList: ").append(vehicleEx1.getGearList().toString()).append("\n");
        sb.append("\tThrottle List: ").append(vehicleEx1.getRegistryThrottle().getThrottleList().toString()).append("\n");
        String expResult = sb.toString();
        String result = vehicleEx1.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertVelocityLimit method, of class Vehicle.
     */
    @Test
    public void testInsertVelocityLimit() {
        System.out.println("insertVelocityLimit");

        Map<String, Double> expected = new HashMap<>();
        expected.put("Highway", UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));

        String segmentType = "Highway";
        Double limit = UnitConverter.kilometerPerHourToMetersPerSecondDouble("110");
        Vehicle instance = new Vehicle();
        instance.insertVelocityLimit(segmentType, limit);

        Map<String, Double> result = instance.getVelocityLimitPerRoad();
        assertEquals(expected, result);
    }

    /**
     * Test of getEnergy_ratio method, of class Vehicle.
     */
    @Test
    public void testGetEnergy_ratio() {
        System.out.println("getEnergy_ratio");
        Vehicle instance = new Vehicle(Type.CAR, 0, Fuel.DIESEL, 0, 0, 0, 0, 0, 0, 0, 0, Motorization.COMBUSTION, new RegistThrottle(), 0, new LinkedList<>(), 2.3);
        double expected = 2.3;
        double result = instance.getEnergyRatio();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setEnergy_ratio method, of class Vehicle.
     */
    @Test
    public void testSetEnergy_ratio() {
        System.out.println("setEnergy_ratio");
        double expected = 2.3;
        vehicleEx2.setEnergyRatio(2.3);
        double result = vehicleEx2.getEnergyRatio();
        assertEquals(expected, result, 0.0);

    }

    /**
     * Test of getRegistryThrottle method, of class Vehicle.
     */
    @Test
    public void testGetRegistryThrottle() {
        System.out.println("setRegistryTrottle");
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

        RegistThrottle registryThrottle = new RegistThrottle();
        registryThrottle.addThrottle(throttle25);
        registryThrottle.addThrottle(throttle50);
        registryThrottle.addThrottle(throttle100);

        Vehicle expectedV = new Vehicle(Type.CAR, 0, Fuel.DIESEL, 0, 0, 0, 0, 0, 0, 0, 0, Motorization.COMBUSTION, registryThrottle, 0, new LinkedList<>());
        RegistThrottle expected = expectedV.getRegistryThrottle();
        RegistThrottle result = vehicleEx1.getRegistryThrottle();
        assertEquals(expected, result);
    }

    /**
     * Test of setRegistryThrottle method, of class Vehicle.
     */
    @Test
    public void testSetRegistryTrottle() {
        System.out.println("setRegistryTrottle");
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

        RegistThrottle registryThrottle = new RegistThrottle();
        registryThrottle.addThrottle(throttle25);
        registryThrottle.addThrottle(throttle50);
        registryThrottle.addThrottle(throttle100);

        Vehicle resultV = new Vehicle();
        resultV.setRegistryThrottle(registryThrottle);
        RegistThrottle result = resultV.getRegistryThrottle();
        RegistThrottle expected = vehicleEx1.getRegistryThrottle();
        assertEquals(expected, result);
    }

}
