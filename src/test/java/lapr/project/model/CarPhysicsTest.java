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
 * @author salva
 */
public class CarPhysicsTest {

    private Vehicle vehicle;
    private Road r1, r2, r3, r4, r5;
    private Project project;
    private Junction j000, j001;
    private Section s01;
    private Segment sg1, sg2, sg3, sg4;
    private Throttle throttle25, throttle50, throttle100;
    private Regime reg251, reg252, reg253, reg254, reg255;
    private Regime reg501, reg502, reg503, reg504, reg505;
    private Regime reg1001, reg1002, reg1003, reg1004, reg1005;
    private RegistThrottle registerThrottle1;

    public CarPhysicsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        project = new Project();
        project.setName("Project");
        project.setDescription("Description");

        reg251 = new Regime(115, 125, 900, 1499, 500);
        reg252 = new Regime(125, 120, 1500, 2499, 450);
        reg253 = new Regime(120, 105, 2500, 3499, 520);
        reg254 = new Regime(105, 90, 3500, 4499, 550);
        reg255 = new Regime(90, 80, 4500, 5500, 650);

        throttle25 = new Throttle(25);
        throttle25.addRegime(reg251);
        throttle25.addRegime(reg252);
        throttle25.addRegime(reg253);
        throttle25.addRegime(reg254);
        throttle25.addRegime(reg255);

        reg501 = new Regime(185, 195, 900, 1499, 380);
        reg502 = new Regime(195, 190, 1500, 2499, 350);
        reg503 = new Regime(190, 180, 2500, 3999, 360);
        reg504 = new Regime(180, 150, 3500, 4499, 400);
        reg505 = new Regime(150, 135, 4500, 5500, 520);

        throttle50 = new Throttle(50);
        throttle50.addRegime(reg501);
        throttle50.addRegime(reg502);
        throttle50.addRegime(reg503);
        throttle50.addRegime(reg504);
        throttle50.addRegime(reg505);

        reg1001 = new Regime(305, 325, 900, 1499, 380);
        reg1002 = new Regime(325, 315, 1500, 2499, 350);
        reg1003 = new Regime(315, 290, 2500, 3999, 360);
        reg1004 = new Regime(290, 220, 3500, 4499, 400);
        reg1005 = new Regime(220, 205, 4500, 5500, 520);

        throttle100 = new Throttle(100);
        throttle100.addRegime(reg1001);
        throttle100.addRegime(reg1002);
        throttle100.addRegime(reg1003);
        throttle100.addRegime(reg1004);
        throttle100.addRegime(reg1005);

        registerThrottle1 = new RegistThrottle();
        registerThrottle1.addThrottle(throttle25);
        registerThrottle1.addThrottle(throttle50);
        registerThrottle1.addThrottle(throttle100);

        LinkedList<Gear> gearList1 = new LinkedList<>();

        gearList1.add(new Gear(4.5));
        gearList1.add(new Gear(3.5));
        gearList1.add(new Gear(2.7));
        gearList1.add(new Gear(1.6));
        gearList1.add(new Gear(1.2));
        gearList1.add(new Gear(0.9));

