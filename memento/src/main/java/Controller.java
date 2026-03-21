

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    private List<IMemento> history; // undo list

    // NEW: redo list
    private List<IMemento> redoList;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>(); // NEW
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoList.clear(); // NEW: clear redo when new change
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoList.clear(); // NEW
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo");

            // NEW: save current state to redo
            redoList.add(model.createMemento());

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    // NEW: redo method
    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Redo");

            // save current state to undo
            history.add(model.createMemento());

            IMemento state = redoList.remove(redoList.size() - 1);
            model.restoreState(state);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    // NEW: getter for history (used by history window)
    public List<IMemento> getHistory() {
        return history;
    }

    // NEW: restore specific state (for list click)
    public void restoreFromHistory(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }
}