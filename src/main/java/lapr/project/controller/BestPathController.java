
package lapr.project.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.utils.ExportCSV;
import lapr.project.utils.ExportHTML;
import lapr.project.model.Junction;
import lapr.project.model.Project;
import lapr.project.model.RegistryProject;
import lapr.project.model.Vehicle;
import lapr.project.model.RoadNetwork;
import lapr.project.model.Section;
import lapr.project.model.graphbase.Graph;
import lapr.project.utils.DataBase;

/**
 *
 * @author rgcar
 */
public class BestPathController{

    private final Project project;
//    private final Project project;

    public BestPathController(Project project) {
        this.project = project;
       
    }

    /**
     * get list of projects to present in comboBox
     *
     * @param rp
     * @return
     */
    public ArrayList<String> getcomboBoxProjectList(RegistryProject rp) {

        ArrayList<String> pList = new ArrayList<>();

        List<Project> projectList = rp.getProjectList();

        for (Project p : projectList) {
            String name = p.toString();
            pList.add(name);
            }

        return pList;
    }

    /**
     * gets the arraylist to present in combobox this is getting a dummy vehicle list - must be fetching from database
     *
     * @param proj
     * @return
     */
    public ArrayList<String> getComboBoxVehicleList(Project proj) {
        ArrayList<String> vTypes = new ArrayList<>();

        LinkedList<Vehicle> vehicleList = proj.getRegistVehicle().getVehicleList();

        for (Vehicle p : vehicleList) {
            String vType = (p.getName());
            vTypes.add(vType);
        }
        return vTypes;
    }

    /**
     * gets all the junctions in Road Network to present in comboBox
     *
     * @param proj
     * @return
     */
    public ArrayList<String> getcomboBoxJunctionList(Project proj) {
        
        Iterable<Junction> junctionList = proj.getAllJunctions(proj.getRoadNetwork());

        ArrayList<String> junctionNames = new ArrayList<>();

        for (Junction j : junctionList) {
            String jID = (j.getId());
            junctionNames.add(jID);
        }
        
        return junctionNames;
    }

    /**
     * 
     * @param j1
     * @param j2
     * @param v
     * @return 
     */
    public ArrayList<String> getBestPathtoArray(Junction j1, Junction j2, Vehicle v,double acel,double timeInter,double load,String algoritName) {
        ArrayList<String> fPath = new ArrayList<>();
        LinkedList<Section> fastestPath = RoadNetwork.getBestPath(project.getRoadNetwork(), j1, j2, v,acel,timeInter,load,algoritName);

        for (Section s : fastestPath) {
            String sectionDesc = s.toString();
            fPath.add(sectionDesc);
        }

        return fPath;
    }

    /**
     * 
     * @param j1
     * @param j2
     * @param v
     * @return 
     */
//    public String getFastestTravelTime(Junction j1, Junction j2, Vehicle v) {
//       String travelTime;
//       
//       LinkedList<Section> sectionList = RoadNetwork.getFastestPath(project.getRoadNetwork(), j1, j2, v);
//       
//       travelTime = RoadNetwork.calcTravelTime(sectionList, v);
//      
//       return travelTime;
//    }
    
     /**
     * 
     * @param j1
     * @param j2
     * @param v
     * @return 
     */
//    public String getRealEfficientTravelTime(Junction j1, Junction j2, Vehicle v) {
//       String travelTime;
//       //alterar getFastestPath para getRealEfficientPath a implementar na RoadNetwork
//       LinkedList<Section> sectionList = RoadNetwork.getFastestPath(project.getRoadNetwork(), j1, j2, v);
//       
//       travelTime = RoadNetwork.calcTravelTime(sectionList, v);
//      
//       return travelTime;
//    }

//    public double getConsumption(Graph<Junction, Section> graph, LinkedList<Junction> junctionList,Vehicle v,double acel,double timeInter,double load) {
//        return RoadNetwork.getPathEnergy(graph, junctionList, v, acel, timeInter, load);
//        
//    }

//    public double getFastestTollCost(Junction j1, Junction j2, Vehicle v) {
//        double tollCost;
//        
//        LinkedList<Section> sectionList = RoadNetwork.getFastestPath(project.getRoadNetwork(), j1, j2, v);
//        
//        tollCost = RoadNetwork.calcTollCost(sectionList, v);
//        
//        return tollCost;
//    }
//    
    public double[] getBestPathValues(Junction j1,Junction j2,Vehicle v,double acel,double interTime,double load,String algoritName){
        double[] values = new double[3];
        
        LinkedList<Section> sectionList = RoadNetwork.getBestPath(project.getRoadNetwork(), j1, j2, v,acel,interTime,load, algoritName);
        
        values[0] = RoadNetwork.calcTravelTime(sectionList, v);
        values[1] = RoadNetwork.calcEnergy(sectionList, v, acel, interTime,load);
        values[2] = RoadNetwork.calcTollCost(sectionList, v);
        
        return values;
        
    }
//    
//       public double getRealEfficientTollCost(Junction j1, Junction j2, Vehicle v) {
//       double tollCost;
//        
//        LinkedList<Section> sectionList = RoadNetwork.getFastestPath(project.getRoadNetwork(), j1, j2, v);
//        
//        tollCost = RoadNetwork.calcTollCost(sectionList, v);
//        
//        return tollCost;
//    }
       
