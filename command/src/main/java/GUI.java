

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// GUI class
// Creates: receiver, commands, GUI

public class GUI extends Application {

    // size of one square
    private final int CELL_SIZE = 50;

    @Override
    public void start(Stage stage) {

        // receiver
        PixelArtEditor editor =
                new PixelArtEditor();

        // commands
        Command up =
                new MoveCursorUpCommand(editor);

        Command down =
                new MoveCursorDownCommand(editor);

        Command left =
                new MoveCursorLeftCommand(editor);

        Command right =
                new MoveCursorRightCommand(editor);

        Command toggle =
                new TogglePixelCommand(editor);

        Command generate =
                new GenerateCodeCommand(editor);

        // view
        Canvas canvas =
                new Canvas(400, 400);

        // draw initial state
        draw(canvas, editor);

        // button to generate code
        Button generateButton =
                new Button("Generate Code");

        // button action
        generateButton.setOnAction(e -> {

            generate.execute();
        });

        VBox root =
                new VBox(canvas, generateButton);

        Scene scene =
                new Scene(root);

        // key press events
        scene.setOnKeyPressed(event -> {

            // check which key was pressed and execute corresponding command

            if (event.getCode() == KeyCode.UP) {

                up.execute();
            }

            else if (event.getCode()
                    == KeyCode.DOWN) {

                down.execute();
            }

            else if (event.getCode()
                    == KeyCode.LEFT) {

                left.execute();
            }

            else if (event.getCode()
                    == KeyCode.RIGHT) {

                right.execute();
            }

            else if (event.getCode()
                    == KeyCode.SPACE) {

                toggle.execute();
            }

            // redraw after changes
            draw(canvas, editor);
        });

        stage.setScene(scene);

        stage.setTitle(
                "Pixel Art Editor");

        stage.show();

        // request focus to capture key events
        scene.getRoot().requestFocus();
    }

    // method to draw the grid and pixels
    private void draw(
            Canvas canvas,
            PixelArtEditor editor) {

        GraphicsContext gc =
                canvas.getGraphicsContext2D();

        boolean[][] pixels =
                editor.getPixels();

        // clear canvas
        gc.clearRect(
                0,
                0,
                canvas.getWidth(),
                canvas.getHeight()
        );

        // draw grid and pixels
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                // set color based on pixel state
                if (pixels[row][col]) {

                    gc.setFill(Color.BLACK);
                }
                else {

                    gc.setFill(Color.WHITE);
                }

                // fill cell
                gc.fillRect(
                        col * CELL_SIZE,
                        row * CELL_SIZE,
                        CELL_SIZE,
                        CELL_SIZE
                );

                // draw grid lines
                gc.setStroke(Color.GRAY);

                gc.strokeRect(
                        col * CELL_SIZE,
                        row * CELL_SIZE,
                        CELL_SIZE,
                        CELL_SIZE
                );

                // highlight cursor position
                if (row ==
                        editor.getCursorRow()

                        &&

                        col ==
                                editor.getCursorCol()) {

                    gc.setStroke(Color.RED);

                    gc.strokeRect(
                            col * CELL_SIZE + 2,
                            row * CELL_SIZE + 2,
                            CELL_SIZE - 4,
                            CELL_SIZE - 4
                    );
                }
            }
        }
    }

    public static void main(String[] args) {

        launch();
    }
}
