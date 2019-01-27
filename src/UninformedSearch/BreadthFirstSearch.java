///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package UninformedSearch;
//
///**
// *
// * @author cahkanor
// */
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * basic breadth first search in java
// */
//public class BreadthFirstSearch {
//
//    Node startNode;
//    Node goalNode;
//
//    public BreadthFirstSearch(Node start, Node goalNode){
//        this.startNode = start;
//        this.goalNode = goalNode;
//    }
//
//    public boolean compute(){
//
//        if(this.startNode.equals(goalNode)){
//            System.out.println("Goal Node Found!");
//            System.out.println(startNode);
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        ArrayList<Node> explored = new ArrayList<>();
//        queue.add(this.startNode);
//        //explored.add(startNode);
//
//        while(!queue.isEmpty()){
//            Node current = queue.remove();
//            if(current.equals(this.goalNode)) {
//                //System.out.println(explored);
//                explored.add(current);
//                System.out.println("Explored Node : ");
//                explored.stream().forEach((item) -> {   
//                    System.out.println(item.stationName+" ");
//                });
//                return true;
//            }
//            else{
//                if(current.getChildren().isEmpty())
//                    return false;
//                else
//                    queue.addAll(current.getChildren());
//            }
//            explored.add(current);
//        }
//
//        return false;
//
//    }
//
//}
//
//

