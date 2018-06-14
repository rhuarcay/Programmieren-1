public class SpecialWeapon extends Weapon implements Intiface{
	
	protected int ammo;
	
	public SpecialWeapon(){
		this.atk = 5; 
		this.offset = 50;
	}
	
	public boolean spendAmmo(){	//mit Überlagerung ?
		
		this.ammo -= 1;
		if(this.ammo >= 0){
			return true;
		}else {
			return false;
		}	
	}
	
	public int getRadius(){
		int radius = (int) (Math.random() * 3);
		
		if(radius == 3){
			this.atk = 5;
		}else if(radius == 2){
			this.atk = 6;
		}else{
			this.atk = 7;
		}
		
		return radius;
	}
	
	public int arealDamage(){
		int hitRate = (int) Math.random() * 100;
		
		if (hitRate > this.atk) {
			getRadius();
			return this.atk;
            
        } else {
            return this.atk;
        }
		//create wall/destroy wall
		//Meteordmg > Katapultdmg
	}
	
	public boolean load(){
		//load 2 turns
		int load = 2;
		
		return true;
	}
}