import com.sun.java.accessibility.util.SwingEventMonitor;
import processing.core.PApplet;

abstract public class Rival extends DrawableObject{
    public Rival(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact){
        super(window, posX, posY, generalSize, width, height, health, isIntact);
    }


    @Override
    public void draw() {
    }
    @Override
    public  void move(){
    }
    @Override
    public void collision(){

    }
}
