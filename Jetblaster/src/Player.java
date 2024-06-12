import processing.core.PApplet;

public class Player extends MoveableObject {
    int angle; //Spieler winkel hin her

    public Player(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact) {
        super(window, posX, posY, generalSize, width, height, health, isIntact);
    }


    @Override
    public void draw() {
        angle = (window.mouseX - window.pmouseX) / 2; //Ist für den Winkel zuständig, wenn hin und her lenken

        window.pushMatrix(); // Speichere aktuellen Zustand der Transformationen
        window.translate(posX, posY); //Ursprung des Koordinatensystems zur Maus
        window.rotate(PApplet.radians((float) angle)); // Rotiere Koordinatensystem um angle

        window.strokeWeight(1 * generalSize);
        window.stroke(10);
        window.fill(130);

        //Plane
        //Rechte Riffle
        window.beginShape();
        window.vertex((generalSize * 20), (generalSize * 15));
        window.vertex((generalSize * 24), (generalSize * 15));
        window.vertex((generalSize * 24), -(generalSize * 20));
        window.vertex((generalSize * 22), -(generalSize * 25));
        window.vertex((generalSize * 20), -(generalSize * 20));
        window.endShape(PApplet.CLOSE);

        //Linke Riffle
        window.beginShape();
        window.vertex(-(generalSize * 20), (generalSize * 15));
        window.vertex(-(generalSize * 24), (generalSize * 15));
        window.vertex(-(generalSize * 24), -(generalSize * 20));
        window.vertex(-(generalSize * 22), -(generalSize * 25));
        window.vertex(-(generalSize * 20), -(generalSize * 20));
        window.endShape(PApplet.CLOSE);

        //Wings
        window.beginShape();
        window.vertex(0, (generalSize * 10));
        window.vertex((generalSize * 50), (generalSize * 5));
        window.vertex((generalSize * 50), 0);
        window.vertex(0, -(generalSize * 20));
        window.vertex(-(generalSize * 50), 0);
        window.vertex(-(generalSize * 50), (generalSize * 5));
        window.endShape(PApplet.CLOSE);
        window.rectMode(window.CENTER); //"Endkappen"
        window.rect(-(generalSize * 50), 0, (generalSize * 4), (generalSize * 10));
        window.rect((generalSize * 50), 0, (generalSize * 4), (generalSize * 10));

        //Long Body
        window.beginShape();
        window.vertex(0, (generalSize * 20));
        window.vertex((generalSize * 5), (generalSize * 15));
        window.vertex((generalSize * 5), -(generalSize * 30));
        window.vertex(0, -(generalSize * 40));
        window.vertex(-(generalSize * 5), -(generalSize * 30));
        window.vertex(-(generalSize * 5), (generalSize * 15));
        window.endShape(PApplet.CLOSE);

        window.popMatrix(); //vorherigen Zustand der Transformationen
    }


    @Override
    public void move() {
        posX = window.mouseX; // Spieler der Maus folgen lassen
        posY = window.mouseY;
    }

    @Override
    public void collision() {
        if (posX <= 0 || posX >= width || posY <= 0 || posY >= height) {
            health -= health / 3;

            if (health <= 0) {
                isIntact = false;
                //DeathScreen = true
            }
        }
        //Wenn Spieler einen Rival berührt, Leben abgezogen
        // Setze boolean für Deathscreen auf true
        //statistiken speichern
    }
}
