import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        screen();
    }
    public static void screen(){
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("PixelDead");

        FirstPanel panel=new FirstPanel();

        frame.add(panel);

        frame.pack();

        frame.setVisible(true);
    }
}