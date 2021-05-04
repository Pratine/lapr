/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 */
public class CarPhysics {

    /* m/s */
    private static final double GRAVITY_VALUE = 9.81;

    /* kg/m3 */
    private static final double AIR_DENSITY = 1.225;

    public static double forceOnVehicle(Segment seg, Vehicle v, double torque, double gearRatio, double velocity) {
        return getEngineForce(v, torque, gearRatio) - getGroundFrictionForceSlope(v, seg) - getWindDragForce(v, velocity, seg) - getGravitationalForce(v, seg);
    }

    public static double vehicleLinearVelocity(double radiusTire, int engineRotations, double finalDriveRatio, double gearRatio) {
        return (2 * Math.PI * radiusTire * engineRotations) / (60 * finalDriveRatio * gearRatio);
    }

    /**
     * Method that returns the rpm needed to reach a certain velocity
     *
     * @param vel
     * @param radiusTire
     * @param finalDriveRatio
     * @param gearRatio
     * @return
     */
    public static double getRpm(double vel, double radiusTire, double finalDriveRatio, double gearRatio) {
        return (vel * 60 * finalDriveRatio * gearRatio) / (2 * Math.PI * radiusTire);
    }

    /**
     * Method that returns the force thats acts on the vehicle by the ground
     *
     * @param v
     * @param torque
     * @param gearRatio
     * @return
     */
    public static double getEngineForce(Vehicle v, double torque, double gearRatio) {
        return (torque * v.getFinalDriveRatio() * gearRatio) / v.getWheelSize();
    }

    /**
     * Method that returns the gravitational force that acts on a given vehicle
     *
     * @param v
     * @param seg
     * @return
     */
    public static double getGroundFrictionForceSlope(Vehicle v, Segment seg) {
        return v.getResistanceCoefficient() * (v.getMass() + v.getLoad()) * GRAVITY_VALUE * Math.cos(Math.toRadians(seg.getSlope()));
    }

    /**
     * Method that returns the force that acts on a vehicle by the wind
     *
     * @param v
     * @param velocity
     * @param seg
     * @return
     */
    public static double getWindDragForce(Vehicle v, double velocity, Segment seg) {
        return 0.5 * v.getDragCoefficient() * v.getFrontalArea() * AIR_DENSITY * Math.pow(velocity + seg.maxSpeedWind(), 2);

    }

    public static double getGravitationalForce(Vehicle v, Segment seg) {
        return (v.getMass() + v.getLoad()) * GRAVITY_VALUE * Math.sin(Math.toRadians(seg.getSlope()));
    }

    public static double getPowerGenerated(double torque, double rpm) {
        return 2 * Math.PI * torque * (rpm / 60);
    }

    public static double getInstantVelocity(double initialVel, double acel, double time) {
        return initialVel + (acel * time);
    }

    public static double getResultantForce(double mass, double load, double acel) {
        return (mass + load) * acel;
    }

    public static double getTorqueForRpm(Regime r, double rpm) {

        int rpmHigh = r.getRpmHigh();
        int rpmLow = r.getRpmLow();
        int torqueHigh = r.getTorqueHigh();
        int torqueLow = r.getTorqueLow();

        double m = ((double) torqueHigh - torqueLow) / ((double) rpmHigh - rpmLow);
        double b = torqueHigh - (m * rpmHigh);

        return (m * rpm) + b;
    }

    public static double getGroundFrictionForce(Vehicle v) {
        return v.getResistanceCoefficient() * (v.getMass() + v.getLoad()) * GRAVITY_VALUE;

    }

    public static double roundValue(double value) {
        return Math.round(value * 100.0) / 100.0;
    }    
}
