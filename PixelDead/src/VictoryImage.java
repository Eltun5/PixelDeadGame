import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VictoryImage {
    FirstPanel fp;
    BufferedImage name,lev1,lev2,background;
    public VictoryImage(FirstPanel fp){
        this.fp=fp;
        setImage();
    }
    public void setImage(){
        try{
            background = ImageIO.read(getClass().getResourceAsStream("BackgroundV2.png"));
            name = ImageIO.read(getClass().getResourceAsStream("Victory.png"));
            lev1 = ImageIO.read(getClass().getResourceAsStream("Buttons/LevelsV1.png"));
            lev2 = ImageIO.read(getClass().getResourceAsStream("Buttons/LevelsV2.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void imageDraw(Graphics2D g2){
        g2.drawImage(background,0,0,765,765,null);
        g2.drawImage(name,182,100,400,67,null);
        if(!fp.pressedLevel){
            g2.drawImage(lev1,112,282,540,180,null);
        }else{
            g2.drawImage(lev2,112,282,540,180,null);
        }
    }
}
