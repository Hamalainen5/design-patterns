// Concrete command
public class MoveCursorUpCommand implements Command {
    private PixelArtEditor editor;

    public MoveCursorUpCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        // call the method in
        editor.moveUp();
    }

}
