
package Defender20XX;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.ArrayList;

public class StageOneScene extends Scene {
    private Ship ship;
    private EngineExhaust engineExhaust;
    private EngineWake engineWake;
    private ShipGuns shipGuns;
    private Enemy enemy;
    private boolean enemy_xDir = true;
    private boolean enemy_yDir = true;
    private boolean engineWakeVisible;
    private Building building1;
    private Building building2;
    private Car car1;
    private Car car2;
    final private int ground_y = 129;
    final private int streetLampGround_y = 113;
    private ArrayList<Streetlamp> streetlamps;
    
    StageOneScene(int col, int row) {
        ship = new Ship(50, 50);
        engineExhaust = new EngineExhaust(ship, 50, 50, 0);
        //engineWake = new EngineWake(ship, 50, 50, 0);
        shipGuns = new ShipGuns(ship, 0, 0);
        enemy = new Enemy(100, 50, 0);
        car1 = new Car(25, ground_y);
        car2 = new Car(115, ground_y);
        engineWakeVisible = false;
        building1 = new Building(90, 35);
        building1.set_zDepth(2);
        building2 = new Building(25, 25);
        building2.set_zDepth(3);
        streetlamps = new ArrayList();
        for(int i = 0; i < 8; i++) {
            Streetlamp streetlamp = new Streetlamp(i*40, streetLampGround_y);
            streetlamp.set_zDepth(1);
            streetlamps.add(streetlamp);
            sceneObjects.add(streetlamp);
        }
        sceneObjects.add(car1);
        sceneObjects.add(car2);
        sceneObjects.add(building1);
        sceneObjects.add(building2);
        sceneObjects.add(ship);
        sceneObjects.add(engineExhaust);
        //sceneObjects.add(engineWake);
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
                case KeyEvent.VK_L:
                    LaserCharge enemyLaser = new LaserCharge(10, 10, 0);
                    sceneObjects.add(enemyLaser);
                    break;
                default:
                    break;
            }
        }
        for(int i = 0; i < streetlamps.size(); i++) {
            Streetlamp streetlamp = streetlamps.get(i);
            if(streetlamp.get_xPos() < -80) {
                streetlamp.set_xPos(250);
            }
        }
        /*adds wake when ship gets low. Control for removal is handled within
        the engine wake instance because I'm too stupid to figure out 
        how to make it work another way*/
        if (ship.get_yPos() > 110 && engineWakeVisible == false) {
            engineWakeVisible = true;
            engineWake = new EngineWake(ship, ship.get_xPos()-20, 120, 0);
            sceneObjects.add(engineWake);
        }
        //enemy x direction
        /*
        if(enemy_xDir) {
            enemy.set_xPos(enemy.get_xPos()+1);
        }
        else if(!enemy_xDir){
            enemy.set_xPos(enemy.get_xPos()-1);
        }
        //enemy y direction
        if(enemy_yDir) {
            enemy.set_yPos(enemy.get_yPos()+1);
        }
        else {
            enemy.set_yPos(enemy.get_yPos()-1);
        }
        //checks to see if x direction needs reversing
        if(enemy.get_xPos() > 150 && enemy_xDir) {
            enemy_xDir = false;
        }
        if(enemy.get_xPos() < 100 && !enemy_xDir) {
            enemy_xDir = true;
        }
        //checks to see if enemy y direction needs reversing
        if(enemy.get_yPos() > 75 && enemy_yDir) {
            enemy_yDir = false;
        }
        if(enemy.get_yPos() < 20 && !enemy_yDir) {
            enemy_yDir = true;
        }*/
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
        if (car1.get_xPos() < -80) {
            sceneObjects.remove(car1);
            car1 = new Car(250, ground_y);
            car1.set_zDepth(1);
            sceneObjects.add(car1);
        }
        if (car2.get_xPos() < -80) {
            sceneObjects.remove(car2);
            car2 = new Car(250, ground_y);
            car2.set_zDepth(1);
            sceneObjects.add(car2);
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
    
