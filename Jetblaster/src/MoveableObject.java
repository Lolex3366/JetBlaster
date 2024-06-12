import processing.core.PApplet;

abstract public class MoveableObject extends DrawableObject{

    float health;
    boolean isIntact;

    public MoveableObject(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact) {
        super(window, posX, posY, generalSize, width, height);
        this.health = health;
        this.isIntact = isIntact;

    }

    @Override
    public void draw(){ //dunno ob man überhaupt braucht, wenn nichts passiert
    }

    @Override
    public void move(){
    }

    @Override
    public void collision(){
    }
}