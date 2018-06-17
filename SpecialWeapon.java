abstract class SpecialWeapon extends Weapon implements Intiface{
	
	protected int ammo;
	protected int radius;
	
	public SpecialWeapon(){
		this.atk = 5; 
		this.offset = 20;
		this.radius = 0;
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
		this.radius = (int) (Math.random() * 3);
		
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
	
	public int arealDamage(Arena arena, Character enemy){
		char [][] map = arena.getMap();
		int rad = this.radius;
		int enemyY = enemy.getY();
		int enemyX = enemy.getX();
		int enemyLY = enemyY - rad - 1;
		int enemyUY = enemyY + rad + 1;
		int enemyLX = enemyX - rad - 1;
		int enemyUX = enemyX + rad + 1;

		int randomY = (int) (Math.random() * (enemyUY - enemyLY)) + enemyLY;
		int randomX = (int) (Math.random() * (enemyUX - enemyLX)) + enemyLX;
		
		if (map[randomY][randomX] == ' ') {
			arena.setMap(randomY, randomX, '%'); 
		} else if (map[randomY][randomX] == '%') {
			arena.setMap(randomY, randomX, ' ');
		}
		
		//create wall/destroy wall
		return atk;
	}
	
	public int getLoadStatus(){
		int status = 2 - this.ammo;
		
		if( status == 0){
			System.out.println("Waffe ist feuerbereit! \n");
		}else{
			System.out.println("Waffe muss noch " + status + " Runde laden \n");
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
		this.getRadius();
        return this.offset;
    }
}