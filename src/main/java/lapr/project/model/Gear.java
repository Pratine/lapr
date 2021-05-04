package lapr.project.model;

/**
 *
 * @author salva
 */
public class Gear {

    private double ratio;

    public Gear(double ratio) {
        this.ratio = ratio;
    }

    public Gear() {
        this.ratio = 0.0f;
    }

    /**
     * @return the ratio
     */
    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
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
        Gear otherGear = (Gear) obj;
        if (!(Math.abs(this.ratio - otherGear.ratio) < 0.0000001f)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.ratio) ^ (Double.doubleToLongBits(this.ratio) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\t\tRatio: ").append(this.ratio).append("\n");
        return sb.toString();
    }
}
