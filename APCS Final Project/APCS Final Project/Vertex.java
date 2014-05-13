
 

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Kent Gang Scott Zelman and Suraj Sinha
 */
public class Vertex {

    public Vertex(String label) {
        name = label;
        active = true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Vertex) {
            Vertex v = (Vertex) ob;
            return this.name.equals(v.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getDist() {
        return dist;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean b) {
        active = b;
    }

    public boolean addEdge(Vertex next , double dist) {
        return neighbors.add(new Edge(next , dist));
    }

    public boolean deleteEdge(String s) {
        Edge delete = null;
        for (Edge e : neighbors) {
            if (s.equals(e.toString())) {
                delete = e;
                break;
            }
        }
        if (delete != null) {
            neighbors.remove(delete);
            return true;
        }
        return false;
    }

    public boolean setActiveEdge(String next , boolean b) {
        Edge edgy = null;
        for (Edge e : neighbors) {
            if (e.getNext().toString().equals(next)) {
                edgy = e;
                break;
            }
        }
        if (edgy != null) {
            edgy.setActive(b);
            return true;
        } else {
            return false;
        }
    }

    public void reset(boolean isSource) {
        previous = null;
        dist = isSource ? 0 : Double.POSITIVE_INFINITY;
    }

    public void takeAVisit() {
        for (Edge e : neighbors) {
            if (e.isActive()) {
                if (this.dist + e.getLength() < e.getNext().dist) {
                    e.getNext().dist = this.dist + e.getLength();
                    e.getNext().previous = this;
                }
            }
        }
    }

    private String name;
    private Set<Edge> neighbors = new HashSet<>();
    private double dist;
    private Vertex previous;
    private boolean active;
}
