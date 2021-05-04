/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Iterator;
import java.util.Objects;
import lapr.project.model.graphbase.Graph;

/**
 *
 * @author 1150736
 */
public class Project {

    private String name;
    private String description;
    private RegistryVehicle registVehicle;
    private RegistryRoads registRoads;
    private Graph<Junction, Section> roadNetwork;

    private static final String NAME_BY_DEFAULT = "n/a";
    private static final String DESCRIPTION_BY_DEFAULT = "n/a";

    public Project() {
        this.name = NAME_BY_DEFAULT;
        this.description = DESCRIPTION_BY_DEFAULT;
        this.roadNetwork = new Graph<>(true);
        this.registVehicle = new RegistryVehicle();
        this.registRoads = new RegistryRoads();

    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.roadNetwork = new Graph<>(true);
        this.registVehicle = new RegistryVehicle();
        this.registRoads = new RegistryRoads();
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public RegistryVehicle getRegistVehicle() {
        return registVehicle;
    }

    public RegistryRoads getRegistryRoads() {
        return registRoads;
    }

    @Override
    public String toString() {
        return "Name: " + name + ";Description: " + description;
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
        Project otherProject = (Project) obj;

        return this.name.equals(otherProject.name)
                && this.description.equals(otherProject.description)
                ;
    }

    public boolean addVehicle(Vehicle v) {
        return registVehicle.addVehicle(v);
    }

    public RegistryVehicle getRv() {
        return registVehicle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /*
    adds a vertex to roadNetwork
     */
    public boolean addJunction(Junction junction) {
        return this.roadNetwork.insertVertex(junction);
    }

    /*
    adds a edge to roadNetwork
     */
    public boolean addSection(Section section) {
        return this.roadNetwork.insertEdge(section.getBegginingJunction(), section.getEndingJunction(), section, section.getTotalLengthOfSection());
    }

    public boolean addSectionReverse(Section section) {
        return this.roadNetwork.insertEdge(section.getEndingJunction(), section.getBegginingJunction(), section, section.getTotalLengthOfSection());
    }

    public Project CloneProject() {
        Project clone = new Project();
        clone.setName(name + "-copy");
        clone.setDescription(description);
        clone.setRegistVehicle(registVehicle);
        clone.setRoadNetwork(roadNetwork);

        return clone;
    }

    public Junction newJunction() {
        return new Junction();
    }

    public Section newSection() {
        return new Section();
    }

    public Graph<Junction, Section> getRoadNetwork() {
        return roadNetwork;
    }

    public Iterable<Junction> getAllJunctions(Graph<Junction, Section> roadNetwork) {
        Iterable<Junction> junctionList = roadNetwork.vertices();
        
        return junctionList;

    }
 

    //este método foi criado devido à alteração de roadnetwork para graph em Project, uma vez que deixou de ser possivel obter objetos da classe RoadNetwork
    public Junction getJunctionInProject(String name, Iterable<Junction> node_list) {
        Iterator<Junction> it = node_list.iterator();
        Junction j;

        while (it.hasNext()) {
            j = it.next();
            if (name.equals(j.getId())) {
                return j;
            }
        }

        return null;
    }

    /**
     * @param registVehicle the registVehicle to set
     */
    public void setRegistVehicle(RegistryVehicle registVehicle) {
        this.registVehicle = registVehicle;
    }

    /**
     * @param roadNetwork the roadNetwork to set
     */
    public void setRoadNetwork(Graph<Junction, Section> roadNetwork) {
        this.roadNetwork = roadNetwork;
    }

    public boolean validate() {
        if (this.name == null || this.name.trim().isEmpty()) {
            return false;
        }

        if (this.description == null || this.description.trim().isEmpty()) {
            return false;
        }
        if (this.registVehicle.validate() != true) {
            return false;
        }
        if (this.roadNetwork.numEdges() < 2) {
            return false;
        }
        if (this.roadNetwork.numVertices() == 0) {
            return false;
        }
        return true;
    }
}
