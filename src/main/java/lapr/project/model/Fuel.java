/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author salva
 */
public enum Fuel {

    DIESEL(1, "diesel", 48),
    /**
     *
     */
    GASOLINE(2, "gasoline", 44.4),
    /**
     *
     */
    ELECTRIC(3, "electric", 1),
    DEFAULT(0, "default", 0);

    private final String name;
    private final int id;
    private final double energy;

    private Fuel(int id, String name, double energy) {
        this.name = name;
        this.id = id;
        this.energy = energy;
    }

    public static double getEnergyById(int id) {
        for (Fuel fuel : values()) {
            if (fuel.id == id) {
                return fuel.energy;
            }
        }
        return 0;
    }

}
