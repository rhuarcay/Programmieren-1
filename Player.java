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
	
	public boolean move(int x, int y){
		
		char direction = ' ';
        boolean validMove = false;
		
        while ((direction != 'w' && direction != 'a' && direction != 's' && direction != 'd' && direction != 'q') || !validMove) {
            System.out.println("w,a,s,d,q zur Bewegung nutzen. Bei q bleibt der Spieler, wo er ist.");
            direction = sc.next().toLowerCase().charAt(0); //Erstes Symbol einer Eingabe
            switch (direction) {
                case 'w':
                    if (isWalkable(this.getYPos() - 1, this.getXPos())) {
                        this.getYPos()--;
                        validMove = true;
                        break;
                    } else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
                case 's':
                    if (isWalkable(this.getYPos() + 1, this.getXPos())) {
                        this.getYPos()++;
                        validMove = true;
                        break;
                    } else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
                case 'a':
                    if (isWalkable(this.getYPos(), this.getXPos() - 1)) {
                        this.getXPos()--;
                        validMove = true;
                        break;
                    } else {
                        System.out.println("Hierhin kann man nicht gehen.");
                        break;
                    }
                case 'd':
                    if (isWalkable(this.getYPos(), this.getXPos() + 1)) {
                        this.getXPos()++;
                        validMove = true;
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