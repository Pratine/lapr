/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Project;
import lapr.project.model.RegistryProject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1150736
 */
public class CopyProjectControllerIT {
    
    public CopyProjectControllerIT() {
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
     * Test of getProjectList method, of class CopyProjectController.
     */
    @Test
    public void testGetProjectList() {
        System.out.println("getProjectList");
        RegistryProject proj = new RegistryProject();
        CopyProjectController instance = new CopyProjectController(proj);
        List<Project> expResult = new ArrayList<>();
        List<Project> result = instance.getProjectList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class CopyProjectController.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        RegistryProject proj = new RegistryProject();
        CopyProjectController instance = new CopyProjectController(proj);
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CopyProjectController.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        RegistryProject proj = new RegistryProject();
        CopyProjectController instance = new CopyProjectController(proj);
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
}

