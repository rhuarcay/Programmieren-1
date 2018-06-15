abstract class SpecialWeapon extends Weapon implements Intiface{
	
	protected int ammo;
	
	public SpecialWeapon(){
		this.atk = 5; 
		this.offset = 20;
	}
	
	public void spendAmmo(){
		this.ammo -= 2;
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
		}else if(radius == 1){
			this.atk += 2;
			this.offset = 30;
		}else{
			this.atk += 3;
			this.offset = 40;
		}
		
		return radius;
	}
	
	public int arealDamage(){
		int hitRate = (int) (Math.random() * 100);
		getRadius();

		//create wall/destroy wall
		return atk;
	}
	
	public int getLoadStatus(){
		int status = 2 - this.ammo;
		
		if( status == 0){
			System.out.println("Waffe ist feuerbereit!");
		}else{
			System.out.println("Waffe muss noch" + status + " Runde laden");
		}
		return status;
	}
	
	
	 /**
     * Gibt ATK Wert zurück
     * @return ATK
     */
	 @Override
    public int getATK() {
        return this.atk;
    }
	
	/**
     * Gibt den Offset der Waffe zurück
     *
     * @param distance Abstand zum Ziel
     * @return Offset
     */
	 @Override
    public int calculateOffset(int distance) {
		getRadius();
        return this.offset;
    }
}