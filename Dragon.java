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
		//MeteorSchauer meteor = new MeteorSchauer();
        weapons = new Weapon[]{new Fire()}; //Nur Feuer als Waffe
    }
}
