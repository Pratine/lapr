/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author salva
 */
public class Road implements Comparable<Road> {

    private String name;
    private Typology typology;
    private Map<Integer, Double> toll_fare;

    private static final String NAME_BY_DEFAULT = "n/a";

    public Road(String name) {
        this.name = name;
        this.typology = Typology.DEFAULT;
        toll_fare = new HashMap<>();
    }

    public Road(String name, Typology typoligy) {
        this.name = name;
        this.typology = typoligy;
        this.toll_fare = new HashMap<>();
    }

    public Road() {
        name = NAME_BY_DEFAULT;
        this.typology = Typology.DEFAULT;
        this.toll_fare = new HashMap<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setTypology(Typology typology) {
        this.typology = typology;

    }

    public Map<Integer, Double> getTollFare() {
        return toll_fare;
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
        Road otherRoad = (Road) obj;
        return this.name.equals(otherRoad.name)
                && this.typology.equals(otherRoad.typology)
                && this.toll_fare.equals(otherRoad.toll_fare);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public int compareTo(Road road) {
        return this.name.compareTo(road.name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("RoadName: ").append(this.name).append("\n");
        sb.append(this.getTypology());
        if (this.toll_fare != null) {
            sb.append(toll_fare);
        }
        sb.append("\n");

        return sb.toString();
    }

    public boolean validate() {
        return !(this.name == null || this.name.trim().isEmpty());
    }

    /**
     * @return the typology
     */
    public Typology getTypology() {
        return typology;
    }

    public String getTypologyName() {
        return typology.name();
    }

    public void setToll(Integer id, Double fare) {
        this.getTollFare().put(id, fare);
    }
}