            public double getTheoreticalEfficientTollCost(Junction j1, Junction j2, Vehicle v) {
        double tollCost = 0;
        
        return tollCost;
    }

    public ArrayList<String> getRealEfficientPath(Junction j1, Junction j2, Vehicle v) {
        //Dummy list to test the UI
        ArrayList<String> nodeList = new ArrayList<>();
        nodeList.add("Junction1");
        nodeList.add("Junction2");
        nodeList.add("Junction3");
        nodeList.add("Junction4");
        nodeList.add("Junction5");

//--------Actual code to get the list once the fastestPath method is working-----
//        ArrayList<String> ePath = new ArrayList<>();
//        LinkedList<Junction> fastestPath = project.getRoadNetwork().mostEfficientRealPath(j1, j2, v);
//
//        for (Junction j : fastestPath) {
//            for (String id : fPath) {
//                id = j.getId();
//            }
//        }
        return nodeList;
    }

    public ArrayList<String> getTheoreticalEfficientPath(Junction j1, Junction j2, Vehicle v) {
        //Dummy list to test the UI
        ArrayList<String> nodeList = new ArrayList<>();
        nodeList.add("Junction1");
        nodeList.add("Junction2");
        nodeList.add("Junction3");
        nodeList.add("Junction4");
        nodeList.add("Junction5");

//--------Actual code to get the list once the fastestPath method is working-----
//        ArrayList<String> ePath = new ArrayList<>();
//        LinkedList<Junction> fastestPath = project.getRoadNetwork().mostEfficientRealPath(j1, j2, v);
//
//        for (Junction j : fastestPath) {
//            for (String id : fPath) {
//                id = j.getId();
//            }
//        }
        return nodeList;
    }

    public void exportNetworkAnalysisCSV(String projectName, String vehicleName, String initJunctionName, String endJunctionName, double energyConsumption, double travelTime, double tollCost, ArrayList<String> path, String filePath) {

        ExportCSV csv = new ExportCSV();
        csv.exportNetworkAnalysis(projectName, vehicleName, initJunctionName, endJunctionName, energyConsumption, travelTime, tollCost, path, filePath);

    }
    
        public void exportNetworkAnalysisHTML(String projectName, String vehicleName, String initJunctionName, String endJunctionName, String energyConsumption, String travelTime, String tollCost, ArrayList<String> path, String filePath) {

        ExportHTML html = new ExportHTML();
        html.exportNetworkAnalysis(projectName, vehicleName, initJunctionName, endJunctionName, energyConsumption, travelTime, tollCost, path, filePath);
 
    }
        
    public void saveResultsInDataBase(String project, String travelTime, double Energy, double tollCost) {

        DataBase db = new DataBase();
        System.out.println("\nConnecting to Data Base...");
        db.openConnection();
        System.out.println("\t... Connection Successfull.");
        System.out.println("\nSaving Results ...");
        db.saveResults(project, travelTime, Energy, tollCost);
        System.out.println("\t... Results Saved.");
        String mensagem = db.closeAll();
        if (!mensagem.isEmpty()) {
            System.out.println(mensagem);
        }
        System.out.println("\nConnection Terminated.");

    }

}
