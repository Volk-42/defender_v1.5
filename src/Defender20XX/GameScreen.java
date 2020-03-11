package Defender20XX;

import java.awt.Color;
import javax.swing.JFrame;

public class GameScreen {
    final private GamePanel p;  
    final private int width;
    final private int height;
    
    public GameScreen(int width, int height, GamePanel p) {
        
        this.width = width;
        this.height = height; 
        this.p = p;
        p.setBackground(Color.BLACK);
        JFrame f = new JFrame();
        //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //f.setUndecorated(true);
        f.setSize(width, height);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
    }
}