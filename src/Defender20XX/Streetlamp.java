package Defender20XX;

import java.awt.Color;

public class Streetlamp extends SceneObject {
    
    public Streetlamp(int x, int y) {
        super(Sprite.getSprite("streetlamp"), x, y);
        setColor(ColorPalette.B3);
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
    @Override
    public void update() {
        set_xPos(get_xPos() - 8);
        super.update();
    }
    
}
