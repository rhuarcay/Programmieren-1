package pckg1;

public class Probe {

	public static void main(String [] args) {
	
	//Fire fire = new Fire();
	//Bow bow = new Bow();
	//Sword sword = new Sword(); 
	//int lebensPunkte, char symbol, int xPos, int yPos
	Dragon dragon = new Dragon(25, 'X', 4, 7);
	Player player = new Player(15, 'O', 5, 8);
	//int damge = 2;
	
	System.out.println(dragon);
	
	System.out.println(dragon);
	
	System.out.println(player);
	/*
	player.setXPos(4);
	player.setYPos(8);
	
	
	System.out.println("THe Attack of the Fire is " + fire.getAtk() + " and the Offset is " + fire.getOffset());
	System.out.println("THe Attack of the Bow is " + bow.getAtk() + " and the Offset is " + bow.getOffset());
	System.out.println("THe Attack of the Sword is " + sword.getAtk() + " and the Offset is " + sword.getOffset());
	System.out.println(dragon);
	System.out.println(player);
	*/
	
	}
}