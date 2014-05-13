

 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Kent Gang and Will Xu
 */
public class World {

    public World() {
    }

    public Vertex addVertex(Vertex v) {
        if (graph.add(v)) {
            return v;
        }
        return null;
    }

    public boolean deleteVertex(String s) {
        Vertex delete = null;
        for (Vertex v : graph) {
            if (s.equals(v.toString())) {
                delete = v;
                break;
            }
        }
        if (delete != null) {
            graph.remove(delete);
            for (Vertex v : graph) { //deletes all paths to the deleted vertex
                v.deleteEdge(s);
            }
            return true;
        }
        return false;
    }

    public Vertex getVertex(String s) {
        for (Vertex v : graph) {
            if (s.equals(v.toString())) {
                return v;
            }
        }
        return null;
    }

    public boolean setActiveVertex(String s , boolean b) {
        Vertex vert = null;
        for (Vertex v : graph) {
            if (v.toString().equals(s)) {
                vert = v;
                break;
            }
        }
        if (vert != null) {
            vert.setActive(b);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getPath() {
        List<String> tempPath = new ArrayList<>();
        tempPath.addAll(path);
        return tempPath;
    }

    public double shortestDist(String start , String end) {
        Vertex source = null;
        Vertex target = null;
        for (Vertex v : graph) {
            if (!v.isActive()) {
                continue;
            }
            if (start.equals(v.toString())) {
                source = v;
            }
            if (end.equals(v.toString())) {
                target = v;
            }
        }
        if (source == null) {
            return -1;
        } else if (target == null) {
            return -2;
        }
        
        Set<Vertex> unvisited = new HashSet<>();
        for (Vertex v : graph) {
            v.reset(v.equals(source));
            if (v.isActive()) {
                unvisited.add(v);
            }
        }
        path.clear();
        
        while (unvisited.contains(target)) {
            Vertex curr = target;
            for (Vertex v : unvisited) {
                if (v.getDist() < curr.getDist()) {
                    curr = v;
                }
            }
            if (curr.getDist() == Double.POSITIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            
            unvisited.remove(curr);
            
            if (curr == target) { //target reached, calculating vertex path
                while (curr != null) {
                    path.add(0 , curr.toString());
                    curr = curr.getPrevious();
                }
            } else {
                curr.takeAVisit();
            }
        }
        
        return target.getDist();
    }

    private Set<Vertex> graph = new HashSet<>();
    private List<String> path = new ArrayList<>();
}
