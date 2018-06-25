/**
 * Repräsentiert die Waffe Schwert
 * Das Schwert hat deutlich mehr ATK als der Bogen
 * trifft dafür aber auch nur in unmittelbarer Nähe zum Drachen
 */
public class Sword extends Weapon {
    /**
     * Erstellt ein neues Schwert
     */
    public Sword() {
        this.atk = 3;
        this.offset = 0;
    }

    /**
     * Berechnet den Offset der Waffe
     * Also die Wahrscheinlichkeit zu treffen
     *
     * @param distance Abstand zum Ziel muss genau 1 sein
     * @return Trifft das Schwert
     */
    @Override
    public int calculateOffset(int distance) {
        if (distance == 1) this.offset = 0; //Trifft immer
        else { //Zu weit entfernt
            System.out.println("Für den Einsatz des Schwertes ist der Held zu weit vom Drachen entfernt.");
            this.offset = 100; //Attacke geht immer daneben
        }
        return this.offset;
    }
}
