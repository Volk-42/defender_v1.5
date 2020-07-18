package Defender20XX;

import java.awt.Color;
import java.io.File;

public class Cursor extends SceneObject {
    
    public Cursor(int x, int y) {
        super(new File("cursor.csv"), x, y);
        setColor(ColorPalette.B2);
    }
    //not needed?
    /*
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
*/
}
