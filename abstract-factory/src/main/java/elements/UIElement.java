package elements;

// Common abstract superclass for all UI elements
// Contains shared state (text) and behavior (setText)
public abstract class UIElement {

    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    // Changes the text of the UI element
    public void setText(String text) {
        this.text = text;
    }

    // Each UI element has a different way of displaying its text
    public abstract void display();
}
