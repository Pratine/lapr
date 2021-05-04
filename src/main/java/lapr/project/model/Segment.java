package lapr.project.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Joao Paulo
 */
public class Segment {

    private int id;

    private double initialHeight;
    private double finalHeight;
    private double length;
    private int maxSpeed;
    private int minSpeed;
    private double windDirection;
    private double windSpeed;

    private static final float FLOATING_PRECISION_FOR_WEIGHT = 0.0000001f;

    //CONSTRUCTORS
    /**
     * -1 passed as parameters to be easily identifiable in case of error
     */
    public Segment() {
        id = -1;
        initialHeight = -1.0;
        finalHeight = -1.0;
        length = -1.0;
        maxSpeed = -1;
        minSpeed = -1;
        windDirection = 0;
        windSpeed = -1.0;
    }

    /**
     *
     * @param id
     * @param segId
     * @param initialHeight
     * @param finalHeight
     * @param slope
     * @param length
     * @param windDirection
     * @param windSpeed
     * @param maxSpeed
     * @param minSpeed
     * @param tool
     */
    public Segment(int id, double initialHeight, double finalHeight, double length, double windDirection, double windSpeed, int maxSpeed, int minSpeed) {
        this.id = id;
        this.initialHeight = initialHeight;
        this.finalHeight = finalHeight;
        this.length = length;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the initialHeight
     */
    public double getInitialHeight() {
        return initialHeight;
    }

    /**
     * @return the finalHeight
     */
    public double getFinalHeight() {
        return finalHeight;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @return the maxSpeed
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @return the minSpeed
     */
    public int getMinSpeed() {
        return minSpeed;
    }

    /**
     * @return the windDirection
     */
    public double getWindDirection() {
        return windDirection;
    }

    /**
     * @return the windSpeed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param initialHeight the initialHeight to set
     */
    public void setInitialHeight(double initialHeight) {
        this.initialHeight = initialHeight;
    }

    /**
     * @param finalHeight the finalHeight to set
     */
    public void setFinalHeight(double finalHeight) {
        this.finalHeight = finalHeight;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @param maxSpeed the maxSpeed to set
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @param minSpeed the minSpeed to set
     */
    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    /**
     * @param windDirection the windDirection to set
     */
    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    //GET'S and SET'S
    /**
     * @return Segment Identificator
     */
    //TO STRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\tSegment: ").append(this.id).append("\n");
        sb.append("\t\t\tInitial Height: ").append(this.initialHeight).append("\n");
        sb.append("\t\t\tFinal Height: ").append(this.finalHeight).append("\n");
        sb.append("\t\t\tLength: ").append(this.length).append("\n");
        sb.append("\t\t\tMax Velocity: ").append(this.maxSpeed).append("\n");
        sb.append("\t\t\tMin Velocity: ").append(this.minSpeed).append("\n");
        sb.append("\t\t\tWind Direction: ").append(this.windDirection).append("\n");
        sb.append("\t\t\tWind Speed: ").append(this.windSpeed).append("\n");

        return sb.toString();
    }

    public double segmentNecessaryTimeMaxSpeed(Vehicle v, double velOnTypology) {
        double vel = getSegmentVehicleMaxSpeed(v, velOnTypology);
        return Math.round((getLength() / vel) * 100.0) / 100.0;
    }

    public double getSegmentVehicleMaxSpeed(Vehicle v, double velOnTypology) {
        double vel;
        if (Double.compare(v.maxSpeed(), getMaxSpeed()) > 0.0) {
            vel = getMaxSpeed();
        } else {
            vel = v.maxSpeed();
        }
        if (vel < velOnTypology) {
            return vel;
        }

        return velOnTypology;
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Segment other = (Segment) obj;
        if (!(Math.abs(this.initialHeight - other.initialHeight) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.finalHeight - other.finalHeight) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.length - other.length) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.windDirection - other.windDirection) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (!(Math.abs(this.windSpeed - other.windSpeed) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }
        if (this.getMaxSpeed() != other.getMaxSpeed()) {
            return false;
        }
        return this.getMinSpeed() == other.getMinSpeed();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 12;
        return hash;
    }
    
    /**
     * Instant max speed obtained by the vehicle
     * @param velInstant
     * @param velOnTypology
     * @return 
     */
    public double getSegmentVehicleMaxSpeedInstant(double velInstant, double velOnTypology) {
        double vel;
        if (Double.compare(velInstant, getMaxSpeed()) < 0) {
            vel = velInstant;
        } else {
            vel = getMaxSpeed();
        }

        if (vel > velOnTypology) {
            vel = velOnTypology;
        }

        return CarPhysics.roundValue(vel);
    }
    /**
     * Method that returns the slope of the ground
     * @return 
     */
    public double getSlope() {

        double height = Math.abs(getFinalHeight() - getInitialHeight());
        double temp = height / getLength();
        double angleRadian = Math.asin(temp);
        return CarPhysics.roundValue(Math.toDegrees(angleRadian));
    }
    
    /**
     * Power generated by a vehicle in a segment N11
     * @param v
     * @param maxVelTypology
     * @param velInitial
     * @param acel
     * @param timeInter
     * @param load
     * @param lastSegment
     * @return 
     */
    public double[] getPowerBySegment(Vehicle v, double maxVelTypology, double velInitial, double acel, double timeInter, double load, boolean lastSegment) {
        double force=Double.MAX_VALUE;//force to compare
        double forceTemp;//temporary force 
        double usedTorque = 0.0;//used torque
        double usedSFC = 0.0; // used SFC 
        double velInstant = 0;//instant velocity
        double resultantForce = CarPhysics.getResultantForce(v.getMass(), load, acel);//resultant forc F = m*a
        double lengthCovered = 0;//length covered in the timeIntervalGiven
        double power = 0;//power genaretd
        double[] result = new double[3];//result array that as the power genareted and the end velocity
        double[] torques = new double[3];//torque for each throttle
        double[] usedGears = new double[3];//torque for each throttle
        double usedGear = 0.0;
        double[] sfc = new double[3];//sfc for each throttle
        double vel = 0.0;//velocity used
        double localVelInitial = velInitial;//temporary initial velocity
        double totalLengthCovered = 0;//variable to keep track of total length covered
        boolean velConsReached = false;// controller to verify if constant velocity was reached
        double maxVel = getSegmentVehicleMaxSpeed(v, maxVelTypology);

        //checks if lengthCovered doesnt exceed the segment length
        while (totalLengthCovered < this.length) {

            //check if current velocity isnt the vehicls allowed  max speed
            if (vel >= maxVel) {
                velConsReached = true;
                vel = maxVel;
                lengthCovered = this.length - totalLengthCovered;
            }

            //in case constant velocity isnt reached //min gk min rpm
            if (!velConsReached) {
                velInstant = CarPhysics.getInstantVelocity(localVelInitial, acel, timeInter);

                vel = getSegmentVehicleMaxSpeedInstant(velInstant, maxVelTypology);

                lengthCovered = vel * timeInter;
                
                //if length covered is expected to be more than the segments length the vehicle starts to break
                if ((totalLengthCovered + lengthCovered > this.length) && (lastSegment)) {
                    lengthCovered = this.length - totalLengthCovered;
                    vel = lengthCovered / timeInter;
                }
            }
            
            torques[0] = 0;
            torques[1] = 0;
            torques[2] = 0;
            
            usedGears[0] = 0;
            usedGears[1] = 0;
            usedGears[2] = 0;

            sfc[0] = 0;
            sfc[1] = 0;
            sfc[2] = 0;

            double rpm = 0;
            int i;
            int j;
            
            //cicle to iterate trough the gears in reverse order
            for (int idx = v.getGearList().size() - 1; idx >= 0; idx--) {
                i = 0;
                //rpm needed to get given velocity
                rpm = CarPhysics.getRpm(vel, v.getWheelSize(), v.getFinalDriveRatio(), v.getGearList().get(idx).getRatio());
                
                //if rpm is lower than minimum rpm it means the vehicle is stopped,so it is given the lowest rpm
                if (rpm < v.getMin_rpm()) {
                    rpm = v.getMin_rpm();
                }

                //iterate through  the throttle list
                LinkedList<Throttle> throttleList = v.getRegistryThrottle().getThrottleList();
                Iterator<Throttle> itThrottle = throttleList.iterator();
                Throttle t;

                while (itThrottle.hasNext()) {
                    t = itThrottle.next();
                    LinkedList<Regime> regimeList = t.getRegimeList();

                    Iterator<Regime> itRegime = regimeList.iterator();
                    Regime r;

                    i = 0;
                    while (itRegime.hasNext()) {
                        r = itRegime.next();
                        if ((rpm <= r.getRpmHigh()) && (rpm >= r.getRpmLow())) {
                            torques[i] = CarPhysics.getTorqueForRpm(r, rpm);
                            //tracks the sfc
                            sfc[i] = r.getSfc();
                            //and used Gear
                            usedGears[i] = v.getGearList().get(idx).getRatio();
                            i++;
                        }
                    }
                }
            }
            //for each throttle, checks which one is closest to F=0
            for (j = 0; j < torques.length; j++) {
                forceTemp = Math.abs(CarPhysics.forceOnVehicle(this, v, torques[j],usedGear , vel)-resultantForce);
                

                if (forceTemp < force) {
                    force = forceTemp;
                    usedTorque = torques[j];
                    usedSFC = sfc[j];
                    usedGear = usedGears[j];
                    
                }
            }
            
            //increments total segment power
            power += CarPhysics.getPowerGenerated(usedTorque, rpm);
            
            
            //increments length covered by the vehicle
            totalLengthCovered += lengthCovered;
            //checks if constant velocity is reached
            if (!velConsReached) {
                localVelInitial = vel;
            }
        }
        //returns power, last velocity and used sfc
        result[0] = power;
        result[1] = velInstant;
        result[2] = usedSFC;
        
        
        return result;

    }
    /**
     * Method that returns the most effecient way to drive in a segment N12
     * @param v
     * @param maxVelTypology
     * @param velInitial
     * @param acel
     * @param timeInter
     * @param load
     * @param lastSegment
     * @return 
     */
    public double[] getRealPowerBySegment(Vehicle v, double maxVelTypology, double velInitial, double acel, double timeInter, double load, boolean lastSegment) {

        double usedTorque = 0.0;//used torque
        double usedSFC = 0.0; // used SFC 
        double velInstant = 0;//instant velocity
        double resultantForce = CarPhysics.getResultantForce(v.getMass(), load, acel);//resultant forc F = m*a
        double lengthCovered = 0;//length covered in the timeIntervalGiven
        double power = 0;//power genaretd
        double[] result = new double[3];//result array that as the power genareted and the end velocity
        double[] usedGears = new double[3];//usedGears for each throttle
        double vel = 0.0;//velocity used
        double localVelInitial = velInitial;//temporary initial velocity
        double totalLengthCovered = 0;//variable to keep track of total length covered
        boolean velConsReached = false;// controller to verify if constant velocity was reached
        double maxVel = getSegmentVehicleMaxSpeed(v, maxVelTypology);
        double rpm = 0;
        int i=0;
        double velTemp;//temporary veleocity to know if vehicle is braking or acelerating
        double usedGear;

        //checks if lengthCovered doesnt exceed the segment length
        while (totalLengthCovered < this.length) {

            velTemp = vel;

            //check if current velocity isnt the vehicls allowed  max speed
            if (vel >= maxVel) {
                velConsReached = true;
                vel = maxVel;
                lengthCovered = this.length - totalLengthCovered;
            }

            //in case constant velocity isnt reached //min gk min rpm
            if (!velConsReached) {
                velInstant = CarPhysics.getInstantVelocity(localVelInitial, acel, timeInter);

                vel = getSegmentVehicleMaxSpeedInstant(velInstant, maxVelTypology);

                lengthCovered = vel * timeInter;

                if ((totalLengthCovered + lengthCovered > this.length) && (lastSegment)) {
                    lengthCovered = this.length - totalLengthCovered;
                    vel = lengthCovered / timeInter;
                }
            }
            
            
            
            if ((vel - velTemp) >= 0.0000001f) {//ACELARATING

                for (int idx = v.getGearList().size() - 1; idx >= 0; idx--) {
                    
                    rpm = CarPhysics.getRpm(vel, v.getWheelSize(), v.getFinalDriveRatio(), v.getGearList().get(idx).getRatio());

                    if (rpm < v.getMin_rpm()) {
                        rpm = v.getMin_rpm();
                    }
                    //cicles trough regimes of the first throttle
                    for (Regime r : v.getRegistryThrottle().getThrottleList().getFirst().getRegimeList()) {
                       
                        if ((rpm <= r.getRpmHigh()) && (rpm >= r.getRpmLow())) {
                            usedTorque = CarPhysics.getTorqueForRpm(r, rpm);
                            usedSFC = r.getSfc();
                            usedGear = v.getGearList().get(idx).getRatio();
                            
                        }
                    }
                }
            } else {//BREAKING
                for (int idx = v.getGearList().size() - 1; idx >= 0; idx--) {

                    rpm = CarPhysics.getRpm(vel, v.getWheelSize(), v.getFinalDriveRatio(), v.getGearList().get(idx).getRatio());

                    if (rpm < v.getMin_rpm()) {
                        rpm = v.getMin_rpm();
                    }

                    Throttle t = v.getRegistryThrottle().getThrottleList().getFirst();
                    for (Regime r : t.getRegimeList()) {
                        
                        if ((rpm <= r.getRpmHigh()) && (rpm >= r.getRpmLow())) {
                            usedTorque = CarPhysics.getTorqueForRpm(r, rpm);
                            usedSFC = r.getSfc();
                            usedGear = v.getGearList().get(idx).getRatio();
                            
                        }
                    }

                }

            }

            power += CarPhysics.getPowerGenerated(usedTorque, rpm);

            totalLengthCovered += lengthCovered;
            if (!velConsReached) {
                localVelInitial = vel;
            }
        }
        result[0] = power;
        result[1] = velInstant;
        result[2] = usedSFC;

        return result;

    }
    
    public double[] getSegmentEnergyReal(Vehicle v, double maxVelTypology, double velInitial, double acel, double timeInter, double load, boolean lastSegment) {
        double[] result = new double[2];
        result = getRealPowerBySegment(v, maxVelTypology, velInitial, acel, timeInter, load, lastSegment);
        result[0] = result[0] * segmentNecessaryTimeMaxSpeed(v, maxVelTypology) * result[2];
        return result;
    }

    public double[] getSegmentEnergy(Vehicle v, double maxVelTypology, double velInitial, double acel, double timeInter, double load, boolean lastSegment) {
        double[] result = new double[2];
        result = getPowerBySegment(v, maxVelTypology, velInitial, acel, timeInter, load, lastSegment);
        result[0] = result[0] * segmentNecessaryTimeMaxSpeed(v, maxVelTypology) * result[2];

        return result;
    }

    public boolean validate() {
        if (this.id < 0) {
            return false;
        }
        if (this.initialHeight < 0.0f) {
            return false;
        }
        if (this.finalHeight < 0.0f) {
            return false;
        }
        if (this.length < 0.0f) {
            return false;
        }
        if (this.maxSpeed < 0) {
            return false;
        }
        if (this.minSpeed < 0) {
            return false;
        }
        if (this.maxSpeed <= this.minSpeed) {
            return false;
        }
        return this.windSpeed >= 0.0f;
    }

    public double maxSpeedWind() {
        double angle = getWindDirection();
        return (Math.cos(Math.toRadians(angle)) * getWindSpeed());
    }
}
