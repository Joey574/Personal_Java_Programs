public class Cell {
    public int x;
    public int y;

    public boolean alive;

    Cell(){};

    Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public String cellData() {
        return "X: " + x + " Y: " + y + " State: " + alive;
    }

}
