/**
 * Ein Charakter kann sowohl ein Spieler, als auch ein Drache sein
 */
public abstract class Character {
    /**
     * Koordinaten des Charakters
     */
    protected int x, y;

    /**
     * Lebenspunkte
     */
    protected int hp;

    /**
     * Waffe
     */
    protected Weapon[] weapons;

    /**
     * X oder O
     */
    protected char symbol;

    /**
     * Gibt Lebenspunkte als formartierten String zurück
     *
     * @return Lebenspunkte
     */
    @Override
    public String toString() {
        String result = "";
        result += ("Leben des " + this.getClass().getSimpleName() + " : ");
        for (int i = 0; i < hp; i++) {
            result += (symbol + " ");
        }
        result += "\n";
        return result;
    }

    /**
     * x-Koordintae
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * y-Koordinate
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * this greift einen Charakter an
     * @param enemy Feind
     * @param weapon Welche Waffe nutzt der Angreifer (this)
     * @param distance Abstand vom Angreifer zum Feind
     * @return Getroffen?
     */
    public boolean attack(Character enemy, Weapon weapon, int distance) {
        int hitRate = (int) (Math.random() * 100);
        System.out.println(hitRate + " " + distance + " " + weapon.calculateOffset(distance));
        if (hitRate > weapon.calculateOffset(distance)) {
            enemy.setHP(enemy.getHP() - weapon.getATK());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gibt charakteristisches Symbol des Charakters zurück
     * @return D für Dragon, P für Spieler
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Gibt alles Waffen des Charakters zurück
     * @return Waffenarray
     */
    public Weapon[] getWeapons() {
        return weapons;
    }

    /**
     * Lebt dieser Charakter noch?
     * @return Lebt er noch?
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * Gibt Lebenspunkte des Charakters zurück
     * @return Lebenspunkte
     */
    public int getHP() {
        return hp;
    }

    /**
     * Setzt Lebenspunkte auf übergebenen Wert
     * @param hp Neue Lebenspunkte
     */
    public void setHP(int hp) {
        this.hp = hp;
    }
}
