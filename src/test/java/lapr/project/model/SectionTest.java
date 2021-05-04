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
public class SectionTest {

    private Section sectionEx1;
    private Section sectionEx1Copy;
    private Section sectionEx2;
    private Section sectionFail;
    private Vehicle vehicleEx1;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        // Sections
        // SectionFail
        sectionFail = new Section();
        // Section1
        sectionEx1 = new Section();
        sectionEx1.setBegginingJunction("n0");
        sectionEx1.setEndingJunction("n2");
        sectionEx1.setRoad(new Road("E01", Typology.ROAD));
        sectionEx1.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentList01 = new LinkedList<>();
        Segment sg1 = new Segment();
        sg1.setId(1);
        sg1.setInitialHeight(100);
        sg1.setFinalHeight(200);
        sg1.setLength(1200);
        sg1.setMaxSpeed(25);
        sg1.setMinSpeed(0);
        sg1.setWindDirection(20);
        sg1.setWindSpeed(5);
        segmentList01.add(sg1);

        Segment sg2 = new Segment();
        sg2.setId(2);
        sg2.setInitialHeight(200);
        sg2.setFinalHeight(150);
        sg2.setLength(6500);
        sg2.setMaxSpeed(25);
        sg2.setMinSpeed(0);
        sg2.setWindDirection(-10);
        sg2.setWindSpeed(2);
        segmentList01.add(sg2);

        Segment sg3 = new Segment();
        sg3.setId(3);
        sg3.setInitialHeight(150);
        sg3.setFinalHeight(350);
        sg3.setLength(4000);
        sg3.setMaxSpeed(25);
        sg3.setMinSpeed(0);
        sg3.setWindDirection(-10);
        sg3.setWindSpeed(2.5);
        segmentList01.add(sg3);

        Segment sg4 = new Segment();
        sg4.setId(4);
        sg4.setInitialHeight(350);
        sg4.setFinalHeight(150);
        sg4.setLength(10000);
        sg4.setMaxSpeed(25);
        sg4.setMinSpeed(0);
        sg4.setWindDirection(-60);
        sg4.setWindSpeed(2.7);
        segmentList01.add(sg4);

        sectionEx1.setSegmentsList(segmentList01);
        sectionEx1.setToll(1, 1.25);
        sectionEx1.setToll(2, 3.00);
        sectionEx1.setToll(3, 5.00);

        // Section1 (copy)
        sectionEx1Copy = new Section();
        sectionEx1Copy.setBegginingJunction("n0");
        sectionEx1Copy.setEndingJunction("n2");
        sectionEx1Copy.setRoad(new Road("E01"));
        sectionEx1Copy.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentList01c = new LinkedList<>();
        Segment sg1c = new Segment();
        sg1c.setId(1);
        sg1c.setInitialHeight(100);
        sg1c.setFinalHeight(200);
        sg1c.setLength(1200);
        sg1c.setMaxSpeed(25);
        sg1c.setMinSpeed(0);
        sg1c.setWindDirection(20);
        sg1c.setWindSpeed(5);
        segmentList01c.add(sg1c);

        Segment sg2c = new Segment();
        sg2c.setId(2);
        sg2c.setInitialHeight(200);
        sg2c.setFinalHeight(150);
        sg2c.setLength(6500);
        sg2c.setMaxSpeed(25);
        sg2c.setMinSpeed(0);
        sg2c.setWindDirection(-10);
        sg2c.setWindSpeed(2);
        segmentList01c.add(sg2c);

        Segment sg3c = new Segment();
        sg3c.setId(3);
        sg3c.setInitialHeight(150);
        sg3c.setFinalHeight(350);
        sg3c.setLength(4000);
        sg3c.setMaxSpeed(25);
        sg3c.setMinSpeed(0);
        sg3c.setWindDirection(-10);
        sg3c.setWindSpeed(2.5);
        segmentList01c.add(sg3c);

        Segment sg4c = new Segment();
        sg4c.setId(4);
        sg4c.setInitialHeight(350);
        sg4c.setFinalHeight(150);
        sg4c.setLength(10000);
        sg4c.setMaxSpeed(25);
        sg4c.setMinSpeed(0);
        sg4c.setWindDirection(-60);
        sg4c.setWindSpeed(2.7);
        segmentList01c.add(sg4c);

        sectionEx1Copy.setSegmentsList(segmentList01c);

