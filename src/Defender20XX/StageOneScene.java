
package Defender20XX;

import java.awt.event.KeyEvent;
import java.util.Iterator;

public class StageOneScene extends Scene {
    private Ship ship;
    private ShipGuns shipGuns;
    private Enemy enemy;
    private Building building1;
    private Building building2;
    StageOneScene(int col, int row) {
        ship = new Ship(50, 50);
        shipGuns = new ShipGuns(ship, 0, 0);
        enemy = new Enemy(100, 50, 0);
        building1 = new Building(90, 35);
        building1.set_zDepth(2);
        building2 = new Building(25, 25);
        building2.set_zDepth(3);
        sceneObjects.add(building1);
        sceneObjects.add(building2);
        sceneObjects.add(ship);
        sceneObjects.add(shipGuns);
        sceneObjects.add(enemy);
    }
    @Override
    public void update() {
        Iterator<Integer> keyIterator = activeKeys.iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            switch(key) {
                case KeyEvent.VK_DOWN:
                    ship.moveDown();
                    break;
            case KeyEvent.VK_UP:
                    ship.moveUp();
                    break;
            case KeyEvent.VK_LEFT:
                    ship.moveLeft();
                    break;
            case KeyEvent.VK_RIGHT:
                    ship.moveRight();
                    ship.enginesEngaged();
                    break;
            case KeyEvent.VK_A:
                    ship.fireWeapons();
                    //enemy.setDestroyed(true);
                    break;
            case KeyEvent.VK_ENTER:
                    break;
            }
        }
        building1.set_xPos(building1.get_xPos() - 1);
        if (building1.get_xPos() < -80) {
            sceneObjects.remove(building1);
            building1 = new Building(230, 35);
            building1.set_zDepth(2);
            sceneObjects.add(building1);
        } 
        building2.set_xPos(building2.get_xPos() - 2);
        if (building2.get_xPos() < -80) {
            sceneObjects.remove(building2);
            building2 = new Building(230, 25);
            building2.set_zDepth(3);
            sceneObjects.add(building2);
        }
        if (ship.weaponsEngaged()) {
            shipGuns.setVisible(true);
            if(enemy.get_yPos() == ship.get_yPos() 
                    && enemy.getDestroyed() == false) {
                enemy.setDestroyed(true);
                int x = enemy.get_xPos();
                int y = enemy.get_yPos();
                Fireball fireball_1 = new Fireball(x + 25, y, 0);
                Fireball fireball_2 = new Fireball(x + 35, y + 5, 3);
                sceneObjects.add(fireball_1);
                sceneObjects.add(fireball_2);
            }
        }
        else {
            shipGuns.setVisible(false);
        }
        super.update();
    }
}
    
