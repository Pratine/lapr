/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.model.graphbase.Edge;
import lapr.project.model.graphbase.Vertex;
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
public class ImportXMLTest {

    public ImportXMLTest() {
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
     * Test of importRoads method, of class ImportXML.
     */
    @Test
    public void testImportRoadNetwork() {
        System.out.println("importRoads");
        Project project = new Project();
        project.setName("Project");
        project.setDescription("Description");
        String filePath = "TestSet02_Network_v2.xml";
        ImportXML instance = new ImportXML();
        boolean result = instance.importRoadNetwork(project, filePath);

        /*Test junctions*/
        int numVertsExpected = 7;
        Junction[] resultJunctions = project.getRoadNetwork().allkeyVerts();
        Junction[] expectedJunctions = new Junction[7];
        expectedJunctions[0] = new Junction("n0");
        expectedJunctions[1] = new Junction("n1");
        expectedJunctions[2] = new Junction("n2");
        expectedJunctions[3] = new Junction("n3");
        expectedJunctions[4] = new Junction("n4");
        expectedJunctions[5] = new Junction("n5");
        expectedJunctions[6] = new Junction("n7");

        assertArrayEquals(expectedJunctions, resultJunctions);
        assertEquals(numVertsExpected, project.getRoadNetwork().numVertices());

        /*Test Road List*/
        int numOfRoadsExpected = 5;
        LinkedList<Road> expectedList = new LinkedList<>();
        Road r1 = new Road("E01", Typology.ROAD);
        Road r2 = new Road("A01", Typology.HIGHWAY);
        r2.setToll(1, 0.15);
        r2.setToll(2, 0.25);
        r2.setToll(3, 0.35);
        Road r3 = new Road("A02", Typology.GANTRY);
        Road r4 = new Road("E06", Typology.ROAD);
        Road r5 = new Road("N232", Typology.ROAD);
        expectedList.add(r1);
        expectedList.add(r2);
        expectedList.add(r3);
        expectedList.add(r4);
        expectedList.add(r5);

        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println(project.getRegistryRoads().getRoadsList().get(i));
            assertEquals(expectedList.get(i), project.getRegistryRoads().getRoadsList().get(i));
        }
        assertEquals(numOfRoadsExpected, project.getRegistryRoads().size());

        /*Test Sections*/
        int numEdgesExpected = 20;
        Iterable<Edge<Junction, Section>> edgesResult = project.getRoadNetwork().edges();

        Junction j000 = new Junction("n0");
        Junction j001 = new Junction("n2");
        Section s01 = new Section();
        s01.setBegginingJunction("n0");
        s01.setEndingJunction("n2");
        s01.setRoad(project.getRegistryRoads().getRoadByName("E01"));
        s01.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentListExpected01 = new LinkedList<>();
        Segment sg1 = new Segment();
        sg1.setId(1);
        sg1.setInitialHeight(100);
        sg1.setFinalHeight(200);
        sg1.setLength(1200);
        sg1.setMaxSpeed(25);
        sg1.setMinSpeed(0);
        sg1.setWindDirection(20);
        sg1.setWindSpeed(5);
        segmentListExpected01.add(sg1);

        Segment sg2 = new Segment();
        sg2.setId(2);
        sg2.setInitialHeight(200);
        sg2.setFinalHeight(150);
        sg2.setLength(6500);
        sg2.setMaxSpeed(25);
        sg2.setMinSpeed(0);
        sg2.setWindDirection(-10);
        sg2.setWindSpeed(2);
        segmentListExpected01.add(sg2);

        Segment sg3 = new Segment();
        sg3.setId(3);
        sg3.setInitialHeight(150);
        sg3.setFinalHeight(350);
        sg3.setLength(4000);
        sg3.setMaxSpeed(25);
        sg3.setMinSpeed(0);
        sg3.setWindDirection(-10);
        sg3.setWindSpeed(2.5);
        segmentListExpected01.add(sg3);

        Segment sg4 = new Segment();
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

        Edge<Junction, Section> e01 = new Edge<>(s01, s01.getTotalLengthOfSection(), new Vertex<>(0, j000), new Vertex<>(1, j001));

        Junction j002 = new Junction("n2");
        Junction j003 = new Junction("n0");
        Section s02 = new Section();
        s02.setBegginingJunction("n2");
        s02.setEndingJunction("n0");
        s02.setRoad(project.getRegistryRoads().getRoadByName("E01"));
        s02.setDirection(Boolean.TRUE);

        LinkedList<Segment> segmentListExpected02 = new LinkedList<>();
        Segment sg5 = new Segment();
        sg5.setId(4);
        sg5.setInitialHeight(150);
        sg5.setFinalHeight(350);
        sg5.setLength(10000);
        sg5.setMaxSpeed(25);
        sg5.setMinSpeed(0);
        sg5.setWindDirection(60);
        sg5.setWindSpeed(2.7);
        segmentListExpected02.add(sg5);

        Segment sg6 = new Segment();
        sg6.setId(3);
        sg6.setInitialHeight(350);
        sg6.setFinalHeight(150);
        sg6.setLength(4000);
        sg6.setMaxSpeed(25);
        sg6.setMinSpeed(0);
        sg6.setWindDirection(10);
        sg6.setWindSpeed(2.5);
        segmentListExpected02.add(sg6);

        Segment sg7 = new Segment();
        sg7.setId(2);
        sg7.setInitialHeight(150);
        sg7.setFinalHeight(200);
        sg7.setLength(6500);
        sg7.setMaxSpeed(25);
        sg7.setMinSpeed(0);
        sg7.setWindDirection(10);
        sg7.setWindSpeed(2);
        segmentListExpected02.add(sg7);

        Segment sg8 = new Segment();
        sg8.setId(1);
        sg8.setInitialHeight(200);
        sg8.setFinalHeight(100);
        sg8.setLength(1200);
        sg8.setMaxSpeed(25);
        sg8.setMinSpeed(0);
        sg8.setWindDirection(-20);
        sg8.setWindSpeed(5);
        segmentListExpected02.add(sg8);

        s02.setSegmentsList(segmentListExpected02);

        Edge<Junction, Section> e02 = new Edge<>(s02, s02.getTotalLengthOfSection(), new Vertex<>(2, j002), new Vertex<>(3, j003));

        LinkedList<Edge<Junction, Section>> edgesExpected = new LinkedList<>();

        edgesExpected.add(e01);
        edgesExpected.add(e02);

        for (Edge<Junction, Section> edge : edgesResult) {
            if (edge.getElement().getRoad().getName().equals("E01")
                    && edge.getVOrig().getId().equals("n0")
                    && edge.getVDest().getId().equals("n2")) {
                System.out.println(edge.getElement().getSegmentsList());
                assertEquals(segmentListExpected01, edge.getElement().getSegmentsList());
            }
        }
        for (Edge<Junction, Section> edge : edgesResult) {
            if (edge.getElement().getRoad().getName().equals("E01")
                    && edge.getVOrig().getId().equals("n2")
                    && edge.getVDest().getId().equals("n0")) {
                System.out.println(edge.getElement().getSegmentsList() + "\n");
                assertEquals(segmentListExpected02, edge.getElement().getSegmentsList());
            }
        }
        assertFalse(instance.importRoadNetwork(project, "fail.xml"));
        assertTrue(result);
        assertEquals(numEdgesExpected, project.getRoadNetwork().numEdges());
    }

