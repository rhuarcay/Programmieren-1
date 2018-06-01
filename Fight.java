package pckg1;

public class Fight {

	public static void main(String[] args) {
		
		Arena arena = new Arena();
		
		
		
		arena.setMap(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println(arena.getArg0() + " " + arena.getArg1());
			
		
		
		
	}

}