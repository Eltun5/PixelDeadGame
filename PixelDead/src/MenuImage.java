import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class MenuImage {
    FirstPanel fp;
    BufferedImage name,startBtn,settingBtn,quitBtn,startBtn1,settingBtn1,quitBtn1,background;
    int X=112,Y=-60,speed=2;
    public MenuImage(FirstPanel fp){
        this.fp=fp;
        getImage();
    }
    public void update(){
        if(Y<60){
            Y+=speed;
        }
    }
    public void getImage(){
     try {
         name= ImageIO.read(getClass().getResourceAsStream("GameName.png"));
         startBtn= ImageIO.read(getClass().getResourceAsStream("Buttons/StartButton1.png"));
         settingBtn= ImageIO.read(getClass().getResourceAsStream("Buttons/SettingsButton1.png"));
         quitBtn=ImageIO.read(getClass().getResourceAsStream("Buttons/QuitButton1.png"));
         startBtn1= ImageIO.read(getClass().getResourceAsStream("Buttons/StartButton2.png"));
         settingBtn1= ImageIO.read(getClass().getResourceAsStream("Buttons/SettingsButton2.png"));
         quitBtn1=ImageIO.read(getClass().getResourceAsStream("Buttons/QuitButton2.png"));
         background=ImageIO.read(getClass().getResourceAsStream("BackgroundV2.png"));
     }catch (IOException e){
         e.printStackTrace();
     }
    }
    public void imageDraw(Graphics2D g2){
        g2.drawImage(background,0,0,765,765,null);
        g2.drawImage(name,X,Y,540,180,null);
        if (fp.startAni) {
            g2.drawImage(startBtn, 247, 240, 270, 90, null);
        }else {
            g2.drawImage(startBtn1, 247, 240, 270, 90, null);
        }
        if (fp.settingAni) {
            g2.drawImage(settingBtn, 247, 335, 270, 90, null);
        }else {
            g2.drawImage(settingBtn1, 247, 335, 270, 90, null);
        }
        if (fp.quitAni){
            g2.drawImage(quitBtn,247,430,270,90,null);
        }else {
            g2.drawImage(quitBtn1,247,430,270,90,null);
        }

    }
}
