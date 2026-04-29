// This class contains the real logic of the application
// Commands call methods from this class

public class PixelArtEditor {

    // Size of the grid
    private final int SIZE = 8;

    // 8x8 grid of pixels
    // false = OFF pixel
    // true = ON pixel

    private boolean[][] pixels = new boolean[SIZE][SIZE];

    // cursor position
    private int cursorRow = 0;
    private int cursorCol = 0;

    // Move cursor up
    public void moveUp() {

        // Prevent going out of bounds
        if (cursorRow > 0) {
            cursorRow--;
        }
    }

    // Move cursor down
    public void moveDown() {
        if (cursorRow < SIZE - 1) {
            cursorRow++;
        }
    }

    // Move cursor left
    public void moveLeft() {
        if (cursorCol > 0) {
            cursorCol--;
        }
    }

    // Move cursor right
    public void moveRight() {
        if (cursorCol < SIZE - 1) {
            cursorCol++;
        }
    }

    // Toggle pixel at cursor position
    // True becomes False, False becomes True

    public void togglePixel() {
        pixels[cursorRow][cursorCol] = !pixels[cursorRow][cursorCol];
    }

    // Generate java array code
    // Print pixel art as java code into console

    public void generateCode() {
        System.out.println("int[][] pixels = {");

        // Go through each row
        for (int row = 0; row < SIZE; row++) {
            System.out.print("    {");

            // Go through each column
            for (int col = 0; col < SIZE; col++) {
                // Print 1 for ON pixel, 0 for OFF pixel
                int value = pixels[row][col] ? 1 : 0;
                System.out.print(value);

                // Add comma if not last column
                if (col < SIZE - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
    }
    // Getters
    public boolean[][] getPixels() {
        return pixels;
    }
    public int getCursorRow() {
        return cursorRow;
    }
    public int getCursorCol() {
        return cursorCol;
    }
}
