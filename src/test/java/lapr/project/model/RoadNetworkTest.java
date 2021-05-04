
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.graphbase.Graph;
import lapr.project.utils.UnitConverter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author salva
 */
public class RoadNetworkTest {

    private Vehicle vehicle;
    private Road r1, r2, r3, r4, r5;
    private Project project;
    private Junction j000, j001,j002,j003;
    private Section s01,s02,s03,s04;
    private Segment sg1, sg2, sg3, sg4;
    private Throttle throttle25, throttle50, throttle100;
    private Regime reg251, reg252, reg253, reg254, reg255;
    private Regime reg501, reg502, reg503, reg504, reg505;
    private Regime reg1001, reg1002, reg1003, reg1004, reg1005;
    private RegistThrottle registerThrottle1;
    Graph<Junction, Section> graph = new Graph<>(true);
    private LinkedList<Segment> segmentListExpected01;
    private LinkedList<Segment> segmentListExpected02;

    public RoadNetworkTest() {
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
        j001 = new Junction("n1");
        j002 = new Junction("n2");
        j003 = new Junction("n3");
        
        s01 = new Section();
        s01.setBegginingJunction("n0");
        s01.setEndingJunction("n1");
        s01.setRoad(r1);
        s01.setDirection(Boolean.TRUE);
        
        s02 = new Section();
        s02.setBegginingJunction("n1");
        s02.setEndingJunction("n3");
        s02.setRoad(r1);
        s02.setDirection(Boolean.TRUE);
        
        s03 = new Section();
        s03.setBegginingJunction("n0");
        s03.setEndingJunction("n2");
        s03.setRoad(r1);
        s03.setDirection(Boolean.TRUE);
        
        s04 = new Section();
        s04.setBegginingJunction("n2");
        s04.setEndingJunction("n3");
        s04.setRoad(r1);
        s04.setDirection(Boolean.TRUE);

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
        
        segmentListExpected02 = new LinkedList<>();
        segmentListExpected02.add(sg1);

        s01.setSegmentsList(segmentListExpected01);
        s02.setSegmentsList(segmentListExpected01);
        s03.setSegmentsList(segmentListExpected01);
        s04.setSegmentsList(segmentListExpected02);
        
        graph.insertVertex(j000);
        graph.insertVertex(j001);
        graph.insertVertex(j002);
        graph.insertVertex(j003);
        graph.insertEdge(j000, j001, s01, 0);
        graph.insertEdge(j001, j003, s02, 0);
        graph.insertEdge(j000, j002, s03, 0);
        graph.insertEdge(j002, j003, s04, 0);
        
        

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcTollCost method, of class RoadNetwork.
     */
    @Test
    public void testCalcTollCost() {
        Junction a = new Junction("a");
        Junction b = new Junction("b");
        Junction c = new Junction("c");
        Junction d = new Junction("d");
        Junction e = new Junction("e");

        Segment segA = new Segment(1, 0, 0, 10000, 0, 0, 33, 0);
        Segment segB = new Segment(2, 0, 0, 10000, 0, 0, 13, 0);
        Segment segC = new Segment(3, 0, 0, 10000, 0, 0, 33, 0);
        Segment segD = new Segment(4, 0, 0, 10000, 0, 0, 33, 0);

        LinkedList<Segment> segmentsList1 = new LinkedList<>();
        LinkedList<Segment> segmentsList2 = new LinkedList<>();
        LinkedList<Segment> segmentsList3 = new LinkedList<>();
        LinkedList<Segment> segmentsList4 = new LinkedList<>();

        Road r1 = new Road();
        Road r2 = new Road();
        Road r3 = new Road();
        Road r4 = new Road();

        r1.setTypology(Typology.ROAD);
        r2.setTypology(Typology.HIGHWAY);
        r2.setToll(2, 1.0);
        r3.setTypology(Typology.GANTRY);
        r4.setTypology(Typology.ROAD);

        Section s1 = new Section(a, b, r1, true);
        Section s2 = new Section(b, c, r2, true);
        Section s3 = new Section(c, d, r3, true);
        s3.setToll(2, 2.0);
        Section s4 = new Section(d, e, r4, true);

        s1.setSegmentsList(segmentsList1);
        s2.setSegmentsList(segmentsList2);
        s3.setSegmentsList(segmentsList3);
        s4.setSegmentsList(segmentsList4);
        segmentsList1.add(segA);
        segmentsList2.add(segB);
        segmentsList3.add(segC);
        segmentsList4.add(segD);

        Vehicle v = new Vehicle();
        v.setTollClass(2);

        System.out.println("calcTollCost");

        LinkedList<Section> sectionList1 = new LinkedList<>();
        sectionList1.add(s1);
        sectionList1.add(s2);
        sectionList1.add(s3);
        sectionList1.add(s4);
        double expResult1 = 12.0;

        LinkedList<Section> sectionList2 = new LinkedList<>();
        sectionList2.add(s1);
        sectionList2.add(s2);
        sectionList2.add(s4);
        double expResult2 = 10.0;

        LinkedList<Section> sectionList3 = new LinkedList<>();
        sectionList3.add(s1);
        sectionList3.add(s3);
        sectionList3.add(s4);
        double expResult3 = 2.0;

        LinkedList<Section> sectionList4 = new LinkedList<>();
        sectionList4.add(s1);
        sectionList4.add(s4);
        double expResult4 = 0.0;

        double result1 = RoadNetwork.calcTollCost(sectionList1, v);
        double result2 = RoadNetwork.calcTollCost(sectionList2, v);
        double result3 = RoadNetwork.calcTollCost(sectionList3, v);
        double result4 = RoadNetwork.calcTollCost(sectionList4, v);

        System.out.println("Toltal length of Section 1: " + s1.getTotalLengthOfSection());
        System.out.println("Toltal length of Section 2: " + s1.getTotalLengthOfSection());
        System.out.println("Toltal length of Section 3: " + s1.getTotalLengthOfSection());
        System.out.println("Toltal length of Section 4: " + s1.getTotalLengthOfSection());

        System.out.println("SectionList size: " + sectionList1.size());
        System.out.println("Toll Fare of section3 " + s3.getTollFare().get(v.getTollClass()));
        System.out.println("Toll Fare of Road 2 " + r2.getTollFare().get(v.getTollClass()));

        System.out.println("Expected1: " + expResult1 + " | Result1: " + result1);
        System.out.println("Expected2: " + expResult2 + " | Result2: " + result2);
        System.out.println("Expected3: " + expResult3 + " | Result3: " + result3);
        System.out.println("Expected4: " + expResult4 + " | Result4: " + result4);

        assertEquals(expResult1, result1, 0.0);
        assertEquals(expResult2, result2, 0.0);
        assertEquals(expResult3, result3, 0.0);
        assertEquals(expResult4, result4, 0.0);

    }

    /**
     * Test of getBestPath method, of class RoadNetwork.
     */
    @Test
    public void testGetBestPath() {
        System.out.println("getBestPath");
        
        double acel = 1.0;
        double timeInter = 1.0;
        double load = 100000.0;
        String algoritName = "FASTESTPATH";
        LinkedList<Section> expResult = new LinkedList<>();
        expResult.add(s03);
        expResult.add(s04);
        LinkedList<Section> result = RoadNetwork.getBestPath(graph, j000, j003, vehicle, acel, timeInter, load, algoritName);
        assertEquals(expResult, result);
        
        s02.setSegmentsList(segmentListExpected02); //to make it the shortest path
        s04.setSegmentsList(segmentListExpected02);
        
        LinkedList<Section> expResult2 = new LinkedList<>();
        LinkedList<Section> result2 = RoadNetwork.getBestPath(graph, j000, j003, vehicle, acel, timeInter, load, algoritName);
        
        
        expResult2.add(s01);
        expResult2.add(s02);
        
        assertEquals(expResult2, result2);
        
        //algoritName = "EFFECIENTPATH";
        
        //LinkedList<Section> result3 = RoadNetwork.getBestPath(graph, j000, j003, vehicle, acel, timeInter, load, algoritName);
    }

    /**
     * Test of getPathSections method, of class RoadNetwork.
     */
    @Test
    public void testGetPathSections() {
        System.out.println("getPathSections");
        //Graph<Junction, Section> graph = null;
        LinkedList<Junction> junctionList = new LinkedList<>();
        junctionList.add(j000);
        junctionList.add(j001);
        junctionList.add(j003);
        LinkedList<Section> expResult = new LinkedList<Section>();
        expResult.add(s01);
        expResult.add(s02);
        LinkedList<Section> result = RoadNetwork.getPathSections(graph, junctionList);
        assertEquals(expResult, result);
        
    }
//
//    /**
//     * Test of getPathEnergy method, of class RoadNetwork.
//     */
//    @Test
//    public void testGetPathEnergy() {
//        System.out.println("getPathEnergy");
//        Graph<Junction, Section> graph = null;
//        LinkedList<Junction> junctionList = null;
//        Vehicle v = null;
//        double acel = 0.0;
//        double timeInter = 0.0;
//        double load = 0.0;
//        double expResult = 0.0;
//        double result = RoadNetwork.getPathEnergy(graph, junctionList, v, acel, timeInter, load);
//        //assertEquals(expResult, result, 0.0);
//       
//    }
//
//    /**
//     * Test of bestPath method, of class RoadNetwork.
//     */
//    @Test
//    public void testBestPath() {
//        System.out.println("bestPath");
//        Graph<Junction, Section> graph = null;
//        Junction jOrig = null;
//        Junction jDest = null;
//        LinkedList<Junction> shortPath = null;
//        Vehicle vehicle = null;
//        double acel = 0.0;
//        double timeInter = 0.0;
//        double load = 0.0;
//        String algoritName = "FA";
//        double expResult = 0.0;
//        double result = RoadNetwork.bestPath(graph, jOrig, jDest, shortPath, vehicle, acel, timeInter, load, algoritName);
//        //assertEquals(expResult, result, 0.0);
//        
//    }
//
//    /**
//     * Test of getPathJunctions method, of class RoadNetwork.
//     */
//    @Test
//    public void testGetPathJunctions() {
//        System.out.println("getPathJunctions");
//        LinkedList<Section> section_list = null;
//        RoadNetwork instance = new RoadNetwork();
//        List<Junction> expResult = null;
//        List<Junction> result = instance.getPathJunctions(section_list);
//        //assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of calcTravelTime method, of class RoadNetwork.
//     */
//    @Test
//    public void testCalcTravelTime() {
//        System.out.println("calcTravelTime");
//        LinkedList<Section> section_list = null;
//        Vehicle v = null;
//        double expResult = 0.0;
//        double result = RoadNetwork.calcTravelTime(section_list, v);
//        //assertEquals(expResult, result, 0.0);
//       
//    }
//
//    /**
//     * Test of timeToString method, of class RoadNetwork.
//     */
//    @Test
//    public void testTimeToString() {
//        System.out.println("timeToString");
//        double time = 0.0;
//        String expResult = "";
//        String result = RoadNetwork.timeToString(time);
//        //assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of calcEnergy method, of class RoadNetwork.
//     */
//    @Test
//    public void testCalcEnergy() {
//        System.out.println("calcEnergy");
//        LinkedList<Section> section_list = null;
//        Vehicle v = null;
//        double acel = 0.0;
//        double timeInter = 0.0;
//        double load = 0.0;
//        double expResult = 0.0;
//        double result = RoadNetwork.calcEnergy(section_list, v, acel, timeInter, load);
//        //assertEquals(expResult, result, 0.0);
//        
//    }
//
//    /**
//     * Test of calcTravelTime method, of class RoadNetwork.
//     */
////    @Test
////    public void testCalcTravelTime() {
////        System.out.println("calcTravelTime");
////        LinkedList<Section> section_list = null;
////        Vehicle v = null;
////        String expResult = "";
//////        String result = RoadNetwork.calcTravelTime(section_list, v);
//////        assertEquals(expResult1, result);
////
//////        fail("The test case is a prototype.");
////    }
//    /**
//     * Test of createGraphFromXML method, of class RoadNetwork.
//     */
////    @Test
////    public void testCreateGraphFromXML() throws Exception {
////        System.out.println("createGraphFromXML");
////        RoadNetwork instance = new RoadNetwork();
////
////        Junction jun0 = new Junction("n0");
////        Junction jun1 = new Junction("n1");
////        Junction jun2 = new Junction("n2");
////        Junction jun3 = new Junction("n3");
////        Junction jun4 = new Junction("n4");
////        Junction jun5 = new Junction("n5");
////        Junction jun6 = new Junction("n6");
////
////        instance.node_list.add(jun0);
////        instance.node_list.add(jun1);
////        instance.node_list.add(jun2);
////        instance.node_list.add(jun3);
////        instance.node_list.add(jun4);
////        instance.node_list.add(jun5);
////        instance.node_list.add(jun6);
////        
////        
////        instance.createGraphFromXML();
////
////        assertEquals("Number of vertices should be 7\n\n", 7 == instance.graph.numVertices());
////
////    }
////    /**
////     * Test of getNode_list method, of class RoadNetwork.
////     */
////    @Test
////    public void testGetNode_list() {
////        System.out.println("getNode_list");
////        RoadNetwork instance = new RoadNetwork();
////        LinkedList<Junction> expResult1 = null;
////        LinkedList<Junction> result = instance.getNode_list();
////        assertEquals(expResult1, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of fastestPathBetween method, of class RoadNetwork.
////     */
////    @Test
////    public void testFastestPathBetween() {
////        System.out.println("fastestPathBetween");
////        Junction j1 = null;
////        Junction j2 = null;
////        Vehicle v = null;
////        RoadNetwork instance = new RoadNetwork();
////        LinkedList<Junction> expResult1 = null;
////        LinkedList<Junction> result = instance.fastestPathBetween(j1, j2, v);
////        assertEquals(expResult1, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of fastestPath method, of class RoadNetwork.
////     */
////    @Test
////    public void testFastestPath() {
////        System.out.println("fastestPath");
////        Junction jOrig = null;
////        Junction jDest = null;
////        LinkedList<Junction> shortPath = null;
////        Vehicle vehicle = null;
////        RoadNetwork instance = new RoadNetwork();
////        double expResult1 = 0.0;
////        double result = instance.fastestPath(jOrig, jDest, shortPath, vehicle);
////        assertEquals(expResult1, result, 0.0);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of addSection method, of class RoadNetwork.
////     */
////    @Test
////    public void testAddSection() {
////        System.out.println("addSection");
////        Section s = null;
////        RoadNetwork instance = new RoadNetwork();
////        instance.addSection(s);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getPathJunctions method, of class RoadNetwork.
////     */
////    @Test
////    public void testGetPathJunctions() {
////        System.out.println("getPathJunctions");
////        LinkedList<Section> section_list = null;
////        RoadNetwork instance = new RoadNetwork();
////        List<Junction> expResult1 = null;
////        List<Junction> result = instance.getPathJunctions(section_list);
////        assertEquals(expResult1, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of loadFromFile method, of class RoadNetwork.
////     */
////    @Test
////    public void testLoadFromFile() throws Exception {
////        System.out.println("loadFromFile");
////        Node node = null;
////        RoadNetwork instance = new RoadNetwork();
////        //instance.loadFromFile(node);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    /**
////     * Test of fastestPathBetween method, of class RoadNetwork.
////     */
////    @Test 
////    public void testFastestPathBetween() {
////        System.out.println("fastestPathBetween");
////        Junction a = new Junction("a");
////        Junction b = new Junction("b");
////        Junction c = new Junction("c");
////        Junction d = new Junction("d");
////        Junction e = new Junction("e");
////        Junction f = new Junction("f");
////        
////        Segment segA = new Segment(1,0,0,100,0,0,120,0,false);
////        Segment segB = new Segment(2,0,0,100,0,0,40,0,false);
////        Segment segC = new Segment(3,0,0,100,0,0,120,0,false);
////        Segment segD = new Segment(4,0,0,100,0,0,120,0,false);
////        
////        
////        LinkedList<Segment> segmentsList1 = new LinkedList<Segment>();
////        LinkedList<Segment> segmentsList2 = new LinkedList<Segment>();
////        LinkedList<Segment> segmentsList3 = new LinkedList<Segment>();
////        LinkedList<Segment> segmentsList4 = new LinkedList<Segment>();
////        
////        segmentsList1.add(segA);
////        segmentsList2.add(segB);
////        segmentsList3.add(segC);
////        segmentsList4.add(segD);
////        
////        Road r1 = new Road();
////        Road r2 = new Road();
////        Road r3 = new Road();
////        Road r4 = new Road();
////        
////        r1.setTypology("ROAD");
////        r2.setTypology("ROAD");
////        r3.setTypology("ROAD");
////        r4.setTypology("ROAD");
////        
////        
////        
////        Section s1 = new Section(a,b,r1,true,segmentsList1);
////        Section s2 = new Section(b,d,r2,true,segmentsList2);
////        Section s3 = new Section(a,c,r3,true,segmentsList3);
////        Section s4 = new Section(c,d,r4,true,segmentsList4);
////        
////        Graph<Junction, Section> rn = new Graph<>(true);
////        
////        rn.insertVertex(a);
////        rn.insertVertex(b);
////        rn.insertVertex(c);
////        rn.insertVertex(d);
////        
////        rn.insertEdge(a, b, s1, 0);
////        rn.insertEdge(b, d, s2, 0);
////        rn.insertEdge(a, c, s3, 0);
////        rn.insertEdge(c, d, s4, 0);
////        
////        
////        
////        Project proj = new Project();
////        proj.setRoadNetwork(rn);
////
////        Gear gear1 = new Gear(0.9);
////        
////        
////        
////        
////        Regime reg1 = new Regime(115,900,1499,500); 
////        Regime reg2 = new Regime(125,1500,2499,450);
////        Regime reg3 = new Regime(120,2500,3499,520);
////        Regime reg4 = new Regime(105,3500,4499,550);
////        
////        Throttle t = new Throttle(25);
////        t.addRegime(reg1);
////        t.addRegime(reg2);
////        t.addRegime(reg3);
////        t.addRegime(reg4);
////        
////        RegistThrottle rt = new RegistThrottle();
////        rt.addThrottle(t);
////        //Motorization m = new Motorization(1,"combustion");
////        Motorization []ri = Motorization.values() ;
////        
////        Vehicle v = new Vehicle(Type.CAR,2,Fuel.GASOLINE,2,2000,700,0.4,0.0015,0.8,5000,900,5500,Motorization.COMBUSTION,rt,4);
////        
////        v.addGear(gear1);
////        Map<String, Double> limitPerRoad = new HashMap<>();
////        limitPerRoad.put("ROAD", 70.0);
////        v.setVelocityLimitPerRoad(limitPerRoad);
////        
////        Project p = new Project("proj1","DESC1");
////        p.setRoadNetwork(rn);
////        p.addVehicle(v);
////        
////        
////        
////        Junction j1 = a;
////        Junction j2 = d;
////        LinkedList<Junction> result = RoadNetwork.fastestPathBetween(p.getRoadNetwork(),j1, j2,v);
////        
////        
////        assertTrue("must have initial junction", result.contains(a));
////        assertTrue("must have final junction", result.contains(d));
////        assertTrue("must have junction c", result.contains(c));
////        assertTrue("cant have junction b,because it is the slowest path", !result.contains(b));
////        
////    }
//    /**
//     * Test of fastestPath method, of class RoadNetwork. //
//     */
////    @Test
////    public void testFastestPath() {
////        System.out.println("fastestPath");
////        Junction jOrig = null;
////        Junction jDest = null;
////        LinkedList<Junction> shortPath = null;
////        RoadNetwork instance = new RoadNetwork();
////        double expResult1 = 0.0;
////        double result = instance.fastestPath(jOrig, jDest, shortPath);
////        assertEquals(expResult1, result, 0.0);
////        
////    }
}
