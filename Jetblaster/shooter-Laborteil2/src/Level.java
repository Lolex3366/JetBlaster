import java.util.ArrayList;
import processing.core.PApplet;

public class Level {
    public int currentLevel = 0;
    public int numRivals = 50;
    public int speedRivals = 10;
    public int healthRivals = 100;


    public void mainScreen(){
        //Hauptmenü mit Start, Statistiken, evtl. Einstellungen
    }
    public void levelBuild(){
        //baut den momentanen Level
        //(wie viele Gegner spawnen, wie stark sie sind, wie groß, Endboss)
    }
    public void deathScreen(){
        //Statistik vom letzten Spiel, evtl. Zeit, Punkte, etc.
        //mainScreen Button
    }
    public void nextLevel(int numRivals, int speedRivals) {
        this.numRivals += 20;
        this.speedRivals += 2;
        this.healthRivals += 20;
        //Macht den nächsten Level etwas schwieriger
    }
}
