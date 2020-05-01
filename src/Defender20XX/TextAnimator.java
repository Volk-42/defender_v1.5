package Defender20XX;

import java.util.Random;

public class TextAnimator {
    final private String ALPHANUMERIC_CHARACTERS = 
                                "0123456789abcdefghijklmnopqrstuvwxyz";
    private int x; //starting coordinate
    private int y; //starting coordinate
    String inputString;
    char finalChar;
    char startingChar;
    
    TextAnimator (Scene activeScene, String inputString, int x,int y,
                                                int activationDelay) {
        
        this.inputString = inputString;
        this.x = x; //starting coordinate
        this.y = y; //starting coordinate
        
        for (int i = 0; i < inputString.length(); i++) {
            startingChar = getRandomChar();
            finalChar = inputString.charAt(i);
            PixelChar pixelChar = new PixelChar(finalChar, x +(i*5), y, i*2);
            activeScene.sceneObjects.add(pixelChar);
        }
    }
    private char getRandomChar() {
        Random r = new Random();
        char c = ALPHANUMERIC_CHARACTERS.charAt(r.nextInt(26));
        return c;
    }
}
