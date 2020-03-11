
package Defender20XX;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
        ArrayList<SceneObject> sceneObjects = activeScene.getSceneObjects();
        sceneObjects = zDepthSort(sceneObjects);
        for (int i = 0; i < sceneObjects.size(); i++) {
            SceneObject sceneObject = sceneObjects.get(i);
            
            if(sceneObject.isVisible()) {
                int[][] spriteGrid = sceneObject.getSpriteGrid();
                framePainter.setColor(sceneObject.getColor());
                for (int i2 = 0; i2 < spriteGrid.length; i2++) {
                    int x = spriteGrid[i2][0];
                    int y = spriteGrid[i2][1];
                    if (x <= colBound && y <= rowBound) {
                        framePainter.fillRect(x*5, y*5, 5, 5);
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
