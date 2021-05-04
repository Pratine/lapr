/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Joao Paulo
 */
public class RegistRegime {

    private LinkedList<Regime> regimeList;

    public RegistRegime() {
        regimeList = new LinkedList<>();
    }

    public void addRegime(Regime r) {
        regimeList.add(r);
    }

    public LinkedList<Regime> getRegimeList() {
        return regimeList;
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
        RegistRegime otherRegistRegime = (RegistRegime) obj;
        if (!this.getRegimeList().equals(otherRegistRegime.getRegimeList())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.regimeList);
        return hash;
    }
}
