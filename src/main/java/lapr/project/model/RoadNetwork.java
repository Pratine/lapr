/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.graphbase.Edge;
import lapr.project.model.graphbase.Graph;

/**
 *
 * @author salva
 */
public class RoadNetwork {

    /**
     * @param graph
     * @param j1
     * @param j2
     * @param v
     * @return
     */
    public static LinkedList<Section> getBestPath(Graph<Junction, Section> graph, Junction j1, Junction j2, Vehicle v,double acel,double timeInter,double load,String algoritName) {

        LinkedList<Junction> junctionList = new LinkedList<>();

        LinkedList<Section> sectionList = new LinkedList<>();

        bestPath(graph, j1, j2, junctionList, v,acel,timeInter,load,algoritName);

        sectionList = getPathSections(graph, junctionList);

        return sectionList;
    }

    /**
     *
     * @param graph
     * @param junctionList
     * @return
     */
    public static LinkedList<Section> getPathSections(Graph<Junction, Section> graph, LinkedList<Junction> junctionList) {
        Junction jInit;
        Junction jEnd = null;
        Section s;
        LinkedList<Section> sectionList = new LinkedList<>();
        Iterator<Junction> it = junctionList.iterator();

        boolean ctr = false;
        while (it.hasNext()) {
            if (!ctr) {
                jInit = it.next();
            } else {
                jInit = jEnd;
            }
            if (it.hasNext()) {
                jEnd = it.next();
                s = graph.getEdge(jInit, jEnd).getElement();
                sectionList.add(s);
                ctr = true;
            }

        }

        return sectionList;
    }



    /**
     *
     * @param graph
     * @param jOrig
     * @param jDest
     * @param shortPath
     * @param vehicle
     * @param algoritName
     * @return
     */
    public static double bestPath(Graph<Junction, Section> graph, Junction jOrig, Junction jDest, LinkedList<Junction> shortPath, Vehicle vehicle,double acel,double timeInter,double load, String algoritName) {
        if (graph.validVertex(jDest) && graph.validVertex(jOrig)) {
            if (jOrig.equals(jDest)) {
                shortPath.add(jDest);
                return 0;
            }
            Junction[] vertices = graph.allkeyVerts();
            boolean[] visited = new boolean[graph.numVertices()];
            int[] pathKeys = new int[graph.numVertices()];
            double[] dist = new double[graph.numVertices()];
            shortestPathLength(graph, jOrig, vertices, visited, pathKeys, dist, vehicle,acel,timeInter,load,algoritName);
            if (pathKeys[graph.getKey(jDest)] != -1) {
                getPath(graph, jOrig, jDest, vertices, pathKeys, shortPath);
            }

            return dist[graph.getKey(jDest)];
        }
        return 0;
    }

    private static void shortestPathLength(Graph<Junction, Section> graph, Junction jOrig, Junction[] vertices,
            boolean[] visited, int[] pathKeys, double[] dist, Vehicle vehicle,double acel,double timeInter,double load,String algoritName) {

        for (int i = 0; i < graph.numVertices(); i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
            visited[i] = false;
        }
        dist[graph.getKey(jOrig)] = 0;
        int idx = graph.getKey(jOrig);
        while (idx != -1) {
            visited[idx] = true;
            for (Edge<Junction, Section> outgoingEdge : graph.outgoingEdges(vertices[idx])) {
                int i = graph.getKey(outgoingEdge.getVDest());
                if(algoritName.equalsIgnoreCase("FASTESTPATH")){
                    if (visited[i] == false && dist[i] > (dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionNecessaryTimeMaxSpeed(vehicle))) {
                        dist[i] = dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionNecessaryTimeMaxSpeed(vehicle);
                        pathKeys[i] = idx;

                    }
                }    
                if(algoritName.equalsIgnoreCase("EFFECIENTPATHTHEORICAL")){
                    if (visited[i] == false && dist[i] > (dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionEnergy(vehicle, acel, timeInter, load))) {
                        dist[i] = dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionEnergy(vehicle, acel, timeInter, load);
                        pathKeys[i] = idx;

                    }
                }    
                if(algoritName.equalsIgnoreCase("EFFECIENTPATHREAL")){
                    if (visited[i] == false && dist[i] > (dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionRealEnergy(vehicle, acel, timeInter, load))) {
                        dist[i] = dist[idx] + graph.getEdge(vertices[idx], vertices[i]).getElement().sectionEnergy(vehicle, acel, timeInter, load);
                        pathKeys[i] = idx;

                    }
                }    
            }

            int indiceAux = idx;
            double distanciaMinima = Double.MAX_VALUE;
            for (int i = 0; i < dist.length; i++) {

                if (visited[i] == false) {
                    if (dist[i] < distanciaMinima) {
                        distanciaMinima = dist[i];
                        idx = i;

                    }
                }
                if (i == dist.length - 1 && idx == indiceAux) {
                    idx = -1;
                }

            }
        }
    }

    private static void getPath(Graph<Junction, Section> g, Junction vOrig, Junction vDest, Junction[] verts, int[] pathKeys, LinkedList<Junction> path) {
        path.addFirst(vDest);
        Junction aux = verts[pathKeys[g.getKey(vDest)]];
        while (g.getKey(aux) != (g.getKey(vOrig))) {
            path.addFirst(aux);
            aux = verts[pathKeys[g.getKey(aux)]];
        }
        path.addFirst(vOrig);
    }

    public List<Junction> getPathJunctions(LinkedList<Section> section_list) {

        List<Junction> junctionList = new ArrayList<>();

        for (Section sc : section_list) {
            Junction start = sc.getBegginingJunction();
            Junction end = sc.getEndingJunction();
            if (!junctionList.contains(start)) {
                junctionList.add(start);
            }
            if (!junctionList.contains(end)) {
                junctionList.add(end);

            }

        }
        return junctionList;
    }

    public static double calcTollCost(LinkedList<Section> sectionList, Vehicle v) {
        double cost = 0.0;

        for (Section section : sectionList) {
            Typology type = section.getTypoligy();

            switch (type) {
                case HIGHWAY:
                    cost += section.getRoad().getTollFare().get(v.getTollClass()) * (section.getTotalLengthOfSection() / 1000);
                    break;
                case GANTRY:
                    cost += section.getTollFare().get(v.getTollClass());
                    break;
                case ROAD:
                    cost += 0.0;
                    break;
                default:
                    break;
            }

        }
        cost = Math.round(cost * 100);
        cost = cost/100;

        return cost;

    }

    public static double calcTravelTime(LinkedList<Section> section_list, Vehicle v) {

        int time = 0;

        for (Section section : section_list) {
            time += section.sectionNecessaryTimeMaxSpeed(v);
        }


        return time;
    }
    
    public static String timeToString(double time){
        int seconds = (int) (time % 60);
        int minutes = (int) (time / 60);
        if (minutes >= 60) {
            int hours = minutes / 60;
            minutes %= 60;

            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        
        return String.format("00:%02d:%02d", minutes, seconds);
    }
    

    public static double calcEnergy(LinkedList<Section> section_list, Vehicle v, double acel, double timeInter, double load) {

        int energy = 0;

        for (Section section : section_list) {

            energy += section.sectionEnergy(v, acel, timeInter, load);

        }

        energy = energy / 1000000;
        energy = Math.round(energy * 100f);
        energy = energy / 100;

        return energy;
    }

}
