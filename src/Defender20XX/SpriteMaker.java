package Defender20XX;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SpriteMaker {
    private int[][] spriteGrid;
    SpriteMaker(File spriteFile) {
        try {
            FileReader fr = new FileReader(spriteFile);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            //debugger
            System.out.println(s);
            String[] coordinateArray = new String[s.length()/2];
            coordinateArray = s.split(",");
            int index = 0;
            spriteGrid = new int[coordinateArray.length/2][2];
            //debugger
            System.out.println("spriteGrid Length " + spriteGrid.length);
            for (int i = 0; i < spriteGrid.length; i++) {
                spriteGrid[i][0] = Integer.parseInt(coordinateArray[index]);
                spriteGrid[i][1] = Integer.parseInt(coordinateArray[index+1]);
                index+=2;
            }
            //debugger
            System.out.println("spritegrid coordinates " + spriteGrid[0][0]);
            System.out.println("spritegrid coordinates " + spriteGrid[0][1]);
        }
        catch(FileNotFoundException e1) {
            System.out.println(e1);
        }
        catch(EOFException e2) {
            System.out.println(e2);
        }
        catch(IOException e3) {
            System.out.println(e3);
        }    
    }
    public int[][] getSpriteGrid() {
        return spriteGrid;
    }
}
