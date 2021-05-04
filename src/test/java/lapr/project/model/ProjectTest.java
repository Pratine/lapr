/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Iterator;
import lapr.project.model.graphbase.Graph;

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
public class ProjectTest {

    public ProjectTest() {
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
     * Test of getName method, of class Project.
     */
    @Test
    public void testSetandGetName() {
        System.out.println("setandgetName");
        Project instance = new Project();
        instance.setName("ProjectTest");
        String expResult = "ProjectTest";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
//
    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testSetandGetDescription() {
        System.out.println("setandgetDescription");
        Project instance = new Project();
        instance.setDescription("DescriptionTest");
        String expResult = "DescriptionTest";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
//    
    /**
     * Test of toString method, of class Project.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Project proj = new Project("Proj1","newProj");
        String expResult = "Name: Proj1;Description: newProj";
        String result = proj.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Project.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Project p1 = new Project("Proj","no");
        Project p2 = new Project("Proj","no");
        Project p3 = new Project("Proj2","no");
        Project p4 = new Project("Proj","no3");
        Project p5 = null;
        Segment s1 = new Segment();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result5 = p1.equals(p5);
        boolean result1 = p1.equals(p2);
        boolean result2 = p1.equals(p3);
        boolean result3 = p1.equals(p4);
        boolean result4 = p1.equals(s1);
        
        assertEquals(expResult2, result5);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult2, result3);
        assertEquals(expResult2, result4);
        
    }

    /**
     * Test of hashCode method, of class Project.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Project instance = new Project();
        int expResult = 107635;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addJunction method, of class Project.
     */
    @Test
    public void testAddJunction() {
        System.out.println("addJunction");
        Junction junction = new Junction();
        junction.setId("n01");
        Project instance = new Project();

        assertTrue("Junction should have been added", instance.addJunction(junction));

        assertFalse("Junction is already present and should not be added", instance.addJunction(junction));
    }

    /**
     * Test of addSection method, of class Road.
     */
    @Test
    public void testAddSection() {
        System.out.println("addSection");
        Project proj= new Project("Proj","desc");
        
        Section s = new Section();
        
        int numEdgesResult = proj.getRoadNetwork().numEdges();
        int numEdgesExpected = 0;
        
        assertEquals(numEdgesExpected, numEdgesResult);
        
        boolean add = proj.addSection(s);
        
        int numEdgesResult2 = proj.getRoadNetwork().numEdges();
        int numEdgesExpected2 = 1;
        
        assertEquals(numEdgesExpected2, numEdgesResult2);
        assertEquals(true, add);

    }
//
//   
    /**
     * Test of getRegistVehicle method, of class Project.
     */
    @Test
    public void testGetRegistVehicle() {
        System.out.println("getRegistVehicle");
        Project proj = new Project("Project1","descrption1");
        RegistryVehicle regV = new RegistryVehicle();
        
        Vehicle v = new Vehicle();
        v.setName("Vehicle1");
        
        regV.addVehicle(v);
        
        proj.addVehicle(v);
        
        RegistryVehicle regV2 = proj.getRegistVehicle();
        
        boolean result = regV2.contains(v);
        boolean expResult = true;
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRegistryRoads method, of class Project.
     */
    @Test
    public void testGetRegistryRoads() {
        System.out.println("getRegistryRoads");
        Project proj = new Project("Proj1","desc1");
        Road r = new Road();
        int size = proj.getRegistryRoads().size();
        
        assertEquals(0,size);
    }

   
//
    /**
     * Test of addVehicle method, of class Project.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        Vehicle v = new Vehicle();
        Project proj = new Project("Proj1","desc");
        boolean expResult = true;
        boolean result = proj.addVehicle(v);
        assertEquals(expResult, result);
        
    }
//
    /**
     * Test of getRv method, of class Project.
     */
    @Test
    public void testGetRv() {
        System.out.println("getRv");
        Project proj = new Project("ProjNew","ProjDesc");
        
        RegistryVehicle result = proj.getRv();
        int size1 = result.size();
        
        assertEquals(0,size1);
        
        Vehicle v1 = new Vehicle();
        proj.addVehicle(v1);
       
        RegistryVehicle result2 = proj.getRv();
        int size2 = result.size();
        
        assertEquals(1,size2);
    }

    /**
     * Test of addSectionReverse method, of class Project.
     */
    @Test
    public void testAddSectionReverse() {
        System.out.println("addSectionReverse");
        Section section = new Section();
        Project proj = new Project("Proj","ProjD");
        
        int size = proj.getRoadNetwork().numEdges();
        int expSize = 0;
        
        assertEquals(expSize,size);
        
        boolean result = proj.addSectionReverse(section);
        boolean expResult = true;
        
        assertEquals(expResult, result);
        
        int size2 = proj.getRoadNetwork().numEdges();
        int expSize2 = 1;
        
         assertEquals(expSize2, size2);
    }
//
    /**
     * Test of CloneProject method, of class Project.
     */
    @Test
    public void testClone() {
        System.out.println("Clone");
        Project proj = new Project("Project1","desc1");
        
        Project pClone = proj.CloneProject();
        
        String nameResult = pClone.getName();
        String nameExp = "Project1-copy";
        
        String descResult = pClone.getDescription();
        String descExp = "desc1";

        assertEquals(nameExp, nameResult);
        assertEquals(descExp, descResult);
    }
//
    /**
     * Test of newJunction method, of class Project.
     */
    @Test
    public void testNewJunction() {
        System.out.println("newJunction");
        Project proj = new Project("Proj2","desc");
        
        Junction resultJunc = proj.newJunction();
        Junction expJunc = new Junction();
        assertEquals(expJunc,resultJunc);
        
    }
//
    /**
     * Test of newSection method, of class Project.
     */
    @Test
    public void testNewSection() {
        System.out.println("newSection");
        
        Project proj = new Project("Proj2","desc");
        
        Section resultSection = proj.newSection();
        Section expSection = new Section();
        assertEquals(expSection,resultSection);
    }
//
    /**
     * Test of getRoadNetwork method, of class Project.
     */
    @Test
    public void testGetRoadNetwork() {
        System.out.println("getRoadNetwork");
        Project proj = new Project("Project","desc22");
        
        proj.addJunction(new Junction("No1"));
        proj.addJunction(new Junction("No2"));
        
        Graph<Junction, Section> result = proj.getRoadNetwork();
        
        int resultSize = result.numEdges();
        int expSize = result.numEdges();
        assertEquals(expSize, resultSize);
       
    }

    /**
     * Test of getAllJunctions method, of class Project.
     */
    @Test
    public void testGetAllJunctions() {
        System.out.println("getAllJunctions");
        Graph<Junction, Section> roadNetwork = null;
        Project proj = new Project("Proj","desc");
        
        Junction j1 = new Junction("J1");
        Junction j2 = new Junction("J2");
        Junction j3 = new Junction("J3");
        
        proj.addJunction(j1);
        proj.addJunction(j2);
        
        
        Iterable<Junction> result = proj.getAllJunctions(proj.getRoadNetwork());
        Iterator<Junction> it = result.iterator();
        Junction item;
        ArrayList<Junction> junctions = new ArrayList<>();
        
        while(it.hasNext()){
            item = it.next();
            junctions.add(item);

        }
        
        boolean result1 = junctions.contains(j1);
        boolean result2 = junctions.contains(j2);
        boolean result3 = junctions.contains(j3);
        
        assertEquals(true, result1);
        assertEquals(true, result2);
        assertEquals(false, result3);
    }

    /**
     * Test of getJunctionInProject method, of class Project.
     */
    @Test
    public void testGetJunctionInProject() {
        System.out.println("getJunctionInProject");
        String name = "J1";
        Junction j1 = new Junction("J1");
        Junction j2 = new Junction("J2");
        Junction j3 = null;
        
        Project proj = new Project("Proj","desc");
        proj.addJunction(j1);
        proj.addJunction(j2);
        Iterable<Junction> node_list = proj.getRoadNetwork().vertices();
        
        Junction expResult = j1;
        Junction result = proj.getJunctionInProject(name, node_list);
        assertEquals(expResult, result);
        
        Junction expResult2 = j3;
        Junction result2 = proj.getJunctionInProject("non", node_list);
        
        assertEquals(expResult2, result2);
        
        
    }

    /**
     * Test of setRegistVehicle method, of class Project.
     */
    @Test
    public void testSetRegistVehicle() {
        System.out.println("setRegistVehicle");
        RegistryVehicle registVehicle = new RegistryVehicle();
        
        Vehicle v = new Vehicle();
        registVehicle.addVehicle(v);
        
        Project proj = new Project("Proj1","desc");
        int size = proj.getRegistVehicle().size();
        
        assertEquals(0,size);
        
        proj.setRegistVehicle(registVehicle);
        
        assertEquals(1, proj.getRegistVehicle().size());
        
    }

    /**
     * Test of setRoadNetwork method, of class Project.
     */
    @Test
    public void testSetRoadNetwork() {
        System.out.println("setRoadNetwork");
        
        Project proj = new Project("Proj1","desc");
        
        int sizeResult1 = proj.getRoadNetwork().numVertices();
        
        Graph<Junction, Section> roadNetTest = new Graph<>(true);
        
        Junction j1 = new Junction("J1");
        
        assertEquals(0, sizeResult1);
        
        roadNetTest.insertVertex(j1);
        proj.setRoadNetwork(roadNetTest);
        
        int sizeResult2 = proj.getRoadNetwork().numVertices();
        
        assertEquals(1, sizeResult2);  
    }

    /**
     * Test of validate method, of class Project.
     */
    @Test
    public void testValidate() {
        System.out.println("validade");
        
        Project proj = new Project("Proj","desc");
        Project proj2 = new Project("","desc");
        
        String name = null;
        Project proj3 = new Project("","desc");

        proj3.setName(name);
        
        Project proj4 = new Project("Proj","");
        Project proj5 = new Project("Proj","");
        
        proj5.setDescription(name);
        
        
        
        boolean result1 = proj.validate();
        boolean result2 = proj2.validate();
        boolean result3 = proj3.validate();
        boolean result4 = proj4.validate();
        boolean result5 = proj5.validate();
        boolean result6 = proj.validate();
        
        boolean expResult = false;
        
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult, result4);
        assertEquals(expResult, result5);
        assertEquals(expResult, result6);
        
        Vehicle v1 = new Vehicle();
        proj.addVehicle(v1);
        
        boolean result7 = proj.validate();
        
        assertEquals(expResult, result7);
        
        Section s1 = new Section();
        Section s2 = new Section();
        proj.addSection(s1);
       // proj.addSection(s2);
        
        boolean result8 = proj.validate();
        
        assertEquals(expResult, result8);
        
        Junction j1 = new Junction("J1");
        
        proj.addJunction(j1);
        
        boolean result9 = proj.validate();
        
        assertEquals(expResult, result9);
        
        
    }
}
