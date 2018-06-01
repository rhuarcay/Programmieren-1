package pckg1;

public class Arena {
	
	private char[][] map;
	private Player player;
	private Dragon dragon;
	
	public Arena() {
		
	}
	
	public Arena(Player player, Dragon dragon) {
		this.setPlayer(player);
		this.setDragon(dragon);
	}
	
	public void setMap(int arg0, int arg1) {
		this.map = new char[arg0][arg1];
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}
	
	public void makeArena() {
		
		//Map mit Leerzeichen füllen
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = ' ';
            }
        }
		
		map[player.getYPos()][player.getXPos()] = player.getSymbol();
        map[dragon.getYPos()][dragon.getXPos()] = dragon.getSymbol();

        //Wände in erster und letzter Zeile
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = '#';
            map[map.length - 1][i] = '#';
        }
        //Wände in erster und letzter Spalte
        for (int i = 0; i < map.length; i++) {
            map[i][0] = '#';
            map[i][map[0].length - 1] = '#';
        }

        //Ausgabe der Map
        String line = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                line += map[i][j];
            }
            System.out.println(line);
            line = "";
        }
	}
	/*
	public int getArg0() {
		return this.map.length;
	}
	
	public int getArg1() {
		return this.map[0].length;
	}
	*/
}
