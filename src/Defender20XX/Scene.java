
package Defender20XX;

import java.util.ArrayList;
import java.util.HashSet;

public class Scene {
    ArrayList<SceneObject> sceneObjects = new ArrayList();;
    HashSet<Integer> activeKeys = new HashSet();;
    Scene newScene;
    int[][] pixelGrid;
    int col;
    int row;
    boolean active = true;
    
    
    public void update() {
        for(int i = 0; i < sceneObjects.size(); i++) {
            SceneObject sceneObject = sceneObjects.get(i);
            if(sceneObject.active() == false) {
                sceneObjects.remove(sceneObject);
            }
            else {
                sceneObject.update();
            }
        }
    }
    
    public boolean active() {
        return active;
    }
    
    public Scene newScene() {
        return newScene;
    }
   
    public ArrayList<SceneObject> getSceneObjects() {
        return sceneObjects;
    }


}
