
package Defender20XX;

import java.awt.Color;
import java.util.ArrayList;
import java.io.File;

public class Fireball extends SceneObject {      
    Fireball(int x, int y, int activationDelay) {
        super(new File("fireball1.csv"), x, y, activationDelay);
        set_zDepth(0);
        setColor(ColorPalette.B1);
        setAnimationSpeed(4);
        setAnimationLength(0);
        String[] frames = {"fireball2.csv"};
        setAnimationFrames(frames);
    }
    @Override
    public void update() {
        if(getAnimationFrameNum() > getAnimationLength()) {
            setActive(false);
        }
        super.update();
    }
}
