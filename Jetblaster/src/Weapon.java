import processing.core.PApplet;

public class Weapon extends MoveableObject {

    float projectileSpeed;
    int damage;
    Fenster window;

    public Weapon(PApplet window, float posX, float posY, float generalSize, float width, float height, float health, boolean isIntact, float projectileSpeed, int damage) {
        super(window, posX, posY, generalSize, width, height, health, isIntact);
        this.projectileSpeed = projectileSpeed;
        this.damage = damage;
        this.window = (Fenster) window;
    }

    @Override
    public void draw() {
        window.rectMode(window.CENTER);
        window.fill(0, 255, 0); // Grün als Farbe für das Projektil
        window.rect(posX, posY, width, height); // Zeichne ein grünes Rechteck als Waffe
    }

    @Override
    public void move() {

        // Bewege jedes Projektil nach oben
        for (DrawableObject obj : window.drawableObjects) {
            obj.posY -= projectileSpeed;
        }
    }

    @Override
    public void collision() {
        //Wenn rival getroffen setzt isIntact auf false, bzw lösche das Objekt aus Array
    }

    public void fireProjectile(Player player) {
        // Erzeuge ein neues Projektil aus der Position des Spielers und füge es zur Liste hinzu
        window.drawableObjects.add(new Weapon(window, player.posX, player.posY, 1, 5, 10, 1, true, projectileSpeed, damage));
    }

    public void powerUpFaster(){
        //der Abstand wie die Projectiles abgefeuert werden wird kleiner (mehr ammo)
    }
    public void powerUpBigger(){
        //Die Projektile werden dicker, oder es fliegen zusätzlich projectile zur seite Raus(weiß aber nicht wie geil für Leistung, wenn so viele)
    }
}
