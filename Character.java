package pckg1;

abstract class Character {

	private int xPos;
	private int yPos;
	private char symbol;
	private int lebensPunkte;
	private Weapon[] weapon;
	
	public Character() {
		
	}

	public Character(int lebensPunkte, char symbol, int yPos, int xPos) {
		
		this.setLebensPunkte(lebensPunkte);
		this.setSymbol(symbol);
		this.setXPos(xPos);
		this.setYPos(yPos);
		
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
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getLebensPunkte() {
		return this.lebensPunkte;
	}
	
	public String toString() {
		String life = "";
        for (int i = 0; i < this.getLebensPunkte(); i++) {
			life = life + " " + symbol;
        }
		
		switch (symbol) {
			case 'O':
				return "Leben des Helden:  " + life;
			case 'X':
				return "Leben des Drachen: " + life;
		}
		
		return "";
	}
	
	
	
}