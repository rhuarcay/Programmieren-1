package pckg1;

import java.util.Scanner;

public class Player extends Character {
	
	static Scanner sc = new Scanner(System.in);
	private Arena arena;
	
	public Player() {
		
	}
	
	public Player(int lebensPunkte, char symbol, int yPos, int xPos) {
		
		super.setLebensPunkte(lebensPunkte);
		super.setSymbol(symbol);
		super.setXPos(xPos);
		super.setYPos(yPos);
	}
	
	public void move(Arena arena) {
		this.arena = arena;
		char direction = ' ';
		boolean validMove = false;
		while ((direction != 'w' && direction != 'a' && direction != 's' && direction != 'd' && direction != 'q') || !validMove) {
			System.out.println("w,a,s,d,q zur Bewegung nutzen. Bei q bleibt der Spieler, wo er ist.");
			direction = sc.next().toLowerCase().charAt(0); //Erstes Symbol einer Eingabe
			switch (direction) {
				case 'w':
					if (arena.walkable(this.getYPos() - 1 ,this.getXPos())) {
						this.setYPos(this.getYPos() - 1);
						validMove = true;
						//System.out.println(this.getYPos() + " " + this.getXPos());
						break;
					} else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
				case 's':
					if (arena.walkable(this.getYPos() + 1 ,this.getXPos())) {
						this.setYPos(this.getYPos() + 1);
						validMove = true;
						//System.out.println(this.getYPos() + " " + this.getXPos());
						break;
					} else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
				case 'a':
					if (arena.walkable(this.getYPos(),this.getXPos() - 1)) {
						this.setXPos(this.getXPos() - 1);
						validMove = true;
						//System.out.println(this.getYPos() + " " + this.getXPos());
						break;
					} else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
				case 'd':
					if (arena.walkable(this.getYPos(),this.getXPos() + 1)) {
						this.setXPos(this.getXPos() + 1);
						validMove = true;
						//System.out.println(this.getYPos() + " " + this.getXPos());
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

	}
	
	
}