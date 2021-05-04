/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;

/**
 *
 * @author salva
 */
public class RegistryRoads {

    private LinkedList<Road> roadsList;

    public RegistryRoads() {
        roadsList = new LinkedList<>();
    }

    public void addRoad(Road road) {
        roadsList.add(road);
    }

    public Road getRoadByName(String name) {
        for (Road road : roadsList) {
            if (road.getName().equalsIgnoreCase(name)) {
                return road;
            }
        }
        return null;
    }

    public LinkedList<Road> getRoadsList() {
        return roadsList;
    }

    public int size() {
        int size = 0;
        for (Road road : roadsList) {
            size++;
        }
        return size;
    }
}
