
package Defender20XX;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class GameKeyboard implements KeyListener {
    final private Scene activeScene;
    final private HashSet<Integer> activeKeys;
    GameKeyboard(Scene activeScene) {
        this.activeScene = activeScene;
        activeKeys = new HashSet();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        Integer key = e.getKeyCode();
        activeKeys.add(key);
        activeScene.activeKeys = this.activeKeys;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Integer key = e.getKeyCode();
        activeKeys.remove(key);
        activeScene.activeKeys = this.activeKeys;
    }
}
