/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;

/**
 *
 * @author rgcar
 */
public interface ExportableHTML {
     /**
     * Exports the data contained in open project in simulator, to file HTML
     *
     * @param projectName
     * @param vehicleName
     * @param initJunctionName
     * @param endJunctionName
     * @param energyConsumption
     * @param travelTime
     * @param path
     * @param tollCost
     * @param filePath
     */
    public void exportNetworkAnalysis(String projectName, String vehicleName, String initJunctionName, String endJunctionName, 
            String energyConsumption, String travelTime, String tollCost, ArrayList<String> path, String filePath);
    
    
}
