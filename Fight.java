package pckg1;

public class Fight {

	public static void main(String[] args) {
		
		int args0 = Integer.parseInt(args[0]);
		int args1 = Integer.parseInt(args[1]);
		
		if (args0 < 5 || args1 < 5) {
            System.out.println("Die Map muss mindestens die Dimension 5x5 haben.");
            System.exit(0);
        }
		
		Dragon dragon = new Dragon(25, 'X', args1-2, args0/2);
		Player player = new Player(15, 'O', 1, args0/2);
		
		Arena arena = new Arena(player, dragon);
		arena.setMap(args0, args1);
			
		System.out.println("Der Kampf beginnt");
		
		arena.makeArena();
		
		player.move(arena);
		
		arena.makeArena();
		
		System.out.println(player);
		System.out.println(dragon);
		System.out.println(arena.distance(player, dragon));
		
	}

}