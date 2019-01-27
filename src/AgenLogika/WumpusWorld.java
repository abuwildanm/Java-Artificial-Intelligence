package AgenLogika;

public class WumpusWorld {

    Room[][] room = new Room[4][4];
    Agent agent;

    public WumpusWorld() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                room[i][j] = new Room();
            }
        }

        addGlitter(1, 1);
        addWumpus(1, 0);

        addPit(0, 3);
        addPit(1, 2);
        addPit(3, 2);

        agent = new Agent(3, 0);
    }

    void addGlitter(int x, int y) {
        room[x][y].glitter = true;
    }

    void addWumpus(int x, int y) {
        room[x][y].wumpus = true;
        try { room[x + 1][y].stench = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x - 1][y].stench = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x][y + 1].stench = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x][y - 1].stench = true; } catch (IndexOutOfBoundsException E) {}
    }

    void addPit(int x, int y) {
        room[x][y].pit = true;
        try { room[x + 1][y].breeze = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x - 1][y].breeze = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x][y + 1].breeze = true; } catch (IndexOutOfBoundsException E) {}
        try { room[x][y - 1].breeze = true; } catch (IndexOutOfBoundsException E) {}
    }
}





