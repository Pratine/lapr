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
public enum Type {
    
    CAR(1, "car"),    
    TRUCK(2, "truck"),
    TRACTOR_SEMI_TRAILER(3, "tractor and semi-trailer"),
    MOTORCYCLE(4, "motorcycle"),
    DEFAULT(0, "default");

    private final String name;
    private final int id;

    private Type(int id, String name) {
        this.name = name;
        this.id = id;
    }
}
