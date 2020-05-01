
package Defender20XX;

import java.awt.Color;
import java.util.ArrayList;
import java.io.File;

public class LaserCharge extends SceneObject {
    LaserCharge(int x, int y, int activationDelay) {
        super(new File("laserfire.csv"), x, y, activationDelay);
        set_zDepth(0);
        setColor(ColorPalette.B1);
        setAnimationSpeed(4);
        setAnimationLength(Sprite.LASER_FRAMES.size() - 1);
    }
    @Override
    public void update() {
        if(getAnimationFrameNum() > getAnimationLength()) {
            setActive(false);
        }
        super.update();
    }
}
