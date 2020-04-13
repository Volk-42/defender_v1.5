package Defender20XX;

import java.awt.Color;
import java.io.File;

public class Building extends SceneObject {
    
    public Building(int x, int y) {
        super(new File("building1.csv"), x, y);
        setColor(ColorPalette.B3_1);
    }
    public boolean moved() {
        boolean moved;
        int xPos = get_xPos();
        int yPos = get_yPos();
        int oldX = get_oldX();
        int oldY = get_oldY();
        if(xPos != oldX || yPos != oldY) {
            moved = true;
        }
        else {
            moved = false;
        }
        return moved;
    }
}
