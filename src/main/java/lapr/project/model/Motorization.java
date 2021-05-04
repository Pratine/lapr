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
public enum Motorization {
    COMBUSTION(1, "combustion"),
    ELECTRIC(2, "eletric"),
    HYBRID(3, "hybrid"),
    DEFAULT(0, "default");

    private final String name;
    private final int id;

    private Motorization(int id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     *
     * @param id
     * @return
     */
    public static String getById(int id) {
        for (Motorization motorization : values()) {
            if (motorization.id == id) {
                return motorization.name;
            }
        }
        return null;
    }
}
