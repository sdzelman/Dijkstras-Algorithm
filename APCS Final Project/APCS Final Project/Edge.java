/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.util.Objects;

/**
 *
 * @author Kent Gang and Will Xu
 */
public class Edge {

    public Edge(Vertex next , double length) {
        this.next = next;
        this.length = length;
        this.active = true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.next);
        return hash;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Edge) {
            Edge e = (Edge) ob;
            return this.next.equals(e.next);
        }
        return false;
    }

    public Vertex getNext() {
        return next;
    }

    public double getLength() {
        return length;
    }

    public boolean isActive() {
        return active;
    }

    public void setLength(double d) {
        length = d;
    }

    public void setActive(boolean b) {
        active = b;
    }

    private Vertex next;
    private double length;
    private boolean active;
}
