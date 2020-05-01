
package Defender20XX;

import java.awt.Color;
import java.util.Random;
import java.io.File;

public class EngineExhaust extends SceneObject {
    private int explosionSpeed;
    private int frame;
    private int ticker;
    private int timer;
    private int loopingBackTicker;
    private boolean destroyed;
    private boolean loopingBack;
    EngineExhaust(int x, int y, int activationDelay) {
        super(new File("engineExhaust1.csv"), x, y, activationDelay);
        set_zDepth(1);
        setColor(ColorPalette.B2);
        setAnimated(true);
        setVisible(true);
        setLoops(true);
        setAnimationSpeed(4);
        setAnimationLength(5);
        String[] frames = {"engineExhaust1", "engineExhaust2"};
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
}
