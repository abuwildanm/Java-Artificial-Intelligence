package InformedSearch;

import java.util.*;

class Edge {
    public final double cost;
    public final Node target;
    
    public Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}

class Node {
    public String stationName;
    public double pathCost; //g(n)
    public double estimateCost; //h(n)
    public double totalCost; //f(n)
    public Edge[] adjacencies;
    public Node parent;

    public Node(String stationName, double estimateCost) {
        this.stationName = stationName;
        this.estimateCost = estimateCost;
    }

    @Override
    public String toString() {
        return stationName;
    }
}

public class AStarSearch {
    Node startNode;
    Node goalNode;

    public AStarSearch(Node start, Node goalNode){
        this.startNode = start;
        this.goalNode = goalNode;
    }

    public void compute(){
        startNode.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
            @Override
            public int compare(Node i, Node j) {
                if (i.totalCost > j.totalCost) {
                    return 1;
                } else if (i.totalCost < j.totalCost) {
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
                child.totalCost = child.pathCost + child.estimateCost;
                
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
    
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        
        //inisialisasi graphnya
        Node n1 = new Node("A", 180);
        Node n2 = new Node("B", 90);
        Node n3 = new Node("C", 89);
        Node n4 = new Node("D", 0);
        Node n5 = new Node("E", 110);
        Node n6 = new Node("F", 79);
        Node n7 = new Node("G", 100);
        
        Node kota[] = {n1, n2, n3, n4, n5, n6, n7};
        
        //inisialisasi semua edge
        //Dari A ke B,G,F
        n1.adjacencies = new Edge[] {
            new Edge(n2, 79), new Edge(n7, 63), new Edge(n6, 81)
        };
        
        //Dari B ke A,G,D,C
        n2.adjacencies = new Edge[] {
            new Edge(n1, 79), new Edge(n7, 55), 
            new Edge(n4, 109), new Edge(n3, 131)
        };
        
        //Dari C ke B,D
        n3.adjacencies = new Edge[] {
            new Edge(n2, 131), new Edge(n4, 88)
        };
        
        //Dari D ke C,B,F,E
        n4.adjacencies = new Edge[] {
            new Edge(n3, 88), new Edge(n2, 109), 
            new Edge(n6, 126), new Edge(n5, 92)
        };
        
        //Dari E ke D,F
        n5.adjacencies = new Edge[] {
            new Edge(n4, 92), new Edge(n6, 148)
        };
        
        //Dari F ke A,G,D,E
        n6.adjacencies = new Edge[] {
            new Edge(n1, 81), new Edge(n7, 60),
            new Edge(n4, 126), new Edge(n5, 148)
        };
        
        //Dari G ke B,A,F
        n7.adjacencies = new Edge[] {
            new Edge(n2, 55), new Edge(n1, 63), new Edge(n6, 60)
        };
        
        System.out.println("=== A-Star Search ==="); //hanya berlaku untuk goal state = node D
        System.out.print("Masukkan Kota Asal   : ");
        String asal = masuk.next();
        System.out.print("Masukkan Kota Tujuan : ");
        String tujuan = masuk.next();
        System.out.println("\nLangkah Pencarian Rute");
        
        Node src = null, des = null;
        for (int i = 0; i < kota.length; i++) {
            if (kota[i].stationName.equals(asal)) {
                src = kota[i];
            }
            if (kota[i].stationName.equals(tujuan)) {
                des = kota[i];
            }
        }
        
        AStarSearch astar = new AStarSearch(src, des);
        astar.compute();
        List<Node> path = astar.printPath(des);
        System.out.println("Path            : " + path);
        System.out.println("Total Cost      : " + path.get(path.size() - 1).totalCost);
    }
}













