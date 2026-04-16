import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements KeyListener {
    private static final int TILE_SIZE = 50;
    Player player = new Player(0, 0, TILE_SIZE);
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;

    private Timer timer;
    TileMap map;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        map = new TileMap(10, 10, TILE_SIZE);
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        timer.start();
    }
    
    private void updateGame() {
        player.update(upPressed, downPressed, leftPressed, rightPressed, map);
        player.updateAnimation();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        map.draw(g);
        player.draw(g);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) leftPressed = true;
        if(key == KeyEvent.VK_RIGHT) rightPressed = true;
        if(key == KeyEvent.VK_UP) upPressed = true;
        if(key == KeyEvent.VK_DOWN) downPressed = true;
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) leftPressed = false;
        if(key == KeyEvent.VK_RIGHT) rightPressed = false;
        if(key == KeyEvent.VK_UP) upPressed = false;
        if(key == KeyEvent.VK_DOWN) downPressed = false;
    }
}
