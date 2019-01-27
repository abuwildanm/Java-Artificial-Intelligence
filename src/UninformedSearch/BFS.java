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
//public class BFS {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Node station1 = new Node("Westminster", null, null);
//        Node station2 = new Node("Waterloo", station1, null);
//        Node station3 = new Node("Trafalgar Square", station1, station2);
//        Node station4 = new Node("Canary Wharf", station2, station3);
//        Node station5 = new Node("London Bridge", station4, station3);
//        Node station6 = new Node("Tottenham Court Road", station5, station4);
//        
//        station1.leftChild = station2;
//        station1.rightChild = station3;
//        
//        station2.middleChild = station3;
//        station2.rightChild = station4;
//        
//        station3.middleChild = station4;
//        station3.middleChild2 = station5;
//        
//        station4.middleChild = station5;
//        station4.middleChild2 = station6;
//        
//        station5.middleChild = station6;
//        
//        BreadthFirstSearch bfs = new BreadthFirstSearch(station6, station1);
//
//        if(bfs.compute())
//            System.out.print("Path Found!");
//    }
//    
//}
//

