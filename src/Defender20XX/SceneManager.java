
package Defender20XX;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;


public class SceneManager implements Runnable {
    Scene activeScene;
    private boolean running = true;
    GamePanel defenderPanel;
    GameScreen defenderScreen;
    GraphicsManager graphicsManager;
    final private int width;
    final private int height;
    final private int col;
    final private int row;
    final private int pixelation = 5;
    final private Dimension2D screenDimension;
  
    SceneManager() {
        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        width = 1280;
                //(int)screenDimension.getWidth();
        height = 720;
                //(int)screenDimension.getHeight();
        col = (int)(10*(Math.round(width/10)))/pixelation;
        System.out.println("col created: " +col);
        row = (int)(10*(Math.round(height/10)))/pixelation;
        System.out.println("row created: " +row);
        activeScene = new TitleScene();
        System.out.println("sceneManager sets activeScene to new TitleScene");
        defenderPanel = new GamePanel(width, height, col, row);
        defenderScreen = new GameScreen(width, height, defenderPanel);
        graphicsManager = new GraphicsManager(width, height, col, row);
        defenderPanel.loadKeyBoard(activeScene);
        
    }
    
    @Override
    public void run() {
        while (running) {
            activeScene.update();
            if (activeScene.active() == false) {
                Scene sceneHolder = activeScene.newScene();
                activeScene = sceneHolder;
                defenderPanel.loadKeyBoard(activeScene);
            }
            defenderPanel.loadFrame(graphicsManager.getNextFrame(activeScene));
            defenderPanel.repaint();
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
}
