import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class FirstPanel extends JPanel implements Runnable {
        boolean startAni = true, settingAni = true, quitAni = true,
                one=true;
        boolean clickStart = false,waitStart=false,clickSetting=false,waitSetting=false,clickLevels=false,
                pressedLevel=false;
        boolean click1=false,click2=false,click3=false,click4=false,click5=false,
                click6=false,click7=false,click8=false,click9=false,click10=false,
                clickBack=false;
        boolean open2=false,open3=false,open4=false,open5=false,open6=false,open7=false,open8=false, open9=false,open10=false,
                bck=false,
                start1=false,start2=false,start3=false,start4=false,start5=false,start6=false,start7=false,start8=false,start9=false,start10=false,
                cl1=false,cl2=false,cl3=false,cl4=false,cl5=false,cl6=false,cl7=false,cl8=false,cl9=false,cl10=false;
        boolean pause=false,btnX=false,btnContinue=false,stop=false,restart=false;
        int FPS = 60, check = 0,check1=0,numberEnemy=0,HP=3, lvScore =30;
        public List<Enemies> enemies;
        public List<Bullet1> bullet1;
        public List<Bullet2> bullet2;
        public List<Bullet3> bullet3;
        public List<Bullet4> bullet4;
        private double enemySpawn = 90;
        private double enemySpawnTimer = 0;
        Thread thread;
        Move m=new Move();
        MenuImage mi = new MenuImage(this);
        LevelImage li = new LevelImage(this);
        GameImage gi=new GameImage(this,m);
        StartImage si =new StartImage(this);
        GameOverImage goi=new GameOverImage(this);
        SettingImage seti=new SettingImage(this);
        VictoryImage vi=new VictoryImage(this);
        public FirstPanel() {
                this.setPreferredSize(new Dimension(765, 765));
                this.setBackground(Color.black);
                this.addKeyListener(m);
                this.setFocusable(true);
                thread = new Thread(this);
                thread.start();

                enemies=new ArrayList<>();
                bullet1=new ArrayList<>();
                bullet2=new ArrayList<>();
                bullet3=new ArrayList<>();
                bullet4=new ArrayList<>();
        }
        @Override
        public void run() {
                double drawInterval = 1000000000 / FPS;
                double nextDrawTime = System.nanoTime() + drawInterval;
                while (thread != null) {
                        update();
                        repaint();
                        try {
                                double rTime = nextDrawTime - System.nanoTime();
                                rTime = rTime / 1000000;
                                if (rTime < 0) {
                                        rTime = 0;
                                }
                                Thread.sleep((long) rTime);

                                nextDrawTime += drawInterval;

                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
        public void update(){
                if (!clickStart&&!clickSetting) {
                        mi.update();
                        menuButton();
                        if (!startAni || !settingAni || !quitAni) {
                                check++;
                                if (!quitAni && check == 30) {
                                        System.exit(0);
                                }
                                if (check == 30) {
                                        startAni = true;
                                        settingAni = true;
                                        check = 0;
                                }
                        }
                }
                if(waitStart){
                        check1++;
                        if(check1==50){
                                clickStart=true;
                                check1=0;
                                removeAll();
                                waitStart=false;
                        }
                }
                if(waitSetting){
                        check1++;
                        if(check1==50){
                                check1=0;
                                removeAll();
                                clickSetting=true;
                                waitSetting=false;
                        }
                }
                if(clickSetting){
                        settingButtons();
                        if(bck){
                                check1++;
                                if(check1==30){
                                        clickBack=false;
                                }
                                if(check1==60){
                                        clickSetting=false;
                                        clickStart=false;
                                        removeAll();
                                        check1=0;
                                        bck=false;
                                }
                        }
                }
                if(clickStart&&!(start1||start2||start3||start4||start5||start6||start7||start8||start9||start10)&&!clickSetting){
                        levelButtons();
                        if(click2||click3||click4||click5||click6||click7||click8||click9||click10){
                                check++;
                                if (check==30){
                                        click2=false;
                                        click3=false;
                                        click4=false;
                                        click5=false;
                                        click6=false;
                                        click7=false;
                                        click8=false;
                                        click9=false;
                                        click10=false;
                                        check=0;
                                }
                        }
                        if(cl1||cl2||cl3||cl4||cl5||cl6||cl7||cl8||cl9||cl10){
                                check1++;
                                if(check1==30){
                                        click1=false;
                                        click2=false;
                                        click3=false;
                                        click4=false;
                                        click5=false;
                                        click6=false;
                                        click7=false;
                                        click8=false;
                                        click9=false;
                                        click10=false;
                                }
                                if(check1==60){
                                        removeAll();
                                        check1=0;
                                        if(cl1) {
                                                start1 = true;
                                                cl1 = false;
                                        }
                                        if(cl2) {
                                                start2 = true;
                                                cl2 = false;
                                        }
                                        if(cl3) {
                                                start3 = true;
                                                cl3 = false;
                                        }
                                        if(cl4) {
                                                start4 = true;
                                                cl4 = false;
                                        }
                                        if(cl5) {
                                                start5 = true;
                                                cl5 = false;
                                        }
                                        if(cl6) {
                                                start6 = true;
                                                cl6 = false;
                                        }
                                        if(cl7) {
                                                start7 = true;
                                                cl7 = false;
                                        }
                                        if(cl8) {
                                                start8 = true;
                                                cl8 = false;
                                        }
                                        if(cl9) {
                                                start9 = true;
                                                cl9 = false;
                                        }
                                        if(cl10) {
                                                start10 = true;
                                                cl10 = false;
                                        }
                                }
                        }
                        if(bck){
                                check1++;
                                if(check1==30){
                                        clickBack=false;
                                }
                                if(check1==60){
                                        clickStart=false;
                                        removeAll();
                                        check1=0;
                                        bck=false;
                                }
                        }
                }
                if(numberEnemy== lvScore){
                        victoryBtn();
                        if (one){
                                removeAll();
                                enemies.clear();
                                bullet1.clear();
                                bullet2.clear();
                                bullet3.clear();
                                bullet4.clear();
                                one=false;
                                if (start1) {
                                        open2 = true;
                                }
                                if (start2) {
                                        open3 = true;
                                }
                                if (start3) {
                                        open4 = true;
                                }
                                if (start4) {
                                        open5 = true;
                                }
                                if (start5) {
                                        open6 = true;
                                }
                                if (start6) {
                                        open7 = true;
                                }
                                if (start7) {
                                        open8 = true;
                                }
                                if (start8) {
                                        open9 = true;
                                }
                                if (start9) {
                                        open10 = true;
                                }
                                if (start10) {
                                        System.out.println("You Vin.");
                                }
                                start1 = false;
                                start2 = false;
                                start3 = false;
                                start4 = false;
                                start5 = false;
                                start6 = false;
                                start7 = false;
                                start8 = false;
                                start9 = false;
                                start10 = false;
                        }
                        if(clickLevels) {
                                check1++;
                                if (check1 == 1) {
                                        pressedLevel = true;
                                } else if (check1 == 20) {
                                        pressedLevel = false;
                                } else if (check1 == 30) {
                                        clickLevels = false;
                                        clickStart=true;
                                        numberEnemy=0;
                                        removeAll();
                                        check1 = 0;
                                        one=true;
                                }
                        }
                }
                if(!stop&&clickStart&&numberEnemy< lvScore &&(start1||start2||start3||start4||start5||start6||start7||start8||start9||start10)){
                        gi.update();
                        gameButtons();
                        enemySpawnTimer++;
                        if(enemySpawnTimer>=enemySpawn){
                                Random rand = new Random();
                                int upperbound = 5;
                                int a = rand.nextInt(upperbound);
                                Enemies newEnemy = new Enemies(this,a);
                                enemies.add(newEnemy);
                                enemySpawnTimer=0;
                        }
                        for (Enemies enemy : enemies){
                                enemy.update();
                                for(Bullet1 bullet:bullet1){
                                        if(enemy.y1+85<=bullet.y&&enemy.y1+95>=bullet.y){
                                                numberEnemy++;
                                                enemy.y1=765;
                                                bullet.y=-21;
                                        }
                                }
                                for(Bullet2 bullet:bullet2){
                                        if(enemy.x2+85<=bullet.x&&enemy.x2+95>=bullet.x){
                                                numberEnemy++;
                                                enemy.x2=765;
                                                bullet.x=-21;
                                        }
                                }
                                for(Bullet3 bullet:bullet3){
                                        if(enemy.y3>=bullet.y+20&&enemy.y3-10<=bullet.y+20){
                                                numberEnemy++;
                                                enemy.y3=-85;
                                                bullet.y=786;
                                        }
                                }
                                for(Bullet4 bullet:bullet4){
                                        if(enemy.x4>=bullet.x+20&&enemy.x4-10<=bullet.x+20){
                                                numberEnemy++;
                                                enemy.x4=-85;
                                                bullet.x=786;
                                        }
                                }
                        }
                                if (m.attackUp&&gi.finish) {
                                        check++;
                                        if (check == 1) {
                                                Bullet1 newB1 = new Bullet1(this);
                                                bullet1.add(newB1);
                                        } else if (check == 3) {
                                                check = 0;
                                        }
                                }
                                for (Bullet1 bullet : bullet1) {
                                        bullet.update();
                                }
                                if (m.attackLeft&&gi.finish) {
                                        check++;
                                        if (check == 1) {
                                                Bullet2 newB2 = new Bullet2(this);
                                                bullet2.add(newB2);
                                        } else if (check == 3) {
                                                check = 0;
                                        }
                                }
                                for (Bullet2 bullet : bullet2) {
                                        bullet.update();
                                }
                                if (m.attackDown&&gi.finish) {
                                        check++;
                                        if (check == 1) {
                                                Bullet3 newB3 = new Bullet3(this);
                                                bullet3.add(newB3);
                                        } else if (check == 3) {
                                                check = 0;
                                        }
                                }
                                for (Bullet3 bullet : bullet3) {
                                        bullet.update();
                                }
                                if (m.attackRight&&gi.finish) {
                                        check++;
                                        if (check == 1) {
                                                Bullet4 newB4 = new Bullet4(this);
                                                bullet4.add(newB4);
                                        } else if (check == 3) {
                                                check = 0;
                                        }
                                }
                                for (Bullet4 bullet : bullet4) {
                                        bullet.update();
                                }
                }
                if (stop){
                        si.update();
                        continueButton();
                }
                if (HP<0){
                        gameOverButtons();
                        goi.update();
                }
        }
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                if (!clickStart&&!clickSetting) {
                        mi.imageDraw(g2);
                }
                if(clickStart&&!(start1||start2||start3||start4||start5||start6||start7||start8||start9||start10)&&
                        !clickSetting&&numberEnemy<lvScore){
                        li.imageDraw(g2);
                }
                if(numberEnemy>= lvScore){
                        vi.imageDraw(g2);
                }
                if (clickSetting){
                        seti.imageDraw(g2);
                }
                if((start1||start2||start3||start4||start5||start6||start7||start8||start9||start10)&&!stop){
                        gi.imageDraw(g2);
                        for (Enemies enemy :enemies) {
                                enemy.imageDraw(g2);
                        }
                        for (Bullet1 bullet:bullet1){
                                bullet.imageDraw(g2);
                        }
                        for (Bullet2 bullet:bullet2){
                                bullet.imageDraw(g2);
                        }
                        for (Bullet3 bullet:bullet3){
                                bullet.imageDraw(g2);
                        }
                        for (Bullet4 bullet:bullet4){
                                bullet.imageDraw(g2);
                        }
                }
                if (stop){
                        si.imageDraw(g2);
                }
                if (HP<0){
                        goi.imageDraw(g2);
                }
                g2.dispose();
        }
        public void menuButton() {
                JButton startBtn = new JButton();
                startBtn.setOpaque(false);
                startBtn.setContentAreaFilled(false);
                startBtn.setBorderPainted(false);
                startBtn.setBounds(247, 240, 270, 90);
                add(startBtn);
                startBtn.addActionListener((ActionEvent e) -> {
                        waitStart = true;
                        startAni = false;
                });
                JButton settingBtn = new JButton();
                settingBtn.setOpaque(false);
                settingBtn.setContentAreaFilled(false);
                settingBtn.setBorderPainted(false);
                settingBtn.setBounds(247, 335, 270, 90);
                add(settingBtn);
                settingBtn.addActionListener((ActionEvent e) -> {
                        waitSetting=true;
                        settingAni = false;
                });
                JButton quitBtn = new JButton();
                quitBtn.setOpaque(false);
                quitBtn.setContentAreaFilled(false);
                quitBtn.setBorderPainted(false);
                quitBtn.setBounds(247, 430, 270, 90);
                add(quitBtn);
                quitBtn.addActionListener((ActionEvent e) -> {
                        quitAni = false;
                });
        }
        public void levelButtons(){
                int y1=297,y2=507,size=96;
                JButton level1 = new JButton();
                level1.setOpaque(false);
                level1.setContentAreaFilled(false);
                level1.setBorderPainted(false);
                level1.setBounds(122, y1, size, size);
                add(level1);
                level1.addActionListener((ActionEvent e) -> {
                        click1=true;
                        cl1=true;
                        enemySpawn=90;
                        lvScore=20;
                        HP=3;
                });
                if (open2) {
                        JButton level2 = new JButton();
                        level2.setOpaque(false);
                        level2.setContentAreaFilled(false);
                        level2.setBorderPainted(false);
                        level2.setBounds(228, y1, size, size);
                        add(level2);
                        level2.addActionListener((ActionEvent e) -> {
                                click2 = true;
                                cl2=true;
                                enemySpawn=85;
                                lvScore=22;
                                HP=3;
                        });
                }
                if(open3) {
                        JButton level3 = new JButton();
                        level3.setOpaque(false);
                        level3.setContentAreaFilled(false);
                        level3.setBorderPainted(false);
                        level3.setBounds(334, y1, size, size);
                        add(level3);
                        level3.addActionListener((ActionEvent e) -> {
                                click3 = true;
                                cl3=true;
                                enemySpawn=80;
                                lvScore=24;
                                HP=3;
                        });
                }
                if(open4) {
                        JButton level4 = new JButton();
                        level4.setOpaque(false);
                        level4.setContentAreaFilled(false);
                        level4.setBorderPainted(false);
                        level4.setBounds(440, y1, size, size);
                        add(level4);
                        level4.addActionListener((ActionEvent e) -> {
                                click4 = true;
                                cl4=true;
                                enemySpawn=80;
                                lvScore=28;
                                HP=3;
                        });
                }
                if (open5) {
                        JButton level5 = new JButton();
                        level5.setOpaque(false);
                        level5.setContentAreaFilled(false);
                        level5.setBorderPainted(false);
                        level5.setBounds(546, y1, size, size);
                        add(level5);
                        level5.addActionListener((ActionEvent e) -> {
                                click5 = true;
                                cl5=true;
                                enemySpawn=70;
                                lvScore=40;
                                HP=3;
                        });
                }
                if(open6) {
                        JButton level6 = new JButton();
                        level6.setOpaque(false);
                        level6.setContentAreaFilled(false);
                        level6.setBorderPainted(false);
                        level6.setBounds(122, y2, size, size);
                        add(level6);
                        level6.addActionListener((ActionEvent e) -> {
                                click6 = true;
                                cl6=true;
                                enemySpawn=70;
                                lvScore=42;
                                HP=3;
                        });
                }
                if(open7) {
                        JButton level7 = new JButton();
                        level7.setOpaque(false);
                        level7.setContentAreaFilled(false);
                        level7.setBorderPainted(false);
                        level7.setBounds(228, y2, size, size);
                        add(level7);
                        level7.addActionListener((ActionEvent e) -> {
                                click7 = true;
                                cl7=true;
                                enemySpawn=65;
                                lvScore=44;
                                HP=3;
                        });
                }
                if(open8) {
                        JButton level8 = new JButton();
                        level8.setOpaque(false);
                        level8.setContentAreaFilled(false);
                        level8.setBorderPainted(false);
                        level8.setBounds(334, y2, size, size);
                        add(level8);
                        level8.addActionListener((ActionEvent e) -> {
                                click8 = true;
                                cl8=true;
                                enemySpawn=60;
                                lvScore=46;
                                HP=3;
                        });
                }
                if(open9) {
                        JButton level9 = new JButton();
                        level9.setOpaque(false);
                        level9.setContentAreaFilled(false);
                        level9.setBorderPainted(false);
                        level9.setBounds(440, y2, size, size);
                        add(level9);
                        level9.addActionListener((ActionEvent e) -> {
                                click9 = true;
                                cl9=true;
                                enemySpawn=60;
                                lvScore=48;
                                HP=3;
                        });
                }
                if(open10) {
                        JButton level10 = new JButton();
                        level10.setOpaque(false);
                        level10.setContentAreaFilled(false);
                        level10.setBorderPainted(false);
                        level10.setBounds(546, y2, size, size);
                        add(level10);
                        level10.addActionListener((ActionEvent e) -> {
                                click10 = true;
                                cl10=true;
                                enemySpawn=50;
                                lvScore=60;
                                HP=3;
                        });
                }
                JButton backBtn = new JButton();
                backBtn.setOpaque(false);
                backBtn.setContentAreaFilled(false);
                backBtn.setBorderPainted(false);
                backBtn.setBounds(650,701, 105, 54);
                add(backBtn);
                backBtn.addActionListener((ActionEvent e) -> {
                        clickBack=true;
                        bck=true;
                });
        }
        public void gameButtons(){
                JButton buttonX = new JButton();
                buttonX.setOpaque(false);
                buttonX.setContentAreaFilled(false);
                buttonX.setBorderPainted(false);
                buttonX.setBounds(707, 10 , 48, 48);
                add(buttonX);
                buttonX.addActionListener((ActionEvent e) -> {
                        btnX=true;
                });
                JButton btnPause = new JButton();
                btnPause.setOpaque(false);
                btnPause.setContentAreaFilled(false);
                btnPause.setBorderPainted(false);
                btnPause.setBounds(654, 10 , 48, 48);
                add(btnPause);
                btnPause.addActionListener((ActionEvent e) -> {
                        pause=true;
                });
        }
        public void continueButton(){
                JButton continueBtn = new JButton();
                continueBtn.setOpaque(false);
                continueBtn.setContentAreaFilled(false);
                continueBtn.setBorderPainted(false);
                continueBtn.setBounds(117, 292 , 530, 180);
                add(continueBtn);
                continueBtn.addActionListener((ActionEvent e) -> {
                        btnContinue=true;
                });
        }
        public void gameOverButtons(){
                JButton restartBtn = new JButton();
                restartBtn.setOpaque(false);
                restartBtn.setContentAreaFilled(false);
                restartBtn.setBorderPainted(false);
                restartBtn.setBounds(112,320,540,180);
                add(restartBtn);
                restartBtn.addActionListener((ActionEvent e) -> {
                        restart=true;
                });
        }
        public void settingButtons(){
                JButton backBtn = new JButton();
                backBtn.setOpaque(false);
                backBtn.setContentAreaFilled(false);
                backBtn.setBorderPainted(false);
                backBtn.setBounds(650,701, 105, 54);
                add(backBtn);
                backBtn.addActionListener((ActionEvent e) -> {
                        clickBack=true;
                        bck=true;
                });
        }
        public void victoryBtn(){
                JButton Levels = new JButton();
                Levels.setOpaque(false);
                Levels.setContentAreaFilled(false);
                Levels.setBorderPainted(false);
                Levels.setBounds(112,282,540,180);
                add(Levels);
                Levels.addActionListener((ActionEvent e) -> {
                        clickLevels=true;
                });
        }
}