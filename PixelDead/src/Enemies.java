import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemies {
    FirstPanel fp;
    BufferedImage eUp1,eUp2,eUp3,eLeft1,eLeft2,eLeft3,eDown1,eDown2,eDown3,eRight1,eRight2,eRight3,enemy;
    int x1=340,y1=-85,x2=-85,x4=764,y2=340,y3=764,speed=4,ran,x,y,timer=0,anitime=5,size=85;
    public Enemies(FirstPanel fp,int ran){
        this.fp=fp;
        setImage();
        this.ran=ran;
    }
    public void setImage() {
        try {
            eUp1 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1Up.png"));
            eUp2 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1UpV1.png"));
            eUp3 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1UpV2.png"));
            eLeft1 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1Left.png"));
            eLeft2 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1LeftV1.png"));
            eLeft3 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1LeftV2.png"));
            eRight1 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1Right.png"));
            eRight2 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1RightV1.png"));
            eRight3 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1RightV2.png"));
            eDown1 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1Bottom.png"));
            eDown2 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1BottomV1.png"));
            eDown3 = ImageIO.read(getClass().getResourceAsStream("Enemies/Enemy1BottomV2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if (fp.HP>=0) {
            if (ran == 1 && y1 <= 260) {
                x = x1;
                timer++;
                if (timer == anitime) {
                    y1 += speed;
                    y = y1;
                    enemy = eUp1;
                } else if (timer == anitime * 2) {
                    y1 += speed;
                    y = y1;
                    enemy = eUp2;
                } else if (timer == anitime * 3) {
                    y1 += speed;
                    y = y1;
                    enemy = eUp1;
                } else if (timer == anitime * 4) {
                    y1 += speed;
                    y = y1;
                    enemy = eUp3;
                    timer = 0;
                }
                if (y1 > 260) {
                    fp.HP--;
                    enemy = null;
                }
            } else if (ran==1&&y1 > 760) {
                enemy = null;
            } else if (ran == 2 && x2 <= 260) {
                y = y2;
                timer++;
                if (timer == anitime) {
                    x2 += speed;
                    x = x2;
                    enemy = eLeft1;
                } else if (timer == anitime * 2) {
                    x2 += speed;
                    x = x2;
                    enemy = eLeft2;
                } else if (timer == anitime * 3) {
                    x2 += speed;
                    x = x2;
                    enemy = eLeft1;
                } else if (timer == anitime * 4) {
                    x2 += speed;
                    x = x2;
                    enemy = eLeft3;
                    timer = 0;
                }
                if (x2 > 260) {
                    fp.HP--;
                    enemy = null;
                }
            } else if (ran==2&&x2>760) {
                enemy = null;
            } else if (ran == 3 && y3 >= 410) {
                x = x1;
                timer++;
                if (timer == anitime) {
                    y3 -= speed;
                    y = y3;
                    enemy = eDown1;
                } else if (timer == anitime * 2) {
                    y3 -= speed;
                    y = y3;
                    enemy = eDown2;
                } else if (timer == anitime * 3) {
                    y3 -= speed;
                    y = y3;
                    enemy = eDown1;
                } else if (timer == anitime * 4) {
                    y3 -= speed;
                    y = y3;
                    enemy = eDown3;
                    timer = 0;

                }
                if (y3 < 410) {
                    fp.HP--;
                    enemy = null;
                }
            } else if (ran==3&&y3<-80) {
                enemy = null;
            } else if (ran == 4 && x4 >= 410) {
                y = y2;
                timer++;
                if (timer == anitime) {
                    x4 -= speed;
                    x = x4;
                    enemy = eRight1;
                } else if (timer == anitime * 2) {
                    x4 -= speed;
                    x = x4;
                    enemy = eRight2;
                } else if (timer == anitime * 3) {
                    x4 -= speed;
                    x = x4;
                    enemy = eRight1;
                } else if (timer == anitime * 4) {
                    x4 -= speed;
                    x = x4;
                    enemy = eRight3;
                    timer = 0;
                }
                if (x4 < 410) {
                    fp.HP--;
                    enemy = null;
                }
            } else if (ran==4&&x4<-80) {
                enemy=null;
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
        g2.drawImage(enemy,x,y,size,size,null);
    }
}
