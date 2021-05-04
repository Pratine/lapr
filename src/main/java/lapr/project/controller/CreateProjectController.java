/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import javax.swing.JOptionPane;
import lapr.project.model.ImportXML;
import lapr.project.model.Project;
import lapr.project.model.RegistryProject;
import lapr.project.utils.DataBase;

/**
 *
 * @author salva
 */
public class CreateProjectController {

    
    private Project project;
    private RegistryProject registryProject;

    public CreateProjectController(Project project, RegistryProject registryProject) {
        this.project = project;
        this.registryProject = registryProject;
    }

    public void newProject(RegistryProject registryProject) {
        this.registryProject = registryProject;
        this.project = this.registryProject.newProject();
    }

    public void setData(String name, String description) {
        this.project.setName(name);
        this.project.setDescription(description);
    }

    public void importFromFiles(String filenameRoadNetwork, String filenameVehicles) {
        boolean flag;
        flag = importNetwork(filenameRoadNetwork, project);
        if (flag) {
            flag = importVehicles(filenameVehicles, project);
            if (flag) {
                project.validate();
                registryProject.addProject(project);
                JOptionPane.showMessageDialog(null, "Project Created");
            } else {
                JOptionPane.showMessageDialog(null, "Error Creating Project");
            }
        }
    }

    private boolean importNetwork(String filename, Project project) {
        try {
            ImportXML imp = new ImportXML();
            return imp.importRoadNetwork(project, filename);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "FileName Invalid");
        }
        return false;
    }

    private boolean importVehicles(String filename, Project project) {
        try {
            ImportXML imp = new ImportXML();
            return imp.importVehicles(project, filename);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "FileName Invalid");
        }
        return false;
    }

    public void insertProjectInDataBase(String projectName, String projectDesdription) {

        DataBase db = new DataBase();
        System.out.println("\nConnecting to Data Base...");
        db.openConnection();
        System.out.println("\t... Connection Successfull.");
        System.out.println("\nSaving Project ...");
        db.insertProject(projectName, projectDesdription);
        System.out.println("\t... Projet Saved.");
        String mensagem = db.closeAll();
        if (!mensagem.isEmpty()) {
            System.out.println(mensagem);
        }
        System.out.println("\nConnection Terminated.");

    }
}
