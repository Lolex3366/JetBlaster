import processing.core.PApplet;

public class BasicRival extends Rival {
    public BasicRival(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact) {
        super(window, posX, posY, generalSize, width, height, health, isIntact);
    }


    @Override
    public void draw(){
        window.fill(0, 0, 255);
        window.rect(posX, posY, width, height);
    }
    @Override
    public void move(){
        posY += 3;
        //wenn nicht getroffen geht es einfach nach unten aus Bildschirm >> health auf 0 setzen damit tot
    }

    @Override
    public void collision(){
        //falls getroffen health abziehen >> wenn health unter 0 = tot von Rival
        //wenn tot aus Array löschen
    }
}
