/**
 * Repräsentiert den Bogen
 */
public class Bow extends Weapon {
    /**
     * Erstellt einen neuen Bogen
     */
    public Bow() {
        this.setATK(1);
        this.setOffset(0);
    }

    /**
     * Berechnet den Offset für den Bogen an Hand des Abstandes vom Schützen zum Ziel
     *
     * @param distance Wie weit ist das Ziel entfernt
     * @return Offset. Je höher, desto schwieriger wird es, dass eine Zufallszahl diesen übertrifft
     */
    @Override
    public int calculateOffset(int distance) {
        this.setOffset( (distance * 10)); //Je weiter entfernt, desto schlechter trifft der Bogen
        return this.getOffset();
    }
}
