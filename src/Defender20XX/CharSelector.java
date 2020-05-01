package Defender20XX;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CharSelector {
    final private String ALPHANUMERIC_CHARACTERS = 
                                "0123456789abcdefghijklmnopqrstuvwxyz";
    private File fileName;
    char randomChar;
    char finalChar;
    CharSelector(char finalChar) {
        this.finalChar = finalChar;
        fileName = selectChar(finalChar);
    }
    CharSelector() {
        Random r = new Random();
        randomChar = ALPHANUMERIC_CHARACTERS.charAt(r.nextInt(26));
        fileName = selectChar(randomChar);   
    }
    private File selectChar(char selectedChar) {
        switch(selectedChar) {
            case ' ':
                fileName = new File("char_Space.csv");
                break;
            case 'a':
                fileName = new File("charA.csv");
                break;
            case 'b':
                fileName = new File("charB.csv");
                break;
            case 'c':
                fileName = new File("charC.csv");
                break;
            case 'd':
                fileName = new File("charD.csv");
                break;
            case 'e':
                fileName = new File("charE.csv");
                break;
            case 'f':
                fileName = new File("charF.csv");
                break;
            case 'g':
                fileName = new File("charG.csv");
                break;
            case 'h':
                fileName = new File("charH.csv");
                break;
            case 'i':
                fileName = new File("charI.csv");
                break;
            case 'j':
                fileName = new File("charJ.csv");
                break;
            case 'k':
                fileName = new File("charK.csv");
                break;
            case 'l':
                fileName = new File("charL.csv");
                break;
            case 'm':
                fileName = new File("charM.csv");
                break;
            case 'n':
                fileName = new File("charN.csv");
                break;
            case 'o':
                fileName = new File("charO.csv");
                break;
            case 'p':
                fileName = new File("charP.csv");
                break;
            case 'q':
                fileName = new File("charQ.csv");
                break;
            case 'r':
                fileName = new File("charR.csv");
                break;
            case 's':
                fileName = new File("charS.csv");
                break;
            case 't':
                fileName = new File("charT.csv");
                break;
            case 'u':
                fileName = new File("charU.csv");
                break;
            case 'v':
                fileName = new File("charV.csv");
                break;
            case 'w':
                fileName = new File("charW.csv");
                break;
            case 'x':
                fileName = new File("charX.csv");
                break;
            case 'y':
                fileName = new File("charY.csv");
                break;
            case 'z':
                fileName = new File("charZ.csv");
                break;
            case '0':
                fileName = new File("charO.csv");
                break;
            case '1':
                fileName = new File("char1.csv");
                break;
            case '2':
                fileName = new File("char2.csv");
                break;
            case '3':
                fileName = new File("char3.csv");
                break;
            default:
                fileName = new File("charO.csv");
                break;
            }
        return fileName;
    }
    public File getSpriteFileName() {
        return fileName;
    }
}
        