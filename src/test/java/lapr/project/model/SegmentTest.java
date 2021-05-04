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
public class SegmentTest {

    private Section sectionEx1;
    private Segment segmentEx1;
    private Segment segmentTest;
    private Segment segmentEx1copy;
    private Segment segmentEx2;
    private Vehicle vehicleEx1;

    public SegmentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        //Section
        sectionEx1 = new Section();
        sectionEx1.setBegginingJunction("n0");
        sectionEx1.setEndingJunction("n2");
        sectionEx1.setRoad(new Road("E01", Typology.ROAD));
        sectionEx1.setDirection(Boolean.TRUE);
        // Segments
        segmentEx1 = new Segment();
        segmentEx1.setId(1);
        segmentEx1.setInitialHeight(100.0);
        segmentEx1.setFinalHeight(200.0);
        segmentEx1.setLength(1200.0);
        segmentEx1.setMaxSpeed(25);
        segmentEx1.setMinSpeed(0);
        segmentEx1.setWindDirection(20);
        segmentEx1.setWindSpeed(5);
        
        segmentTest = new Segment();
        segmentTest.setId(1);
        segmentTest.setInitialHeight(100.0);
        segmentTest.setFinalHeight(200.0);
        segmentTest.setLength(1200.0);
        segmentTest.setMaxSpeed(100000);
        segmentTest.setMinSpeed(0);
        segmentTest.setWindDirection(20);
        segmentTest.setWindSpeed(5);

        segmentEx1copy = new Segment();
        segmentEx1copy.setId(1);
        segmentEx1copy.setInitialHeight(100);
        segmentEx1copy.setFinalHeight(200);
        segmentEx1copy.setLength(1200);
        segmentEx1copy.setMaxSpeed(25);
        segmentEx1copy.setMinSpeed(0);
        segmentEx1copy.setWindDirection(20);
        segmentEx1copy.setWindSpeed(5);

        segmentEx2 = new Segment();

        LinkedList<Segment> segmentList = new LinkedList<>();
        segmentList.add(segmentEx1);
        segmentList.add(segmentEx1copy);
        segmentList.add(segmentEx2);
        sectionEx1.setSegmentsList(segmentList);
        sectionEx1.setToll(1, 1.25);
        sectionEx1.setToll(2, 3.00);
        sectionEx1.setToll(3, 5.00);

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

        LinkedList<Gear> gearList1 = new LinkedList<>();

        gearList1.add(new Gear(4.5));
        gearList1.add(new Gear(3.5));
        gearList1.add(new Gear(2.7));
        gearList1.add(new Gear(1.6));
        gearList1.add(new Gear(1.2));
        gearList1.add(new Gear(0.9));

