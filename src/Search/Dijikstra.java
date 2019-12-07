package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijikstra {

    public Dijikstra(Vertex vertex){
        computeShotestPath(vertex);
    }

    public void computeShotestPath(Vertex sourceVertex){
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);
        while (!priorityQueue.isEmpty()){
            Vertex vertex = priorityQueue.poll();
            for (Edge edge:vertex.getAdjacencieList()){
                Vertex v = edge.getTarget();
                if (!v.isVisited()){
                    double newDistance = vertex.getDistance() + edge.getWeight();
                    if (newDistance < v.getDistance()){
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecesor(vertex);
                        priorityQueue.add(v);
                    }
                }
            }
            vertex.setVisited(true);
        }
    }

    public List<String> pathToList(Vertex vertex){
        List<String> path = new ArrayList<>();
        for (Vertex v = vertex; v != null; v = v.getPredecesor()){
            path.add(v.getName());
        }
        Collections.reverse(path);
        return path;
    }
}
