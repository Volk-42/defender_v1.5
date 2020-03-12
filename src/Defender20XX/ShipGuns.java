package Defender20XX;
import java.awt.Color;
import java.util.Random;

public class ShipGuns extends SceneObject {
    private Ship ship;
    private int frame;
    private int flickerRate;
    private int weaponsLag;
    private Random r;
   
    public ShipGuns(Ship ship, int x, int y) {
        super(Sprite.getShot1(), x, y);
        set_zDepth(1);
        this.setVisible(false);
        setColor(ColorPalette.B1);
        this.ship = ship;
        frame = 0;
        flickerRate = 10;
        weaponsLag = 5;
        r = new Random();
    }
    
    @Override
    public void update() {
        int xOffset = r.nextInt(150) + 35;
        set_xPos(ship.get_xPos() + xOffset);
        set_yPos(ship.get_yPos() + 8);
        frame++;
        frame%=flickerRate*2;
        super.update();
    }
    @Override
    public void animate() {
        
    }
}
