package Defender20XX;

import java.awt.Color;

public class Car extends SceneObject {
    
    public Car(int x, int y) {
        super(Sprite.getSprite("car"), x, y);
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
    @Override
    public void update() {
        set_xPos(get_xPos() - 4);
        super.update();
    }
    
}
