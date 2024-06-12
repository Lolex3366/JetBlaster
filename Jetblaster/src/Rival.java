import processing.core.PApplet;

abstract public class Rival extends MoveableObject {
    public Rival(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact){
        super(window, posX, posY, generalSize, width, height, health, isIntact);
    }

//  Bewegungen
    public void verticalMove(){
    }

    public void diagonalMove(){
    }

    public void horizontalMove(){
    }

    public void persistentMove(){
    }

    public void zigzagMove(){
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
