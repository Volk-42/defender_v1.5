
package Defender20XX;

import java.awt.Color;
import java.util.ArrayList;

public class Fireball extends SceneObject {
    Fireball(int x, int y, int activationDelay) {
        super(Sprite.getFireballFrame(0), x, y, activationDelay);
        set_zDepth(0);
        setColor(ColorPalette.B1);
        setAnimationSpeed(4);
        setAnimationLength(Sprite.FIREBALL_FRAMES.size() - 1);
    }
    @Override
    public void update() {
        if(getAnimationFrameNum() > getAnimationLength()) {
            setActive(false);
        }
        super.update();
    }
    @Override
    public int[][] getNextAnimationFrame(int animationFrameNum) {
        int[][] nextAnimationFrame = Sprite.getFireballFrame(animationFrameNum);
        return nextAnimationFrame;
    }
}