        sectionEx1Copy.setToll(1, 1.25);
        sectionEx1Copy.setToll(2, 3.00);
        sectionEx1Copy.setToll(3, 5.00);

        // Section2
        sectionEx2 = new Section();
        sectionEx2.setBegginingJunction("n1");
        sectionEx2.setEndingJunction("n3");
        sectionEx2.setRoad(new Road("E02", Typology.ROAD));
        sectionEx2.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentListf = new LinkedList<>();
        Segment sg1f = new Segment();
        sg1f.setId(1);
        sg1f.setInitialHeight(110);
        sg1f.setFinalHeight(210);
        sg1f.setLength(1100);
        sg1f.setMaxSpeed(30);
        sg1f.setMinSpeed(5);
        sg1f.setWindDirection(20);
        sg1f.setWindSpeed(5);
        segmentListf.add(sg1f);

        Segment sg2f = new Segment();
        sg2f.setId(2);
        sg2f.setInitialHeight(200);
        sg2f.setFinalHeight(150);
        sg2f.setLength(6000);
        sg2f.setMaxSpeed(25);
        sg2f.setMinSpeed(5);
        sg2f.setWindDirection(10);
        sg2f.setWindSpeed(2.3);
        segmentListf.add(sg2f);

        Segment sg3f = new Segment();
        sg3f.setId(3);
        sg3f.setInitialHeight(160);
        sg3f.setFinalHeight(370);
        sg3f.setLength(4100);
        sg3f.setMaxSpeed(25);
        sg3f.setMinSpeed(5);
        sg3f.setWindDirection(10);
        sg3f.setWindSpeed(2.0);
        segmentListf.add(sg3);

        Segment sg4f = new Segment();
        sg4f.setId(4);
        sg4f.setInitialHeight(330);
        sg4f.setFinalHeight(130);
        sg4f.setLength(11000);
        sg4f.setMaxSpeed(35);
        sg4f.setMinSpeed(5);
        sg4f.setWindDirection(60);
        sg4f.setWindSpeed(2.7);
        segmentListf.add(sg4);

