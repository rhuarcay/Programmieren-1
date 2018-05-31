package pckg1;

public class Probe {

	public static void main(String [] args) {
	
	Fire fire = new Fire(4, 50);
	Bow bow = new Bow(5, 60);
	Sword sword = new Sword(3, 30);
	
	System.out.println("THe Attack of the Fire is " + fire.getAtk() + " and the Offset is " + fire.getOffset());
	System.out.println("THe Attack of the Bow is " + bow.getAtk() + " and the Offset is " + bow.getOffset());
	System.out.println("THe Attack of the Sword is " + sword.getAtk() + " and the Offset is " + sword.getOffset());
	
	}
}