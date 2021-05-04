package lapr.project.controller;

import lapr.project.model.ImportXML;
import lapr.project.model.Project;

/**
 *
 * @author Bruno Fonseca
 */
public class AddRoadsController {

    private Project project;

    public AddRoadsController(Project project) {
        this.project = project;
    }

    public boolean importRoadsData(String filePath) throws Exception {
        ImportXML imp = new ImportXML();
        return imp.importRoadNetwork(project, filePath);
    }
}
