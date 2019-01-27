package UninformedSearch;

import java.util.*;

public class UniformCostSearch {
    Node startNode;
    Node goalNode;

    public UniformCostSearch(Node start, Node goalNode){
        this.startNode = start;
        this.goalNode = goalNode;
    }

    public void compute(){
        startNode.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
            @Override
            public int compare(Node i, Node j) {
                if (i.pathCost > j.pathCost) {
                    return 1;
                } else if (i.pathCost < j.pathCost) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        queue.add(startNode);
        Set<Node> explored = new HashSet<Node>();
        boolean found = false;
        
        do {
            Node current = queue.poll();
            explored.add(current);
            
            if (current.stationName.equals(goalNode.stationName)) {
                found = true;
            }
            
            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                child.pathCost = current.pathCost + cost;
                
                if (!explored.contains(child) && !queue.contains(child)) {
                    child.parent = current;
                    queue.add(child);
                    
                    System.out.println(child);
                    System.out.println(queue);
                    System.out.println("");
                } else if ((queue.contains(child)) && (child.pathCost > current.pathCost)) {
                    child.parent = current;
                    current = child;
                }
            }
        } while (!queue.isEmpty());
    }
    
    public List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}



