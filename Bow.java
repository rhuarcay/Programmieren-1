package pckg1;

public class Bow extends Weapon {
	
	public Bow() {
		
		this.setAtk(5);
		
		//Mit größerem Abstand ungenauer werden. Dafür braucht man die Methode distance
		this.setOffset(60);
		
	}
	
}