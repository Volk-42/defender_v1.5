package Defender20XX;

import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.File;

public class Ship extends SceneObject {
    private boolean weaponsEngaged;
    private boolean enginesEngaged;
    private int weaponsLag;
    private int engineLag;
    private int frame;
    private int flickerRate;
    
   
    public Ship(int x, int y) {
        super(new File("ship.csv"), x, y);
        set_zDepth(1);
        setColor(ColorPalette.B2);
        weaponsLag = 0;
        engineLag = 0;
        frame = 1;
        flickerRate = 10;
    }
    public void moveRight() {
        if(get_xPos() < 220) {
            set_xPos(get_xPos() + 1);
        }
    }
    public void moveLeft() {
        int xPos = get_xPos();
        if(xPos > 5) {
            xPos--;
            set_xPos(xPos);
        }
    }
    public void moveUp() {
        int yPos = get_yPos();
        if(yPos > 5) {
            yPos--;
            set_yPos(yPos);
        }
    }
    public void moveDown() {
        int yPos = get_yPos();
        if(yPos < 115) {
            yPos++;
            set_yPos(yPos);
        }
    }
    public void fireWeapons() {
        weaponsEngaged = true;
        weaponsLag = 5;
    }
    public boolean weaponsEngaged() {
        return weaponsEngaged;
    }
    
    public void weaponsDisengaged() {
        weaponsEngaged = false;
    }
    public void enginesEngaged() {
        //enginesEngaged = true;
        engineLag = 15;
    }
    
    public void enginesDisengaged() {
        enginesEngaged = false;
    }
    public boolean getEngineStatus() {
        return enginesEngaged;
    }
    
    @Override
    public void update() {
        if (weaponsLag > 0) {
            weaponsLag--;
        }
        if (weaponsLag <= 0) {
            weaponsLag = 0;
            weaponsDisengaged();
        }
        /*
        if (engineLag > 0) {
            if(frame < flickerRate) {
                this.setSprite(Sprite.shipAfterBurn1);
            }
            else {
                this.setSprite(Sprite.shipAfterBurn2);
            }
            engineLag--;
        }
        else if(engineLag <= 0) {
            if(frame < flickerRate) {
                this.setSprite(Sprite.shipPulse1);
            }
            else {
                this.setSprite(Sprite.shipPulse2);
            }
        }
        */
        frame++;
        frame%=flickerRate*2;
        super.update();
    }
    @Override
    public void animate() {
        
    }
}
