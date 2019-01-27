package UninformedSearch;

//import java.util.ArrayList;

class Edge {
    public final double cost;
    public final Node target;
    
    public Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}

public class Node {

    public String stationName;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return stationName;
    }
}



