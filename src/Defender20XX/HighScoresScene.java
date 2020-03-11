
package Defender20XX;

import java.awt.event.KeyEvent;
import java.util.Iterator;

public class HighScoresScene extends Scene {
    final private TextAnimator name;
    final private TextAnimator player;
    final private TextAnimator player2;
    final private TextAnimator sample;
    final private TextAnimator home;
    final private Cursor cursor;
    private int selector;
    private int cooldown;
    HighScoresScene(int col, int row) {
        name = new TextAnimator(this,    "name       score", 85, 30, 0);
        player = new TextAnimator(this,  "player 1   2oooo", 85, 50, 0);
        player2 = new TextAnimator(this, "player 2   12ooo", 85, 70, 0);
        sample = new TextAnimator(this,  "player 3   1oooo", 85, 90, 0);
        home = new TextAnimator(this, "push start button", 85, 110, 0);
        cursor = new Cursor(75, 51);
        //sceneGraphics.add(cursor);
        selector = 0;
        cooldown = 0;
    }
    @Override
    public void update() {
        Iterator<Integer> keyIterator = activeKeys.iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            switch(key) {
                case KeyEvent.VK_DOWN:
                    if(selector < 3 && cooldown == 0) {
                        selector++;
                        cooldown = 5;
                        moveCursor();
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(selector > 0 && cooldown == 0) {
                        selector--;
                        cooldown = 5;
                        moveCursor();
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    newScene = new TitleScene();
                    active = false;
                    if (selector == 3) {
                        
                    }
                    break;
            }
        }
        if (cooldown > 0) {
            cooldown--;    
        }
        super.update();
    }
    private void moveCursor() {
    switch(selector) {
        case 0:
            cursor.set_xPos(75);
            cursor.set_yPos(51);
            break;
        case 1:
            cursor.set_xPos(75);
            cursor.set_yPos(71);
            break;
        case 2:
            cursor.set_xPos(75);
            cursor.set_yPos(91);
            break;
        case 3:
            cursor.set_xPos(110);
            cursor.set_yPos(111);
            break;
        }    
    }
}