        sectionEx2.setSegmentsList(segmentList01);
        sectionEx2.setToll(1, 1.25);
        sectionEx2.setToll(2, 3.00);
        sectionEx2.setToll(3, 5.00);

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
     * Test of getBegginingJunction method, of class Section.
     */
    @Test
    public void testGetBegginingJunction() {
        System.out.println("getBegginingJunction");
        Junction expResult = new Junction("n0");
        Junction result = sectionEx1.getBegginingJunction();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndingJunction method, of class Section.
     */
    @Test
    public void testGetEndingJunction() {
        System.out.println("getEndingJunction");
        Junction expResult = new Junction("n2");
        Junction result = sectionEx1.getEndingJunction();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirection method, of class Section.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Boolean expResult = true;
        Boolean result = sectionEx1.getDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegmentsList method, of class Section.
     */
    @Test
    public void testGetSegmentsList() {
        System.out.println("getSegmentsList");
        LinkedList<Segment> lSeg = new LinkedList<>();
        Segment sg1 = new Segment();
        sg1.setId(1);
        sg1.setInitialHeight(100);
        sg1.setFinalHeight(200);
        sg1.setLength(1200);
        sg1.setMaxSpeed(25);
        sg1.setMinSpeed(0);
        sg1.setWindDirection(20);
        sg1.setWindSpeed(5);
        lSeg.add(sg1);

        Segment sg2 = new Segment();
        sg2.setId(2);
        sg2.setInitialHeight(200);
        sg2.setFinalHeight(150);
        sg2.setLength(6500);
        sg2.setMaxSpeed(25);
        sg2.setMinSpeed(0);
        sg2.setWindDirection(-10);
        sg2.setWindSpeed(2);
        lSeg.add(sg2);

        Segment sg3 = new Segment();
        sg3.setId(3);
        sg3.setInitialHeight(150);
        sg3.setFinalHeight(350);
        sg3.setLength(4000);
        sg3.setMaxSpeed(25);
        sg3.setMinSpeed(0);
        sg3.setWindDirection(-10);
        sg3.setWindSpeed(2.5);
        lSeg.add(sg3);

        Segment sg4 = new Segment();
        sg4.setId(4);
        sg4.setInitialHeight(350);
        sg4.setFinalHeight(150);
        sg4.setLength(10000);
        sg4.setMaxSpeed(25);
        sg4.setMinSpeed(0);
        sg4.setWindDirection(-60);
        sg4.setWindSpeed(2.7);
        lSeg.add(sg4);
        LinkedList<Segment> expResult = lSeg;
        LinkedList<Segment> result = sectionEx1.getSegmentsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTollFare method, of class Section.
     */
    @Test
    public void testGetTollFare() {
        System.out.println("getTollFare");
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(1, 1.25);
        expected.put(2, 3.0);
        expected.put(3, 5.00);
        Map<Integer, Double> result = sectionEx1.getTollFare();
        assertEquals(expected, result);
    }

    /**
     * Test of getRoad method, of class Section.
     */
    @Test
    public void testGetRoad() {
        System.out.println("getRoad");
        Road expResult = new Road("E01", Typology.ROAD);
        Road result = sectionEx1.getRoad();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBegginingJunction method, of class Section.
     */
    @Test
    public void testSetBegginingJunction() {
        System.out.println("setBegginingJunction");
        String begginingJunction = "test";
        Junction expected = new Junction(begginingJunction);
        Section instance = new Section();
        instance.setBegginingJunction(begginingJunction);
        Junction result = instance.getBegginingJunction();
        assertEquals(expected, result);
    }

    /**
     * Test of setEndingJunction method, of class Section.
     */
    @Test
    public void testSetEndingJunction() {
        System.out.println("setEndingJunction");
        String endingJunction = "test";
        Junction expected = new Junction(endingJunction);
        Section instance = new Section();
        instance.setEndingJunction(endingJunction);
        Junction result = instance.getEndingJunction();
        assertEquals(expected, result);
    }

    /**
     * Test of setDirection method, of class Section.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        Boolean expected = true;
        Section instance = new Section();
        instance.setDirection(true);
        Boolean result = instance.getDirection();
        assertEquals(result, expected);
    }

    /**
     * Test of setSegmentsList method, of class Section.
     */
    @Test
    public void testSetSegmentsList() {
        System.out.println("setSegmentsList");
        Section instance = new Section();
        LinkedList<Segment> lSeg = new LinkedList<>();
        Segment sg1 = new Segment();
        sg1.setId(1);
        sg1.setInitialHeight(100);
        sg1.setFinalHeight(200);
        sg1.setLength(1200);
        sg1.setMaxSpeed(25);
        sg1.setMinSpeed(0);
        sg1.setWindDirection(20);
        sg1.setWindSpeed(5);
        lSeg.add(sg1);

        Segment sg2 = new Segment();
        sg2.setId(2);
        sg2.setInitialHeight(200);
        sg2.setFinalHeight(150);
        sg2.setLength(6500);
        sg2.setMaxSpeed(25);
        sg2.setMinSpeed(0);
        sg2.setWindDirection(-10);
        sg2.setWindSpeed(2);
        lSeg.add(sg2);

        Segment sg3 = new Segment();
        sg3.setId(3);
        sg3.setInitialHeight(150);
        sg3.setFinalHeight(350);
        sg3.setLength(4000);
        sg3.setMaxSpeed(25);
        sg3.setMinSpeed(0);
        sg3.setWindDirection(-10);
        sg3.setWindSpeed(2.5);
        lSeg.add(sg3);

        Segment sg4 = new Segment();
        sg4.setId(4);
        sg4.setInitialHeight(350);
        sg4.setFinalHeight(150);
        sg4.setLength(10000);
        sg4.setMaxSpeed(25);
        sg4.setMinSpeed(0);
        sg4.setWindDirection(-60);
        sg4.setWindSpeed(2.7);
        lSeg.add(sg4);
        instance.setSegmentsList(lSeg);
        LinkedList<Segment> result = instance.getSegmentsList();
        LinkedList<Segment> expected = sectionEx1.getSegmentsList();
        assertEquals(expected, result);
    }

    /**
     * Test of setRoad method, of class Section.
     */
    @Test
    public void testSetRoad() {
        System.out.println("setRoad");
        Road expected = new Road("test");
        expected.setTypology(Typology.HIGHWAY);
        Section instance = new Section();
        instance.setRoad(expected);
        Road result = instance.getRoad();
        assertEquals(expected, result);
    }

    /**
     * Test of setToll method, of class Section.
     */
    @Test
    public void testSetToll() {
        System.out.println("setToll");
        Integer id = 1;
        Double fare = 1.25;
        Section instance = new Section();
        instance.setToll(id, fare);
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(id, fare);
        Map<Integer, Double> result = instance.getTollFare();
        assertEquals(expected, result);
    }

    /**
     * Test of toString method, of class Section.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringBuilder expectedString = new StringBuilder();
        expectedString.append(new Road("E01", Typology.ROAD));
        expectedString.append("Begin: ").append("n0").append("\n");
        expectedString.append("End: ").append("n2").append("\n");
        String result = sectionEx1.toString();
        String expected = expectedString.toString();
        assertEquals(expected, result);
    }

    /**
     * Test of equals method, of class Section.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = sectionEx1.equals(sectionEx1);
        boolean result1 = sectionEx1.equals(sectionEx1Copy);
        boolean result2 = sectionEx1.equals(sectionEx2);
        boolean result3 = sectionEx1.equals(new Segment());
        assertFalse(result3);
        assertFalse(result2);
        assertEquals(expResult, result);
        assertEquals(expResult, result1);
    }

    /**
     * Test of hashCode method, of class Section.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 27287642;
        int result = sectionEx1.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of sectionNecessaryTimeMaxSpeed method, of class Section.
     */
    @Test
    public void testSectionNecessaryTimeMaxSpeed() {
        System.out.println("sectionNecessaryTimeMaxSpeed");
        double expResult = 976.61;
        double result = sectionEx1.sectionNecessaryTimeMaxSpeed(vehicleEx1);
        assertEquals(expResult, result, 0.0);
    }
//
//    /**
//     * Test of sectionPower method, of class Section.
//     */
//    @Test
//    public void testSectionPower() {
//        System.out.println("sectionPower");
//        Vehicle vehicle = null;
//        Section instance = new Section();
//        double expResult = 0.0;
//        double result = instance.sectionPower(vehicle);
//        assertEquals(expResult, result, 0.0);
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of sectionEnergy method, of class Section.
//     */
//    @Test
//    public void testSectionEnergy() {
//        System.out.println("sectionEnergy");
//        Vehicle vehicle = null;
//        Section instance = new Section();
//        double expResult = 0.0;
//        double result = instance.sectionEnergy(vehicle);
//        assertEquals(expResult, result, 0.0);
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getTotalLengthOfSection method, of class Section.
     */
    @Test
    public void testGetTotalLengthOfSection() {
        System.out.println("getTotalLengthOfSection");
        double expResult = 21700.0;
        double result = sectionEx1.getTotalLengthOfSection();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of newSegment method, of class Section.
     */
    @Test
    public void testNewSegment() {
        System.out.println("newSegment");
        Segment expResult = new Segment();
        Segment result = sectionEx1.newSegment();
        assertEquals(expResult, result);
    }

    /**
     * Test of newRoad method, of class Section.
     */
    @Test
    public void testNewRoad() {
        System.out.println("newRoad");
        Road expResult = new Road();
        Road result = sectionEx1.newRoad();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Section.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        boolean expResult = true;
        boolean result = sectionEx1.validate();
        Section sFail1 = new Section();
        Section sFail2 = new Section();
        Section sFail3 = new Section();
        Section sFail4 = new Section();
        sFail1.setBegginingJunction("fail");
        sFail2.setBegginingJunction("fail");
        sFail2.setEndingJunction("fail");
        sFail3.setBegginingJunction("fail");
        sFail3.setEndingJunction("fail");
        Road r = new Road();
        sFail3.setRoad(r);
        sFail4.setBegginingJunction("fail");
        sFail4.setEndingJunction("fail");
        Road road = new Road("fail");
        road.setTypology(Typology.ROAD);
        sFail4.setRoad(road);
        sFail4.setDirection(null);
        boolean result1 = sectionFail.validate();
        boolean result2 = sFail1.validate();
        boolean result3 = sFail2.validate();
        boolean result4 = sFail3.validate();
        boolean result5 = sFail4.validate();
        assertEquals(expResult, result);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);

    }

    /**
     * Test of getTypoligy method, of class Section.
     */
    @Test
    public void testGetTypoligy() {
        System.out.println("getTypoligy");
        Typology expResult = Typology.ROAD;
        Typology result = sectionEx1.getTypoligy();
        assertEquals(expResult, result);
    }

}
