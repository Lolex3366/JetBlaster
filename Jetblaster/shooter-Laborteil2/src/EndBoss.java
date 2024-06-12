import processing.core.PApplet;

public class EndBoss extends Rival {
    public EndBoss(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact) {
        super(window, posX, posY, generalSize, width, height, health, isIntact);
    }

    @Override
    public void draw(){
            window.fill(255, 0, 0);
            window.rect(posX, posY, width, height);
    }
    @Override
    public void move(){
        //
    }
}
