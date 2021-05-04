/*
* A collection of graph algorithms.
*/
package lapr.project.model.graphbase;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author DEI-ESINF
 */
@SuppressWarnings("unchecked")
public class GraphAlgorithms {
    
    private static final float FLOATING_PRECISION_FOR_WEIGHT = 0.0000001f;
    
   /**
   * Performs breadth-first search of a Graph starting in a Vertex 
   * @param g Graph instance
   * @param vInf information of the Vertex that will be the source of the search
   * @return qbfs a queue with the vertices of breadth-first search 
   */
    public static<V,E> LinkedList<V> BreadthFirstSearch(Graph<V,E> g, V vert){
    
        if (!g.validVertex(vert)) 
           return null; 
        
        LinkedList<V> qbfs = new LinkedList<>(); 
        LinkedList<V> qaux = new LinkedList<>();
        boolean[] visited = new boolean[g.numVertices()];  //default initializ.: false

        qbfs.add(vert);
        qaux.add(vert);
        int vKey=g.getKey(vert);
        visited[vKey]=true;
       
        while(!qaux.isEmpty()){
            vert=qaux.remove(); 
            for (Edge<V,E> edge : g.outgoingEdges(vert)){                
                V vAdj = g.opposite(vert, edge);
                vKey = g.getKey(vAdj);
                if (!visited[vKey]){
                    qbfs.add(vAdj);
                    qaux.add(vAdj);
                    visited[vKey]=true;
                }
            }
        }
        return qbfs;
    }
   
    /**
   * Performs depth-first search starting in a Vertex   
   * @param g Graph instance
   * @param vOrig Vertex of graph g that will be the source of the search
   * @param visited set of discovered vertices
   * @param qdfs queue with vertices of depth-first search
   */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {
        int vKey = g.getKey(vOrig);                         //stores key from vOrig 
        visited[vKey] = true;                               //vOrig becomes visited

        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {   // for each edge of outgoingedges()
            V vAdj = g.opposite(vOrig, edge);
            vKey = g.getKey(vAdj);                         //gets key from adjacent

            if (vAdj != null && !visited[vKey]) {          //if not visited and not null
                qdfs.add(vAdj);                           //add to queue
                DepthFirstSearch(g, vAdj, visited, qdfs);

            }

        }

    }
  
   /**
   * @param g Graph instance
   * @param vInf information of the Vertex that will be the source of the search
   * @return qdfs a queue with the vertices of depth-first search 
   */
    public static<V,E> LinkedList<V> DepthFirstSearch(Graph<V,E> g, V vert){
    
        if(!g.validVertex(vert)){
           return null;
           
       } 
        LinkedList<V> path = new LinkedList<>();
        path.add(vert);
        boolean[] knownVert = new boolean[g.numVertices()];

        DepthFirstSearch(g, vert, knownVert, path);

        return path; 
    }
   
    /**
   * Returns all paths from vOrig to vDest
   * @param g Graph instance
   * @param vOrig Vertex that will be the source of the path
   * @param vDest Vertex that will be the end of the path
   * @param visited set of discovered vertices
   * @param path stack with vertices of the current path (the path is in reverse order)
   * @param paths ArrayList with all the paths (in correct order)
   */
    
    private static<V,E> void allPaths(Graph<V,E> g, V vOrig, V vDest, boolean[] visited, 
                                           LinkedList<V> path, ArrayList<LinkedList<V>> paths){
  
       int vKey = g.getKey(vOrig);
        visited[vKey] = true;
        path.push(vOrig);
        
        for (Edge<V,E> e : g.outgoingEdges(vOrig)) {
            V vAdj = e.getVDest();
            if (vAdj.equals(vDest)) {
                path.push(vDest);
                paths.add(path);
                path.pop();
            } else {
                if (!visited[g.getKey(vAdj)]) {
                    GraphAlgorithms.allPaths(g, vAdj, vDest, visited, path, paths);
                }
            }
        }

        visited[vKey] = false;
        path.pop();
    }
    
