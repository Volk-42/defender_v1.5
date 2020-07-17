
package Defender20XX;

import java.awt.Color;
import java.util.Random;
import java.io.File;

public class Enemy extends SceneObject {
    private int explosionSpeed;
    private int frame;
    private int ticker;
    private int timer;
    private int loopingBackTicker;
    private boolean destroyed;
    private boolean loopingBack;
    private boolean inPursuit;
    Enemy(int x, int y, int activationDelay) {
        super(new File("enemy.csv"), x, y, activationDelay);
        set_zDepth(1);
        setColor(ColorPalette.B2);
        setAnimated(false);
        setVisible(true);
        setLoops(false);
        setAnimationSpeed(4);
        setAnimationLength(5);
        String[] frames = {"enemyExplode1.csv","enemyExplode2.csv",
                            "enemyExplode3.csv","enemyExplode4.csv",
                            "enemyExplode5.csv","enemyExplode6.csv"};
        setAnimationFrames(frames);
        explosionSpeed = 5;
        frame = 0;
        ticker = 1;
        timer = 1;
        loopingBackTicker = 0;
        destroyed = false;
        loopingBack = true;
        inPursuit = false;
    }
    public boolean getDestroyed() {
        return destroyed;
    }
    public void setDestroyed(boolean b) {
       destroyed = b;
       setAnimated(true);
    }
    
    @Override
    public void update() {
        if(getAnimationFrameNum() > getAnimationLength()) {
            System.out.println("enemy frameNum > enemy animationLength");
            setActive(false);
        }
        if(destroyed) {
            set_xPos(get_xPos() -1);
            set_yPos(get_yPos() +1);
            
        }
        if(loopingBack) {
            if(loopingBackTicker < 4) {
                set_xPos(get_xPos() + 2);
            }
            else if(loopingBackTicker >= 4 && loopingBackTicker < 7) {
                set_xPos(get_xPos() + 1);
            }
            else if(loopingBackTicker >= 7 && loopingBackTicker < 9) {
                set_xPos(get_xPos() -1);
            }
            else if(loopingBackTicker >= 9 && loopingBackTicker < 11) {
                set_xPos(get_xPos() -2);
            }
            else if(loopingBackTicker >= 11) {
                set_xPos(get_xPos() -3);
            }
            loopingBackTicker++;
            if(get_xPos() < - 70) {
                loopingBack = false;
                loopingBackTicker = 0;
                inPursuit = true;
            }
        }
        if(inPursuit && get_xPos() < 20) {
            set_xPos(get_xPos()+1);
        }
        super.update();
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
