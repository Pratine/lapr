/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Joao Paulo
 */
public class Section {

    private Junction begginingJunction;
    private Junction endingJunction;
    private Road road;
    private Boolean direction;
    private LinkedList<Segment> segmentsList;
    private Map<Integer, Double> toll_fare;

    /**
     * Name of the road of the section.
     *
     * @param begginingJunction
     * @param endingJunction
     * @param road
     * @param direction
     * @param segmentsList
     * @param toll_fare
     */
    public Section(Junction begginingJunction, Junction endingJunction, Road road, Boolean direction) {
        this.begginingJunction = begginingJunction;
        this.endingJunction = endingJunction;
        this.road = road;
        this.direction = direction;
        this.segmentsList = new LinkedList<>();
        this.toll_fare = new HashMap<>();
    }

    public Section() {
        begginingJunction = new Junction();
        endingJunction = new Junction();
        road = new Road();
        direction = false;
        segmentsList = new LinkedList<>();
        toll_fare = new HashMap<>();
    }

    /**
     * @return the begginingJunction
     */
    public Junction getBegginingJunction() {
        return begginingJunction;
    }

    /**
     * @return the endingJunction
     */
    public Junction getEndingJunction() {
        return endingJunction;
    }

    /**
     * @return the direction
     */
    public Boolean getDirection() {
        return direction;
    }

    /**
     * @return the segmentsList
     */
    public LinkedList<Segment> getSegmentsList() {
        return segmentsList;
    }

    public Map<Integer, Double> getTollFare() {
        return toll_fare;
    }

    public Road getRoad() {
        return road;
    }

    /**
     * @param begginingJunction the begginingJunction to set
     */
    public void setBegginingJunction(String begginingJunction) {
        this.begginingJunction = new Junction(begginingJunction);
    }

    /**
     * @param endingJunction the endingJunction to set
     */
    public void setEndingJunction(String endingJunction) {
        this.endingJunction = new Junction(endingJunction);
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

    /**
     * @param segmentsList the segmentsList to set
     */
    public void setSegmentsList(LinkedList<Segment> segmentsList) {
        this.segmentsList = segmentsList;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public void setToll(Integer id, Double fare) {
        this.getTollFare().put(id, fare);
    }

    /**
     * Returns the name of the road of the section.
     *
     * @return Name of the road of the section.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.road);
        sb.append("Begin: ").append(begginingJunction).append("\n");
        sb.append("End: ").append(endingJunction).append("\n");
//        if (direction) {
//            sb.append("Direction: ").append("bidirectional").append("\n");
//        } else {
//            sb.append("Direction: ").append("unidirectional").append("\n");
//        }
//        for (Segment segment : segmentsList) {
//            sb.append(segment.toString());
//        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Section otherSection = (Section) obj;
        return this.begginingJunction.equals(otherSection.begginingJunction)
                && this.endingJunction.equals(otherSection.endingJunction)
                && this.segmentsList.equals(otherSection.segmentsList);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.begginingJunction);
        hash = 79 * hash + Objects.hashCode(this.endingJunction);
        hash = 79 * hash + Objects.hashCode(this.segmentsList);
        return hash;
    }

    public double sectionNecessaryTimeMaxSpeed(Vehicle vehicle) {
        Iterator<Segment> it = segmentsList.iterator();
        Segment item;
        double maxVelOnTypology = Double.MAX_VALUE;

        if (!vehicle.getVelocityLimitPerRoad().isEmpty()) {
            maxVelOnTypology = vehicle.getVelocityLimitOfRoad(road.getTypology().toString());

        }

        double sum = 0;
        while (it.hasNext()) {
            item = it.next();
            sum += item.segmentNecessaryTimeMaxSpeed(vehicle, maxVelOnTypology);
        }

        return CarPhysics.roundValue(sum);
    }

    public double sectionEnergy(Vehicle vehicle, double acel, double timeInter, double load) {

        int rpmMin = vehicle.getMin_rpm();
        double maxVelOnTypology = Double.MAX_VALUE;

        double lowestGearRatio = vehicle.getGearList().get(0).getRatio();
        double velInitial = CarPhysics.vehicleLinearVelocity(vehicle.getWheelSize(), rpmMin, vehicle.getFinalDriveRatio(), lowestGearRatio);
        double totalEnergy = 0;
        double[] result = new double[2];
        boolean lastSegment = false;
        for (Segment seg : segmentsList) {
            if (segmentsList.getLast().equals(seg)) {
                lastSegment = true;
            }
            
                result = seg.getSegmentEnergy(vehicle, maxVelOnTypology, velInitial, acel, timeInter, load, lastSegment);
            
            
            totalEnergy += result[0];
            
            velInitial = result[1];
        }
       
        return totalEnergy;
    }
    
    public double sectionRealEnergy(Vehicle vehicle, double acel, double timeInter, double load) {

        int rpmMin = vehicle.getMin_rpm();
        double maxVelOnTypology = Double.MAX_VALUE;

        double lowestGearRatio = vehicle.getGearList().get(0).getRatio();
        double velInitial = CarPhysics.vehicleLinearVelocity(vehicle.getWheelSize(), rpmMin, vehicle.getFinalDriveRatio(), lowestGearRatio);
        double totalEnergy = 0;
        double[] result = new double[2];
        boolean lastSegment = false;
        for (Segment seg : segmentsList) {
            if (segmentsList.getLast().equals(seg)) {
                lastSegment = true;
            }
            
                result = seg.getSegmentEnergy(vehicle, maxVelOnTypology, velInitial, acel, timeInter, load, lastSegment);
            
            
            totalEnergy += result[0];
            
            velInitial = result[1];
        }
       
        return totalEnergy;
    }

    public double getTotalLengthOfSection() {
        double totalLength = 0.0;
        for (Segment segment : segmentsList) {
            totalLength += segment.getLength();
        }
        return totalLength;
    }

    public Segment newSegment() {
        return new Segment();
    }

    public Road newRoad() {
        return new Road();
    }

    public boolean validate() {
        if (!this.begginingJunction.validate()) {
            return false;
        }
        if (!this.endingJunction.validate()) {
            return false;
        }
        if (!this.road.validate()) {
            return false;
        }
        if (this.direction == null) {
            return false;
        }
        return !this.segmentsList.isEmpty();
    }

    public Typology getTypoligy() {
        return road.getTypology();
    }
}
