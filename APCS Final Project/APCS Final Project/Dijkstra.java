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
        World kesp = new World();
        Vertex a = kesp.addVertex(new Vertex("A"));
        Vertex b = kesp.addVertex(new Vertex("B"));
        Vertex c = kesp.addVertex(new Vertex("C"));
        Vertex d = kesp.addVertex(new Vertex("D"));
        Vertex e = kesp.addVertex(new Vertex("E"));
        
        a.addEdge(b , 5);
        a.addEdge(c , 7);
        a.addEdge(e , 15);
        b.addEdge(c , 4);
        c.addEdge(a , 6);
        b.addEdge(d , 3);
        c.addEdge(d , 8);
        d.addEdge(e , 2);
        
        System.out.println(kesp.shortestDist(a.toString() , e.toString()));
    }
}
