package Defender20XX;

import java.io.FileNotFoundException;

public class Defender20XX {
    
    final private static SceneManager SCENE_MANAGER = 
            new SceneManager();
    final private static Thread GAME_THREAD = 
            new Thread(SCENE_MANAGER);
    
    public static void main(String[] args) throws FileNotFoundException {
        GAME_THREAD.start();
    }
}


