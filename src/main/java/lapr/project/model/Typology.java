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
public enum Typology {
    ROAD(1, "regular road"),
    HIGHWAY(2, "toll highway"),
    GANTRY(3, "gantry toll highway"),
    DEFAULT(0, "default");

    private final String name;
    private final int id;

    private Typology(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public static String getById(int id) {
        for (Typology typology : values()) {
            if (typology.id == id) {
                return typology.name;
            }
        }
        return null;
    }

    public static Typology getByName(String name) {
        for (Typology typology : values()) {
            if (typology.name.equals(name)) {
                return typology;
            }
        }
        return null;
    }
}
