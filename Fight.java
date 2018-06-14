import java.util.Scanner;

/**
 * Erweiterung des Drachenkampfes um eine Map und die Bewegung des Spielers
 */
public class Fight {
    /**
     * Globaler Scanner für alle, die ihn brauchen
     */
    public static final Scanner sc = new Scanner(System.in);

    /**
     * Hier startet das Programm
     *
     * @param args Programmparameter, Größe des Feldes
     */
    public static void main(String[] args) {
        String t = "\u2665"; //Herz
        Arena arena = new Arena(args);
		
		Katapult katapult = new Katapult();
		MeteorSchauer meteor = new MeteorSchauer();
		
		System.out.println(katapult.spendAmmo());
		
        System.out.println("Der Kampf beginnt");

        Player player = arena.getPlayer();
        Dragon dragon = arena.getDragon();

        while (true) {
            System.out.println(arena);

            char direction = ' ';
            boolean validMove = false;
            while ((direction != 'w' && direction != 'a' && direction != 's' && direction != 'd' && direction != 'q') || !validMove) {
                System.out.println("w,a,s,d,q zur Bewegung nutzen. Bei q bleibt der Spieler, wo er ist.");
                direction = sc.next().toLowerCase().charAt(0); //Erstes Symbol einer Eingabe
                switch (direction) {
                    case 'w':
                        if (arena.walkable(player.getY() - 1, player.getX())) { //Ist der Ort begehbar
                            player.move(-1, 0); //Dann geh.
                            validMove = true; //Das war ein gültiger Zug
                            break;
                        } else {
                            System.out.println("Hierhin kann man nicht gehen.");
                            break;
                        }
                    case 's':
                        if (arena.walkable(player.getY() + 1, player.getX())) {
                            player.move(1, 0);
                            validMove = true;
                            break;
                        } else {
                            System.out.println("Hierhin kann man nicht gehen.");
                            break;
                        }
                    case 'a':
                        if (arena.walkable(player.getY(), player.getX() - 1)) {
                            player.move(0, -1);
                            validMove = true;
                            break;
                        } else {
                            System.out.println("Hierhin kann man nicht gehen.");
                            break;
                        }
                    case 'd':
                        if (arena.walkable(player.getY(), player.getX() + 1)) {
                            player.move(0, 1);
                            validMove = true;
                            break;
                        } else {
                            System.out.println("Hierhin kann man nicht gehen.");
                            break;
                        }
                    case 'q':
                        validMove = true;
                        break;
                }
            }

            System.out.println(arena);
            System.out.println(player); //Ausgabe der Lebenspunkte
            System.out.println(dragon);

            int waffe = 0; //Waffenauswahl
            while (waffe != 1 && waffe != 2) {
                System.out.println("Der Held kann mit Pfeil und Bow (1) oder mit dem Sword (2) angreifen.");
                waffe = sc.nextInt();
            }
            //Nutze die Waffe an Stelle -1, da 1. Element im Array Index 0 hat
            if (player.attack(dragon, player.getWeapons()[waffe - 1], arena.distance(player, dragon))) { 
                System.out.println("Der Drache wurde getroffen.");
            } else {
                System.out.println("Der Drache wurde verfehlt.");
            }
            if (!dragon.isAlive()) { //Wurde der Drache besiegt
                System.out.println("Der Drache wurde besiegt. Hurra.");
                break;
            }

            if (dragon.attack(player, dragon.getWeapons()[0], arena.distance(player, dragon))) { //Er benutzt stets sein Feuer
                System.out.println("Der Held wurde verletzt.");
            } else {
                System.out.println("Der Drache hatte eine Fehlzündung. Glück gehabt.");
            }
            if (!player.isAlive()) { //Wurde der Held besiegt
                System.out.println("Der Held wurde besiegt. Oh nein.");
                break;
            }

            System.out.println(player); //Ausgabe der Lebenspunkte
            System.out.println(dragon);
        }
    }

}
