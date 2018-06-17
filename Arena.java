/**
 * Repräsentation der Arena
 */
public class Arena {

    /**
     * Enthält alles, was sich auf dem Spielfeld befindet.
     */
    private char[][] map;

    /**
     * Der Drache der Arena
     */
    private Dragon dragon;

    /**
     * Der Spieler der Arena
     */
    private Player player;

    /**
     * Erstellt eine neue Arena
     *
     * @param args Größen
     */
    public Arena(String[] args) {
        map = new char[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        if (map[0].length < 5 || map.length < 5) {
            System.out.println("Die Map muss mindestens die Dimension 5x5 haben.");
            System.exit(25);
        }
        dragon = new Dragon(map[0].length, map.length); //Drachen in unterster Zeile
        player = new Player(map[0].length, map.length); //Spieler in oberster Zeile
        for (int i = 0; i < map.length; i++) { //Map mit Leerzeichen füllen
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = ' ';
            }
        }
        for (int i = 0; i < map[0].length; i++) { //Wände in erster und letzter Zeile
            map[0][i] = '#';
            map[map.length - 1][i] = '#';
        }
        for (int i = 0; i < map.length; i++) { //Wände in erster und letzter Spalte
            map[i][0] = '#';
            map[i][map[0].length - 1] = '#';
        }
    }

    /**
     * Gibt die Map als String zurück
     * @return Map als String
     */
    @Override
    public String toString() {
        String result = "";
        //Ausgabe der Map
        String line = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == player.getY() && j == player.getX()) {
                    line += player.getSymbol(); //Befindet sich hier der Player
                } else if (i == dragon.getY() && j == dragon.getX()) {
                    line += dragon.getSymbol(); //Befindet sich hier der Drache
                } else {
                    line += map[i][j];  
                } 
            }
            result += (line + "\n");
            line = "";
        }
        return result;
    }

    /**
     * Abstand zwischen zwei Charaktern
     * @param char1 Charakter 1
     * @param char2 Charakter 2
     * @return Abstand in Feldern
     */
    public int distance(Character char1, Character char2) {
        int distanceX = Math.abs(char1.getX() - char2.getX());
        int distanceY = Math.abs(char1.getY() - char2.getY());
        return distanceX + distanceY;
    }

    /**
     * Ist Feld begehbar
     * @param y y-Koordinate
     * @param x x-Koordintae
     * @return Begehbar?
     */
    public boolean walkable(int y, int x) {
        boolean wall = map[y][x] != '#'; //Ist dort eine Wand?
		boolean wall2 = map[y][x] != '%'; //Wand von Katapult?
        boolean drago = dragon.getX() != x || dragon.getY() != y; //Ist dort ein Drache?
        return wall && wall2 && drago;
    }

    /**
     * Gibt den Spieler der Map zurück
     * @return Spieler
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gibt den Drachen der Map zurück
     * @return Drache der Map
     */
    public Dragon getDragon() {
        return dragon;
    }
	
	 /**
     * Gibt den Map der Map zurück
     * @return Map der Map
     */
    public char[][] getMap() {
        return map;
    }
	
	    /**
     * Setzt Map auf übergebenen Wert
     * @param Map Neue Lebenspunkte
     */
    public void setMap(int i, int j, char wall) {
        this.map[i][j] = wall;
    }
}
