package rpg.map;

import rpg.Tiles.*;

public class CityMap extends Map {

    public CityMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    protected Tile createTile() {
        int choice = rand.nextInt(3);
        return switch (choice) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}
