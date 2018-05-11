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
     * @param args Länge des Feldes, Breite des Feldes
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String[] sParam = args;
		if (sParam.length != 2) {
				System.out.println("Sie haben eine fehlerhafte anzahl an Parameter eingegeben \nDas Programm wird abgebrochen");
				System.exit(1);
		}
			
		int feldWide = 0; // Variable für die Breite des Feldes
		int feldLength = 0; // Variable für die Länge des Feldes
		int playerLength = 0;// Variable für die Start-Pos des Helden
		int playerWide = 0;
		int dragonLength = 0; // Variable für die Start-Pos des Drachen
		int dragonWide = 0;
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
			System.out.println("Der Kampf beginnt");
			playerLength = feldLength-feldLength+1;
			playerWide = feldWide/2;
			dragonLength = feldLength-1;
			dragonWide = feldWide/2;
			arenaC = new char [feldLength][feldWide];
			drawArena(arenaC, playerLength, playerWide, dragonLength, dragonWide);
		} else {
			System.out.println("Bitte überprüfen Sie die Parameter nochmal \nDie Parameter sollen gleich sein,  >= 9 sein \nund sollen ungerade sein");
			System.exit(3);
		}
		
		while (true) {
			char way = dir();
			playerLength = playerLength + moveY(way);
			playerWide = playerWide + moveX(way);
			if (walkable(feldLength, feldWide, playerLength, playerWide, dragonLength, dragonWide) == false) {
				playerLength = playerLength - moveY(way);
				playerWide = playerWide - moveX(way);
				continue;
			} else {
				break;
			}
		} 
		drawArena(arenaC, playerLength, playerWide, dragonLength, dragonWide);
		int distance = distance(playerLength, playerWide, dragonLength, dragonWide)-1;
		
		String t = "\u2665"; //Herz
        int player = 12; //Leben des Helds
        int dragon = 6; //Leben des Drachen

		int counter = 0; //Anzahl an durchgänge
		
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
			
			if (counter >0) {
				while (true) {
					char way = dir();
					playerLength = playerLength + moveY(way);
					playerWide = playerWide + moveX(way);
					if (walkable(feldLength, feldWide, playerLength, playerWide, dragonLength, dragonWide) == false) {
						playerLength = playerLength - moveY(way);
						playerWide = playerWide - moveX(way);
						continue;
					} else {
						break;
					}
				} 
				drawArena(arenaC, playerLength, playerWide, dragonLength, dragonWide);
				distance = distance(playerLength, playerWide, dragonLength, dragonWide)-1;
			}
			
			
            int waffe = 0;
            
			if (distance == 1) {
				
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
			} else {
				while (waffe != 1) {
					System.out.println("Der Held kann mit Pfeil und Bow (1)");
					waffe = sc.nextInt();
				}
					if (distance > 6) {
						distance = 6;
					}
					playerATK = 5 - distance/5; //Der Spieler wird stärker
					weaponOffset = 70 + distance; //Dafür sinkt seine Genauigkeit
			
				
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
			counter++;
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
	
	public static void drawArena(char[][] arena, int playerL, int playerW, int dragonL, int dragonW) {
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
						if (i==playerL && j==playerW) {
							arena[i][j] = 'P';
							System.out.print(arena[i][j]);
						} else if (i==dragonL-1 && j==dragonW) {
							arena[i][j] = 'D';
							System.out.print(arena[i][j]);
						} else {
							System.out.print(" ");	
					}	}
					
					
				}
			}
			System.out.print("\n");
		}
		
	
	}
	
	public static int moveX(char way) {
		int xAchse = 0;
				
		switch (way) {
			case 'w':
				xAchse = 0; //foward
				break;
			case 'a':
				xAchse = - 1; //left
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
	
	public static char dir() {
		char way;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("w, a, s, d, q zur Bewegung nutzen. Bei q bleibt der Spieler, wo er ist.");
			way = sc.next().charAt(0);
		} while (way != 'w' && way != 'a' && way != 's' && way != 'd' && way != 'q');
		return way;
	}
	
	public static boolean walkable(int fL, int fW, int pL, int pW, int dL, int dW) { //pl PlayerLenght, pw.... fL FeldLenght ...... dL DragonLenght..
		if (pL == 0 || pL == fL-1) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else if (pW == 0 || pW == fW-1) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else if (pL == dL && pW == dW) {
			System.out.println("Die Bewegung ist nicht zulässig");
			return false;
		} else {
		return true;
		}	
	}	
	
	public static int distance(int pL, int pW, int dL, int dW){
		int distance = Math.abs((pL - dL) + (pW - dW));
		return distance;
	}
}
