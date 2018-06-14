/**
 * Repräsentation des Spielers
 * Erbt alle Eigenschaften des Characters
 */
public class Player extends Character {
    /**
     * Erstellt einen neuen Spieler mit Bogen und Schwert
     *
     * @param sizeX Größe des Spielfeldes in x-Richtung
     * @param sizeY Größe des Spielfeldes in y-Richtung
     */
    public Player(int sizeX, int sizeY) {
        x = sizeX / 2;
        y = 1;
        hp = 15;
        symbol = 'O';
        weapons = new Weapon[]{new Bow(), new Sword(), new Katapult()};
    }

    /**
     * Bewegung des Spielers
     * @param y Wie viel in y-Richtung
     * @param x Wie viel in x-Richtung
     */
    public void move(int y, int x) {
        this.x += x;
        this.y += y;
    }

}
