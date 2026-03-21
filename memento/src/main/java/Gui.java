

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    // NEW: history window elements
    private ListView<String> historyListView = new ListView<>();

    public void start(Stage stage) {

        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(
                colorBox1.getRectangle(),
                colorBox2.getRectangle(),
                colorBox3.getRectangle()
        );
        hBox.setSpacing(10);

        Label label = new Label("Ctrl-Z = Undo, Ctrl-Y = Redo");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label);

        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
            updateHistoryView(); // NEW
        });

        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
                updateHistoryView(); // NEW
            }
            if (event.isControlDown() && event.getCode() == KeyCode.Y) { // NEW
                controller.redo();
                updateHistoryView();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        // NEW: create history window
        createHistoryWindow();
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    // NEW: history window
    private void createHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        VBox layout = new VBox(historyListView);
        Scene scene = new Scene(layout, 200, 300);

        historyStage.setScene(scene);
        historyStage.show();

        // click → restore state
        historyListView.setOnMouseClicked(event -> {
            int index = historyListView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                IMemento memento = controller.getHistory().get(index);
                controller.restoreFromHistory(memento);
            }
        });
    }

    // NEW: update list content
    private void updateHistoryView() {
        historyListView.getItems().clear();

        for (IMemento m : controller.getHistory()) {
            historyListView.getItems().add(m.getTimestamp());
        }
    }
}