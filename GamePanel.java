import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GamePanel extends JPanel {
    private int playerX = 100;
    private int playerY = 100;
    private Timer timer;
    private int[][] grid = new int[10][10];
    private static final int TILE_SIZE = 60;

    public GamePanel() {
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(Math.random() < 0.5) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
        timer.start();
    }
    
    private void updateGame() {
        playerX += 2;
        playerY += 1;
        if (playerX > getWidth()) {
            playerX = -200;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.translate(0, 0);
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if(grid[i][j] == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
