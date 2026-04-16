import java.awt.*;

public class TileMap {
    
    private int[][] grid;
    private int TILE_SIZE;
    private int cols, rows;

    public TileMap(int COLUMNS, int ROWS, int SIZE) {
        this.cols = COLUMNS;
        this.rows = ROWS;
        this.TILE_SIZE = SIZE;
        grid = new int[ROWS][COLUMNS];

        generateMap();
    }

    private void generateMap() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(Math.random() < 0.5) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
    }

    private boolean isWall(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return true;
        }
        
        return grid[row][col] == 1;
    }

    public boolean isColliding(int x, int y, int size) {
        int left = x / TILE_SIZE;
        int right = (x + size - 1) / TILE_SIZE;
        int top = y / TILE_SIZE;
        int bottom = (y + size - 1) / TILE_SIZE;

        return isWall(top, left) ||
            isWall(top, right) ||
            isWall(bottom, left) ||
            isWall(bottom, right);
    }

    public void draw(Graphics g) {
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if(grid[i][j] == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
