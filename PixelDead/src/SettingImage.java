import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SettingImage {
    FirstPanel fp;
    BufferedImage background,name,back1,back2;
    public SettingImage(FirstPanel fp){
        this.fp=fp;
        setImage();
    }
    public void setImage(){
        try{
            name=ImageIO.read(getClass().getResourceAsStream("SettingName.png"));
            background = ImageIO.read(getClass().getResourceAsStream("BackgroundV2.png"));
            back1 = ImageIO.read(getClass().getResourceAsStream("Buttons/BackV1.png"));
            back2 =ImageIO.read(getClass().getResourceAsStream("Buttons/BackV2.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void imageDraw(Graphics2D g2){
        g2.drawImage(background,0,0,765,765,null);
        g2.drawImage(name,182,100,400,58,null);
        if(!fp.clickBack){
            g2.drawImage(back1,650,701,105,54,null);
        }else{
            g2.drawImage(back2,650,701,105,54,null);
        }
    }
}
