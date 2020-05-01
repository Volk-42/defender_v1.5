package Defender20XX;
import java.util.HashSet;
import java.util.Random;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.EOFException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PixelChar extends SceneObject {
    
    private int countdown;
    private char finalChar;
    private int timeToFinal;
    public PixelChar(char finalChar, int x, int y, int activationDelay) {
        super(new File("CharO.csv"), x, y, activationDelay);
        this.finalChar = finalChar;
        timeToFinal = 5;
        countdown = 0;
        setAnimationSpeed(1);
        setAnimationLength(10);
        setColor(ColorPalette.B2);
    }
    
    @Override //overrides superclass animate method for indefinite random chars
    public void animate() {
        if(getAnimationFrameNum() < getAnimationLength()) {
            CharSelector charSelector = new CharSelector();
            File spriteFileName = charSelector.getSpriteFileName();
            SpriteMaker spriteMaker = new SpriteMaker(spriteFileName);
            setSprite(spriteMaker.getSpriteGrid());
            setAnimationFrameNum(getAnimationFrameNum()+1);
        }
        else {
            CharSelector charSelector = new CharSelector(finalChar);
            File spriteFileName = charSelector.getSpriteFileName();
            SpriteMaker spriteMaker = new SpriteMaker(spriteFileName);
            setSprite(spriteMaker.getSpriteGrid());
            if(finalChar == 32) {
                setVisible(false); //sets spaces to invisible
            }
            setAnimated(false);
        }
    }
}
