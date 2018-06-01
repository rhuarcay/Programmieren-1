package pckg1;

public class Dragon extends Character {
	
	public Dragon() {
		
	}
	
	public Dragon(int lebensPunkte, char symbol, int xPos, int yPos) {
		
		super.setLebensPunkte(lebensPunkte);
		super.setSymbol(symbol);
		super.setXPos(xPos);
		super.setYPos(yPos);
	}

}