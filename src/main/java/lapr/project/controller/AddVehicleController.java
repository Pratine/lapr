/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

/**
 *
 * @author Bruno Fonseca
 */
import lapr.project.model.ImportXML;
import lapr.project.model.Project;

public class AddVehicleController {

    private Project project;

    public AddVehicleController(Project project) {
        this.project = project;
    }

    public boolean importVehiclesData(String filePath) throws Exception {
        ImportXML imp = new ImportXML();
        return imp.importVehicles(project, filePath);
    }
}
