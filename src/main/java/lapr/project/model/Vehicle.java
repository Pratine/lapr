/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author salva
 */
public class Vehicle {

    private String name;
    private String description;
    private Type type;
    private Motorization motorization;
    private int tollClass;
    private Fuel fuel;
    private double mass;
    private double load;
    private double dragCoefficient;
    private double frontalArea;
    private double resistanceCoefficient;
    private double wheelSize;
    private Map<String, Double> velocityLimitPerRoad;
    private LinkedList<Gear> gearList;
    private double energyRatio;

    private int min_rpm;
    private int max_rpm;
    private RegistThrottle registryTrottle;
    private double finalDriveRatio;

    private static final double FLOATING_PRECISION_FOR_WEIGHT = 0.0000001f;

    public Vehicle(Type type, int toll_class, Fuel fuel, double frontal_area,
            double mass, double load, double drag_coefficient,
            double resistance_coefficient, double wheel_size,
            int min_rpm, int max_rpm, Motorization motorization,
            RegistThrottle registryThrottle, double finalDriveRatio, LinkedList<Gear> gear_list) {
        this.name = "";
        this.description = "";
        this.type = type;
        this.tollClass = toll_class;
        this.motorization = motorization;
        this.fuel = fuel;
        this.mass = mass;
        this.load = load;
        this.dragCoefficient = drag_coefficient;
        this.frontalArea = frontal_area;
        this.resistanceCoefficient = resistance_coefficient;
        this.wheelSize = wheel_size;
        this.min_rpm = min_rpm;
        this.max_rpm = max_rpm;
        this.finalDriveRatio = finalDriveRatio;
        this.gearList = gear_list;
        this.registryTrottle = registryThrottle;
        velocityLimitPerRoad = new HashMap<>();
    }

    public Vehicle(Type type, int toll_class, Fuel fuel, double frontal_area,
            double mass, double load, double drag_coefficient,
            double resistance_coefficient, double wheel_size,
            int min_rpm, int max_rpm, Motorization motorization,
            RegistThrottle registryThrottle, double finalDriveRatio, LinkedList<Gear> gear_list, double energy_ratio) {
        this.name = "";
        this.description = "";
        this.type = type;
        this.tollClass = toll_class;
        this.motorization = motorization;
        this.fuel = fuel;
        this.mass = mass;
        this.load = load;
        this.dragCoefficient = drag_coefficient;
        this.frontalArea = frontal_area;
        this.resistanceCoefficient = resistance_coefficient;
        this.wheelSize = wheel_size;
        this.min_rpm = min_rpm;
        this.max_rpm = max_rpm;
        this.finalDriveRatio = finalDriveRatio;
        this.gearList = gear_list;
        this.registryTrottle = registryThrottle;
        this.energyRatio = energy_ratio;
        velocityLimitPerRoad = new HashMap<>();
    }

