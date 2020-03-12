
package Defender20XX;

import java.awt.Color;
import java.util.ArrayList;

public abstract class SceneObject {
    private int[][] spriteGrid;
    private ArrayList<int[][]> animationFrames;
    private boolean visible;
    private Color color;
    private int xPos;
    private int yPos;
    private int oldX;
    private int oldY;
    private int zDepth;
    private int liveIn;
    private int animationFrameNum;
    private int animationLength;
    private int animationTicker; //compared against speed to advance frames
    private int animationSpeed; //higher values are slower
    private int activationDelay;
    private boolean spriteChange;
    private boolean animated;
    private boolean loops;
    private boolean runsOnce;
    private boolean runsThenLocks;
    private boolean active;
    
    //constructor for non-animated Sprites
    SceneObject(int[][] spriteGrid, int x, int y) {
        this.spriteGrid = spriteGrid;
        xPos = x;
        yPos = y;
        oldX = x;
        oldY = y;
        for(int i = 0; i < spriteGrid.length; i++) {
            spriteGrid[i][0] += xPos;
            spriteGrid[i][1] += yPos;
        }
        visible = true;
        animated = false;
        color = Color.WHITE;
        spriteChange = false;
        active = true;
    }
    //constructor for animated Sprites
    SceneObject(int[][] spriteGrid, int x, int y, int activationDelay) {
        this.spriteGrid = spriteGrid;
        visible = false;
        animated = true;
        xPos = x;
        yPos = y;
        oldX = x;
        oldY = y;
        for(int i = 0; i < spriteGrid.length; i++) {
            spriteGrid[i][0] += xPos;
            spriteGrid[i][1] += yPos;
        }
        this.activationDelay = activationDelay;
        animationTicker = 0;
        animationFrameNum = 0;
        spriteChange = false;
        active = true;
    }
    
    public void update() {
        if(animated) {
            if(activationDelay > 0) {
                activationDelay--;
            }
            else if(activationDelay <= 0) {
                setVisible(true);
                animate();
            } 
        }
        if(spriteChange) {
            for(int i = 0; i < spriteGrid.length; i++) {
                spriteGrid[i][0] += xPos;
                spriteGrid[i][1] += yPos;
            }
            spriteChange = false;
        }
        if(xPos != oldX || yPos != oldY) {
            for(int i = 0; i < spriteGrid.length; i++) {
                spriteGrid[i][0] -= oldX;
                spriteGrid[i][0] += xPos;
                spriteGrid[i][1] -= oldY;
                spriteGrid[i][1] += yPos;
            }
            oldX = xPos;
            oldY = yPos;
        }    
        
    }
    
    public void animate() {
        setSprite(getNextAnimationFrame(animationFrameNum));
        //controls the speed frames are cycled
        if(animationTicker == animationSpeed) {
            animationFrameNum++;
        }
        animationTicker++;
        animationTicker%=animationSpeed + 1;
        if(animationFrameNum > animationLength && !loops) {
            setAnimated(false);
        }
        else if(animationFrameNum > animationLength && loops) {
            setAnimationFrameNum(0);
        }
    }
    public void setAnimated(boolean b) {
        animated = b;
    }
    public void setAnimationFrameNum(int animationFrameNum) {
        this.animationFrameNum = animationFrameNum;
    }
    public int getAnimationFrameNum() {
        return animationFrameNum;
    }
    public int getAnimationLength() {
        return animationLength;
    }
    public int getAnimationTicker() {
        return animationTicker;
    }
    public int getAnimationSpeed() {
        return animationSpeed;
    }
    public void setAnimationFrames(ArrayList<int[][]> animationFrames) {
        this.animationFrames = animationFrames;
    }
    public void addAnimationFrame(int[][] animationFrame) {
        animationFrames.add(animationFrame);
    }
    public void clearAnimationFrames() {
        animationFrames.clear();
    }
    public int[][] getAnimationFrame(int i) {
        return animationFrames.get(i);
    }
    public int getAnimationFramesLength() {
        return animationFrames.size();
    }
    public void setRunsThenLocks(boolean b) {
        runsThenLocks = b;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setXY(int x, int y) {
        xPos = x;
        yPos = y;
    } 
    
    public void setSprite(int[][] pixelCoordinates) {
        spriteGrid = new int[pixelCoordinates.length][2];
        for(int i = 0; i < pixelCoordinates.length; i++) {
            spriteGrid[i][0] = pixelCoordinates[i][0];
            spriteGrid[i][1] = pixelCoordinates[i][1];
        }
        spriteChange = true;
    }
    
    public void set_xPos(int xPos) {
        this.xPos = xPos;
    }
    
    public void set_yPos(int yPos) {
        this.yPos = yPos;
    }
    
    public int get_yPos() {
        return yPos;
    }
    public int get_xPos() {
        return xPos;
    }
    public int get_oldX() {
        return oldX;
    }
    public int get_oldY() {
        return oldY;
    }
    public void set_zDepth(int z) {
        zDepth = z;
    }
    public int get_zDepth() {
        return zDepth;
    }
    
    
    public int[][] getSpriteGrid() {
        return spriteGrid;
    }
    
    public void setVisible(boolean b) {
        visible = b;
        System.out.println("GraphicsObject.setVisible("+b+")");
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void spriteChange() {
        spriteChange = true;
    }
    
    public boolean active() {
        return active;
    }
    public void setActive(boolean b) {
        active = b;
    }
    public void setLoops(boolean b) {
        loops = b;
    }
    public void setRunsOnce(boolean b) {
        runsOnce = b;
    }
    public int[][] getNextAnimationFrame(int animationFrameNum) {
        int[][] myInt = getSpriteGrid();
        return myInt;
    }
    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }
    public void setAnimationLength(int animationLength) {
        this.animationLength = animationLength;
    }
}
