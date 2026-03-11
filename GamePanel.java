import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {
    private static final int RECT_X = 100;
    private static final int RECT_Y = 100;
    
    public GamePanel() {
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.RED);
        g.fillOval(RECT_X, RECT_Y, 150, 150);
        
        g.setColor(Color.BLACK);
        g.drawString("Hello Swing", 350, 50);
        
        g.setColor(Color.BLUE);
        g.fillRect(100, 100, 200, 150);
    }
}
