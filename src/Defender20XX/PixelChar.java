package Defender20XX;
import java.util.HashSet;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class PixelChar extends SceneObject {
    private int countdown;
    private char character;
    private int timeToFinal;
    public PixelChar(char character, int x, int y, int activationDelay) {
        super(Sprite.getRandomCharFrame(), x, y, activationDelay);
        this.character = character;
        timeToFinal = 5;
        countdown = 0;
        setAnimationSpeed(1);
        setAnimationLength(10);
        setColor(ColorPalette.B2);
    }
    
    @Override
    public int[][] getNextAnimationFrame(int animationFrameNum) {
        int[][] nextAnimationFrame;
        if(getAnimationFrameNum() < getAnimationLength()) {
            nextAnimationFrame = Sprite.getRandomCharFrame();
        }
        else {
            nextAnimationFrame = Sprite.getCharSprite(character);
            if(character == 32) {
                setVisible(false); //sets spaces to invisible
            }
            setAnimated(false);
        }
        return nextAnimationFrame;
    }
}
