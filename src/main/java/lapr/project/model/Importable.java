/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author salva
 */
public interface Importable {
    /**
     *
     * @param project
     * @param filePath
     * @return
     */
    boolean importRoadNetwork(Project project, String filePath);
    boolean importVehicles(Project project, String filePath);   
}
