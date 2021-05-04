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
public class ExportCSV implements ExportableCSV{
    
    
    /**
     * Creates instance
     */
    public ExportCSV(){
        
    }
    
    /**
     * Exports the results of the network static analysis into HTML format.
     * 
     * @param projectName
     * @param vehicles
     * @param filePath Path to export the file.
     */
    @Override
    public void exportNetworkAnalysis(String projectName, String vehicleName, String initJunctionName, String endJunctionName, double energyConsumption, double travelTime, double tollCost, ArrayList<String> path, String filePath) {
        
        StringBuilder sb = new StringBuilder();

        sb.append("projectName");
        sb.append(',');
        sb.append("vehicleName");
        sb.append(',');
        sb.append("initJunctionName");
        sb.append(',');
        sb.append("endJunctionName");
        sb.append(',');
        sb.append("energyConsumption");
        sb.append(',');
        sb.append("travelTime");
        sb.append(',');
        sb.append("tollCost");
        sb.append(',');
        sb.append("path");
        sb.append(System.getProperty("line.separator"));
        //append path

        sb.append(projectName);
        sb.append(',');
        sb.append(vehicleName);
        sb.append(',');
        sb.append(initJunctionName);
        sb.append(',');
        sb.append(endJunctionName);
        sb.append(',');
        sb.append(energyConsumption);
        sb.append(',');
        sb.append(travelTime);
        sb.append(',');
        sb.append(tollCost);
        sb.append(',');
        sb.append(path);
        sb.append(System.getProperty("line.separator"));
        
        writeFileCSV(sb, filePath);
    
    }
    private void writeFileCSV(StringBuilder sb, String filePath) {
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
                    + " attempting to export the CSV file.");            
        }
    }
}
