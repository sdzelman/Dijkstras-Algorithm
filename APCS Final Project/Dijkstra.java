/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author Kent Gang Scott Zelman and Suraj Sinha
 */
public class Dijkstra {

    public static void main(String[] args) {
        World america = new World();
        Vertex a = america.addVertex(new Vertex("A"));
        Vertex b = america.addVertex(new Vertex("B"));
        Vertex c = america.addVertex(new Vertex("C"));
        Vertex d = america.addVertex(new Vertex("D"));
        Vertex e = america.addVertex(new Vertex("E"));
        
        a.addEdge(b , 5);
        a.addEdge(c , 7);
        a.addEdge(e , 15);
        b.addEdge(c , 4);
        c.addEdge(a , 6);
        b.addEdge(d , 3);
        c.addEdge(d , 8);
        d.addEdge(e , 2);
        
        System.out.println(america.shortestDist(a.toString() , e.toString()));
    }
}
