
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
        super(new File("wake1.csv"), x, y, activationDelay);
        this.ship = ship;
        set_zDepth(1);
        setColor(ColorPalette.B2);
        setAnimated(true);
        setVisible(true);
        setLoops(true);
        setAnimationSpeed(4);
        //setAnimationLength(1);
        String[] frames = {"wake1.csv", "wake2.csv"};
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
        set_xPos(ship.get_xPos() - 20);
        //set_yPos(ship.get_yPos());
        
        
        super.update();
    }
}
