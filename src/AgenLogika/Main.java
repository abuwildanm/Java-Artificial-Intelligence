package AgenLogika;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        WumpusWorld w = new WumpusWorld();

        while (true) {
            w.room[w.agent.x][w.agent.y].checkInfo();
            System.out.println("Action");
            System.out.println("1. Move Up");
            System.out.println("2. Move Down");
            System.out.println("3. Move Right");
            System.out.println("4. Move Left");
            System.out.print("-->");
            int move = in.nextInt();

            switch (move) {
                case 1: w.agent.moveUp(); break;
                case 2: w.agent.moveDown(); break;
                case 3: w.agent.moveRight(); break;
                case 4: w.agent.moveLeft(); break;
                default: System.err.print("Unavailable move!\n"); break;
            }

            if (w.room[w.agent.x][w.agent.y].glitter) {
                System.out.println("Anda Menemukan Gold, Anda Menang!");
                break;
            } else if (w.room[w.agent.x][w.agent.y].wumpus) {
                System.out.println("Anda Bertemu Wumpus, Anda Kalah!");
                break;
            }
        }
    }

}
















