/**
 * Allgemeine Waffe
 * Abstrakt, da es nur spezielle Waffen geben darf
 */
public abstract class Weapon {
    /**
     * Offset der Waffe.
     * Je höher, desto weniger wahrscheinlich ist es, dass diese Waffe trifft.
     */
    protected int offset;

    /**
     * Angriff der Waffe
     * Der Feind verliert so viele Lebenspunkte, wie die Waffe ATK hat, wenn sie trifft
     */
    protected int atk;

    /**
     * Standardkonstruktor für neue Waffen.
     * Es gibt keine Waffe vom Typ Weapon!
     */
    public Weapon() {
        this.atk = 3;
        this.offset = 60;
    }

    /**
     * Gibt den Offset der Waffe zurück
     *
     * @param distance Abstand zum Ziel
     * @return Offset
     */
    public int calculateOffset(int distance) {
        return offset;
    }

    /**
     * Gibt ATK Wert zurück
     * @return ATK
     */
    public int getATK() {
        return atk;
    }
	
	public void setATK(int atk){
		this.atk = atk;
	}
}
