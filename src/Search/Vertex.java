package Search;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> adjacencieList;
    private boolean visited;
    private Vertex predecesor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name){
        this.name = name;
        adjacencieList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge){
        this.adjacencieList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacencieList() {
        return adjacencieList;
    }

    public void setAdjacencieList(List<Edge> adjacencieList) {
        this.adjacencieList = adjacencieList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Vertex predecesor) {
        this.predecesor = predecesor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }
}
