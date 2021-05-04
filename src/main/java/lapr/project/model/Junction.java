/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author salva
 */
public class Junction {
 
    private String id;

    private static final String ID_BY_DEFAULT = "";

    public Junction(String id) {
        this.id = id;
    }
    
    public Junction() {
        id = ID_BY_DEFAULT;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
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
        Junction otherJunction = (Junction) obj;

        return this.id.equals(otherJunction.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public boolean validate() {
        return !(this.id == null || this.id.trim().isEmpty());
    }

}
