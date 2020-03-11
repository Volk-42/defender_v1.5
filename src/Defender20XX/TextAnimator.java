package Defender20XX;

import java.util.Random;

public class TextAnimator {
    private int x; //starting coordinate
    private int y; //starting coordinate
    String s;
    char c;
    Random r;
    
    TextAnimator (Scene activeScene, String s, int x,int y,
                                                int activationDelay) {
        
        this.s = s;
        this.x = x; //starting coordinate
        this.y = y; //starting coordinate
        r = new Random();
        
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            PixelChar pixelChar = new PixelChar(c, x +(i*5), y, i*2);
            activeScene.sceneObjects.add(pixelChar);
        }
    }
}
