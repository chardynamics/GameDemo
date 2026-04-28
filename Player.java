import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player {
    int x;
    int y;
    int speed = 5;
    int size;
    int velocityY = 0;
    int gravity = 1;
    boolean onGround = false;

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

        if (up && onGround) {
            velocityY = -15;
            nextY += velocityY;
        } else {
            nextY += velocityY;
        }
        if (left) {
            nextX -= 7;
        }
        if (right) {
            nextX += 7;
        }

        if (!map.isColliding(nextX, y, size)) {
            x = nextX;
        } 

        if (!map.isColliding(nextY, x, size)) {
            y = nextY;
            velocityY += gravity;
            onGround = false;
        } else {
            velocityY = 0;
            onGround = true;
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
