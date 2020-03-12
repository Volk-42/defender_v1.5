
package Defender20XX;

import java.awt.event.KeyEvent;
import java.util.Iterator;

public class TitleScene extends Scene {
    final private Cursor cursor;
    final private TextAnimator title;
    final private TextAnimator newGame;
    final private TextAnimator highScore;
    private boolean startGame;
    private boolean highScores;
    private int fireballCooldown;
    final private int text_x;
    final private int text_y;
    TitleScene() {
        text_x = 90;
        text_y = 50;
        cursor = new Cursor(text_x - 10, 61);
        sceneObjects.add(cursor);
        title = new TextAnimator(this, "defender 2oxx", text_x, text_y, 0);
        newGame = new TextAnimator(this, "new game", text_x, text_y+10, 0);
        highScore = new TextAnimator(this, "high scores", text_x, text_y+20, 0);
        startGame = true;
        highScores = false;
        fireballCooldown = 0;
    }
    @Override
    public void update() {
        Iterator<Integer> keyIterator = activeKeys.iterator();
        if(fireballCooldown > 0) {
            fireballCooldown--;
        }
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            switch(key) {
                case KeyEvent.VK_DOWN:
                    startGame = false;
                    highScores = true;
                    cursor.set_yPos(71);
                    System.out.println("cursor yPos: " + cursor.get_yPos());
                    break;
            case KeyEvent.VK_UP:
                    startGame = true;
                    highScores = false;
                    cursor.set_yPos(61);
                    System.out.println("cursor yPos: " + cursor.get_yPos());
                    break;
            case KeyEvent.VK_RIGHT:
                    System.out.println(" Title scene right key pressed");
                    break;
            case KeyEvent.VK_ENTER:
                    System.out.println("TitleScene enter pressed");
                    if (startGame) {
                        newScene = new StageOneScene(col, row);
                        active = false;
                    }
                    else if (highScores) {
                        newScene = new HighScoresScene(col, row);
                        active = false;
                    }
                    break;
            }
        }
        super.update();
    }
}
