package pckg1;

abstract class Weapon {

	private int atk;
	private int offset;
	
	public Weapon() {
		
		setAtk(4);
		setOffset(50);
	}
	
	/*
	public Weapon(int atk, int offset) {
		
		setAtk(atk);
		setOffset(offset);
		
	}
	*/
	
	public void setOffset(int offset) {
		
		if(offset !=0) {
			this.offset = offset;
		}
	}
	
	public void setAtk(int atk) {
		
		if(atk !=0) {
			this.atk = atk;
		}
	}
	
	public int getOffset() {
		return offset;
	}

	public int getAtk() {
		return atk;
	}
}