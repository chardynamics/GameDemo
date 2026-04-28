import java.awt.*;

public class TileMap {
    
    private double[][] grid;
    private int TILE_SIZE;
    private int cols, rows;

    public TileMap(int COLUMNS, int ROWS, int SIZE) {
        this.cols = COLUMNS;
        this.rows = ROWS;
        this.TILE_SIZE = SIZE;
        grid = new double[ROWS][COLUMNS];

        generateMap();
    }

    private void generateMap() {
        for(int i=0; i<cols; i++) {
            for(int j=0; j<rows; j++) {
                if(i == 0 || i == cols-1 || j == 0 || j == rows-1) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        grid[4][11] = 1;
        grid[8][9] = 1;

        grid[8][10] = 1;
        grid[8][11] = 1;
        grid[11][8] = 1;
        grid[9][4] = 1;
        grid[3][6] = 1;
        grid[1][5] = 1;
        grid[1][4] = 0.5;
    }

    private boolean isWall(double row, double col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return true;
        }
        
        return grid[(int) row][(int) col] == 1;
    }


    public boolean isColliding(double x, double y, int size) {
        double left = x / TILE_SIZE;
        double right = (x + size - 1) / TILE_SIZE;
        double top = y / TILE_SIZE;
        double bottom = (y + size - 1) / TILE_SIZE;

        return isWall(top, left) ||
                isWall(top, right) ||
                isWall(bottom, left) ||
                isWall(bottom, right);

    }

    public void draw(Graphics g) {
        for(int i=0; i<cols; i++) {
            for (int j=0; j<rows; j++) {
                if(grid[i][j] == 0) {
                    g.setColor(Color.BLUE);
                } else if (grid[i][j] == 1) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.GREEN);
                }
                g.fillRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
