/**
 *	Hier Klassenkommentar schreiben:
 *	Es soll die Klasse beschrieben.
 *
 *	@author Rodrigo Huarcaya Alba Y0091437
 *	@author Moritz
 *
 *	@version Drachenspiels Version 1
 *	
 */

 

import java.util.Scanner;

public class Drachenkampf_F_ {
	public static void main(String[] args) {
		/**
		 *	@param heroLife: 	Leben des Heros
		 *	@param dragonLife: 	Leben des Drachen
		 *	@param powerPfeilBogen, powerSchwert, powerFeuer:	Angreifschaden der Waffen
		 *	@param weaponChoice: Auswahl zwischen Waffen 
		 *	@param heroRandomNum:	Zufalls generator für die Angriefswahrscheinlichkeit
		 *
		 *
		 *	@return heroAttackPower: Angriefschaden nach Waffen auswahl
		 *	@return heroAttackChance: Hero Angriefserfolgswahrscheinlichkeit nach Waffen auswahl
		 *	@return heroLife, dragonLife: Falls ein Angreif Erfolgreich war, reduzierte Leben wiedergeben
		 */
		//Methode um ein neues Scanner hinzuzufügen
		Scanner s = new Scanner(System.in);
		
		int heroLife = 10;
		int dragonLife = 15;
		
		// Mit Hilfe von new char und replace wird das Leben des Helden bzw. des Drachen von int auf String umgewandelt
		String heroLifeO = new String(new char[heroLife]).replace("\0", "O ");		// new char has a dafault value 0 oder \u0000 oder \0
		String dragonLifeX = new String(new char[dragonLife]).replace("\0", "X "); 
		System.out.println("");
		System.out.println("Der Kamfp beginnt");
		System.out.println("Leben des Helden	:" + heroLifeO);	// Leben des Heldes ausgegeben
		System.out.println("Leben des Drachen	:" + dragonLifeX);	// Leben des Drachen ausgegeben
		
		// Angriffswerte zuweisen:
		int powerPfeilBogen = 2;
		int powerSchwert = 1;
		int powerFeuer = 3;
		
		do {
			System.out.println("");
			System.out.println("Der Hedl kann mit Pfeil und Bogen (1) oder mit dem Schwert (2) angreifen.");
			int weaponChoice = s.nextInt(); //(1) Für Pfeil und Bogen/(2) für Schwert
			// Paramater des Helden werden erzeugt bzw. berechnet
			int heroAttackPower = 0;
			int heroRandomNum = (int) (Math.random() * 10);
			int heroAttackChance = 0;
			
			switch (weaponChoice) {
				//Pfeil wurde ausgewählt
				case 1:	
					heroAttackPower = powerPfeilBogen;
					heroAttackChance = 5;
					System.out.println(heroAttackChance);
					break;
				case 2:
					//Schwert wurde ausgewählt
					heroAttackPower = powerSchwert;
					heroAttackChance = 3;
					System.out.println(heroAttackChance);
					break;
				default:
					System.out.println("Sie haben eine ungueltige Option gewaehlt");
			}
			
			// Parameter des Drachen werden erzeugt bzw. berechnet
			int dragonAttackPower = powerFeuer;
			int dragonRandomNum = (int) (Math.random() * 10);
			int dragonAttackChance = 4;
			/*Bis Hier werden alle Parameter für den Held und den Drachen berechnet
			--------------------------*/
			//Als erstes greift der Held an
			if (heroRandomNum > heroAttackChance) {
				System.out.println("Der Drache wurde getroffen");
				dragonLife = dragonLife - heroAttackPower;
			} else {
				System.out.println("Der Drache wurde verfehlt");
			}
			
			if (dragonLife <= 0) {
				break;				//Falls der Drache vorher getötet wird, darf er nicht mehr angreifen
			}
			
			//Jetzt greift der Drache an
			if (dragonRandomNum > dragonAttackChance) {
				System.out.println("Der Held wurde verletzt");
				heroLife = heroLife - dragonAttackPower;
			} else {
				System.out.println("Der Drache hatte eine Fehlzuendung. Glueck gehabt");
			}
			
			if (dragonLife >= 0 && heroLife >= 0) {
				heroLifeO = new String(new char[heroLife]).replace("\0", "O ");
				dragonLifeX = new String(new char[dragonLife]).replace("\0", "X ");
				System.out.println("Leben des Helden	:" + heroLifeO);	// Leben des Heldes ausgegeben
				System.out.println("Leben des Drachen	:" + dragonLifeX);	// Leben des Drachen ausgegeben
			}
	
		} while (heroLife > 0 && dragonLife > 0);
		
		if (dragonLife <= 0) {
			System.out.println("Der Drache wurde besiegt. Hurra.");
		} else {
			System.out.println("Der Held wurde besiegt. Buh.");
		}

	}
}