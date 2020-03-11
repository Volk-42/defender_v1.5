package Defender20XX;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel {
    
    final private int width;
    final private int height;
    final private int col;
    final private int row;
    private GameKeyboard keyboard;
    private BufferedImage frame; 
    
    public GamePanel(int width, int height, int col, int row) {
        this.width = width;
        this.height = height;
        this.col = col;
        this.row = row;
        this.setSize(width, height);
    }
    
    //loads keyboard for new scene
    public void loadKeyBoard(Scene activeScene) {
        System.out.println("panel's load scene method: ");
        keyboard = new GameKeyboard(activeScene);
        this.addKeyListener(keyboard);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    public void loadFrame(BufferedImage nextFrame) {
        frame = nextFrame;
    }
    
    //calling repaint() for DefenderPanel now displays next bufferedFrame
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frame, 0, 0, this);
    }
}