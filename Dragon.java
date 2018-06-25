/**
 * Repräsentation des Drachen
 */
public class Dragon extends Character {

    /**
     * Erstellt einen neuen Drachen
     *
     * @param sizeX Feldgröße in x-Richtung
     * @param sizeY Feldgröße in y-Richtung
     */
    public Dragon(int sizeX, int sizeY) {
        x = sizeX / 2;
        y = sizeY - 2;
        hp = 25;
        symbol = 'D';
        weapons = new Weapon[]{new Fire(), new DracoMeteor()}; //Nur Feuer als Waffe
    }
}
