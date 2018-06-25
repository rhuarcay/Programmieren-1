public interface SpecialWeaponInterface {
    /**
     * Beide Waffen, das Katapult, sowie der Meteorschauer können nur solange eingesetzt werden,
     * solange der Vorrat an Munition beider Waffen nicht aufgebraucht ist.
     * Das bedeutet, dass jede SpecialWeapon eine Variable für die Speicherung der Munition besitzen soll.
     * Diese Methode sorgt also nur dafür, dass der Wert dieser Variablen verändert wird.
     * @return Ist noch ausreichend Munition vorhanden, um die Waffe einzusetzen
     */
    boolean spendAmmunition();

    /**
     * Trifft die Spezialwaffe, soll an einer zufälligen Stelle in einem bestimmten Radius um das Ziel herum
     * der Meteor oder Katapultstein landen und eine neue Wand erscheinen. Ist an der per Zufall ausgewählten Position
     * bereits eine Wand, soll diese zerstört werden.
     * Diese Methode gibt zurück, wie viele dieser Steine eine Waffe gleichzeitig schleudern soll.
     * @return Wie viele Steine werden gleichzeitig geworfen
     */
    int arealDamage();

    /**
     * Diese Methode gibt den Radius, in der die Waffe wirken (Steine erscheinen und zerstören) soll zurück
     * @return Wirkungsradius der Spezialwaffe
     */
    int getRadius();

    /**
     * Gibt zurück, wie oft noch geladen werden muss
     *
     * @return Wie viel muss noch geladen werden, bis die Waffe feuerbereit ist.
     */
    int getLoadStatus();

    /**
     * Lädt die Waffe weiter auf.
     * Überschreitet die Aufladung eine festgelegte konstante Schwelle, kann die Waffe treffen
     */
    boolean load();
}
