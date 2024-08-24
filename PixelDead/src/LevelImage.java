import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelImage {
    int y1=297,y2=507;
    FirstPanel fp;
    BufferedImage background,levelsName,level1V1,level1V2,level2V1,
            level2V2,level2V3,level3V1,level3V2,level3V3,level4V1,level4V2,
            level4V3,level5V1,level5V2,level5V3,level6V1,level6V2,level6V3,level7V1,
            level7V2,level7V3,level8V1,level8V2,level8V3,level9V1,level9V2,level9V3,
            level10V1,level10V2,level10V3,back1,back2;
    public LevelImage(FirstPanel fp){
        this.fp=fp;
        getImage();
    }
    public void getImage(){
        try {
            background = ImageIO.read(getClass().getResourceAsStream("BackgroundV2.png"));
            levelsName = ImageIO.read(getClass().getResourceAsStream("LevelsName.png"));
            level1V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/1Level1.png"));
            level1V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/1Level2.png"));
            level2V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/2Level1.png"));
            level2V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/2Level2.png"));
            level2V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/2Level3.png"));
            level3V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/3Level1.png"));
            level3V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/3Level2.png"));
            level3V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/3Level3.png"));
            level4V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/4Level1.png"));
            level4V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/4Level2.png"));
            level4V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/4Level3.png"));
            level5V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/5Level1.png"));
            level5V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/5Level2.png"));
            level5V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/5Level3.png"));
            level6V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/6Level1.png"));
            level6V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/6Level2.png"));
            level6V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/6Level3.png"));
            level7V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/7Level1.png"));
            level7V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/7Level2.png"));
            level7V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/7Level3.png"));
            level8V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/8Level1.png"));
            level8V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/8Level2.png"));
            level8V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/8Level3.png"));
            level9V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/9Level1.png"));
            level9V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/9Level2.png"));
            level9V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/9Level3.png"));
            level10V1 = ImageIO.read(getClass().getResourceAsStream("Buttons/10Level1.png"));
            level10V2 = ImageIO.read(getClass().getResourceAsStream("Buttons/10Level2.png"));
            level10V3 = ImageIO.read(getClass().getResourceAsStream("Buttons/10Level3.png"));
            back1 =ImageIO.read(getClass().getResourceAsStream("Buttons/BackV1.png"));
            back2 =ImageIO.read(getClass().getResourceAsStream("Buttons/BackV2.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void imageDraw(Graphics2D g2){
        g2.drawImage(background,0,0,765,765,null);
        g2.drawImage(levelsName,0,70,765,85,null);

        if(!fp.click1){
            g2.drawImage(level1V1,122,y1,96,96,null);
        }else{
            g2.drawImage(level1V2,122,y1,96,96,null);
        }

        if(!fp.open2){
            g2.drawImage(level2V3,228,y1,96,96,null);
        } else if (!fp.click2) {
            g2.drawImage(level2V1,228,y1,96,96,null);
        } else{
            g2.drawImage(level2V2,228,y1,96,96,null);
        }

        if(!fp.open3){
            g2.drawImage(level3V3,334,y1,96,96,null);
        }else if (!fp.click3) {
            g2.drawImage(level3V1,334,y1,96,96,null);
        }else{
            g2.drawImage(level3V2,334,y1,96,96,null);
        }

        if(!fp.open4){
            g2.drawImage(level4V3,440,y1,96,96,null);
        }else if (!fp.click4) {
            g2.drawImage(level4V1,440,y1,96,96,null);
        }else{
            g2.drawImage(level4V2,440,y1,96,96,null);
        }

        if(!fp.open5){
            g2.drawImage(level5V3,546,y1,96,96,null);
        }else if (!fp.click5) {
            g2.drawImage(level5V1,546,y1,96,96,null);
        }else{
            g2.drawImage(level5V2,546,y1,96,96,null);
        }

        if(!fp.open6){
            g2.drawImage(level6V3,122,y2,96,96,null);
        }else if (!fp.click6) {
            g2.drawImage(level6V1,122,y2,96,96,null);
        }else{
            g2.drawImage(level6V2,122,y2,96,96,null);
        }

        if(!fp.open7){
            g2.drawImage(level7V3,228,y2,96,96,null);
        }else if (!fp.click7) {
            g2.drawImage(level7V1,228,y2,96,96,null);
        }else{
            g2.drawImage(level7V2,228,y2,96,96,null);
        }

        if(!fp.open8){
            g2.drawImage(level8V3,334,y2,96,96,null);
        }else if (!fp.click8) {
            g2.drawImage(level8V1,334,y2,96,96,null);
        }else{
            g2.drawImage(level8V2,334,y2,96,96,null);
        }

        if(!fp.open9){
            g2.drawImage(level9V3,440,y2,96,96,null);
        }else if (!fp.click9) {
            g2.drawImage(level9V1,440,y2,96,96,null);
        }else{
            g2.drawImage(level9V2,440,y2,96,96,null);
        }

        if(!fp.open10){
            g2.drawImage(level10V3,546,y2,96,96,null);
        }else if (!fp.click10) {
            g2.drawImage(level10V1,546,y2,96,96,null);
        }else{
            g2.drawImage(level10V2,546,y2,96,96,null);
        }

        if(!fp.clickBack){
            g2.drawImage(back1,650,701,105,54,null);
        }else{
            g2.drawImage(back2,650,701,105,54,null);
        }
    }
}