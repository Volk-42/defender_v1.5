package Defender20XX;

import java.awt.Color;
import java.io.File;

public class Car extends SceneObject {
    
    Car(int x, int y) {
        super(new File("car.csv"), x, y);
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
