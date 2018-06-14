abstract class SpecialWeapon extends Weapon implements Intiface{
	
	protected int ammo;
	
	public SpecialWeapon(){
		this.atk = 5; 
		this.offset = 50;
	}
	
	public boolean spendAmmo(){	//mit Überlagerung ?
		
		this.ammo -= 1;
		if(this.ammo >= 0){
			System.out.println("Es ist noch " + this.ammo + " Munition mehr vorhanden");
			return true;
		}else {
			System.out.println("Es ist keine Munition mehr vorhanden");
			return false;
		}	
	}
	
	public boolean load(){
		//load 2 turns
		this.ammo += 1;
		
		if(this.ammo == 2){
			return true;
		}else{
			return false;
		}
	}
	
	public int getRadius(){
		int radius = (int) (Math.random() * 2);
		
		if(radius == 2){
			this.atk += 1;
			this.offset = 70;
		}else if(radius == 1){
			this.atk += 2;
			this.offset = 60;
		}else{
			this.atk += 3;
		}
		
		return radius;
	}
	
	public int arealDamage(int x, int y){
		int hitRate = (int) Math.random() * 100;
		int zufallX = (int) Math.random() * x;
		int zufallY = (int) Math.random() * y;
		getRadius();
		if (hitRate > this.offset) {
			
			return this.atk;
        } else {
            return this.atk;
        }
		//create wall/destroy wall
	}
	public int getLoadStatus(){
		int status = 2 - this.ammo;
		return status;
	}
	
	
}