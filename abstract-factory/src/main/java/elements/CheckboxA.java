package elements;// Styled A implementation of elements.Checkbox

public class CheckboxA extends Checkbox {

    public CheckboxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[ ] " + text );
    }
}
