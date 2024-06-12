import processing.core.PApplet;

abstract public class DrawableObject {
    PApplet window;
    float posX; //Position
    float posY;
    float generalSize; //genereller Größenfaktor (eig. immer 1)
    float width; //für die Hitboxen
    float height;
    public DrawableObject(PApplet window, float posX, float posY, float generalSize, float width, float height) {
        this.window = window;
        this.posX = posX;
        this.posY = posY;
        this.generalSize = generalSize;
        this.width = width;
        this.height = height;
    }

    //Abstrakte Funktionen
    abstract public void draw();
    abstract void move();
    abstract void collision();
}
