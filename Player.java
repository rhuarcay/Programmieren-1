package pckg1;

public class Player extends Character {
	
	public Player() {
		
	}
	
	public Player(int lebensPunkte, char symbol, int xPos, int yPos) {
		
		super.setLebensPunkte(lebensPunkte);
		super.setSymbol(symbol);
		super.setXPos(xPos);
		super.setYPos(yPos);
	}
}