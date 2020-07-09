
package Defender20XX;

import java.awt.Color;
import java.util.Random;
import java.io.File;

public class EngineWake extends SceneObject {
    private int explosionSpeed;
    private int frame;
    private int ticker;
    private int timer;
    private int loopingBackTicker;
    private boolean destroyed;
    private boolean loopingBack;
    private Ship ship;
    EngineWake(Ship ship, int x, int y, int activationDelay) {
        super(new File("engineExhaust1.csv"), x, y, activationDelay);
        this.ship = ship;
        set_zDepth(1);
        setColor(ColorPalette.B2);
        setAnimated(true);
        setVisible(false);
        setLoops(true);
        setAnimationSpeed(4);
        //setAnimationLength(1);
        String[] frames = {"engineExhaust1.csv", "engineExhaust2.csv"};
        setAnimationFrames(frames);
        setAnimationLength(frames.length);
        explosionSpeed = 5;
        frame = 0;
        ticker = 1;
        timer = 1;
        loopingBackTicker = 0;
        destroyed = false;
        loopingBack = false;
    }
    
    @Override
    public void update() {
        set_xPos(ship.get_xPos() - 15);
        set_yPos(ship.get_yPos() + 15);
        if(ship.get_yPos() <= 110 && this.isVisible()) {
            this.setLoops(false);
            if(this.getAnimationFrameNum() > this.getAnimationLength()) {
                System.out.println("enemy frameNum > enemy animationLength");
                setActive(false);
            }
        }
        super.update();
    }
}