    /**
     * Test of importVehicles method, of class ImportXML. //
     */
    @Test
    public void testImportVehicles() {
        System.out.println("importVehicles");
        Project project = new Project();
        project.setName("Project");
        project.setDescription("Description");
        String filePath = "TestSet02_Vehicles_v2.xml";
        ImportXML instance = new ImportXML();
        boolean result = instance.importVehicles(project, filePath);

        LinkedList<Vehicle> resultList = project.getRegistVehicle().getVehicleList();

        LinkedList<Vehicle> expectedList = new LinkedList<>();

        /*Vehicle 1*/
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
        velocityLimitPerRoad.put("HIGHWAY", UnitConverter.kilometerPerHourToMetersPerSecondDouble("110"));
        velocityLimitPerRoad.put("ROAD", UnitConverter.kilometerPerHourToMetersPerSecondDouble("80"));

        Vehicle vehicleCombustion01 = new Vehicle(Type.CAR, 2, Fuel.DIESEL, 2.4, 2400, 1200, 0.39, 0.015,
                0.8, 900, 5500, Motorization.COMBUSTION, registerThrottle1, 4, gearList1);
        vehicleCombustion01.setName("Pick_up");
        vehicleCombustion01.setDescription("Pick-up test vehicle");
        vehicleCombustion01.setVelocityLimitPerRoad(velocityLimitPerRoad);
        expectedList.add(vehicleCombustion01);

        /*Vehicle 2*/
        Regime reg256 = new Regime(185, 175, 0, 3499);
        Regime reg257 = new Regime(175, 166, 3500, 4499);
        Regime reg258 = new Regime(166, 158, 4500, 5499);
        Regime reg259 = new Regime(158, 143, 5500, 6499);
        Regime reg260 = new Regime(143, 129, 6500, 7499);
        Regime reg261 = new Regime(129, 116, 7500, 8499);
        Regime reg262 = new Regime(116, 104, 8500, 9499);
        Regime reg263 = new Regime(104, 81, 9500, 12500);

        Throttle throttle252 = new Throttle(25);
        throttle252.addRegime(reg256);
        throttle252.addRegime(reg257);
        throttle252.addRegime(reg258);
        throttle252.addRegime(reg259);
        throttle252.addRegime(reg260);
        throttle252.addRegime(reg261);
        throttle252.addRegime(reg262);
        throttle252.addRegime(reg263);

        Regime reg506 = new Regime(250, 237, 0, 3499);
        Regime reg507 = new Regime(237, 224, 3500, 4499);
        Regime reg508 = new Regime(224, 213, 4500, 5499);
        Regime reg509 = new Regime(213, 192, 5500, 6499);
        Regime reg510 = new Regime(192, 174, 6500, 7499);
        Regime reg511 = new Regime(174, 156, 7500, 8499);
        Regime reg512 = new Regime(156, 140, 8500, 9499);
        Regime reg513 = new Regime(140, 112, 9500, 12500);

        Throttle throttle502 = new Throttle(50);
        throttle502.addRegime(reg506);
        throttle502.addRegime(reg507);
        throttle502.addRegime(reg508);
        throttle502.addRegime(reg509);
        throttle502.addRegime(reg510);
        throttle502.addRegime(reg511);
        throttle502.addRegime(reg512);
        throttle502.addRegime(reg513);

        Regime reg1006 = new Regime(350, 332, 0, 3499);
        Regime reg1007 = new Regime(332, 315, 3500, 4499);
        Regime reg1008 = new Regime(315, 299, 4500, 5499);
        Regime reg1009 = new Regime(299, 270, 5500, 6499);
        Regime reg1010 = new Regime(270, 243, 6500, 7499);
        Regime reg1011 = new Regime(243, 222, 7500, 8499);
        Regime reg1012 = new Regime(222, 200, 8500, 9499);
        Regime reg1013 = new Regime(200, 160, 9500, 12500);

        Throttle throttle1002 = new Throttle(100);
        throttle1002.addRegime(reg1006);
        throttle1002.addRegime(reg1007);
        throttle1002.addRegime(reg1008);
        throttle1002.addRegime(reg1009);
        throttle1002.addRegime(reg1010);
        throttle1002.addRegime(reg1011);
        throttle1002.addRegime(reg1012);
        throttle1002.addRegime(reg1013);

        RegistThrottle registerThrottle2 = new RegistThrottle();
        registerThrottle2.addThrottle(throttle252);
        registerThrottle2.addThrottle(throttle502);
        registerThrottle2.addThrottle(throttle1002);

        LinkedList<Gear> gearList2 = new LinkedList<>();
        Gear g7 = new Gear(1);
        gearList2.add(g7);

        Vehicle vehicleEletric01 = new Vehicle(Type.CAR, 1, Fuel.ELECTRIC, 1.8, 1400, 420, 0.31, 0.01, 0.6, 0, 12500, Motorization.ELECTRIC, registerThrottle2, 10.6, gearList2, 0.8);
        vehicleEletric01.setName("ElectricDummy");
        vehicleEletric01.setDescription("Electric Dummy teste vehicle");

        expectedList.add(vehicleEletric01);
        assertEquals(vehicleCombustion01, resultList.getFirst());

        assertEquals(vehicleEletric01, resultList.getLast());

        assertEquals(3, project.getRegistVehicle().size());
        assertTrue(result);
        assertFalse(instance.importVehicles(project, "fail.xml"));
    }

}
