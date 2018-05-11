import java.util.Scanner;

/**
 *	Die Klasse DrachenKampf beginnt mit Eingabe des Lebens für Held und Drachen diese werden als X und O ausgegeben
 * 	Nach Angriffsauswahl wird Trefferwahrscheinlichekeit sowie Staerke der ausgewaehlten Waffe bestimmt
 * 	Nach Bestimmung des Parameters des Drachen beginnt der Kampf
 *	Held und Drache bekaempfen sich gegenseitig wobei der Held startet
 *	Erreicht ein Lebenswert der Charaktere 0 ist das Spiel vorbei
 *
 *	@author Rodrigo Huarcaya Alba 4919667 Gruppe 1b
 *	@author Moritz Richter 4931881 Gruppe 1b
 *
 *	@version Drachenspiel Version 2
 */
public class DrachenKampf {

    /**
     * Hier startet das Programm
     *
     * @param args Laenge des Feldes, Breite des Feldes
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String[] sParam = args;
		if (sParam.length != 2) {
			System.out.println("Sie haben eine fehlerhafte anzahl an Parameter eingegeben \nDas Programm wird abgebrochen");
			System.exit(1);
		}
			
		int feldWidth = 0; // Variable für die Breite des Feldes
		int feldLength = 0; // Variable für die Laenge des Feldes
		int playerLength = 0; // Variable für die Start-Pos des Helden
		int playerWidth	= 0;
		int dragonLength = 0; // Variable für die Start-Pos des Drachen
		int dragonWidth = 0;
		char[][] arenaC = new char[0][0];
		
		if (isInterger(sParam[0]) && isInterger(sParam[1])) {
			feldWidth = Integer.parseInt(sParam[0]);
			feldLength = Integer.parseInt(sParam[1]);
			//System.out.println(feldWidth + "" + feldLength + "Wurden in Int umgewandelt");
		} else {
			System.out.println("Sie haben einen nicht güiltigen Parameter eingegeben. \nBitte geben Sie nur Zahlen als Parameter ein");
			System.exit(2);
		}
		
		if (feldLength == feldWidth && feldLength >= 9 && feldLength % 2 != 0) { 
		//Laenge und Breite des Feldes sollen mindestens 9 betragen und ungerade sein
			System.out.println("Der Kampf beginnt");
			playerLength = feldLength - feldLength + 1; //Festelegung der Startposition des Helden
			playerWidth = feldWidth / 2;
			dragonLength = feldLength - 1; //Festelegung der Startposition des Drachen
			dragonWidth = feldWidth / 2;
			arenaC = new char[feldLength][feldWidth];
			drawArena(arenaC, playerLength, playerWidth, dragonLength, dragonWidth);
		} else {
			System.out.println("Bitte überprüfen Sie die Parameter nochmal \nDie Parameter sollen gleich sein, >= 9 sein");
			System.out.println("und sollen ungerade sein");
			System.exit(3);
		}
		
		while (true) {
			char way = dir();
			playerLength = playerLength + moveY(way);
			playerWidth = playerWidth + moveX(way);
			if (walkable(feldLength, feldWidth, playerLength, playerWidth, dragonLength, dragonWidth) == false) {
				playerLength = playerLength - moveY(way);
				playerWidth = playerWidth - moveX(way);
				continue;
			} else {
				break;
			}
		} 
		drawArena(arenaC, playerLength, playerWidth, dragonLength, dragonWidth);
		int distance = distance(playerLength, playerWidth, dragonLength, dragonWidth) - 1;
		
		String t = "\u2665"; //Herz
        int player = 12; //Leben des Helds
        int dragon = 6; //Leben des Drachen

		int counter = 0; //Anzahl der Durchgaenge
		
        while (true) {
            int playerATK = 3; //Angriff des Spielers, jedesmal zurückgesetzt
            int dragonATK = 4; //Angriff des Drachen
            int weaponOffset = 50; //Trefferwahrscheinlichkeit des Spielers
            int dragonOffset = 50; //Trefferwahrscheinlichkeit des Drachen

            System.out.print("Leben des Helden : ");
            for (int i = 0; i < player; i++) {
                System.out.print("O "); //Lebenspunkte als O darstellen
            }
            System.out.println("");

            System.out.print("Leben des Drachen: ");
            for (int i = 0; i < dragon; i++) {
                System.out.print("X "); //Lebenspunkte als X darstellen
            }
            System.out.println("\n");
			
			if (counter > 0) {
				while (true) {
					char way = dir(); //Paramater way wird benutzt um die Bewegung zu erstellen
					playerLength = playerLength + moveY(way);
					playerWidth = playerWidth + moveX(way);
					if (walkable(feldLength, feldWidth, playerLength, playerWidth, dragonLength, dragonWidth) == false) {
						//if walkable false dann wird die Bewegung zurueckgesetzt
						playerLength = playerLength - moveY(way);
						playerWidth = playerWidth - moveX(way);
						continue;
					} else {
						break;
					}
				} 
				drawArena(arenaC, playerLength, playerWidth, dragonLength, dragonWidth);
				distance = distance(playerLength, playerWidth, dragonLength, dragonWidth) - 1;
			}
			
			
            int waffe = 0;
            
			if (distance == 1) { //nur wenn die Distanz zum Drachen 1 ist kann das Schwert benutzt werden
				
				while (waffe != 1 && waffe != 2) {
					System.out.println("Der Held kann mit Pfeil und Bow (1) oder mit dem Sword (2) angreifen.");
					waffe = sc.nextInt();
				}

				if (waffe == 1) { //Pfeil und Bow
					playerATK = 5; //Der Held wird staerker
					weaponOffset = 70; //Dafuer sinkt seine Genauigkeit
				} else if (waffe == 2) { //Schwert
					playerATK = 3; //Schwaecher
					weaponOffset = 50; //Aber genauer
				}
			} else {
				while (waffe != 1) { //Angriff ist nur mit dem Bow moeglich
					System.out.println("Der Held kann mit Pfeil und Bow (1)");
					waffe = sc.nextInt();
				}
				if (distance > 6) { 
					distance = 6; //distance wird auf max 6 gesetzt
				}
				playerATK = 5 - distance / 5; //Der Held wird staerker
				weaponOffset = 70 + distance; //seine Genauigkeit sinkt	
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
            if (dragonHitRate > dragonOffset) { //Der Drache trifft
                System.out.println("Der Held wurde verletzt.");
                player -= dragonATK;
            } else {
                System.out.println("Der Drache hatte eine Fehlzündung. Glück gehabt.");
            }
            if (player <= 0) {
                System.out.println("Der Held wurde besiegt. Oh nein.");
                break;
            }
			counter++;
        }
    }
	/**
	* Fehleingaben werden gecatcht damit kein Fehler im Programm entsteht
	* @return gibt true oder false zurück
	* @param input variable für den check von Fehleingaben
	*/
	public static boolean isInterger(String input) { 
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	* Arena wird durch for-Schleife und Mehrdimensionalen Array erstellt
	* @param arena variable wird mit # und leerzeichen befüllt
	* @param playerL variable wird für Positionierung des Helden benötigt(x-Achse)
	* @param playerW (y-Achse)
	* @param dragonL variable wird für Positionierung des Drachen benötigt(x-Achse)
	* @param dragonW (y-Achse)
	*/
	public static void drawArena(char[][] arena, int playerL, int playerW, int dragonL, int dragonW) { 
		for (int i = 0; i < arena.length; i++) {
			for (int j = 0; j < arena.length; j++) {
				arena[i][j] = '#';
				if (i == 0) {
					System.out.print(arena[i][j]);
				} else if (i == arena.length - 1) {
					System.out.print(arena[i][j]);
				} else {
					if (j == 0) {
						System.out.print(arena[i][j]);
					} else if (j == arena.length - 1) {
						System.out.print(arena[i][j]);
					} else {
						if (i == playerL && j == playerW) { //Position des Helden festgelegt
							arena[i][j] = 'P';
							System.out.print(arena[i][j]);
						} else if (i == dragonL - 1 && j == dragonW) { // Position des Drachen festgelegt
							arena[i][j] = 'D';
							System.out.print(arena[i][j]);
						} else {
							System.out.print(" ");	
						}
					}					
				}
			}
			System.out.print("\n");
		}	
	}
	/**
	* Mit dem switch-case befehl werden die x-Achsen von W,A,S,D und Q definiert
	* @param way 
	* @return variable gibt die Bewegung auf der x-Achse zurück 
	*/
	public static int moveX(char way) {
		int xAchse = 0;
				
		switch (way) {
			case 'w':
				xAchse = 0; //foward
				break;
			case 'a':
				xAchse = -1; //left
				break;
			case 's':
				xAchse = 0; //backward
				break;
			case 'd':
				xAchse = 1; //right
				break;
			case 'q':
				xAchse = 0;
				break;
			default:
				System.out.println("Sie haben ein ungueltige Option gewaehlt");	
		}
		return xAchse;
	}
	/**
	* Mit dem switch-case Befehl werden die y-Achsen von W,A,S,D und Q definiert
	* @param way 
	* @return variable gibt die Bewegung auf der y-Achse zurueck 
	*/
	public static int moveY(char way) {
		int yAchse = 0;
		
		switch (way) {
			case 'w':
				yAchse = -1; //foward
				break;
			case 'a':
				yAchse = 0; //left
				break;
			case 's':
				yAchse = 1; //backward
				break;
			case 'd':
				yAchse = 0; //right
				break;
			case 'q':
				yAchse = 0;
				break;
			default:
				System.out.println("Sie haben ein ungueltige Option gewaehlt");	
		}
		return yAchse;
	}
	/** 
	* @return way variable gibt Eingabe W,A,S,D oder Q zurueck
	*/
	public static char dir() {
		char way;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("w, a, s, d, q zur Bewegung nutzen. Bei q bleibt der Spieler, wo er ist.");
			way = sc.next().charAt(0);
		} while (way != 'w' && way != 'a' && way != 's' && way != 'd' && way != 'q');
		return way;
	}
	/**
	* Methode zum definieren welche Felder betreten werden koennen
	* @param fL feldLength
	* @param fW feldWidth
	* @param pL playerLength
	* @param pW playerWidth
	* @param dL dragonLength
	* @param dW dragonWidth
	* @return false bei Feldern die nicht betreten werden sollen und true bei betretbaren Feldern
	*/
	public static boolean walkable(int fL, int fW, int pL, int pW, int dL, int dW) { 
		if (pL == 0 || pL == fL - 1) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else if (pW == 0 || pW == fW - 1) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else if (pL == dL - 1 && pW == dW) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else {
			return true;
		}	
	}	
	/**
	* @param pL playerLength
	* @param pW playerWidth
	* @param dL dragonLength
	* @param dW dragonWidth
	* @return distance variable Entfernung vom Drachen zum Helden 
	*/
	public static int distance(int pL, int pW, int dL, int dW) {
		int distance = Math.abs((pL - dL) + (pW - dW));
		return distance;
	}
}