        Map<String, Double> velocityLimitPerRoad = new HashMap<>();
        velocityLimitPerRoad.put("HIGHWAY", UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("ROAD", UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        vehicle = new Vehicle(Type.CAR, 2, Fuel.DIESEL, 2.4, 2400, 1200, 0.39, 0.015,
                0.8, 900, 5500, Motorization.COMBUSTION, registerThrottle1, 4, gearList1);
        vehicle.setName("Pick_up");
        vehicle.setDescription("Pick-up test vehicle");
        vehicle.setVelocityLimitPerRoad(velocityLimitPerRoad);

        LinkedList<Road> expectedList = new LinkedList<>();
        r1 = new Road("E01", Typology.ROAD);
        r2 = new Road("A01", Typology.HIGHWAY);
        r2.setToll(1, 0.15);
        r2.setToll(2, 0.25);
        r2.setToll(3, 0.35);
        r3 = new Road("A02", Typology.GANTRY);
        r4 = new Road("E06", Typology.ROAD);
        r5 = new Road("N232", Typology.ROAD);
        expectedList.add(r1);
        expectedList.add(r2);
        expectedList.add(r3);
        expectedList.add(r4);
        expectedList.add(r5);

        j000 = new Junction("n0");
        j001 = new Junction("n2");
        s01 = new Section();
        s01.setBegginingJunction("n0");
        s01.setEndingJunction("n2");
        s01.setRoad(r1);
        s01.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentListExpected01 = new LinkedList<>();
        sg1 = new Segment();
        sg1.setId(1);
        sg1.setInitialHeight(100);
        sg1.setFinalHeight(200);
        sg1.setLength(1200);
        sg1.setMaxSpeed(25);
        sg1.setMinSpeed(0);
        sg1.setWindDirection(20);
        sg1.setWindSpeed(5);
        segmentListExpected01.add(sg1);

        sg2 = new Segment();
        sg2.setId(2);
        sg2.setInitialHeight(200);
        sg2.setFinalHeight(150);
        sg2.setLength(6500);
        sg2.setMaxSpeed(25);
        sg2.setMinSpeed(0);
        sg2.setWindDirection(-10);
        sg2.setWindSpeed(2);
        segmentListExpected01.add(sg2);

        sg3 = new Segment();
        sg3.setId(3);
        sg3.setInitialHeight(150);
        sg3.setFinalHeight(350);
        sg3.setLength(4000);
        sg3.setMaxSpeed(25);
        sg3.setMinSpeed(0);
        sg3.setWindDirection(-10);
        sg3.setWindSpeed(2.5);
        segmentListExpected01.add(sg3);

        sg4 = new Segment();
        sg4.setId(4);
        sg4.setInitialHeight(350);
        sg4.setFinalHeight(150);
        sg4.setLength(10000);
        sg4.setMaxSpeed(25);
        sg4.setMinSpeed(0);
        sg4.setWindDirection(-60);
        sg4.setWindSpeed(2.7);
        segmentListExpected01.add(sg4);

        s01.setSegmentsList(segmentListExpected01);

    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getGroundFrictionForceSlope method, of class CarPhysics.
     */
    @Test
    public void testGetGroundFrictionForceSlope() {
        System.out.println("getGroundFrictionForceSlope");
        double expResult = 527.90;
        double result = CarPhysics.getGroundFrictionForceSlope(vehicle, sg1);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getEngineForce method, of class CarPhysics.
     */
    @Test
    public void testGetEngineForce() {
        System.out.println("getEngineForce");
        double torque = 185.0;
        double gearRatio = 4.5;
        double expResult = 4162.5;
        double result = CarPhysics.getEngineForce(vehicle, torque, gearRatio);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of forceOnVehicle method, of class CarPhysics.
     */
    @Test
    public void testForceOnVehicle() {
        System.out.println("forceOnVehicle");
        double torque = 185.0;
        double gearRatio = 4.5;
        double velocity = 4.1887;
        double expResult = 646.44;
        double result = CarPhysics.forceOnVehicle( sg1, vehicle, torque, gearRatio, velocity);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of vehicleLinearVelocity method, of class CarPhysics.
     */
    @Test
    public void testVehicleLinearVelocity() {
        System.out.println("vehicleLinearVelocity");
        double radiusTire = 0.8;
        int engineRotations = 900;
        double finalDriveRatio = 4.0;
        double gearRatio = 4.5;
        double expResult = 4.19;
        double result = CarPhysics.vehicleLinearVelocity(radiusTire, engineRotations, finalDriveRatio, gearRatio);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getRpm method, of class CarPhysics.
     */
    @Test
    public void testGetRpm() {
        System.out.println("getRpm");
        double vel = 4.1887;
        double radiusTire = 0.8;
        double finalDriveRatio = 4;
        double gearRatio = 4.5;
        double expResult = 899.98;
        double result = CarPhysics.getRpm(vel, radiusTire, finalDriveRatio, gearRatio);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getWindDragForce method, of class CarPhysics.
     */
    @Test
    public void testGetWindDragForce() {
        System.out.println("getWindDragForce");
        double velocity = 4.1887;
        double expResult = 45.28;
        double result = CarPhysics.getWindDragForce(vehicle, velocity, sg1);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getGravitationalForce method, of class CarPhysics.
     */
    @Test
    public void testGetGravitationalForce() {
        System.out.println("getGravitationalForce");
        double expResult = 2942.88;
        double result = CarPhysics.getGravitationalForce(vehicle, sg1);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getPowerGenerated method, of class CarPhysics.
     */
    @Test
    public void testGetPowerGenerated() {
        System.out.println("getPowerGenerated");
        double torque = 185.0;
        double rpm = 900.0;
        double expResult = 17435.84;
        double result = CarPhysics.getPowerGenerated(torque, rpm);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getInstantVelocity method, of class CarPhysics.
     */
    @Test
    public void testGetInstantVelocity() {
        System.out.println("getInstantVelocity");
        double initialVel = 0.0;
        double acel = 1.0;
        double time = 1.0;
        double expResult = 1.0;
        double result = CarPhysics.getInstantVelocity(initialVel, acel, time);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResultantForce method, of class CarPhysics.
     */
    @Test
    public void testGetResultantForce() {
        System.out.println("getResultantForce");
        double mass = 2400.0;
        double load = 1200.0;
        double acel = 1.0;
        double expResult = 3600.0;
        double result = CarPhysics.getResultantForce(mass, load, acel);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTorqueForRpm method, of class CarPhysics.
     */
    @Test
    public void testGetTorqueForRpm() {
        System.out.println("getTorqueForRpm");
        double rpm = 900.0;
        double expResult = 115.00;
        double result = CarPhysics.getTorqueForRpm(reg251, rpm);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of getGroundFrictionForce method, of class CarPhysics.
     */
    @Test
    public void testGetGroundFrictionForce() {
        System.out.println("getGroundFrictionForce");
        double expResult = 529.74;
        double result = CarPhysics.getGroundFrictionForce(vehicle);
        assertEquals(expResult, CarPhysics.roundValue(result), 0.0);
    }

    /**
     * Test of roundValue method, of class CarPhysics.
     */
    @Test
    public void testRoundValue() {
        System.out.println("roundValue");
        double value = 12.34496;
        double expResult = 12.34;
        double result = CarPhysics.roundValue(value);
        assertEquals(expResult, result, 0.0);
    }
}
