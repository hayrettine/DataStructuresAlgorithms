package Search;

import java.util.Arrays;

public class SearchApp {
    public static void main(String[] args) {
        int[] array = new int[]{12, 23, 4, 7, 2, 17, 98, 65, 32, 22, 76, 43};
        Arrays.sort(array);
        SearchAlgorithms algorithms = new SearchAlgorithms();
        algorithms.binarySearch(array, 76, 0, array.length-1);

        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        System.out.println("DFS:");
        node40.DFS(node40);
        node40.setFalse(node40);
        System.out.println();
        System.out.println("BFS:");
        node40.BFS(node40);
        System.out.println();

        /*
        Dijikstra
         */

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        vertexA.addNeighbour(new Edge(10,vertexA,vertexC));
        vertexA.addNeighbour(new Edge(17,vertexA,vertexB));
        vertexC.addNeighbour(new Edge(5,vertexC,vertexD));
        vertexC.addNeighbour(new Edge(9,vertexC,vertexB));
        vertexC.addNeighbour(new Edge(11,vertexC,vertexE));
        vertexB.addNeighbour(new Edge(1,vertexB,vertexD));
        vertexD.addNeighbour(new Edge(6,vertexD,vertexE));

        Dijikstra dijikstra = new Dijikstra(vertexA);

        System.out.println("A to E :" +  dijikstra.pathToList(vertexE) + " | distance: " + vertexE.getDistance());
        System.out.println("A to B :" +  dijikstra.pathToList(vertexB) + " | distance: " + vertexB.getDistance());
        System.out.println("A to C :" +  dijikstra.pathToList(vertexC) + " | distance: " + vertexC.getDistance());
        System.out.println("A to D :" +  dijikstra.pathToList(vertexD) + " | distance: " + vertexD.getDistance());
        System.out.println("A to A :" +  dijikstra.pathToList(vertexA) + " | distance: " + vertexA.getDistance());
    }
}
