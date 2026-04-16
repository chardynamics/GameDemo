import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player {
    int x;
    int y;
    int speed = 5;
    int size;

    BufferedImage sprite1;
    BufferedImage sprite2;

    int spriteIndex = 0;
    int spriteCounter = 0;

    public Player(int playerX, int playerY, int playerSize) {
        x = playerX;
        y = playerY;
        size = playerSize;

        try {
            sprite1 = ImageIO.read(getClass().getResource("/left.png"));
            sprite2 = ImageIO.read(getClass().getResource("/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateAnimation() {
        spriteCounter++;
        if(spriteCounter > 10) {
            spriteIndex = (spriteIndex+1) % 2;
            spriteCounter = 0;
        }
    }
    public void update(boolean up, boolean down, boolean left, boolean right, TileMap map) {
        int nextX = x;
        int nextY = y;

        if (up) nextY -= speed;
        if (down) nextY += speed;
        if (left) {
            nextX -= speed;
        }
        if (right) {
            nextX += speed;
        }

        if (!map.isColliding(nextX, y, size)) {
            x = nextX;
        }

        if (!map.isColliding(nextY, x, size)) {
            y = nextY;
        }
    }

    public void draw(Graphics g) {
        BufferedImage sprite;

        if(spriteIndex == 0) {
            sprite = sprite1;
        } else {
            sprite = sprite2;
        }

        g.drawImage(sprite, x, y, size, size, null);
    }
}
