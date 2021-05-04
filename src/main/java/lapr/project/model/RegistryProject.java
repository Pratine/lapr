/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Iterator;
import java.util.LinkedList;


/**
 *
 * @author 1150736
 */
public class RegistryProject {

    private LinkedList<Project> projectList;

    public RegistryProject() {
        this.projectList = new LinkedList<>();
    }

    public void addProject(Project p) {
        projectList.add(p);
    }
    
    public boolean containsProject(Project p) {
        
        if (!projectList.isEmpty()) {
            return projectList.contains(p);
        }
        return false;
    }


    public LinkedList<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(LinkedList<Project> projectList) {
       this.projectList = projectList;
    }

    public Project getProject(int index) {
        return this.projectList.get(index);
    }

    /**
     * Metodo que devolve o nome de todos os projectos para ser usado numa
     * combobox
     *
     * @return
     */
    public String[] getListProjects() {
        String[] names = new String[projectList.size() + 1];
        Iterator<Project> it = projectList.iterator();
        Project p;
        int i = 0;

        if (projectList.size() == 0) {
            return names;
        }

        names[0] = "Choose Project";

        while (it.hasNext()) {
            p = it.next();
            names[i + 1] = p.getName();
            i++;
        }

        return names;
    }

    public Project getProjectByName(String name) {
        Iterator<Project> it = projectList.iterator();
        Project p;

        while (it.hasNext()) {
            p = it.next();
            if (name.equals(p.getName())) {
                return p;
            }
        }

        return null;
    }

    public Project newProject() {
        return new Project();
    }
}
