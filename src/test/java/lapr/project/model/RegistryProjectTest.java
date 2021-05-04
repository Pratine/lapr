/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao Paulo
 */
public class RegistryProjectTest {
    
    private RegistryProject rp;
    private Project p1;
    private Project p2;
    
    public RegistryProjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rp = new RegistryProject();
        p1 = new Project("Project1","description1");
        p2 = new Project("Project2","description2");
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addProject method, of class RegistryProject.
     */
    @Test
    public void testAddProject() {
        System.out.println("addProject");
        RegistryProject regProj = new RegistryProject();
        p1 = new Project("Project1","description1");
        
        regProj.addProject(p1);
        
        //System.out.println("projects:" + rp.getProjectList().toString());
        
        boolean expected = true;
        boolean expected2 = false;
        boolean result = regProj.containsProject(p1);
        boolean result2 = regProj.containsProject(p2);
        
        assertEquals(expected,result);
        assertEquals(expected2,result2)
        ;
    }

    /**
     * Test of getProjectList method, of class RegistryProject.
     */
    @Test
    public void testGetProjectList() {
        System.out.println("getProjectList");
        RegistryProject regProj = new RegistryProject();
        regProj.addProject(p1);
        regProj.addProject(p2);
        
        LinkedList<Project> resultList = regProj.getProjectList();
        
        boolean expected = true;
        boolean result1 = resultList.contains(p1);
        boolean result2 = resultList.contains(p1);
        
        assertEquals(result1, expected);
        assertEquals(result2, expected);
        
    }

    /**
     * Test of setProjectList method, of class RegistryProject.
     */
    @Test
    public void testSetProjectList() {
        System.out.println("setProjectList");
        RegistryProject regProj = new RegistryProject();
        LinkedList<Project> projectList = new LinkedList<>();
        projectList.add(p1);
        projectList.add(p2);
        
        
        regProj.setProjectList(projectList);
        
        boolean expected2 = true;
        boolean result3 = regProj.containsProject(p1);
        boolean result4 = regProj.containsProject(p2);
        
        assertEquals(result3, expected2);
        assertEquals(result4, expected2);
    }

    /**
     * Test of getProject method, of class RegistryProject.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        RegistryProject regProj = new RegistryProject();
        regProj.addProject(p1);
        regProj.addProject(p2);
        
        Project p = regProj.getProject(0);
        
        boolean result = p.getName().equals(p1.getName());
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of getListProjects method, of class RegistryProject.
     */
    @Test
    public void testGetListProjects() {
        System.out.println("getListProjects");
        RegistryProject regProj = new RegistryProject();
        RegistryProject regProj2 = new RegistryProject();
        regProj.addProject(p1);
        regProj.addProject(p2);
        
        String[] result = regProj.getListProjects();
        
        String result1 = result[1];
        String result2 = result[2];
        
        String expResult1 = p1.getName();
        String expResult2 = p2.getName();
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        
        
        String[] resultSet2 = regProj2.getListProjects();
        String[] expResultSet2 = new String[1];
        
        assertArrayEquals(expResultSet2, resultSet2);
        
        
    }

    /**
     * Test of getProjectByName method, of class RegistryProject.
     */
    @Test
    public void testGetProjectByName() {
        System.out.println("getProjectByName");
        RegistryProject regProj = new RegistryProject();
        RegistryProject regProj2 = new RegistryProject();
        regProj.addProject(p1);
        
        Project p = regProj.getProjectByName("Project1");
        Project p2 = regProj2.getProjectByName("ProjectoInexistente");
        
       
        assertTrue(p.equals(p1)==true);
        assertEquals(p2, null);
        
        
    }

    /**
     * Test of newProject method, of class RegistryProject.
     */
    @Test
    public void testNewProject() {
        System.out.println("newProject");
        RegistryProject regProj = new RegistryProject();
        Project pTest1 = regProj.newProject();
        String expResult ="n/a";
        
        assertEquals(pTest1.getName(),expResult);
        
    }
    
}
