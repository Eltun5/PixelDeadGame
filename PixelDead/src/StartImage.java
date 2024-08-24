import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartImage {
    FirstPanel fp;
    BufferedImage continue1, continue2,defContinue;
    int check=0;
    public StartImage(FirstPanel fp) {
        this.fp = fp;
        setImage();
    }
    public void setImage() {
        try {
            continue1 = ImageIO.read(getClass().getResourceAsStream("Buttons/ContinueButtonV1.png"));
            continue2 = ImageIO.read(getClass().getResourceAsStream("Buttons/ContinueButtonV2.png"));
            defContinue=continue1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(fp.btnContinue){
            check++;
            if (check==1){
                defContinue=continue2;
            } else if (check==20) {
                defContinue=continue1;
            } else if (check==30) {
                check=0;
                fp.stop=false;
                fp.btnContinue=false;
                fp.removeAll();
            }
        }
    }
    public void imageDraw(Graphics2D g2) {
        g2.drawImage(defContinue,117,292,530,180, null);
    }
}