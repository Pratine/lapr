package lapr.project.model.graphbase;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 *
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class Edge<V, E> implements Comparable<Edge<V, E>> {

    private E element;           // Edge information
    private double weight;       // Edge weight
    private Vertex<V, E> vOrig;  // vertex origin
    private Vertex<V, E> vDest;  // vertex destination
   
    private static final float FLOATING_PRECISION_FOR_WEIGHT = 0.0000001f;

    public Edge() {
        element = null;
        weight = 0.0;
        vOrig = null;
        vDest = null;
    }

    public Edge(E eInf, double ew, Vertex<V, E> vo, Vertex<V, E> vd) {
        element = eInf;
        weight = ew;
        vOrig = vo;
        vDest = vd;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E eInf) {
        element = eInf;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double ew) {
        weight = ew;
    }

    public V getVOrig() {
        if (this.vOrig != null) {
            return vOrig.getElement();
        }
        return null;
    }

    public void setVOrig(Vertex<V, E> vo) {
        vOrig = vo;
    }

    public V getVDest() {
        if (this.vDest != null) {
            return vDest.getElement();
        }
        return null;
    }

    public void setVDest(Vertex<V, E> vd) {
        vDest = vd;
    }

    public V[] getEndpoints() {

        V oElem = null, dElem = null, typeElem = null;

        if (this.vOrig != null) {
            oElem = vOrig.getElement();
        }

        if (this.vDest != null) {
            dElem = vDest.getElement();
        }

        if (oElem == null && dElem == null) {
            return null;
        }

        if (oElem != null) // To get type
        {
            typeElem = oElem;
        }

        if (dElem != null) {
            typeElem = dElem;
        }

        V[] endverts = (V[]) Array.newInstance(typeElem.getClass(), 2);

        endverts[0] = oElem;
        endverts[1] = dElem;

        return endverts;
    }

    /**
     *
     * @param otherObj
     * @return
     */
    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj) {
            return true;
        }

        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }

        Edge<V, E> otherEdge = (Edge<V, E>) otherObj;

        // if endpoints vertices are not equal
        if ((this.vOrig == null && otherEdge.vOrig != null)
                || (this.vOrig != null && otherEdge.vOrig == null)) {
            return false;
        }

        if ((this.vDest == null && otherEdge.vDest != null)
                || (this.vDest != null && otherEdge.vDest == null)) {
            return false;
        }

        if (this.vOrig != null && otherEdge.vOrig != null
                && !this.vOrig.equals(otherEdge.vOrig)) {
            return false;
        }

        if (this.vDest != null && otherEdge.vDest != null
                && !this.vDest.equals(otherEdge.vDest)) {
            return false;
        }

        if (!(Math.abs(this.weight - otherEdge.weight) < FLOATING_PRECISION_FOR_WEIGHT)) {
            return false;
        }

        if (this.element != null && otherEdge.element != null) {
            return this.element.equals(otherEdge.element);
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.element);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.vOrig);
        hash = 13 * hash + Objects.hashCode(this.vDest);
        return hash;
    }

    @Override
    public Edge<V, E> clone() {

        Edge<V, E> newEdge = new Edge<>();

        newEdge.element = element;
        newEdge.weight = weight;
        newEdge.vOrig = vOrig;
        newEdge.vDest = vDest;

        return newEdge;
    }

    @Override
    public String toString() {
        String st = "";
        if (element != null) {
            st = "      (" + element + ") - ";
        } else {
            st = "\t ";
        }

        if (!(Math.abs(weight - 0.0f) < FLOATING_PRECISION_FOR_WEIGHT)){
            st += weight + " - " + vDest.getElement() + "\n";
        } else {
            st += vDest.getElement() + "\n";
        }

        return st;
    }

    @Override
    public int compareTo(Edge<V, E> t) {
        if (this.weight < t.weight) {
            return -1;
        }
        if (Math.abs(this.weight - t.weight) < FLOATING_PRECISION_FOR_WEIGHT) {
            return 0;
        }
        return 1;
    }

}
