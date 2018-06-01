package pckg1;

public class Bow extends Weapon {
	
	public Bow() {
		
		super.setAtk(5);
		
		//Mit größerem Abstand ungenauer werden. Dafür braucht man die Methode distance
		super.setOffset(60);
		
	}
	
}