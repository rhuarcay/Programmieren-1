/**
 *	Probe für DrachenKampf
 */

public class Probe {
	public static void main(String[] args){
	
	String[] sParam = args;
	//System.out.println(sParam.length);
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