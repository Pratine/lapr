/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Project;
import lapr.project.model.RegistryProject;

/**
 *
 * @author rgcar
 */
public class EditProjectController {
    
    //private final RoadNetwork rn;
    
    private final RegistryProject rp; 
    
    public EditProjectController(RegistryProject rp) {
        this.rp = rp;
    }
    
    /**
     * gets the arraylist to present in combobox
     * @param rp
     * @return 
     */
    public ArrayList<String> getProjList(RegistryProject rp) {
        ArrayList<String> projNames = new ArrayList<>();
        List<Project> projList = rp.getProjectList();

        for (Project p : projList) {
            String name = p.getName();
            projNames.add(name);
        }
        return projNames;
    }
    
    /**
     * returns a project with a given name
     * @param regP
     * @param name
     * @return 
     */
    public Project getProjectByName(RegistryProject regP, String name){
        List<Project> prjList = rp.getProjectList();
        Project proj = new Project();
        for(Project p : prjList){
            if (p.getName().equals(name)){
                proj = p;
            }else{
                return null;
            }
        }
        return proj;
    }
 
    

}


