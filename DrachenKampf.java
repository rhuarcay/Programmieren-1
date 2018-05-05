import java.util.Scanner;

/**
 * Repräsentation des Kampfes zwischen Gut und Böse
 * Held gegen Drache
 */
public class DrachenKampf {

    /**
     * Hier startet das Programm
     *
     * @param args Bisher keine
     */
    public static void main(String[] args) {
        String t = "\u2665"; //Herz
        int player = 12; //Leben des Helds
        int dragon = 6; //Leben des Drachen

        Scanner sc = new Scanner(System.in);

        System.out.println("Der Kampf beginnt");

        while (true) {
            int playerATK = 3; //Angriff des Spielers, jedesmal zurückgesetzt
            int dragonATK = 4; //Angriff des Drachen
            int weaponOffset = 50; //Trefferwahrscheinlichkeit des Spielers
            int dragonOffset = 50; //Trefferwahrscheinlichkeit des Drachen

            System.out.print("Leben des Helden : ");
            for (int i = 0; i < player; i++) {
                System.out.print("O ");
            }
            System.out.println("");

            System.out.print("Leben des Drachen: ");
            for (int i = 0; i < dragon; i++) {
                System.out.print("X "); //Lebenspunkte als X darstellen
            }
            System.out.println("\n");

            int waffe = 0;
            while (waffe != 1 && waffe != 2) {
                System.out.println("Der Held kann mit Pfeil und Bow (1) oder mit dem Sword (2) angreifen.");
                waffe = sc.nextInt();
            }

            if (waffe == 1) { //Pfeil und Bow
                playerATK = 5; //Der Spieler wird stärker
                weaponOffset = 70; //Dafür sinkt seine Genauigkeit
            } else if (waffe == 2) { //Schwert
                playerATK = 3; //Schächer
                weaponOffset = 50; //Aber genauer
            }

            int playerHitRate = (int) (Math.random() * 100);
            if (playerHitRate > weaponOffset) {
                System.out.println("Der Drache wurde getroffen.");
                dragon -= playerATK;
            } else {
                System.out.println("Der Drache wurde verfehlt.");
            }
            if (dragon <= 0) {
                System.out.println("Der Drache wurde besiegt. Hurra.");
                break;
            }

            int dragonHitRate = (int) (Math.random() * 100);
            if (dragonHitRate > dragonOffset) { //Der Drache triffft
                System.out.println("Der Held wurde verletzt.");
                player -= dragonATK;
            } else {
                System.out.println("Der Drache hatte eine Fehlzündung. Glück gehabt.");
            }
            if (player <= 0) {
                System.out.println("Der Held wurde besiegt. Oh nein.");
                break;
            }
        }
    }
}
