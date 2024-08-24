import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {
    public int lastSave,lastmove,move=1;

    public boolean attackUp,attackLeft,attackDown,attackRight;

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            lastSave=lastmove;
            lastmove = move;
            move=1;
            if (lastmove==move){
                lastmove=lastSave;
            }
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            lastSave=lastmove;
            lastmove=move;
            move=2;
            if (lastmove==move){
                lastmove=lastSave;
            }
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            lastSave=lastmove;
            lastmove=move;
            move=3;
            if (lastmove==move){
                lastmove=lastSave;
            }
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            lastSave=lastmove;
            lastmove=move;
            move=4;
            if (lastmove==move){
                lastmove=lastSave;
            }
        }
        if(code == KeyEvent.VK_ENTER ) {
            if (move == 1) {
                attackUp = true;
                lastmove=4;
            } else if (move == 2) {
                attackLeft = true;
                lastmove=1;
            } else if (move == 3) {
                attackDown = true;
                lastmove=2;
            } else if (move == 4) {
                attackRight = true;
                lastmove=3;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
