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
public class RegistThrottle {

    protected LinkedList<Throttle> throttleList;

    public RegistThrottle() {
        throttleList = new LinkedList<>();
    }

    public void addThrottle(Throttle t) {
        throttleList.add(t);
    }

    public LinkedList<Throttle> getThrottleList() {
        return throttleList;
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
        RegistThrottle otherRegistThrottle = (RegistThrottle) obj;

        if (!this.getThrottleList().equals(otherRegistThrottle.getThrottleList())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.throttleList);
        return hash;
    }
}
