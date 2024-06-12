import processing.core.PApplet;
import java.util.ArrayList;

public class Fenster extends PApplet {

    ArrayList<DrawableObject> drawableObjects; // Deklarierung
    Player player; // Referenz auf den Spieler
    Weapon weapon; // Referenz auf die Waffe
    int lastProjectileTime; // Zeitstempel für das letzte abgefeuerte Projektil
    boolean isShooting; // Zustand für das Drücken der Leertaste

    @Override
    public void settings() {
        size(1080, 720);
    }

    @Override
    public void setup() {
        drawableObjects = new ArrayList<>(); // Initialisierung
        lastProjectileTime = millis(); // Initialisierung des Timers
        isShooting = false; // Initialisierung des Schießzustands


        //die dinger hier bisher nur temporär, müsste dann wahrscheinlich in Levelklasse in methode levelBuild (glaube ich, macht das sinn?)
        drawableObjects.add(new Player(this, 100, 100, 1, 60, 30, 100, true)); // Spieler zur Liste hinzufügen
        drawableObjects.add(new BasicRival(this, random(0, width), random(-height, 0), 1, 50, 50, 50, true));
        drawableObjects.add(new Weapon(this, 0, 0, 1, 5, 15, 1, true, 3, 10));
        weapon = (Weapon) drawableObjects.get(drawableObjects.size() - 1); // Letzte Waffe in der Liste als Referenz speichern



        //setze boolean für mainScreen auf true
        //setzt boolean für gameRunning auf false
        //setzt boolean für deathScreen auf false
    }


    @Override
    public void draw() {
        background(0, 0, 25);

        for (DrawableObject obj : drawableObjects) {
            obj.move();  // Bewege das Objekt
            obj.draw();  // Zeichne das Objekt
            obj.collision();  // Überprüfe auf Kollision
        }

        // Projektile nur abfeuern, wenn die Leertaste gedrückt wird oder die Maus geklickt wird
        if ((isShooting && millis() - lastProjectileTime >= 250) || (mousePressed && millis() - lastProjectileTime >= 100)) {
            weapon.fireProjectile((Player) drawableObjects.get(0)); // Den Spieler als Argument übergeben
            lastProjectileTime = millis(); // Timer zurücksetzen
        }

        // Entferne Projektile, die den Bildschirm verlassen haben
        drawableObjects.removeIf(obj -> obj instanceof Weapon && obj.posY < 0);

        System.out.println(drawableObjects);

    }


    @Override
    public void keyPressed() {
        if (key == ' ') {
            isShooting = true;
        }
    }

    @Override
    public void keyReleased() {
        if (key == ' ') {
            isShooting = false;
        }
    }
}
