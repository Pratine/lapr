package lapr.project.model;

/**
 *
 * @author Joao Paulo
 */
public class Regime {

    private int torqueLow;
    private int torqueHigh;
    private int rpmLow;
    private int rpmHigh;
    private double sfc;

    public Regime(int torqueLow, int torqueHigh, int rpmLow, int rpmHigh, double sfc) {
        this.torqueLow = torqueLow;
        this.torqueHigh = torqueHigh;
        this.rpmLow = rpmLow;
        this.rpmHigh = rpmHigh;
        this.sfc = sfc;
    }

    public Regime(int torqueLow, int torqueHigh, int rpmLow, int rpmHigh) {
        this.torqueLow = torqueLow;
        this.torqueHigh = torqueHigh;
        this.rpmLow = rpmLow;
        this.rpmHigh = rpmHigh;
    }

    public Regime() {
        this.torqueLow = 0;
        this.torqueHigh = 0;
        this.rpmLow = 0;
        this.rpmHigh = 0;
        this.sfc = 0;
    }

    /**
     * @return the torqueLow
     */
    public int getTorqueLow() {
        return torqueLow;
    }

    /**
     * @return the torqueHigh
     */
    public int getTorqueHigh() {
        return torqueHigh;
    }

    /**
     * @return the rpmLow
     */
    public int getRpmLow() {
        return rpmLow;
    }

    /**
     * @return the rpmHigh
     */
    public int getRpmHigh() {
        return rpmHigh;
    }

    /**
     * @return the sfc
     */
    public double getSfc() {
        return sfc;
    }

    /**
     * Sets the torque generated in the given range of rpms.
     *
     * @param torqueLow The new torque generated in the given range of rpms.
     */
    public void setTorqueLow(int torqueLow) {
        if (torqueLow > 0) {
            this.torqueLow = torqueLow;
        }
    }

    /**
     * Sets the torque generated in the given range of rpms.
     *
     * @param torqueHigh The new torque generated in the given range of rpms.
     */
    public void setTorqueHigh(int torqueHigh) {
        if (torqueHigh > 0) {
            this.torqueHigh = torqueHigh;
        }
    }

    /**
     * Sets the lowest value in the given range of rpms.
     *
     * @param rpmLow The new lowest value in the given range of rpms.
     */
    public void setRpmLow(int rpmLow) {
        if (rpmLow > 0) {
           this.rpmLow = rpmLow;
        }
    }

    /**
     * Sets the highest value in the given range of rpms.
     *
     * @param rpmHigh The new highest value in the given range of rpms.
     */
    public void setRpmHigh(int rpmHigh) {
        if (rpmHigh > 0) {
            this.rpmHigh = rpmHigh;
        }
    }

    /**
     * Sets the specific fuel consumption in the given range of rpms.
     *
     * @param sfc The new specific fuel consumption in the given range of rpms.
     */
    public void setSfc(Double sfc) {
        if (sfc > 0) {
            this.sfc = sfc;
        }
    }

    /**
     * Validate the regime.
     *
     * @return True if regime is valid else returns false.
     */
    public boolean validate() {
        if (this.torqueLow < 0) {
            return false;
        }
        if (this.torqueHigh <= 0) {
            return false;
        }

        if (this.rpmLow < 0) {
            return false;
        }

        if (this.rpmHigh <= 0) {
            return false;
        }
        if (this.sfc < 0.0f) {
            return false;
        }
        return this.rpmLow <= this.rpmHigh;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.torqueLow;
        hash = 43 * hash + this.torqueHigh;
        hash = 43 * hash + this.rpmLow;
        hash = 43 * hash + this.rpmHigh;
        hash = (int) (43 * hash + this.sfc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Regime other = (Regime) obj;
        if (this.torqueLow != other.torqueLow) {
            throw new IllegalArgumentException("torque low is not the same");
        }
        if (this.torqueHigh != other.torqueHigh) {
            throw new IllegalArgumentException("torque high is not the same");
        }
        if (this.rpmLow != other.rpmLow) {
            throw new IllegalArgumentException("rpm low is not the same");
        }
        if (this.rpmHigh != other.rpmHigh) {
            throw new IllegalArgumentException("rpm high is not the same ");
        }
        if (!(Math.abs(this.sfc - other.sfc) < 0.0000001f)) {
            throw new IllegalArgumentException("sfc is not the same");
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tTorqueLow: ").append(this.torqueLow).append("\n");
        sb.append("\t\t\tTorqueHigh: ").append(this.rpmHigh).append("\n");
        sb.append("\t\t\tRpmLow: ").append(this.rpmLow).append("\n");
        sb.append("\t\t\tRpmHigh: ").append(this.rpmHigh).append("\n");
        sb.append("\t\t\tSFC: ").append(this.sfc).append("\n");
        return sb.toString();
    }
}
