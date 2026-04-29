public class MoveCursorDownCommand implements Command {

    private PixelArtEditor editor;

    public MoveCursorDownCommand(
            PixelArtEditor editor
    ) {
        this.editor = editor;
    }
    @Override
    public void execute() {
        editor.moveDown();
    }
}
