abstract class SpecialWeapon extends Weapon implements Intiface{
	
	protected int ammo;
	
	public SpecialWeapon(){
		this.atk = 5; 
		this.offset = 20;
	}
	
	public boolean spendAmmo(){	//mit Überlagerung ?
		
		this.ammo -= 2;
		return true;
	}
	
	public boolean load(){
		//load 2 turns
		this.ammo += 1;
		
		if(this.ammo == 2){
			System.out.println("Es ist noch " + 1 + " Munition mehr vorhanden. /n");
			return true;
		}else{
			System.out.println("Es ist keine Munition mehr vorhanden, noch " + getLoadStatus() + " Aufladung um aufgeladen zu sein. /n");
			return false;
		}
	}
	
	public int getRadius(){
		int radius = (int) (Math.random() * 2);
		
		if(radius == 2){
			this.atk += 1;
		}else if(radius == 1){
			this.atk += 2;
			this.offset = 30;
		}else{
			this.atk += 3;
			this.offset = 40;
		}
		
		return radius;
	}
	
	public int arealDamage(int y, int x){
		int hitRate = (int) (Math.random() * 100);
		int zufallX = (int) (Math.random() * x);
		int zufallY = (int) (Math.random() * y);
		int radius = getRadius();
		if (hitRate > this.offset) {
			System.out.println("Der Drache wurde getroffen.");
			System.out.println(this.atk);
			spendAmmo();
			return this.atk;
        } else {
            System.out.println("Der Drache wurde verfehlt.");
			this.atk = 0;
			System.out.println(this.atk);
			spendAmmo();
			return this.atk;
        }
		//create wall/destroy wall
	}
	
	public int getLoadStatus(){
		int status = 2 - this.ammo;
		return status;
	}
	
	
}