    public Vehicle() {
        name = "";
        description = "";
        type = Type.DEFAULT;
        tollClass = 0;
        motorization = Motorization.DEFAULT;
        fuel = Fuel.DEFAULT;
        mass = -1;
        load = -1;
        dragCoefficient = -1;
        frontalArea = -1;
        resistanceCoefficient = -1;
        wheelSize = -1;
        min_rpm = -1;
        max_rpm = -1;
        finalDriveRatio = -1;
        gearList = new LinkedList<>();
        registryTrottle = new RegistThrottle();
        energyRatio = -1;
        velocityLimitPerRoad = new HashMap<>();
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the motorization
     */
    public Motorization getMotorization() {
        return motorization;
    }

    /**
     * @return the tollClass
     */
    public int getTollClass() {
        return tollClass;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @return the load
     */
    public double getLoad() {
        return load;
    }

    /**
     * @return the dragCoefficient
     */
    public double getDragCoefficient() {
        return dragCoefficient;
    }

    /**
     * @return the resistanceCoefficient
     */
    public double getResistanceCoefficient() {
        return resistanceCoefficient;
    }

    /**
     * @return the wheelSize
     */
    public double getWheelSize() {
        return wheelSize;
    }

    /**
     * @return the energyRatio
     */
    public double getEnergyRatio() {
        return energyRatio;
    }

    /**
     *
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @param tollClass the tollClass to set
     */
    public void setTollClass(int tollClass) {
        this.tollClass = tollClass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * @param load the load to set
     */
    public void setLoad(double load) {
        this.load = load;
    }

    /**
     * @param dragCoefficient the dragCoefficient to set
     */
    public void setDragCoefficient(double dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    /**
     * @param resistanceCoefficient the resistanceCoefficient to set
     */
    public void setResistanceCoefficient(double resistanceCoefficient) {
        this.resistanceCoefficient = resistanceCoefficient;
    }

    /**
     * @param wheelSize the wheelSize to set
     */
    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    /**
     * @param energyRatio the energyRatio to set
     */
    public void setEnergyRatio(double energyRatio) {
        this.energyRatio = energyRatio;
    }

    /**
     * @return the fuel
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * @return the frontalArea
     */
    public double getFrontalArea() {
        return frontalArea;
    }

    /**
     * @return the gearList
     */
    public LinkedList<Gear> getGearList() {
        return gearList;
    }

    /**
     * @return the min_rpm
     */
    public int getMin_rpm() {
        return min_rpm;
    }

    /**
     * @return the max_rpm
     */
    public int getMax_rpm() {
        return max_rpm;
    }

    /**
     * @return the registryTrottle
     */
    public RegistThrottle getRegistryThrottle() {
        return registryTrottle;
    }

    /**
     * @return the finalDriveRatio
     */
    public double getFinalDriveRatio() {
        return finalDriveRatio;
    }

    /**
     * @return the velocityLimitPerRoad
     */
    public Map<String, Double> getVelocityLimitPerRoad() {
        return velocityLimitPerRoad;
    }

    /**
     * @param velocityLimitPerRoad the velocityLimitPerRoad to set
     */
    public void setVelocityLimitPerRoad(Map<String, Double> velocityLimitPerRoad) {
        this.velocityLimitPerRoad = velocityLimitPerRoad;
    }

    public double getVelocityLimitOfRoad(String roadTypology) {
        if (this.getVelocityLimitPerRoad().containsKey(roadTypology)) {
            return CarPhysics.roundValue(this.getVelocityLimitPerRoad().get(roadTypology));
        }
        return 0.0f;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param motorization the motorization to set
     */
    public void setMotorization(Motorization motorization) {
        this.motorization = motorization;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * @param frontalArea the frontalArea to set
     */
    public void setFrontalArea(double frontalArea) {
        this.frontalArea = frontalArea;
    }

    /**
     * @param gearList the gearList to set
     */
    public void setGearList(LinkedList<Gear> gearList) {
        this.gearList = gearList;
    }

    /**
     * @param min_rpm the min_rpm to set
     */
    public void setMin_rpm(int min_rpm) {
        this.min_rpm = min_rpm;
    }

    /**
     * @param max_rpm the max_rpm to set
     */
    public void setMax_rpm(int max_rpm) {
        this.max_rpm = max_rpm;
    }

    /**
     * @param registryTrottle the registryTrottle to set
     */
    public void setRegistryThrottle(RegistThrottle registryTrottle) {
        this.registryTrottle = registryTrottle;
    }

    /**
     * @param finalDriveRatio the finalDriveRatio to set
     */
    public void setFinalDriveRatio(double finalDriveRatio) {
        this.finalDriveRatio = finalDriveRatio;
    }

    /**
     * @return sb.toString();
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\tName: ").append(this.name).append("\n");
        sb.append("\tDescription: ").append(this.description).append("\n");
        sb.append("\tType: ").append(this.type).append("\n");
        sb.append("\tToll Classe: ").append(this.tollClass).append("\n");
        sb.append("\tMotorization: ").append(this.motorization).append("\n");
        sb.append("\tFuel: ").append(this.fuel).append("\n");
        sb.append("\tMass: ").append(this.mass).append("\n");
        sb.append("\tLoad: ").append(this.load).append("\n");
        sb.append("\tDrag: ").append(this.dragCoefficient).append("\n");
        sb.append("\tFrontal Area: ").append(this.frontalArea).append("\n");
        sb.append("\tRRC: ").append(this.resistanceCoefficient).append("\n");
        sb.append("\tWheelSize: ").append(this.wheelSize).append("\n");
        sb.append("\tMinRpm: ").append(this.min_rpm).append("\n");
        sb.append("\tMaxRpm: ").append(this.max_rpm).append("\n");
        sb.append("\tFinal Drive ratio: ").append(this.finalDriveRatio).append("\n");
        sb.append("\tVelocity limit: ").append(this.velocityLimitPerRoad).append("\n");
        sb.append("\tGearList: ").append(this.gearList).append("\n");
        sb.append("\tThrottle List: ").append(this.registryTrottle.getThrottleList()).append("\n");
        return sb.toString();
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
        Vehicle otherVehicle = (Vehicle) obj;
        if (!this.name.equals(otherVehicle.name)) {
            return false;
        }
        if (!this.description.equals(otherVehicle.description)) {
            return false;
        }
        if (this.type != otherVehicle.type) {
            return false;
        }
        if (this.motorization != otherVehicle.motorization) {
            return false;
        }
        if (this.tollClass != otherVehicle.tollClass) {
            return false;
        }
        if (this.fuel != otherVehicle.fuel) {
            return false;
        }
        if (!(Math.abs(this.mass - otherVehicle.mass) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.load - otherVehicle.load) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.dragCoefficient - otherVehicle.dragCoefficient) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.frontalArea - otherVehicle.frontalArea) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.resistanceCoefficient - otherVehicle.resistanceCoefficient) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.wheelSize - otherVehicle.wheelSize) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
//        if (!(Math.abs(this.energyRatio - otherVehicle.energyRatio) < FLOATING_PRECISION_FOR_WEIGHT)) {
//            return false;
//        }
        if (!(Math.abs(this.finalDriveRatio - otherVehicle.finalDriveRatio) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (this.min_rpm != otherVehicle.min_rpm) {
            return false;
        }
        if (this.max_rpm != otherVehicle.max_rpm) {
            return false;
        }
        if (!this.velocityLimitPerRoad.equals(otherVehicle.velocityLimitPerRoad)) {
            return false;
        }
        if (!this.gearList.equals(otherVehicle.gearList)) {
            return false;
        }
        return this.registryTrottle.getThrottleList().equals(otherVehicle.registryTrottle.getThrottleList());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.tollClass;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.mass) ^ (Double.doubleToLongBits(this.mass) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.load) ^ (Double.doubleToLongBits(this.load) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.dragCoefficient) ^ (Double.doubleToLongBits(this.dragCoefficient) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.resistanceCoefficient) ^ (Double.doubleToLongBits(this.resistanceCoefficient) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.wheelSize) ^ (Double.doubleToLongBits(this.wheelSize) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.energyRatio) ^ (Double.doubleToLongBits(this.energyRatio) >>> 32));
        return hash;
    }

    private double getGearRatio(int gear) {
        return 0;
    }

    private double getMaxGear() {
        return getGearList().getLast().getRatio();
    }

    public double maxSpeed() {
        return CarPhysics.vehicleLinearVelocity(wheelSize, getMax_rpm(), getFinalDriveRatio(), getMaxGear());
    }

    private double maxSpeedWind() {
        return maxSpeed();
    }

    public void addGear(Gear g) {
        getGearList().add(g);
    }

    public boolean validate() {
        if (this.name == null || this.name.trim().isEmpty()) {
            return false;
        }

        if (this.description == null || this.description.trim().isEmpty()) {
            return false;
        }

        if (this.type == null || this.type.toString().isEmpty()) {
            return false;
        }

        if (this.fuel == null || this.fuel.toString().isEmpty()) {
            return false;
        }

        if (this.mass < 0.0f) {
            return false;
        }

        if (this.load < 0.0f) {
            return false;
        }

        if (this.dragCoefficient < 0.0f) {
            return false;
        }

        if (this.frontalArea < 0.0f) {
            return false;
        }

        return this.resistanceCoefficient >= 0.0f;

    }

    public void insertVelocityLimit(String segmentType, Double limit) {
        this.getVelocityLimitPerRoad().put(segmentType, limit);
    }

    public double getEnergyExpenditure(Segment s) {
        double expenditure = Double.MAX_VALUE;
        double expenditureTemp = 0;

        double gearRatio = 0;
        double engineSpeed = 0;
        int torque = 0;

        LinkedList<Throttle> throttleList = registryTrottle.getThrottleList();
        Iterator<Throttle> it = throttleList.iterator();
        Throttle t;

        while (it.hasNext()) {
            t = it.next();
            LinkedList<Regime> regimeList = t.getRegimeList();
            Iterator<Regime> it2 = regimeList.iterator();
            Regime r;

            while (it2.hasNext()) {
                r = it2.next();
                torque = r.getTorqueHigh();

                Iterator<Gear> it3 = gearList.iterator();
                Gear g;

                while (it3.hasNext()) {
                    g = it3.next();
                    engineSpeed = torque;
//                       expenditureTemp = CarPhysics.forceOnVehicleSlope(mass, resistanceCoefficient,
//                               wheelSize,frontalArea,g.getRatio(), dragCoefficient,maxSpeedWind(),
//                               engineSpeed, finalDriveRatio, s.getSlope());
                    if (Math.abs(expenditureTemp) < expenditure) {
                        expenditure = expenditureTemp;
                    }

                }

            }

        }

        return expenditure;
    }

}
