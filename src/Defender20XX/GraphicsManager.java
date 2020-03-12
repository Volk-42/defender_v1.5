
package Defender20XX;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

public class GraphicsManager {
    int width;
    int height;
    int col;
    int row;
    int colBound;
    int rowBound;
    
    GraphicsManager(int width, int height, int col, int row) {
        this.width = width;
        this.height = height;
        this.col = col;
        this.row = row;
        colBound = col-1;
        rowBound = row-1;
    }
   
    public BufferedImage getNextFrame(Scene activeScene) {
        BufferedImage frame = new BufferedImage(width, height, 
                                            BufferedImage.TYPE_INT_RGB);
        Graphics framePainter = frame.createGraphics();
        framePainter.setColor(ColorPalette.B4); //set BG color
        framePainter.fillRect(0, 0, width, height); //paint BG
        ArrayList<SceneObject> sceneObjects = activeScene.getSceneObjects(); //get scene objects
        sceneObjects = zDepthSort(sceneObjects); //sort their painting order(BG first)
        for (int i = 0; i < sceneObjects.size(); i++) { //iterate through scene objects
            SceneObject sceneObject = sceneObjects.get(i);
            if(sceneObject.isVisible()) { //check visibility
                int[][] spriteGrid = sceneObject.getSpriteGrid(); //get scene object pixel coordinates
                framePainter.setColor(sceneObject.getColor()); //get scene object color
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
    }
    
    private ArrayList<SceneObject> zDepthSort (ArrayList<SceneObject> 
                                                             sceneObjects) {
        
        for(int i = 0; i < sceneObjects.size() - 1; i++) {
            int z1 = sceneObjects.get(i).get_zDepth();
            int scanner = i + 1;
            while(scanner < sceneObjects.size()) {
                int z2 = sceneObjects.get(scanner).get_zDepth();
                if (z2 > z1) {
                    SceneObject holder = sceneObjects.get(scanner);
                    sceneObjects.remove(scanner);
                    sceneObjects.add(i, holder);
                }
                scanner++;
            }
        }
        return sceneObjects;
    }
}