        Map<String, Double> velocityLimitPerRoad = new HashMap<>();
        velocityLimitPerRoad.put("Highway".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("Road".toUpperCase(), UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        vehicleEx1 = new Vehicle(Type.CAR, 2, Fuel.DIESEL, 2.4, 2400000, 1200000, 0.39, 0.015,
                0.8, 900, 5500, Motorization.COMBUSTION, registerThrottle1, 4, gearList1);
        vehicleEx1.setName("Pick_up");
        vehicleEx1.setDescription("Pick-up test vehicle");
        vehicleEx1.setVelocityLimitPerRoad(velocityLimitPerRoad);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Segment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = segmentEx1.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialHeight method, of class Segment.
     */
    @Test
    public void testGetInitialHeight() {
        System.out.println("getInitialHeight");
        double expResult = 100.0;
        double result = segmentEx1.getInitialHeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFinalHeight method, of class Segment.
     */
    @Test
    public void testGetFinalHeight() {
        System.out.println("getFinalHeight");
        double expResult = 200.0;
        double result = segmentEx1.getFinalHeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLength method, of class Segment.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        double expResult = 1200.0;
        double result = segmentEx1.getLength();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class Segment.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        int expResult = 25;
        int result = segmentEx1.getMaxSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinSpeed method, of class Segment.
     */
    @Test
    public void testGetMinSpeed() {
        System.out.println("getMinSpeed");
        int expResult = 0;
        int result = segmentEx1.getMinSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWindDirection method, of class Segment.
     */
    @Test
    public void testGetWindDirection() {
        System.out.println("getWindDirection");
        double expResult = 20.0;
        double result = segmentEx1.getWindDirection();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getWindSpeed method, of class Segment.
     */
    @Test
    public void testGetWindSpeed() {
        System.out.println("getWindSpeed");
        double expResult = 5.0;
        double result = segmentEx1.getWindSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setId method, of class Segment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int expected = 5;
        segmentEx2.setId(expected);
        int result = segmentEx2.getId();
        assertEquals(expected, result);
    }

    /**
     * Test of setInitialHeight method, of class Segment.
     */
    @Test
    public void testSetInitialHeight() {
        System.out.println("setInitialHeight");
        double expected = 1.3;
        segmentEx2.setInitialHeight(expected);
        double result = segmentEx2.getInitialHeight();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setFinalHeight method, of class Segment.
     */
    @Test
    public void testSetFinalHeight() {
        System.out.println("setFinalHeight");
        double expected = 1.5;
        segmentEx2.setFinalHeight(expected);
        double result = segmentEx2.getFinalHeight();
        assertEquals(expected, result, 0.0);

    }

    /**
     * Test of setLength method, of class Segment.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        double expected = 245.0;
        segmentEx2.setLength(expected);
        double result = segmentEx2.getLength();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setMaxSpeed method, of class Segment.
     */
    @Test
    public void testSetMaxSpeed() {
        System.out.println("setMaxSpeed");
        int expected = 90;
        segmentEx2.setMaxSpeed(expected);
        int result = segmentEx2.getMaxSpeed();
        assertEquals(expected, result);
    }

    /**
     * Test of setMinSpeed method, of class Segment.
     */
    @Test
    public void testSetMinSpeed() {
        System.out.println("setMinSpeed");
        int expected = 40;
        segmentEx2.setMinSpeed(expected);
        int result = segmentEx2.getMinSpeed();
        assertEquals(expected, result);
    }

    /**
     * Test of setWindDirection method, of class Segment.
     */
    @Test
    public void testSetWindDirection() {
        System.out.println("setWindDirection");
        double expected = 1.2;
        segmentEx2.setWindDirection(expected);
        double result = segmentEx2.getWindDirection();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of setWindSpeed method, of class Segment.
     */
    @Test
    public void testSetWindSpeed() {
        System.out.println("setWindSpeed");
        double expected = 5.0;
        segmentEx2.setWindSpeed(expected);
        double result = segmentEx2.getWindSpeed();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of toString method, of class Segment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringBuilder sb = new StringBuilder();

        sb.append("\t\tSegment: ").append("1").append("\n");
        sb.append("\t\t\tInitial Height: ").append("100.0").append("\n");
        sb.append("\t\t\tFinal Height: ").append("200.0").append("\n");
        sb.append("\t\t\tLength: ").append("1200.0").append("\n");
        sb.append("\t\t\tMax Velocity: ").append("25").append("\n");
        sb.append("\t\t\tMin Velocity: ").append("0").append("\n");
        sb.append("\t\t\tWind Direction: ").append("20.0").append("\n");
        sb.append("\t\t\tWind Speed: ").append("5.0").append("\n");

        String result = segmentEx1.toString();
        String expResult = sb.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of segmentNecessaryTimeMaxSpeed method, of class Segment.
     */
    @Test
    public void testSegmentNecessaryTimeMaxSpeed() {
        System.out.println("segmentNecessaryTimeMaxSpeed");
        double velOnTypology = vehicleEx1.getVelocityLimitOfRoad(Typology.ROAD.toString().toUpperCase());
        double expResult = 54.01;
        double result = segmentEx1.segmentNecessaryTimeMaxSpeed(vehicleEx1, velOnTypology);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSegmentVehicleMaxSpeed method, of class Segment.
     */
    @Test
    public void testGetSegmentVehicleMaxSpeed() {
        System.out.println("getSegmentVehicleMaxSpeed");
        
        //test made to return velocity max on typology as return
        double velOnTypology = vehicleEx1.getVelocityLimitOfRoad("Road".toUpperCase());
        double expResult = 22.22;
        double result = segmentEx1.getSegmentVehicleMaxSpeed(vehicleEx1, velOnTypology);
        assertEquals(expResult, result, 0.0);
        
        //test made to return velocity max of vehicle as return
        double velTypology2 = 1000;
        double result2 = segmentTest.getSegmentVehicleMaxSpeed(vehicleEx1, velTypology2);
        double expResult2 = vehicleEx1.maxSpeed(); 
        assertEquals(expResult2, result2, 0.0);
        
        //test made to return velocity max of segment as return
        segmentTest.setMaxSpeed(10);
        double result3 = segmentTest.getSegmentVehicleMaxSpeed(vehicleEx1, velTypology2);
        double expResult3 = segmentTest.getMaxSpeed();
        assertEquals(expResult3, result3, 0.0);

    }

    /**
     * Test of equals method, of class Segment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Segment instance = new Segment();
        Segment s1 = new Segment();
        instance.setMinSpeed(23);
        instance.setId(1);
        boolean expResult = true;
        boolean result = segmentEx1.equals(segmentEx1copy);
        boolean result1 = segmentEx1.equals(segmentEx2);
        boolean result2 = segmentEx1.equals(new Segment());
        boolean result3 = segmentEx1.equals(new Section());
        boolean result4 = segmentEx1.equals(instance);
        boolean result5 = segmentEx1.equals(s1);
        Segment sg = null;
        boolean result6 = segmentEx1.equals(sg);
        assertEquals(expResult, result);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertFalse(result6);
    }

    /**
     * Test of getSlope method, of class Segment.
     */
    @Test
    public void testGetSlope() {
        System.out.println("getSlope");
        double expResult = 4.78;
        double result = segmentEx1.getSlope();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSegmentEnergy method, of class Segment.
     */
    @Test
    public void testGetSegmentEnergy() {
        System.out.println("getSegmentEnergy");
        
        double maxVelTypology = 20.0;
        double velInitial = 1.0;
        double acel = 1.0;
        double timeInter = 1.0;
        
        double []resultArray = segmentEx1.getSegmentEnergy(vehicleEx1,maxVelTypology,velInitial,acel,timeInter,vehicleEx1.getLoad(),false);
        double expResult = 35537.38;
        double result = resultArray[0]/1000000; //to MegaJoule
        double expResult1 = 35536.56;
        double expResult2 = 35538.01;
        
        boolean resultMax = false;
        boolean resultMin = false;
        
      
        if(result-expResult2<0.0000001f){
            resultMax = true;
        }
        
        if(result-expResult1>0.0000001f){
            resultMin = true;
        }
       
        assertEquals(true, resultMax);
        assertEquals(true, resultMin);
    }

    /**
     * Test of validate method, of class Segment.
     *
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        boolean expResult = true;
        Segment segment1 = new Segment();
        Segment segment2 = new Segment();
        Segment segment3 = new Segment();
        Segment segment4 = new Segment();
        Segment segment5 = new Segment();
        Segment segment6 = new Segment();
        Segment segment7 = new Segment();
        Segment segment8 = new Segment();
        Segment segment9 = new Segment();

        segment1.setId(1);

        segment2.setId(1);
        segment2.setInitialHeight(2);

        segment3.setId(1);
        segment3.setInitialHeight(2);
        segment3.setFinalHeight(3);

        segment4.setId(1);
        segment4.setInitialHeight(2);
        segment4.setFinalHeight(3);
        segment4.setLength(231);

        segment5.setId(1);
        segment5.setInitialHeight(2);
        segment5.setFinalHeight(3);
        segment5.setLength(231);
        segment5.setMinSpeed(23);

        segment6.setId(1);
        segment6.setInitialHeight(2);
        segment6.setFinalHeight(3);
        segment6.setLength(231);
        segment6.setMinSpeed(23);
        segment6.setMaxSpeed(245);
        
        segment7.setId(1);
        segment7.setInitialHeight(2);
        segment7.setFinalHeight(3);
        segment7.setLength(231);
        segment7.setMinSpeed(0);
        segment7.setMaxSpeed(245);
        
        segment8.setId(1);
        segment8.setInitialHeight(2);
        segment8.setFinalHeight(3);
        segment8.setLength(231);
        segment8.setMinSpeed(245);
        segment8.setMaxSpeed(245);
        
        segment9.setId(1);
        segment9.setInitialHeight(2);
        segment9.setFinalHeight(3);
        segment9.setLength(231);
        segment9.setMinSpeed(246);
        segment9.setMaxSpeed(245);

        boolean result = segmentEx1.validate();
        boolean result1 = new Segment().validate();
        boolean result2 = segment1.validate();
        boolean result3 = segment2.validate();
        boolean result4 = segment3.validate();
        boolean result5 = segment4.validate();
        boolean result6 = segment5.validate();
        boolean result7 = segment6.validate();
        boolean result8 = segment7.validate();
        boolean result9 = segment8.validate();
        boolean result10 = segment9.validate();

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
        assertFalse(result10);
    }

    /**
     * Test of maxSpeedWind method, of class Segment.
     */
    @Test
    public void testMaxSpeedWind() {
        System.out.println("maxSpeedWind");
        double expResult = 4.7;
        double result = CarPhysics.roundValue(segmentEx1.maxSpeedWind());
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of hashCode method, of class Segment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Segment instance = new Segment();
        int expResult = 12;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    /**
     * Test of getPowerBySegment method, of class Segment.
     */
    @Test
    public void testGetPowerBySegment() {
        System.out.println("getPowerBySegment");
        
        double maxVelTypology = vehicleEx1.getVelocityLimitOfRoad("ROAD");
        
        
        boolean lastSeg = false;
        double acel = 1.0;
        double interTemp = 1.0;
        double load = 1200.0;
        double velInitial = 1.0;
        double []result = segmentEx1.getPowerBySegment(vehicleEx1, maxVelTypology,velInitial,acel,interTemp,load,lastSeg);
        
        double expResult1 = 2185347.44;
        double expResult2 = 2185351.32;
        
        boolean resultMax = false;
        boolean resultMin = false;
        
        //interval due to human error calculations
        if(result[0]-expResult2<0.0000001f){
            resultMax = true;
        }
        
        if(result[0]-expResult1>0.0000001f){
            resultMin = true;
        }
       
        assertEquals(true, resultMax);
        assertEquals(true, resultMin);
        
    }
}
