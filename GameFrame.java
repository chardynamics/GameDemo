import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private static final int WIDTH = 650;
    private static final int HEIGHT = 650;

    public GameFrame() {
        setTitle("My First Swing Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        GamePanel panel = new GamePanel();
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame();
            }
        });
    }

}