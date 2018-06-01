package pckg1;

abstract class Character {

	private int xPos;
	private int yPos;
	private char symbol;
	private int lebensPunkte;
	private Weapon[] weapon;
	
	public Character(int lp, char symbol) {
		this.setLebensPunkte(lp);
		this.setSymbol(symbol);
	}
	
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public void setLebensPunkte(int lebensPunkte) {
		this.lebensPunkte = lebensPunkte;
	}
	
	public int getLebensPunkte() {
		return this.lebensPunkte;
	}
	public String toString() {
		return xPos + " " + yPos + " " + symbol + " " + lebensPunkte;
	}
	
	
	
}