package pckg1;

public class Probe {

	public static void main(String [] args) {
	
	Fire fire = new Fire();
	Bow bow = new Bow();
	Sword sword = new Sword();
	Dragon dragon = new Dragon();
	Player player = new Player();
	int damge = 2;
	
	dragon.setXPos(5);
	dragon.setYPos(9);
	System.out.println(dragon);
	
	dragon.setLebensPunkte(dragon.getLebensPunkte() - damge);
	
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