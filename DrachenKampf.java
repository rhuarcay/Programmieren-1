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
        String[] sParam = args;
		if (sParam.length != 2) {
				System.out.println("Sie haben eine fehlerhafte anzahl an Parameter eingegeben \nDas Programm wird abgebrochen");
				System.exit(1);
			}
			
			int feldWide = 0; // Variable für die Breite des Feldes
			int feldLength = 0; // Variable für die Länge des Feldes
			int [][] playerPos = new int [0][0]; // Variable für die Start-Pos des Helden
			int [][] dragonPos = new int [0][0]; // Variable für die Start-Pos des Drachen
			char [][] arenaC = new char [0][0];
			
			if (isInterger(sParam[0]) && isInterger(sParam[1])) {
				feldWide = Integer.parseInt(sParam[0]);
				feldLength = Integer.parseInt(sParam[1]);
				//System.out.println(feldWide + "" + feldLength + "Wurden in Int umgewandelt");
			} else {
				System.out.println("Sie haben eine nicht güiltige Parameter eingegeben \nBitte geben Sie nur Zahlen als Parameter ein");
				System.exit(2);
			}
			
			if (feldLength == feldWide && feldLength >= 9 && feldLength % 2 != 0) {
				playerPos = new int [feldLength/2][1];
				dragonPos = new int [feldLength/2][feldWide-1];
				arenaC = new char [feldLength][feldWide];
				drawArena(arenaC);
			} else {
				System.out.println("Bitte überprüfen Sie die Parameter nochmal \nDie Parameter sollen gleich sein,  >= 9 sein \nund sollen ungerade sein");
			}
		
		String t = "\u2665"; //Herz
        int player = 12; //Leben des Helds
        int dragon = 6; //Leben des Drachen

        Scanner sc = new Scanner(System.in);
		
		
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
	
	public static boolean isInterger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void drawArena(char[][] arena) {
		for (int i = 0; i < arena.length; i++) {
			for (int j = 0; j < arena.length; j++) {
				arena[i][j] = '#';
				if (i==0) {
					System.out.print(arena[i][j]);
				} else if (i==arena.length-1) {
					System.out.print(arena[i][j]);
				} else {
					if (j ==0) {
						System.out.print(arena[i][j]);
					} else if (j==arena.length-1) {
						System.out.print(arena[i][j]);
					} else {
						System.out.print(" ");
					}
					
				}
			}
			System.out.print("\n");
		}
	}
	
}
