package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author vdjol
 */

/**
 * @summary Controls the edition of a project. Using this class, a user interface can
 * easily allow the edition of a project.
 */
public class ChangeProjectController {
   
    /**
     * The clone of the opened project.
     */
    private Project clone;
    
    
    /**
     * Returns the project's name.
     * @return (String) The project's name.
     */
    public String getProjectName() {
        return clone.getName();
    }
    
    /**
     * Returns the project's description.
     * @return (String) The project's description.
     */
    public String getProjectDescription() {
        return clone.getDescription();
    }
    
    /**
     * Sets the project's name.
     * @param name (String) The new name of the project.
     */
    public void setProjectName(String name) {
        clone.setName(name);
    }
    
    /**
     * Sets the project's description.
     * @param desc (String) The new description of the project.
     */
    public void setProjectDescription(String desc) {
        clone.setDescription(desc);
    }
}
