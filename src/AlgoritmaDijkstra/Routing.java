package AlgoritmaDijkstra;

import java.util.PriorityQueue;

import java.util.List;

import java.util.ArrayList;

import java.util.Collections;

public class Routing {

    /* Dijkstra Algorithm

 * 

 *

     */
    public static void computePaths(Node source) {

        source.shortestDistance = 0;

        //implement a priority queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        queue.add(source);

        while (!queue.isEmpty()) {

            Node u = queue.poll();

            /*visit the adjacencies, starting from 

			the nearest node(smallest shortestDistance)*/
            for (Edge e : u.adjacencies) {

                Node v = e.target;

                double weight = e.weight;

                //relax(u,v,weight)
                double distanceFromU = u.shortestDistance + weight;

                if (distanceFromU < v.shortestDistance) {

                    /*remove v from queue for updating 

					the shortestDistance value*/
                    queue.remove(v);

                    v.shortestDistance = distanceFromU;

                    v.parent = u;

                    queue.add(v);

                }

            }

        }

    }

    public static List<Node> getShortestPathTo(Node target) {

        //trace path from target to source
        List<Node> path = new ArrayList<Node>();

        for (Node node = target; node != null; node = node.parent) {

            path.add(node);

        }

        //reverse the order such that it will be from source to target
        Collections.reverse(path);

        return path;

    }

    public static void main(String[] args) {

        //initialize the graph base on the Romania map
        Node n1 = new Node("A");

        Node n2 = new Node("B");

        Node n3 = new Node("C");

        Node n4 = new Node("D");

        //initialize the edges
        n1.adjacencies = new Edge[]{
            new Edge(n2, 10),
            new Edge(n3, 6),
            new Edge(n4, 34)

        };

        n2.adjacencies = new Edge[]{
            new Edge(n1, 10),
            new Edge(n4, 7)

        };

        n3.adjacencies = new Edge[]{
            new Edge(n1, 6),
            new Edge(n3, 8),
            new Edge(n4, 10)

        };

        n4.adjacencies = new Edge[]{
            new Edge(n1, 34),
            new Edge(n2, 7),
            new Edge(n3, 10),
            new Edge(n4, 9)
        };

        Node[] nodes = {n1, n2, n3, n4};

        //compute paths
        computePaths(n1);

        //print shortest paths
        for (Node n : nodes) {

            System.out.println("Distance to "
                    + n + ": " + n.shortestDistance);

            List<Node> path = getShortestPathTo(n);

            System.out.println("Path: " + path);

        }
        List<Node> path = getShortestPathTo(n4);

        System.out.println("Path: " + path);

    }

}

