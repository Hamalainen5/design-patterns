package factory;// Abstract Factory interface
// Declares methods for creating UI components

import elements.Button;
import elements.Checkbox;
import elements.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
