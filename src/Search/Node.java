package Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node{
    int data;
    boolean visited;
    List<Node> neighbours;

    Node(int data){
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addneighbours(Node node){
        this.neighbours.add(node);
    }

    public List getNeighbours(){
        return this.neighbours;
    }

    public void SetNeigbours(List list){
        this.neighbours = list;
    }

    public void DFS(Node node){
        node.visited = true;
        System.out.print(node.data + " ");
        for (Node trav:node.neighbours)
            if (!trav.visited)
                DFS(trav);
    }

    public void BFS(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()){
            Node n = queue.remove();
            System.out.print(n.data + " ");
            List<Node> nodes = n.getNeighbours();
            for (Node trav:nodes){
                if (trav != null && !trav.visited) {
                    trav.visited = true;
                    queue.add(trav);
                }
            }
        }
    }

    public void setFalse(Node node){
        node.visited = false;
        for(Node n:node.neighbours) {
            if (n.visited)
                setFalse(n);
        }
    }
}
