import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Bullet3 {
    FirstPanel fp;
    BufferedImage bullet3;
    int x=372,y=392,speed=4;
    public Bullet3(FirstPanel fp){
        this.fp=fp;
        getImage();
    }
    public void getImage(){
        try {
            bullet3=ImageIO.read(getClass().getResourceAsStream("BulletV3.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if (fp.HP>=0) {
            if (y <= 785) {
                y += speed;
            }else {
                bullet3=null;
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
            g2.drawImage(bullet3, x, y, 20, 20, null);
        }
    }
}