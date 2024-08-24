import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class GameImage {
    FirstPanel fp;
    Move m;
    BufferedImage background,p1Up,p1Bottom,p1Left,p1Right,p1UpToLeft,p1LeftToBottom,p1BottomToRight,p1RightToUp,
    p1Up1,p1Bottom1,p1Right1,p1Left1,img,pause1,pause2,pause,x1,x2,x,heart;
    int check=0, check1 =0;
    int aniTime=2;
    boolean finish=true;
    public GameImage(FirstPanel fp,Move m){
        this.fp=fp;
        getImage();
        this.m=m;
        setDefCar();
    }
    public void getImage(){
        try {
            background=ImageIO.read(getClass().getResourceAsStream("BackgroundV4.png"));
            p1Up=ImageIO.read(getClass().getResourceAsStream("Players/Player1Up.png"));
            p1UpToLeft=ImageIO.read(getClass().getResourceAsStream("Players/Player1Up-Left.png"));
            p1Left=ImageIO.read(getClass().getResourceAsStream("Players/Player1Left.png"));
            p1LeftToBottom=ImageIO.read(getClass().getResourceAsStream("Players/Player1Left-Bottom.png"));
            p1Bottom=ImageIO.read(getClass().getResourceAsStream("Players/Player1Bottom.png"));
            p1BottomToRight=ImageIO.read(getClass().getResourceAsStream("Players/Player1Bottom-Right.png"));
            p1Right=ImageIO.read(getClass().getResourceAsStream("Players/Player1Right.png"));
            p1RightToUp=ImageIO.read(getClass().getResourceAsStream("Players/Player1Right-Up.png"));
            p1Up1=ImageIO.read(getClass().getResourceAsStream("Players/Player1PistolUP.png"));
            p1Left1=ImageIO.read(getClass().getResourceAsStream("Players/Player1PistolLeft.png"));
            p1Bottom1=ImageIO.read(getClass().getResourceAsStream("Players/Player1PistolBottom.png"));
            p1Right1=ImageIO.read(getClass().getResourceAsStream("Players/Player1PistolRight.png"));
            heart=ImageIO.read(getClass().getResourceAsStream("Heart.png"));
            x1=ImageIO.read(getClass().getResourceAsStream("Buttons/ButtonXV1.png"));
            x2=ImageIO.read(getClass().getResourceAsStream("Buttons/ButtonXV2.png"));
            pause1=ImageIO.read(getClass().getResourceAsStream("Buttons/PauseButtonV1.png"));
            pause2=ImageIO.read(getClass().getResourceAsStream("Buttons/PauseButtonV2.png"));
            x=x1;
            pause=pause1;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setDefCar(){
        img=p1Up;
    }
    public void setDefAttack(){
        m.attackUp=false;
        m.attackRight=false;
        m.attackDown=false;
        m.attackLeft=false;
    }
    public void update(){
        if (fp.HP>=0) {
            if (m.move == 2 && m.lastmove == 1 && img != p1Left) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1UpToLeft;
                } else if (check == aniTime * 2) {
                    img = p1Left;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 3 && m.lastmove == 2 && img != p1Bottom) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1LeftToBottom;
                } else if (check == aniTime * 2) {
                    img = p1Bottom;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 4 && m.lastmove == 3 && img != p1Right) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1BottomToRight;
                } else if (check == aniTime * 2) {
                    img = p1Right;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 1 && m.lastmove == 4 && img != p1Up && img != p1Up1) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1RightToUp;
                } else if (check == aniTime * 2) {
                    img = p1Up;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 4 && m.lastmove == 1 && img != p1Right) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1RightToUp;
                } else if (check == aniTime * 2) {
                    img = p1Right;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 1 && m.lastmove == 2 && img != p1Up) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1UpToLeft;
                } else if (check == aniTime * 2) {
                    img = p1Up;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 2 && m.lastmove == 3 && img != p1Left) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1LeftToBottom;
                } else if (check == aniTime * 2) {
                    img = p1Left;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 3 && m.lastmove == 4 && img != p1Bottom) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1BottomToRight;
                } else if (check == aniTime * 2) {
                    img = p1Bottom;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 3 && m.lastmove == 1 && img != p1Bottom) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1UpToLeft;
                } else if (check == aniTime * 2) {
                    img = p1Left;
                } else if (check == aniTime * 3) {
                    img = p1LeftToBottom;
                } else if (check == aniTime * 4) {
                    img = p1Bottom;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 1 && m.lastmove == 3 && img != p1Up) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1BottomToRight;
                } else if (check == aniTime * 2) {
                    img = p1Right;
                } else if (check == aniTime * 3) {
                    img = p1RightToUp;
                } else if (check == aniTime * 4) {
                    img = p1Up;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 2 && m.lastmove == 4 && img != p1Left) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1RightToUp;
                } else if (check == aniTime * 2) {
                    img = p1Up;
                } else if (check == aniTime * 3) {
                    img = p1UpToLeft;
                } else if (check == aniTime * 4) {
                    img = p1Left;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.move == 4 && m.lastmove == 2 && img != p1Right) {
                check++;
                if (check==1){
                    finish=false;
                }
                if (check == aniTime) {
                    img = p1LeftToBottom;
                } else if (check == aniTime * 2) {
                    img = p1Bottom;
                } else if (check == aniTime * 3) {
                    img = p1BottomToRight;
                } else if (check == aniTime * 4) {
                    img = p1Right;
                    check = 0;
                    setDefAttack();
                    finish=true;
                }
            } else if (m.attackUp&&finish) {
                check++;
                if (check == aniTime) {
                    img = p1Up1;
                } else if (check == aniTime * 2) {
                    img = p1Up;
                    check = 0;
                    setDefAttack();
                }
            } else if (m.attackLeft&&finish) {
                check++;
                if (check == aniTime) {
                    img = p1Left1;
                } else if (check == aniTime * 2) {
                    img = p1Left;
                    check = 0;
                    setDefAttack();
                }
            } else if (m.attackDown&&finish) {
                check++;
                if (check == aniTime) {
                    img = p1Bottom1;
                } else if (check == aniTime * 2) {
                    img = p1Bottom;
                    check = 0;
                    setDefAttack();
                }
            } else if (m.attackRight&&finish) {
                check++;
                if (check == aniTime) {
                    img = p1Right1;
                } else if (check == aniTime * 2) {
                    img = p1Right;
                    check = 0;
                    setDefAttack();
                }
            }
            if (fp.btnX) {
                check1++;
                if (check1 == 1) {
                    x = x2;
                } else if (check1 == 20) {
                    x = x1;
                } else if (check1 == 30) {
                    fp.btnX = false;
                    fp.start1 = false;
                    fp.start2 = false;
                    fp.start3 = false;
                    fp.start4 = false;
                    fp.start5 = false;
                    fp.start6 = false;
                    fp.start7 = false;
                    fp.start8 = false;
                    fp.start9 = false;
                    fp.start10 = false;
                    fp.enemies.clear();
                    fp.bullet1.clear();
                    fp.bullet2.clear();
                    fp.bullet3.clear();
                    fp.bullet4.clear();
                    fp.removeAll();
                    fp.numberEnemy = 0;
                    check1 = 0;
                }
            }
            if (fp.pause) {
                check1++;
                if (check1 == 1) {
                    pause = pause2;
                } else if (check1 == 20) {
                    pause = pause1;
                } else if (check1 == 30) {
                    fp.stop = true;
                    check1 = 0;
                    fp.pause = false;
                }
            }
        }
    }
    public void imageDraw(Graphics2D g2){
            g2.drawImage(background, 0, 0, 765, 765, null);
            g2.drawImage(img, 284, 284, 192, 192, null);
            g2.drawImage(x, 707, 10, 48, 48, null);
            g2.drawImage(pause, 654, 10, 48, 48, null);
            if (fp.HP == 3) {
                g2.drawImage(heart, 10, 10, 48, 48, null);
                g2.drawImage(heart, 63, 10, 48, 48, null);
                g2.drawImage(heart, 116, 10, 48, 48, null);
            } else if (fp.HP == 2) {
                g2.drawImage(heart, 10, 10, 48, 48, null);
                g2.drawImage(heart, 63, 10, 48, 48, null);
            } else if (fp.HP == 1) {
                g2.drawImage(heart, 10, 10, 48, 48, null);
            }
    }
}