public class SpecialWeapon extends Weapon implements Intiface{
	
	protected int Ammo;
	
	public SpecialWeapon(){
		this.ATK = 5; 
		this.offset = 50;
	}
	
	public boolean spendAmmo(){	//mit Überlagerung ?
		
		this.kAmmo -= 1;
		if(this.kAmmo >= 0){
			return true;
		}else {
			return false;
		}	
	}
	
	public int getRadius(){
		int radius = (int) (Math.random() * 3);
		
		if(radius == 3){
			this.ATK = 5;
		}else if(radius == 2){
			this.ATK = 6;
		}else{
			this.ATK = 7;
		}
		
		return radius;
	}
	
	public int arealDamage(){
		int hitRate = (int) Math.random() * 100;
		
		if (hitRate > this.ATK) {
			getRadius();
			return this.ATK;
            
        } else {
            return this.ATK;
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