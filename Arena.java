package pckg1;

public class Arena {
	
	private char[][] map;
	private Player player;
	private Dragon dragon;
	
	public Arena() {
		
	}
	
	public void setMap(int arg0, int arg1) {
		this.map = new char[arg0][arg1];
	}

	public int getArg0() {
		return this.map.length;
	}
	
	public int getArg1() {
		return this.map[0].length;
	}
}
