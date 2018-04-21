import java.util.Scanner;

public class Drachenkampf {
	public static void main(String[] args){
		//Methode um ein neues Scanner hinzuzufügen
		Scanner s = new Scanner(System.in);
		
		int heroLife = 10;
		int dragonLife = 15;
		
		// Mit Hilfe von new char und replace wird das Leben des Helden bzw. des Drachen von int auf String umgewandelt
		String heroLifeO = new String(new char [heroLife]).replace("\0", "O ");		// new char has a dafault value 0 oder \u0000 oder \0
		String dragonLifeX = new String(new char [dragonLife]).replace("\0", "X "); 
		System.out.println("");
		System.out.println("Der Kamfp beginnt");
		System.out.println("Leben des Helden	:" + heroLifeO);	// Leben des Heldes ausgegeben
		System.out.println("Leben des Drachen	:" + dragonLifeX);	// Leben des Drachen ausgegeben
		
		// Angriffswerte zuweisen:
		int powerPfeilBogen = 2;
		int powerSchwert = 1;
		int powerFeuer = 3;
		
		do {
		
	
		} while (heroLife > 0 && dragonLife > 0);
		


	}
}