package AgenLogika;

public class Agent {

    int point, x, y, bound;

    public Agent(int x, int y) {
        this.point = 16;
        this.x = x;
        this.y = y;
        this.bound = 3;
    }

    void moveRight() {
        if (x == bound) {
            System.out.println("Sudah Sampai Batas");
        } else {
            x++;
            point--;
        }
    }

    void moveLeft() {
        if (x == 0) {
            System.out.println("Sudah Sampai Batas");
        } else {
            x--;
            point--;
        }
    }

    void moveUp() {
        if (y == bound) {
            System.out.println("Sudah Sampai Batas");
        } else {
            y++;
            point--;
        }
    }

    void moveDown() {
        if (y == 0) {
            System.out.println("Sudah Sampai Batas");
        } else {
            y--;
            point--;
        }
    }
}










