import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Bullet1 {
    FirstPanel fp;
    BufferedImage bullet1;
    int x=372,y=352,speed=4;
    public Bullet1(FirstPanel fp){
        this.fp=fp;
        getImage();
    }
    public void getImage(){
        try {
            bullet1=ImageIO.read(getClass().getResourceAsStream("BulletV1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if (fp.HP>=0) {
            if (y >= -20) {
                y -= speed;
            }else {
                bullet1=null;
            }
            if(fp.start1){
                speed=4;
            }else if(fp.start2){
                speed=4;
            }else if(fp.start3){
                speed=5;
            }else if(fp.start4){
                speed=5;
            }else if(fp.start5){
                speed=7;
            }else if(fp.start6){
                speed=8;
            }else if(fp.start7){
                speed=8;
            }else if(fp.start8){
                speed=9;
            }else if(fp.start9){
                speed=10;
            }else if(fp.start10){
                speed=15;
            }
        }
    }
    public void imageDraw(Graphics2D g2){
        if (fp.HP>=0) {
            g2.drawImage(bullet1, x, y, 20, 20, null);
        }
    }
}