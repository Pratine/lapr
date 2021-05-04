/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;

/**
 *
 * @author Joao Paulo
 */
public class Throttle {

    private int idThrottle;
    private RegistRegime registRegime;

    
    public Throttle(int idThrottle) {
        this.idThrottle = idThrottle;
        registRegime = new RegistRegime();
    }

    public void addRegime(Regime r) {
        registRegime.addRegime(r);
    }

    public LinkedList<Regime> getRegimeList() {
        return registRegime.getRegimeList();
    }

    /**
     *
     * @param obj
     * @return
     */
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
        Throttle otherTrottle = (Throttle) obj;

        if (this.idThrottle != otherTrottle.idThrottle) {
            return false;
        }
        if (!this.registRegime.getRegimeList().equals(otherTrottle.registRegime.getRegimeList())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idThrottle;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tIdThrottle: ").append(this.idThrottle).append("\n");
        sb.append("\t\tRegistRegime: ").append(this.registRegime.getRegimeList()).append("\n");
        return sb.toString();
    }
}
