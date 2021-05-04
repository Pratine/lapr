/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author Tiago Sousa 1150736
 */
public class CopyProjectController {

    private RegistryProject projectRegistry;
    private Project copy;
    
  
    public CopyProjectController(RegistryProject projectRegistry) {
        this.copy = new Project();
        this.projectRegistry = projectRegistry;
    }
    
   /**
     * @return the project list
     */
    public List<Project> getProjectList() {
        return this.projectRegistry.getProjectList();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return copy.getName();
    }
    
    /**
    * @return the description
     */
    public String getDescription() {
        return copy.getDescription();
    }
}