   /**
   * @param g Graph instance
   * @param voInf information of the Vertex origin
   * @param vdInf information of the Vertex destination 
   * @return paths ArrayList with all paths from voInf to vdInf 
   */
    public static<V,E> ArrayList<LinkedList<V>> allPaths(Graph<V,E> g, V vOrig, V vDest){
    
        if (!(g.validVertex(vOrig) && g.validVertex(vDest))) {
             return null;
         }
        
        boolean[] visited = new boolean[g.numVertices()];

        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();

        GraphAlgorithms.allPaths(g, vOrig, vDest, visited, path, paths);

        return paths;
    }
    
    /**
   * Computes shortest-path distance from a source vertex to all reachable 
   * vertices of a graph g with nonnegative edge weights
   * This implementation uses Dijkstra's algorithm
   * @param g Graph instance
   * @param vOrig Vertex that will be the source of the path
   * @param visited set of discovered vertices
   * @param pathkeys minimum path vertices keys  
   * @param dist minimum distances
   */
    private static<V,E> void shortestPathLength(Graph<V,E> g, V vOrig, V[] vertices,
                                    boolean[] visited, int[] pathKeys, double[] dist){   
        
       int i = g.getKey(vOrig);
        dist[i] = 0;
        while (i != -1) {

            vOrig = vertices[i];
            int origKey = g.getKey(vOrig);
            visited[origKey] = true;

            for (Edge<V, E> edg : g.outgoingEdges(vOrig)) {
                V vAdj = g.opposite(vOrig, edg);
                int adjKey = g.getKey(vAdj);
                if (!visited[adjKey] && dist[adjKey] > (dist[origKey] + edg.getWeight())) {
                    dist[adjKey] = dist[origKey] + edg.getWeight();
                    pathKeys[adjKey] = origKey;
                }
            }
            i = getVertMinDist(dist, visited);

        }
    
    }
    
     private static int getVertMinDist(double[] dist, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int indice = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && (dist[i] < min)) {
                min = dist[i];
                indice = i;
            }
        }

        return indice;
    }
    
    /**
    * Extracts from pathKeys the minimum path between voInf and vdInf
    * The path is constructed from the end to the beginning
    * @param g Graph instance
    * @param voInf information of the Vertex origin
    * @param vdInf information of the Vertex destination 
    * @param pathkeys minimum path vertices keys  
    * @param path stack with the minimum path (correct order)
    */
    private static<V,E> void getPath(Graph<V,E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path){
    
        if (vOrig != vDest) {

            path.push(vDest);
            int vKey = g.getKey(vDest);
            int prevVKey = pathKeys[vKey];
            vDest = verts[prevVKey];

            getPath(g, vOrig, vDest, verts, pathKeys, path);

        } else {
            path.push(vOrig);
        }
    }

    //shortest-path between voInf and vdInf
    public static<V,E> double shortestPath(Graph<V,E> g, V vOrig, V vDest, LinkedList<V> shortPath){
      
         if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return 0;
        }
        V[] vertices = g.allkeyVerts();
        int numVerts = g.numVertices();
        boolean[] visited = new boolean[numVerts]; 
        int[] Keys = new int[numVerts];
        double[] dist = new double[numVerts];

        for (int i = 0; i < numVerts; i++) {
            dist[i] = Double.MAX_VALUE;
            Keys[i] = -1;
        }

        shortestPathLength(g, vOrig, vertices, visited, Keys, dist);

        double lengthPath = dist[g.getKey(vDest)];

        if(!(Math.abs(lengthPath - Double.MAX_VALUE) < FLOATING_PRECISION_FOR_WEIGHT)){
            getPath(g, vOrig, vDest, vertices, Keys, shortPath);
            return lengthPath;
        }
        return 0;
    }
    
    
   
    /**
     * Reverses the path
     * @param path stack with path
     */
    private static<V,E> LinkedList<V> revPath(LinkedList<V> path){ 
   
        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();
        
        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());
        
        return pathrev ;
    }    
}