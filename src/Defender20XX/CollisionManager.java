package Defender20XX;

import java.util.ArrayList;

public class CollisionManager {

    Scene activeScene;
    CollisionManager(Scene activeScene) {
        this.activeScene = activeScene;
    }
    /*
    public void checkCollision() {
        ArrayList<SceneObject> collisionObjects = activeScene.getSceneObjects();
        getShip(collisionObjects);
        for(int i = 0; i < collisionObjects.size(); i++) {
            SceneObject currentObject = collisionObjects.get(i);
        }
    }
    private Ship (ArrayList<SceneObject> collisionObjects) {
        Ship ship = new Ship(0, 0);
        for(int i = 0; i < collisionObjects.size(); i++) {
            if (collisionObjects.get(i) instanceof Ship) {
                ship = (Ship)collisionObjects.get(i);
            }
        }
        return ship;
    }
    */
    /* consider moving this into the graphics manager. Also consider moving 
    the x, y pixel data updating out of the sceneobject class and into 
    grpahics manager as well. the X and Y offset could be set once and
    assigned to a local variable using the getX, getY method and then added
    at the time of painting to the bufferedimage
    */
   /*
    public void detectCollisions(Scene activeScene) {
        
    }
        
        ArrayList<SceneObject> sceneObjects = activeScene.getSceneObjects(); //get scene objects
        for (int i = 0; i < sceneObjects.size(); i++) { //iterate through scene objects
            SceneObject sceneObject = sceneObjects.get(i); 
            if(sceneObject.isVisible() && sceneObject.isCollidable) { //check visibility and whether or not it been be hit
                int[][] spriteGrid = sceneObject.getSpriteGrid(); //get scene object pixel coordinates
                int numOfOverlapPixels = 0;
                while (numOfOverlapPixels < 3) {
                    int counter = 0;
                    int scanner = 0;
                    int shipXpixel = shipSpriteGrid[counter][0]; //use this to compare against
                    int shipYpixel = shipSpriteGrid[counter][1]; //use this to compare against
                    int enemyXpixel = spriteGrid[scanner][0]; //compare against this
                    int enemyYpixel = spriteGrid[scanner][1]; //compare against this
                    if (shipXpixel == enemyXpixel && shipYpixel == enemyYpixel) {
                        numOfOverlapPixels++;
                    }
                }
                for (int i2 = 0; i2 < spriteGrid.length; i2++) { //iterate through pixel coordinates
                    int x = spriteGrid[i2][0]; //get pixel x position
                    int y = spriteGrid[i2][1]; //get pixel y position
                    if (x <= colBound && y <= rowBound) { //check if on screen
                        framePainter.fillRect(x*5, y*5, 5, 5); //paint pixel
                    }
                }
            }
        }
        return frame;
*/
    }
