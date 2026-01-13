package rpg.map;

import rpg.Tiles.Tile;

import java.util.Random;

public abstract class Map {
    protected int rows;
    protected int cols;
    protected Tile[][] tiles;
    protected Random rand = new Random();

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        tiles = new Tile[rows][cols];
        generateMap();
    }


    protected abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = createTile();
            }
        }
    }


    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
