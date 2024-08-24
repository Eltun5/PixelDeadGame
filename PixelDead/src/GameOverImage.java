import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameOverImage {
    FirstPanel fp;
    BufferedImage gameOver,restart1,restart2,restart;
    int check=0;
    public GameOverImage(FirstPanel fp){
        this.fp=fp;
        setImage();
    }
    public void setImage() {
        try {
            gameOver=ImageIO.read(getClass().getResourceAsStream("GameOver.png"));
            restart1=ImageIO.read(getClass().getResourceAsStream("Buttons/RestartV1.png"));
            restart2=ImageIO.read(getClass().getResourceAsStream("Buttons/RestartV2.png"));
            restart=restart1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if (fp.restart) {
            check++;
            if (check == 1) {
                restart = restart2;
            } else if (check == 20) {
                restart = restart1;
            } else if (check == 30) {
                fp.HP = 3;
                check = 0;
                fp.numberEnemy = 0;
                fp.removeAll();
                fp.restart = false;
                fp.enemies.clear();
            }
        }
    }
    public void imageDraw(Graphics2D g2){
            g2.drawImage(gameOver,32,100,700,100,null);
            g2.drawImage(restart,112,320,540,180,null);
    }
}