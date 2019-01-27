package UninformedSearch;

import java.util.*;

public class UCS {

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        
        //inisialisasi graphnya
        Node n1 = new Node("T");
        Node n2 = new Node("U");
        Node n3 = new Node("S");
        Node n4 = new Node("V");
        Node n5 = new Node("R");
        Node n6 = new Node("A");
        Node n7 = new Node("X");
        Node n8 = new Node("Q");
        Node n9 = new Node("I");
        Node n10 = new Node("B");
        Node n11 = new Node("C");
        Node n12 = new Node("D");
        Node n13 = new Node("J");
        Node n14 = new Node("K");
        Node n15 = new Node("E");
        Node n16 = new Node("M");
        Node n17 = new Node("L");
        Node n18 = new Node("N");
        Node n19 = new Node("P");
        Node n20 = new Node("O");
        Node n21 = new Node("F");
        Node n22 = new Node("G");
        Node n23 = new Node("H");
        Node kota[] = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13,
                       n14, n15, n16, n17, n18, n19, n20, n21, n22, n23};
        
        //inisialisasi semua edge
        //Dari T ke U,V,S
        n1.adjacencies = new Edge[] {
            new Edge(n2, 75), new Edge(n4, 25), new Edge(n3, 112)
        };
        
        //Dari U ke T,V
        n2.adjacencies = new Edge[] {
            new Edge(n1, 75), new Edge(n4, 85)
        };
        
        //Dari S ke T, R
        n3.adjacencies = new Edge[] {
            new Edge(n1, 112), new Edge(n5, 93)
        };
        
        //Dari V ke U,T,A
        n4.adjacencies = new Edge[] {
            new Edge(n2, 85), new Edge(n1, 25), new Edge(n6, 167)
        };
        
        //Dari R ke S,X
        n5.adjacencies = new Edge[] {
            new Edge(n3, 93), new Edge(n7, 57)
        };
        
        //Dari A ke V,B,I,X
        n6.adjacencies = new Edge[] {
            new Edge(n4, 167), new Edge(n10, 145),
            new Edge(n9, 148), new Edge(n7, 55)
        };
        
        //Dari X ke R,A,Q
        n7.adjacencies = new Edge[] {
            new Edge(n5, 57), new Edge(n6, 55), new Edge(n8, 30)
        };
        
        //Dari Q ke X,I
        n8.adjacencies = new Edge[] {
            new Edge(n7, 30), new Edge(n9, 25)
        };
        
        //Dari I ke A,Q,J
        n9.adjacencies = new Edge[] {
            new Edge(n6, 148), new Edge(n8, 25), new Edge(n13, 75)
        };
        
        //Dari B ke C,A
        n10.adjacencies = new Edge[] {
            new Edge(n6, 145), new Edge(n11, 98)
        };
        
        //Dari C ke B,D
        n11.adjacencies = new Edge[] {
            new Edge(n10, 98), new Edge(n12, 212)
        };
        
        //Dari D ke C,K,E
        n12.adjacencies = new Edge[] {
            new Edge(n11, 212), new Edge(n14, 102), new Edge(n5, 102)
        };
        
        //Dari J ke I,K
        n13.adjacencies = new Edge[] {
            new Edge(n9, 75), new Edge(n14, 95)
        };
        
        //Dari K ke J,D
        n14.adjacencies = new Edge[]{
            new Edge(n13, 95), new Edge(n12, 102)
        };
        
        //Dari E ke D,M,N,F,L
        n15.adjacencies = new Edge[]{
            new Edge(n12, 102), new Edge(n16, 73), new Edge(n18, 97),
            new Edge(n21, 152), new Edge(n17, 95)
        };
        
        //Dari M ke E
        n16.adjacencies = new Edge[]{
            new Edge(n15, 73)
        };
        
        //Dari L ke E
        n17.adjacencies = new Edge[]{
            new Edge(n15, 95)
        };
        
        //Dari N ke E,P,O
        n18.adjacencies = new Edge[]{
            new Edge(n15, 97), new Edge(n19, 65), new Edge(n20, 25)
        };
        
        //Dari P to N
        n19.adjacencies = new Edge[]{
            new Edge(n18, 65)
        };
        
        //Dari O ke N
        n20.adjacencies = new Edge[]{
            new Edge(n18, 25)
        };
        
        //Dari F ke E,G
        n21.adjacencies = new Edge[]{
            new Edge(n15, 152),
            new Edge(n22, 83)
        };
        
        //Dari G ke F,H
        n22.adjacencies = new Edge[]{
            new Edge(n23, 75),
            new Edge(n21, 83)
        };
        
        //Dari H ke G
        n23.adjacencies = new Edge[]{
            new Edge(n22, 75)
        };
        
        System.out.println("=== Uniform Cost Search ===");
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
        
        UniformCostSearch ucs = new UniformCostSearch(src, des);
        ucs.compute();
        List<Node> path = ucs.printPath(des);
        System.out.println("Path       : " + path);
        System.out.println("Total Cost : " + path.get(path.size() - 1).pathCost);
    }
}







