package rpg;

import rpg.map.CityMap;
import rpg.map.Map;
import rpg.map.WildernessMap;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();

        Map map = game.createMap("city", 5, 10);

        map.display();
    }

    public Map createMap(String mapType, int rows, int cols) {
        if (mapType.equalsIgnoreCase("city")) {
            return new CityMap(rows, cols);
        } else {
            return new WildernessMap(rows, cols);
        }
    }
}
