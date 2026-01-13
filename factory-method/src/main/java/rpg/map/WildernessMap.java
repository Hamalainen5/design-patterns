package rpg.map;

import rpg.Tiles.ForestTile;
import rpg.Tiles.SwampTile;
import rpg.Tiles.Tile;
import rpg.Tiles.WaterTile;

public class WildernessMap extends Map{
    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        int choice = rand.nextInt(3);
        return switch (choice) {
            case 0 -> new WaterTile();
            case 1 -> new ForestTile();
            default -> new SwampTile();
        };

    }
}
