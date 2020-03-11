package Defender20XX;

import java.awt.Color;

public class Building extends SceneObject {
    
    public Building(int x, int y) {
        super(Sprite.BUILDING_2, x, y);
        setColor(Color.BLUE);
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
