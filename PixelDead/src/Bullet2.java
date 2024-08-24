import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Bullet2 {
    FirstPanel fp;
    BufferedImage bullet2;
    int x=352,y=372,speed=4;
    public Bullet2(FirstPanel fp){
        this.fp=fp;
        getImage();
    }
    public void getImage(){
        try {
            bullet2=ImageIO.read(getClass().getResourceAsStream("BulletV2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if (fp.HP>=0) {
            if (x >= -20) {
                x -= speed;
            }else {
                bullet2=null;
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
            g2.drawImage(bullet2, x, y, 20, 20, null);
        }
    }
}