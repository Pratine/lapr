/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Joao Paulo
 */
public class RegistryVehicle {

    private LinkedList<Vehicle> vehicleList;

    public RegistryVehicle() {
        this.vehicleList = new LinkedList<>();
    }

    public boolean addVehicle(Vehicle v) {

        if (vehicleList.contains(v)) {
            return false;
        } else {
            vehicleList.add(v);
            return true;
        }
    }

    public LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public boolean contains(Vehicle vehicle) {
        return vehicleList.contains(vehicle);
    }

    public ArrayList<String> getVehicleNamesList() {
        ArrayList<String> vName = new ArrayList<>();

        for (Vehicle v : vehicleList) {
            String name = v.getName();
            vName.add(name);
        }
        return vName;
    }

    public Vehicle getVehicleByName(String name) {
        Iterator<Vehicle> it = vehicleList.iterator();
        Vehicle v;

        while (it.hasNext()) {
            v = it.next();
            if (name.equals(v.getName())) {
                return v;
            }
        }

        return null;
    }

    public Vehicle newVehicle() {
        return new Vehicle();
    }

    public boolean validate() {
        if (vehicleList.isEmpty()) {
            return false;
        }
        return true;
    }

    public int size() {
        int size = 0;
        for (Vehicle vehicle : vehicleList) {
            size++;
        }
        return size;
    }
}
