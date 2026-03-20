import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements KeyListener {
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 5;
    private Timer timer;
    private int[][] grid = new int[10][10];
    private static final int TILE_SIZE = 60;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
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
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
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
        
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT:
                playerX -= playerSpeed;
            case KeyEvent.VK_RIGHT:
                playerX += playerSpeed;
            case KeyEvent.VK_UP:
                playerY -= playerSpeed;
            case KeyEvent.VK_DOWN:
                playerY += playerSpeed;
        }
    }
    public void keyReleased(KeyEvent e) {}
}
