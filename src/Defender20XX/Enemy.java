
package Defender20XX;

import java.awt.Color;
import java.util.Random;

public class Enemy extends SceneObject {
    private int explosionSpeed;
    private int frame;
    private int ticker;
    private int timer;
    private boolean destroyed;
    Enemy(int x, int y, int activationDelay) {
        super(Sprite.getEnemyFrame(0), x, y, activationDelay);
        set_zDepth(1);
        setColor(ColorPalette.B2);
        setAnimated(false);
        setVisible(true);
        setLoops(false);
        setAnimationSpeed(4);
        setAnimationLength(Sprite.ENEMY_FRAMES.size() - 1);
        explosionSpeed = 5;
        frame = 0;
        ticker = 1;
        timer = 1;
        destroyed = false;
    }
    public boolean getDestroyed() {
        return destroyed;
    }
    public void setDestroyed(boolean b) {
        setAnimated(true);
        destroyed = b;
    }
    
    @Override
    public void update() {
        if(getAnimationFrameNum() > getAnimationLength()) {
            System.out.println("enemy frameNum > enemy animationLength");
            setActive(false);
        }
        super.update();
    }
    @Override
    public int[][] getNextAnimationFrame(int animationFrameNum) {
        int[][] nextAnimationFrame = Sprite.getEnemyFrame(animationFrameNum);
        return nextAnimationFrame;
    }
    
    private void sink() {
        set_xPos(get_xPos() -1);
        //set_yPos(get_yPos() +1);
    }
    private void move() {
        if(timer <= 25) {
            set_xPos(get_xPos() + 1);
        }
        else if(timer > 25 && timer <= 50) {
            set_xPos(get_xPos() - 1);
        }
        else if(timer > 50 && timer <= 75) {
            set_yPos(get_yPos() + 1);
        }
        else {
            set_yPos(get_yPos() - 1);
        }
    }
}
