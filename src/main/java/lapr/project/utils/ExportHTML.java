/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rgcar
 */
public class ExportHTML implements ExportableHTML{
    
    
    /**
     * Creates instance
     */
    public ExportHTML(){
        
    }
    
    /**
     * Exports the results of the network static analysis into HTML format.
     * 
     * @param projectName
     * @param filePath Path to export the file.
     */
    @Override
    public void exportNetworkAnalysis(String projectName, String vehicleName, String initJunctionName, String endJunctionName, String energyConsumption, String travelTime, String tollCost, ArrayList<String> path, String filePath) {
        
        StringBuilder sb = new StringBuilder();

        sb.append("projectName: ").append(projectName);
        sb.append("<br>");
        sb.append("vehicleName: ").append(vehicleName);
        sb.append("<br>");
        sb.append("initJunctionName: ").append(initJunctionName);
        sb.append("<br>");
        sb.append("endJunctionName: ").append(endJunctionName);
        sb.append("<br>");
        sb.append("energyConsumption: ").append(energyConsumption);
        sb.append("<br>");
        sb.append("travelTime: ").append(travelTime);
        sb.append("<br>");
        sb.append("tollCost: ").append(tollCost);
        sb.append("<br>");
        sb.append("path: ").append(path);
        sb.append("<br>");
        
        writeFileHTML(sb, filePath);
    
    }
    private void writeFileHTML(StringBuilder sb, String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(sb.toString());
                JOptionPane.showMessageDialog(null, "Network Analysis Saved");
                
            }
            

        } catch (IOException e) {
            throw new IllegalArgumentException("An error occured while"
                    + " attempting to export the HTML file.");            
        }
    }
}
